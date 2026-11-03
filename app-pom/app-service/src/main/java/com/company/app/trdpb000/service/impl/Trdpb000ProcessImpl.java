
package com.company.app.trdpb000.service.impl;

import com.company.app.trdpb000.business.context.Trdpb000Context;
import com.company.app.trdpb000.service.Trdpb000Process;
import com.netfective.bluage.gapwalk.database.support.central.ESQLAttribute;
import com.netfective.bluage.gapwalk.database.support.central.SQLExecutorBuilder;
import com.netfective.bluage.gapwalk.database.support.central.SQLParameterBuilder;
import com.netfective.bluage.gapwalk.database.support.central.functions.SqlcaHandler;
import com.netfective.bluage.gapwalk.datasimplifier.utils.DataUtils;
import com.netfective.bluage.gapwalk.datasimplifier.utils.NumberUtils;
import com.netfective.bluage.gapwalk.datasimplifier.utils.StringUtils;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;
import com.netfective.bluage.gapwalk.rt.utils.ArgUtils;
import com.netfective.bluage.gapwalk.runtime.statements.CallBuilder;
import com.netfective.bluage.gapwalk.runtime.statements.DateHelper;
import com.netfective.bluage.gapwalk.runtime.statements.StringConcatenationBuilder;
import com.netfective.bluage.gapwalk.runtime.tool.DisplayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Class Trdpb000ProcessImpl
 * 
 * Defines application services for Trdpb000Process
 * @see Trdpb000Process
 */
@Service("com.company.app.trdpb000.service.Trdpb000Process")
@Lazy

public class Trdpb000ProcessImpl implements Trdpb000Process {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Trdpb000ProcessImpl.class);


	/**
	 * Process operation mainline.
	 * 
	 * Legacy: 0000-MAINLINE
	 * PROGRAM-ID.TRDPB000.
	 * ****************************************************************
	 *                                                                *
	 *  TRDPB000 : Process Trading Orders                             *
	 *                                                                *
	 *   - Transaction starting this program is of format             *
	 *     T<CurrencyCode> viz. TUSD, TINR, TCHF and so on.           *
	 *   - This Program is the first series of programs that          *
	 *     Validates & Matches Buy & Sell Side Orders.                *
	 *   - Multi-threading of this process is based on running        *
	 *     multiple background transactions for settling trades       *
	 *     based on currency                                          *
	 *   - Once trades are matched, Settlement batch for that         *
	 *     trade currency should be done                              *
	 *   - Any validation issues will be logged in TBTRDEXP table     *
	 *                                                                *
	 * ****************************************************************
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void mainline(final Trdpb000Context ctx, final ExecutionController ctrl) {
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.setAttribute(ESQLAttribute.WITH_HOLD)
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getOrdCurrency().getOrdCurrencyReference()))
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getOrdTradingXchng().getOrdTradingXchngReference()))
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getOrdStatus().getOrdStatusReference()))
			.execute("TRDPB000_1");
		ctx.getLkParm().bind(ArgUtils.get(ctx, 0));
		
		/* 
		****************************************************************
		THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 4       *
		WITH UR
		Validate Currency */
		if (ctx.getLkParm().isValidCurrency()) {
			
			/* 
			Do nothing */
		} else {
			ctx.getWsExcpType().setSystemException(true);
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize(ctx.getLkParm().getLkCurrency())
				.addDelimitedBySize(" : ")
				.addDelimitedBySize("Currency parameter passed is invalid")
				.end();
			reportException(ctx, ctrl);
		}
		
		/* 
		Default Chkpt frequency is 100 */
		if (NumberUtils.lt(ctx.getLkParm().getLkChkpFrequencyReference(), 100)) {
			ctx.getLkParm().setLkChkpFrequency(100);
		} 
		
		/* 
		Log Start timestamp */
		ctx.getDcltbtrdlog().getField().initialize();
		ctx.getDcltbtrdlog().setLogTransaction("ACCEPTANCE");
		ctx.getDcltbtrdlog().getLogCurrencyReference().setValue(ctx.getLkParm().getLkCurrencyReference());
		ctx.setWsCurrdate(DateHelper.getFormattedDate("yyyyMMdd"));
		ctx.setWsCurrtime(DateHelper.getFormattedDate("HHmmssSS"));
		DataUtils.setToBlank(ctx.getDcltbtrdlog().getLogStartTsReference());
		StringConcatenationBuilder.newInstance(ctx.getDcltbtrdlog().getLogStartTsReference())
			.addDelimitedBySize(StringUtils.substring(ctx.getWsCurrdate(),0,4))
			.addDelimitedBySize("-")
			.addDelimitedBySize(StringUtils.substring(ctx.getWsCurrdate(),4,2))
			.addDelimitedBySize("-")
			.addDelimitedBySize(StringUtils.substring(ctx.getWsCurrdate(),6,2))
			.addDelimitedBySize(" ")
			.addDelimitedBySize(StringUtils.substring(ctx.getWsCurrtime(),0,2))
			.addDelimitedBySize(":")
			.addDelimitedBySize(StringUtils.substring(ctx.getWsCurrtime(),2,2))
			.addDelimitedBySize(":")
			.addDelimitedBySize(StringUtils.substring(ctx.getWsCurrtime(),4,2))
			.end();
		
		/* 
		EXEC SQL
		SET :LOG-START-TS = CURRENT_TIMESTAMP
		END-EXEC
		IF SQLCODE NOT = 0 THEN
		MOVE SQLCODE TO WS-SQLCODE
		SET APPL-EXCEPTION TO TRUE
		MOVE SPACES TO WS-EXCEPTION
		STRING
		'LOG Set Start Timestamp failed : SQLCODE = '
		WS-SQLCODE
		DELIMITED BY SIZE
		INTO WS-EXCEPTION
		END-STRING
		PERFORM 9000-REPORT-EXCEPTION
		THRU 9000-EXIT
		END-IF */
		orderAcceptance(ctx, ctrl);
		ctx.setWsCurrdate(DateHelper.getFormattedDate("yyyyMMdd"));
		ctx.setWsCurrtime(DateHelper.getFormattedDate("HHmmssSS"));
		DataUtils.setToBlank(ctx.getDcltbtrdlog().getLogEndTsReference());
		StringConcatenationBuilder.newInstance(ctx.getDcltbtrdlog().getLogEndTsReference())
			.addDelimitedBySize(StringUtils.substring(ctx.getWsCurrdate(),0,4))
			.addDelimitedBySize("-")
			.addDelimitedBySize(StringUtils.substring(ctx.getWsCurrdate(),4,2))
			.addDelimitedBySize("-")
			.addDelimitedBySize(StringUtils.substring(ctx.getWsCurrdate(),6,2))
			.addDelimitedBySize(" ")
			.addDelimitedBySize(StringUtils.substring(ctx.getWsCurrtime(),0,2))
			.addDelimitedBySize(":")
			.addDelimitedBySize(StringUtils.substring(ctx.getWsCurrtime(),2,2))
			.addDelimitedBySize(":")
			.addDelimitedBySize(StringUtils.substring(ctx.getWsCurrtime(),4,2))
			.end();
		
		/* 
		EXEC SQL
		SET :LOG-END-TS = CURRENT_TIMESTAMP
		END-EXEC
		IF SQLCODE NOT = 0 THEN
		MOVE SQLCODE TO WS-SQLCODE
		SET APPL-EXCEPTION TO TRUE
		MOVE SPACES TO WS-EXCEPTION
		STRING
		'LOG Set End Timestamp failed : SQLCODE = '
		WS-SQLCODE
		DELIMITED BY SIZE
		INTO WS-EXCEPTION
		END-STRING
		PERFORM 9000-REPORT-EXCEPTION
		THRU 9000-EXIT
		END-IF */
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdlog().getLogTransaction()))
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdlog().getLogCurrency()))
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdlog().getLogStartTs()))
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdlog().getLogEndTs()))
			.execute("TRDPB000_2");
		if (ctx.getSqlca().getSqlcode() == 0) {
			
			/* 
			Do nothing */
		} else if (ctx.getSqlca().getSqlcode() == -803) {
			SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdlog().getLogEndTs()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdlog().getLogTransaction()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdlog().getLogCurrency()))
				.execute("TRDPB000_3");
			if (ctx.getSqlca().getSqlcode() != 0) {
				ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
				ctx.getWsExcpType().setApplException(true);
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("LOG Update Failed : SQLCODE = ")
					.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
					.end();
				reportException(ctx, ctrl);
			} 
		} else {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			ctx.getWsExcpType().setApplException(true);
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("LOG Insert Failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
		ctrl.getExecutionContext().commitConnection(SqlcaHandler.setSqlcodeAndSqlstate, ctx.getSqlca());
		if (ctx.isMainProgram()) {
			ctrl.stopRunUnit();
		}
	}

	/**
	 * Process operation orderAcceptance.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void orderAcceptance(final Trdpb000Context ctx, final ExecutionController ctrl) {
		ctx.getOrdCurrency().getOrdCurrencyReference().setValue(ctx.getLkParm().getLkCurrencyReference());
		ctx.getWsSettlmentQueueTable().setWsStqIndex(1);
		while (ctx.getWsSettlmentQueueTable().getWsStqIndex() <= 100) {
			ctx.getWsSettlmentQueueTable().getItemFromWsStqCurrencyReference(ctx.getWsSettlmentQueueTable().getWsStqIndex() - 1).setValue(ctx.getLkParm().getLkCurrencyReference());
			ctx.getWsSettlmentQueueTable().setWsStqIndex(ctx.getWsSettlmentQueueTable().getWsStqIndex() + 1);
		}
		ctx.getWsSettlmentQueueTable().setWsStqIndex(0);
		if (DataUtils.compare(ctx.getOrdCurrency().getOrdCurrencyReference(), "EUR") == 0) {
			ctx.getOrdTradingXchng().setOrdTradingXchng("DAX");
		} else if (DataUtils.compare(ctx.getOrdCurrency().getOrdCurrencyReference(), "USD") == 0) {
			ctx.getOrdTradingXchng().setOrdTradingXchng("NYSE");
		} else if (DataUtils.compare(ctx.getOrdCurrency().getOrdCurrencyReference(), "CAD") == 0) {
			ctx.getOrdTradingXchng().setOrdTradingXchng("TSX");
		} else if (DataUtils.compare(ctx.getOrdCurrency().getOrdCurrencyReference(), "CNY") == 0) {
			ctx.getOrdTradingXchng().setOrdTradingXchng("SSE");
		} else if (DataUtils.compare(ctx.getOrdCurrency().getOrdCurrencyReference(), "INR") == 0) {
			ctx.getOrdTradingXchng().setOrdTradingXchng("BSE");
		} else if (DataUtils.compare(ctx.getOrdCurrency().getOrdCurrencyReference(), "CHF") == 0) {
			ctx.getOrdTradingXchng().setOrdTradingXchng("SWX");
		} else if (DataUtils.compare(ctx.getOrdCurrency().getOrdCurrencyReference(), "JPY") == 0) {
			ctx.getOrdTradingXchng().setOrdTradingXchng("TSE");
		} else if (DataUtils.compare(ctx.getOrdCurrency().getOrdCurrencyReference(), "MXN") == 0) {
			ctx.getOrdTradingXchng().setOrdTradingXchng("BMV");
		} else if (DataUtils.compare(ctx.getOrdCurrency().getOrdCurrencyReference(), "KRW") == 0) {
			ctx.getOrdTradingXchng().setOrdTradingXchng("KRX");
		} else if (DataUtils.compare(ctx.getOrdCurrency().getOrdCurrencyReference(), "GBX") == 0) {
			ctx.getOrdTradingXchng().setOrdTradingXchng("FTSE");
		} 
		ctx.getWsOrderStatus().setAccepted(true);
		ctx.getOrdStatus().getOrdStatusReference().setValue(ctx.getWsOrderStatus().getWsOrderStatusReference());
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB000_4");
		if (ctx.getSqlca().getSqlcode() != 0) {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			ctx.getWsExcpType().setApplException(true);
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Open BUY_SIDE_ORDERS Cursor failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		} 
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdTradeid().getOrdTradeidReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdBuySellInd().getOrdBuySellIndReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdCustomerId().getOrdCustomerIdReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdFigi().getOrdFigiReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdQuantity().getOrdQuantityReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdCurrency().getOrdCurrencyReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdAmount().getOrdAmountReference()))
			.execute("TRDPB000_5");
		if (ctx.getSqlca().getSqlcode() == 100) {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			ctx.getWsOrdersSwitch().setNoMoreOrders(true);
			ctx.getWsExcpType().setDataException(true);
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("No BUY_SIDE_ORDERS to Settle ")
				.end();
			reportException(ctx, ctrl);
		} 
		ctx.getWsOrderCount().setWsOrderCount(0);
		while (!(ctx.getWsOrdersSwitch().isNoMoreOrders())) {
			ctx.getWsOrderCount().setWsOrderCount(ctx.getWsOrderCount().getWsOrderCount() + 1);
			ctx.getWsExcpType().setNoExceptions(true);
			ctx.getTrdOrderPair().getTrdExchangeReference().setValue(ctx.getOrdTradingXchng().getOrdTradingXchngReference());
			ctx.getTrdOrderPair().getTrdBuyerIdReference().setValue(ctx.getOrdCustomerId().getOrdCustomerIdReference());
			ctx.getTrdOrderPair().getTrdOrderIdReference().setValue(ctx.getOrdTradeid().getOrdTradeidReference());
			ctx.getTrdOrderPair().getTrdFigiReference().setValue(ctx.getOrdFigi().getOrdFigiReference());
			ctx.getTrdOrderPair().getTrdOrderQtyReference().setValue(ctx.getOrdQuantity().getOrdQuantityReference());
			ctx.getTrdOrderPair().getTrdCurrencyReference().setValue(ctx.getOrdCurrency().getOrdCurrencyReference());
			ctx.getTrdOrderPair().getTrdOrderAmountReference().setValue(ctx.getOrdAmount().getOrdAmountReference());
			getSellSideOrder(ctx, ctrl);
			if (ctx.getWsExcpType().isNoExceptions()) {
				validateCustomers(ctx, ctrl);
			} 
			if (ctx.getWsExcpType().isNoExceptions()) {
				validateSecurity(ctx, ctrl);
			} 
			if (ctx.getWsExcpType().isNoExceptions()) {
				buyerSecAccount(ctx, ctrl);
			} 
			if (ctx.getWsExcpType().isNoExceptions()) {
				sellerSecAccount(ctx, ctrl);
			} 
			if (ctx.getWsExcpType().isNoExceptions()) {
				buyerMoneyAccount(ctx, ctrl);
			} 
			if (ctx.getWsExcpType().isNoExceptions()) {
				sellerMoneyAccount(ctx, ctrl);
			} 
			if (ctx.getWsExcpType().isNoExceptions()) {
				updateOrderMatched(ctx, ctrl);
				writeToStlmtQueue(ctx, ctrl);
				if (NumberUtils.ge(ctx.getWsOrderCount().getWsOrderCountReference(), ctx.getLkParm().getLkChkpFrequencyReference())) {
					ctrl.getExecutionContext().commitConnection(SqlcaHandler.setSqlcodeAndSqlstate, ctx.getSqlca());
					ctx.getWsOrderCount().setWsOrderCount(0);
				} 
			} 
			SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdTradeid().getOrdTradeidReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdBuySellInd().getOrdBuySellIndReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdCustomerId().getOrdCustomerIdReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdFigi().getOrdFigiReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdQuantity().getOrdQuantityReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdCurrency().getOrdCurrencyReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdAmount().getOrdAmountReference()))
				.execute("TRDPB000_6");
			if (ctx.getSqlca().getSqlcode() == 0) {
				
				/* 
				Do nothing */
			} else if (ctx.getSqlca().getSqlcode() == 100) {
				ctx.getWsOrdersSwitch().setNoMoreOrders(true);
			} else {
				ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
				ctx.getWsExcpType().setApplException(true);
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("Fetch BUY_SIDE_ORDERS failed : SQLCODE = ")
					.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
					.end();
				reportException(ctx, ctrl);
			}
		}
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB000_7");
		if (ctx.getSqlca().getSqlcode() == 0) {
			
			/* 
			Do nothing */
		} else {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			ctx.getWsExcpType().setApplException(true);
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Close BUY_SIDE_ORDERS failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
		if (ctx.getWsSettlmentQueueTable().getWsStqIndex() > 0) {
			insertToStq(ctx, ctrl);
		} 
		ctrl.getExecutionContext().commitConnection(SqlcaHandler.setSqlcodeAndSqlstate, ctx.getSqlca());
	}

	/**
	 * Process operation getSellSideOrder.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void getSellSideOrder(final Trdpb000Context ctx, final ExecutionController ctrl) {
		ctx.getOrdBuySellInd().setOrdBuySellInd("S");
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getOrdCurrency().getOrdCurrency()))
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getOrdTradingXchng().getOrdTradingXchng()))
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getOrdTradeid().getOrdTradeid()))
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getOrdFigi().getOrdFigi()))
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getOrdBuySellInd().getOrdBuySellInd()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdCustomerId().getOrdCustomerIdReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdStatus().getOrdStatusReference()))
			.execute("TRDPB000_8");
		if (ctx.getSqlca().getSqlcode() == 0) {
			ctx.getWsOrderStatus().getWsOrderStatusReference().setValue(ctx.getOrdStatus().getOrdStatusReference());
			if (ctx.getWsOrderStatus().isAccepted()) {
				ctx.getTrdOrderPair().getTrdSellerIdReference().setValue(ctx.getOrdCustomerId().getOrdCustomerIdReference());
				
				/* 
				Do nothing */
			} else {
				ctx.getWsExcpType().setDataException(true);
				ctx.getWsTradeid().setWsTradeid(NumberUtils.convert(ctx.getOrdTradeid().getOrdTradeid()).intValue());
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("TradeId = ")
					.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
					.addDelimitedBySize(" : ")
					.addDelimitedBySize("Rejected - Reason : Seller Side Order ")
					.addDelimitedBySize("Status Invalid - Order Status = ")
					.addDelimitedBySize(ctx.getWsOrderStatus().getWsOrderStatus())
					.end();
				reportException(ctx, ctrl);
				
				/* 
				Update Buyer side order to Overdue */
				ctx.getWsOrderStatus().setOverdueSellerOrdstaInvld(true);
				ctx.getOrdStatus().getOrdStatusReference().setValue(ctx.getWsOrderStatus().getWsOrderStatusReference());
				ctx.getOrdCurrency().getOrdCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
				ctx.getOrdTradingXchng().getOrdTradingXchngReference().setValue(ctx.getTrdOrderPair().getTrdExchangeReference());
				ctx.getOrdTradeid().getOrdTradeidReference().setValue(ctx.getTrdOrderPair().getTrdOrderIdReference());
				ctx.getOrdFigi().getOrdFigiReference().setValue(ctx.getTrdOrderPair().getTrdFigiReference());
				ctx.getOrdBuySellInd().setOrdBuySellInd("B");
				updateOrder(ctx, ctrl);
			}
		} else if (ctx.getSqlca().getSqlcode() == 100) {
			ctx.getWsExcpType().setDataException(true);
			ctx.getWsTradeid().setWsTradeid(NumberUtils.convert(ctx.getOrdTradeid().getOrdTradeid()).intValue());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("TradeId = ")
				.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
				.addDelimitedBySize(" : ")
				.addDelimitedBySize("Rejected - Reason : Seller Side Order ")
				.addDelimitedBySize("Not Found ")
				.end();
			reportException(ctx, ctrl);
			
			/* 
			Update Buyer side order to Overdue */
			ctx.getWsOrderStatus().setOverdueSellerOrdMissing(true);
			ctx.getOrdStatus().getOrdStatusReference().setValue(ctx.getWsOrderStatus().getWsOrderStatusReference());
			ctx.getOrdCurrency().getOrdCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
			ctx.getOrdTradingXchng().getOrdTradingXchngReference().setValue(ctx.getTrdOrderPair().getTrdExchangeReference());
			ctx.getOrdTradeid().getOrdTradeidReference().setValue(ctx.getTrdOrderPair().getTrdOrderIdReference());
			ctx.getOrdFigi().getOrdFigiReference().setValue(ctx.getTrdOrderPair().getTrdFigiReference());
			ctx.getOrdBuySellInd().setOrdBuySellInd("B");
			updateOrder(ctx, ctrl);
		} else {
			ctx.getWsExcpType().setApplException(true);
			ctx.getWsTradeid().setWsTradeid(NumberUtils.convert(ctx.getOrdTradeid().getOrdTradeid()).intValue());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Seller Order Select Failed - SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
	}

	/**
	 * Process operation validateCustomers.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void validateCustomers(final Trdpb000Context ctx, final ExecutionController ctrl) {
		/* 
		Validate Buyer */
		ctx.getWsOrderStatus().setAccepted(true);
		ctx.getWsCustomerIo().getField().initialize();
		ctx.getWsCustomerIo().getWsCustomerIdReference().setValue(ctx.getTrdOrderPair().getTrdBuyerIdReference());
		ctrl.callSubProgram(ctx.getWsCustomerCheck().getWsCustomerCheck(), CallBuilder.newInstance()
			.byReference(ctx.getWsCustomerIo())
			.getArguments(), ctx);
		if (ctx.getWsCustomerIo().isCustomerActive()) {
			
			/* 
			Do nothing */
		} else if (ctx.getWsCustomerIo().isCustomerNotFound()) {
			ctx.getWsExcpType().setDataException(true);
			ctx.getWsTradeid().setWsTradeid(NumberUtils.convert(ctx.getOrdTradeid().getOrdTradeid()).intValue());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("TradeId = ")
				.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
				.addDelimitedBySize(" : ")
				.addDelimitedBySize("Rejected - Reason : Customer ")
				.addDelimitedBySize(ctx.getOrdCustomerId().getOrdCustomerId())
				.addDelimitedBySize(" Not found")
				.end();
			reportException(ctx, ctrl);
		} else if (ctx.getWsCustomerIo().isCustomerInactive()) {
			ctx.getWsExcpType().setDataException(true);
			ctx.getWsTradeid().setWsTradeid(NumberUtils.convert(ctx.getOrdTradeid().getOrdTradeid()).intValue());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("TradeId = ")
				.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
				.addDelimitedBySize(" : ")
				.addDelimitedBySize("Rejected - Reason : Customer ")
				.addDelimitedBySize(ctx.getOrdCustomerId().getOrdCustomerId())
				.addDelimitedBySize(" Not Active")
				.end();
			reportException(ctx, ctrl);
		} else if (ctx.getWsCustomerIo().isCustomerException()) {
			ctx.getWsExcpType().setApplException(true);
			ctx.getWsException().getWsExceptionReference().setValue(ctx.getWsCustomerIo().getWsCustomerErrorMsgReference());
			reportException(ctx, ctrl);
		} 
		if (ctx.getWsCustomerIo().isCustomerActive()) {
			
			/* 
			Do nothing */
		} else {
			
			/* 
			Update Buyer/Seller Order status */
			ctx.getWsOrderStatus().setOverdueBuyerIdInvld(true);
		}
		
		/* 
		Validate Seller */
		ctx.getWsCustomerIo().getField().initialize();
		ctx.getWsCustomerIo().getWsCustomerIdReference().setValue(ctx.getTrdOrderPair().getTrdSellerIdReference());
		ctrl.callSubProgram(ctx.getWsCustomerCheck().getWsCustomerCheck(), CallBuilder.newInstance()
			.byReference(ctx.getWsCustomerIo())
			.getArguments(), ctx);
		if (ctx.getWsCustomerIo().isCustomerActive()) {
			
			/* 
			Do nothing */
		} else if (ctx.getWsCustomerIo().isCustomerNotFound()) {
			ctx.getWsExcpType().setDataException(true);
			ctx.getWsTradeid().setWsTradeid(NumberUtils.convert(ctx.getOrdTradeid().getOrdTradeid()).intValue());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("TradeId = ")
				.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
				.addDelimitedBySize(" : ")
				.addDelimitedBySize("Rejected - Reason : Customer ")
				.addDelimitedBySize(ctx.getOrdCustomerId().getOrdCustomerId())
				.addDelimitedBySize(" Not found")
				.end();
			reportException(ctx, ctrl);
		} else if (ctx.getWsCustomerIo().isCustomerInactive()) {
			ctx.getWsExcpType().setDataException(true);
			ctx.getWsTradeid().setWsTradeid(NumberUtils.convert(ctx.getOrdTradeid().getOrdTradeid()).intValue());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("TradeId = ")
				.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
				.addDelimitedBySize(" : ")
				.addDelimitedBySize("Rejected - Reason : Customer ")
				.addDelimitedBySize(ctx.getOrdCustomerId().getOrdCustomerId())
				.addDelimitedBySize(" Not Active")
				.end();
			reportException(ctx, ctrl);
		} else if (ctx.getWsCustomerIo().isCustomerException()) {
			ctx.getWsExcpType().setApplException(true);
			ctx.getWsException().getWsExceptionReference().setValue(ctx.getWsCustomerIo().getWsCustomerErrorMsgReference());
			reportException(ctx, ctrl);
		} 
		if (ctx.getWsCustomerIo().isCustomerActive()) {
			
			/* 
			Do nothing */
		} else {
			
			/* 
			Update Buyer/Seller Order status */
			ctx.getWsOrderStatus().setOverdueSellerIdInvld(true);
		}
		if (ctx.getWsOrderStatus().isOverdueBuyerIdInvld() || ctx.getWsOrderStatus().isOverdueSellerIdInvld()) {
			ctx.getOrdStatus().getOrdStatusReference().setValue(ctx.getWsOrderStatus().getWsOrderStatusReference());
			ctx.getOrdCurrency().getOrdCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
			ctx.getOrdTradingXchng().getOrdTradingXchngReference().setValue(ctx.getTrdOrderPair().getTrdExchangeReference());
			ctx.getOrdTradeid().getOrdTradeidReference().setValue(ctx.getTrdOrderPair().getTrdOrderIdReference());
			ctx.getOrdFigi().getOrdFigiReference().setValue(ctx.getTrdOrderPair().getTrdFigiReference());
			ctx.getOrdBuySellInd().setOrdBuySellInd("B");
			updateOrder(ctx, ctrl);
			ctx.getOrdBuySellInd().setOrdBuySellInd("S");
			updateOrder(ctx, ctrl);
		}
	}

	/**
	 * Process operation validateSecurity.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void validateSecurity(final Trdpb000Context ctx, final ExecutionController ctrl) {
		ctx.getWsSecurityIo().getField().initialize();
		ctx.getWsSecurityIo().getWsFigiReference().setValue(ctx.getOrdFigi().getOrdFigiReference());
		ctrl.callSubProgram(ctx.getWsSecurityCheck().getWsSecurityCheck(), CallBuilder.newInstance()
			.byReference(ctx.getWsSecurityIo())
			.getArguments(), ctx);
		if (ctx.getWsSecurityIo().isSecurityActive()) {
			
			/* 
			Do nothing */
		} else if (ctx.getWsSecurityIo().isSecurityNotFound()) {
			ctx.getWsExcpType().setDataException(true);
			ctx.getWsTradeid().setWsTradeid(NumberUtils.convert(ctx.getOrdTradeid().getOrdTradeid()).intValue());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("TradeId = ")
				.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
				.addDelimitedBySize(" : ")
				.addDelimitedBySize("Rejected - Reason : SECURITY ")
				.addDelimitedBySize(ctx.getOrdFigi().getOrdFigi())
				.addDelimitedBySize(" Not found")
				.end();
			reportException(ctx, ctrl);
		} else if (ctx.getWsSecurityIo().isSecurityInactive()) {
			ctx.getWsExcpType().setDataException(true);
			ctx.getWsTradeid().setWsTradeid(NumberUtils.convert(ctx.getOrdTradeid().getOrdTradeid()).intValue());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("TradeId = ")
				.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
				.addDelimitedBySize(" : ")
				.addDelimitedBySize("Rejected - Reason : SECURITY ")
				.addDelimitedBySize(ctx.getOrdFigi().getOrdFigi())
				.addDelimitedBySize(" Not Active")
				.end();
			reportException(ctx, ctrl);
		} else if (ctx.getWsSecurityIo().isSecurityException()) {
			ctx.getWsExcpType().setApplException(true);
			ctx.getWsException().getWsExceptionReference().setValue(ctx.getWsSecurityIo().getWsSecurityErrorMsgReference());
			reportException(ctx, ctrl);
		} 
		if (ctx.getWsSecurityIo().isSecurityActive()) {
			
			/* 
			Do nothing */
		} else {
			
			/* 
			Update Buyer/Seller Order status */
			ctx.getWsOrderStatus().setOverdueSecurityInvld(true);
			ctx.getOrdStatus().getOrdStatusReference().setValue(ctx.getWsOrderStatus().getWsOrderStatusReference());
			ctx.getOrdCurrency().getOrdCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
			ctx.getOrdTradingXchng().getOrdTradingXchngReference().setValue(ctx.getTrdOrderPair().getTrdExchangeReference());
			ctx.getOrdTradeid().getOrdTradeidReference().setValue(ctx.getTrdOrderPair().getTrdOrderIdReference());
			ctx.getOrdFigi().getOrdFigiReference().setValue(ctx.getTrdOrderPair().getTrdFigiReference());
			ctx.getOrdBuySellInd().setOrdBuySellInd("B");
			updateOrder(ctx, ctrl);
			ctx.getOrdBuySellInd().setOrdBuySellInd("S");
			updateOrder(ctx, ctrl);
		}
	}

	/**
	 * Process operation buyerSecAccount.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void buyerSecAccount(final Trdpb000Context ctx, final ExecutionController ctrl) {
		ctx.getSacCustomerId().getSacCustomerIdReference().setValue(ctx.getTrdOrderPair().getTrdBuyerIdReference());
		ctx.getSacCurrency().getSacCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getSacCustomerId().getSacCustomerId()))
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getSacCurrency().getSacCurrency()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSacNumber().getSacNumberReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSacStatus().getSacStatusReference()))
			.execute("TRDPB000_9");
		ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
		if (ctx.getSqlca().getSqlcode() == 0) {
			if (DataUtils.compare(ctx.getSacStatus().getSacStatusReference(), "A") == 0) {
				DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}{}{}{}" , ctx.getSacCustomerId().getSacCustomerId() , "**" , ctx.getSacCurrency().getSacCurrency() , "**" , ctx.getSacNumber().getSacNumberReference().getDisplayValue(String.class));
				ctx.getTrdOrderPair().getTrdBuyerSecAccNumReference().setValue(ctx.getSacNumber().getSacNumberReference());
			} else {
				ctx.getWsExcpType().setDataException(true);
				ctx.getWsAccDisp().getWsAccDispReference().setValue(ctx.getSacNumber().getSacNumber());
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("TradeId = ")
					.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
					.addDelimitedBySize(" : ")
					.addDelimitedBySize("Rejected - Reason : Buyer Security Account")
					.addDelimitedBySize(" Not active - SAC Numnber  = ")
					.addDelimitedBySize(ctx.getWsAccDisp().getWsAccDisp())
					.end();
				reportException(ctx, ctrl);
				
				/* 
				Update Buyer/Seller side order to Overdue */
				ctx.getWsOrderStatus().setOverdueBuyerAcInvld(true);
				ctx.getOrdStatus().getOrdStatusReference().setValue(ctx.getWsOrderStatus().getWsOrderStatusReference());
				ctx.getOrdCurrency().getOrdCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
				ctx.getOrdTradingXchng().getOrdTradingXchngReference().setValue(ctx.getTrdOrderPair().getTrdExchangeReference());
				ctx.getOrdTradeid().getOrdTradeidReference().setValue(ctx.getTrdOrderPair().getTrdOrderIdReference());
				ctx.getOrdFigi().getOrdFigiReference().setValue(ctx.getTrdOrderPair().getTrdFigiReference());
				ctx.getOrdBuySellInd().setOrdBuySellInd("B");
				updateOrder(ctx, ctrl);
				ctx.getOrdBuySellInd().setOrdBuySellInd("S");
				updateOrder(ctx, ctrl);
			}
		} else if (ctx.getSqlca().getSqlcode() == 100) {
			ctx.getWsExcpType().setDataException(true);
			ctx.getWsAccDisp().getWsAccDispReference().setValue(ctx.getSacNumber().getSacNumber());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("TradeId = ")
				.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
				.addDelimitedBySize(" : ")
				.addDelimitedBySize("Rejected - Reason : Buyer Security Account")
				.addDelimitedBySize(" Not Found  - SAC Numnber  = ")
				.addDelimitedBySize(ctx.getWsAccDisp().getWsAccDisp())
				.end();
			reportException(ctx, ctrl);
			
			/* 
			Update Buyer/Seller side order to Overdue */
			ctx.getWsOrderStatus().setOverdueBuyerAcInvld(true);
			ctx.getOrdStatus().getOrdStatusReference().setValue(ctx.getWsOrderStatus().getWsOrderStatusReference());
			ctx.getOrdCurrency().getOrdCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
			ctx.getOrdTradingXchng().getOrdTradingXchngReference().setValue(ctx.getTrdOrderPair().getTrdExchangeReference());
			ctx.getOrdTradeid().getOrdTradeidReference().setValue(ctx.getTrdOrderPair().getTrdOrderIdReference());
			ctx.getOrdFigi().getOrdFigiReference().setValue(ctx.getTrdOrderPair().getTrdFigiReference());
			ctx.getOrdBuySellInd().setOrdBuySellInd("B");
			updateOrder(ctx, ctrl);
			ctx.getOrdBuySellInd().setOrdBuySellInd("S");
			updateOrder(ctx, ctrl);
		} else {
			ctx.getWsExcpType().setApplException(true);
			ctx.getWsAccDisp().getWsAccDispReference().setValue(ctx.getSacNumber().getSacNumber());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Buyer Security Account")
				.addDelimitedBySize(" Select Failed - SQLCODE  = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
	}

	/**
	 * Process operation sellerSecAccount.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void sellerSecAccount(final Trdpb000Context ctx, final ExecutionController ctrl) {
		ctx.getSacCustomerId().getSacCustomerIdReference().setValue(ctx.getTrdOrderPair().getTrdSellerIdReference());
		ctx.getSacCurrency().getSacCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getSacCustomerId().getSacCustomerId()))
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getSacCurrency().getSacCurrency()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSacNumber().getSacNumberReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSacStatus().getSacStatusReference()))
			.execute("TRDPB000_10");
		ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
		if (ctx.getSqlca().getSqlcode() == 0) {
			if (DataUtils.compare(ctx.getSacStatus().getSacStatusReference(), "A") == 0) {
				ctx.getTrdOrderPair().getTrdSellerSecAccNumReference().setValue(ctx.getSacNumber().getSacNumberReference());
			} else {
				ctx.getWsExcpType().setDataException(true);
				ctx.getWsAccDisp().getWsAccDispReference().setValue(ctx.getSacNumber().getSacNumber());
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("TradeId = ")
					.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
					.addDelimitedBySize(" : ")
					.addDelimitedBySize("Rejected - Reason : Seller Security Account")
					.addDelimitedBySize(" Not active - SAC Numnber  = ")
					.addDelimitedBySize(ctx.getWsAccDisp().getWsAccDisp())
					.end();
				reportException(ctx, ctrl);
				
				/* 
				Update Buyer/Seller side order to Overdue */
				ctx.getWsOrderStatus().setOverdueSellerAcInvld(true);
				ctx.getOrdStatus().getOrdStatusReference().setValue(ctx.getWsOrderStatus().getWsOrderStatusReference());
				ctx.getOrdCurrency().getOrdCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
				ctx.getOrdTradingXchng().getOrdTradingXchngReference().setValue(ctx.getTrdOrderPair().getTrdExchangeReference());
				ctx.getOrdTradeid().getOrdTradeidReference().setValue(ctx.getTrdOrderPair().getTrdOrderIdReference());
				ctx.getOrdFigi().getOrdFigiReference().setValue(ctx.getTrdOrderPair().getTrdFigiReference());
				ctx.getOrdBuySellInd().setOrdBuySellInd("B");
				updateOrder(ctx, ctrl);
				ctx.getOrdBuySellInd().setOrdBuySellInd("S");
				updateOrder(ctx, ctrl);
			}
		} else if (ctx.getSqlca().getSqlcode() == 100) {
			ctx.getWsExcpType().setDataException(true);
			ctx.getWsAccDisp().getWsAccDispReference().setValue(ctx.getSacNumber().getSacNumber());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("TradeId = ")
				.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
				.addDelimitedBySize(" : ")
				.addDelimitedBySize("Rejected - Reason : Seller Security Account")
				.addDelimitedBySize(" Not Found  - SAC Numnber  = ")
				.addDelimitedBySize(ctx.getWsAccDisp().getWsAccDisp())
				.end();
			reportException(ctx, ctrl);
			
			/* 
			Update Buyer/Seller side order to Overdue */
			ctx.getWsOrderStatus().setOverdueSellerAcInvld(true);
			ctx.getOrdStatus().getOrdStatusReference().setValue(ctx.getWsOrderStatus().getWsOrderStatusReference());
			ctx.getOrdCurrency().getOrdCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
			ctx.getOrdTradingXchng().getOrdTradingXchngReference().setValue(ctx.getTrdOrderPair().getTrdExchangeReference());
			ctx.getOrdTradeid().getOrdTradeidReference().setValue(ctx.getTrdOrderPair().getTrdOrderIdReference());
			ctx.getOrdFigi().getOrdFigiReference().setValue(ctx.getTrdOrderPair().getTrdFigiReference());
			ctx.getOrdBuySellInd().setOrdBuySellInd("B");
			updateOrder(ctx, ctrl);
			ctx.getOrdBuySellInd().setOrdBuySellInd("S");
			updateOrder(ctx, ctrl);
		} else {
			ctx.getWsExcpType().setApplException(true);
			ctx.getWsAccDisp().getWsAccDispReference().setValue(ctx.getSacNumber().getSacNumber());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Seller Security Account")
				.addDelimitedBySize(" Select Failed - SQLCODE  = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
	}

	/**
	 * Process operation buyerMoneyAccount.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void buyerMoneyAccount(final Trdpb000Context ctx, final ExecutionController ctrl) {
		ctx.getMacCurrency().getMacCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
		ctx.getMacCustomerId().getMacCustomerIdReference().setValue(ctx.getTrdOrderPair().getTrdBuyerIdReference());
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getMacCurrency().getMacCurrency()))
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getMacCustomerId().getMacCustomerId()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getMacNumber().getMacNumberReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getMacStatus().getMacStatusReference()))
			.execute("TRDPB000_11");
		ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
		if (ctx.getSqlca().getSqlcode() == 0) {
			if (DataUtils.compare(ctx.getMacStatus().getMacStatusReference(), "A") == 0) {
				ctx.getTrdOrderPair().getTrdBuyerMoneyAccNumReference().setValue(ctx.getMacNumber().getMacNumberReference());
			} else {
				ctx.getWsExcpType().setDataException(true);
				ctx.getWsAccDisp().getWsAccDispReference().setValue(ctx.getMacNumber().getMacNumber());
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("TradeId = ")
					.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
					.addDelimitedBySize(" : ")
					.addDelimitedBySize("Rejected - Reason : Buyer Money Account")
					.addDelimitedBySize(" Not active - MAC Numnber  = ")
					.addDelimitedBySize(ctx.getWsAccDisp().getWsAccDisp())
					.end();
				reportException(ctx, ctrl);
				
				/* 
				Update Buyer/Seller side order to Overdue */
				ctx.getWsOrderStatus().setOverdueBuyerAcInvld(true);
				ctx.getOrdStatus().getOrdStatusReference().setValue(ctx.getWsOrderStatus().getWsOrderStatusReference());
				ctx.getOrdCurrency().getOrdCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
				ctx.getOrdTradingXchng().getOrdTradingXchngReference().setValue(ctx.getTrdOrderPair().getTrdExchangeReference());
				ctx.getOrdTradeid().getOrdTradeidReference().setValue(ctx.getTrdOrderPair().getTrdOrderIdReference());
				ctx.getOrdFigi().getOrdFigiReference().setValue(ctx.getTrdOrderPair().getTrdFigiReference());
				ctx.getOrdBuySellInd().setOrdBuySellInd("B");
				updateOrder(ctx, ctrl);
				ctx.getOrdBuySellInd().setOrdBuySellInd("S");
				updateOrder(ctx, ctrl);
			}
		} else if (ctx.getSqlca().getSqlcode() == 100) {
			ctx.getWsExcpType().setDataException(true);
			ctx.getWsAccDisp().getWsAccDispReference().setValue(ctx.getMacNumber().getMacNumber());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("TradeId = ")
				.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
				.addDelimitedBySize(" : ")
				.addDelimitedBySize("Rejected - Reason : Buyer Money Account")
				.addDelimitedBySize(" Not Found  - MAC Numnber  = ")
				.addDelimitedBySize(ctx.getWsAccDisp().getWsAccDisp())
				.end();
			reportException(ctx, ctrl);
			
			/* 
			Update Buyer/Seller side order to Overdue */
			ctx.getWsOrderStatus().setOverdueBuyerAcInvld(true);
			ctx.getOrdStatus().getOrdStatusReference().setValue(ctx.getWsOrderStatus().getWsOrderStatusReference());
			ctx.getOrdCurrency().getOrdCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
			ctx.getOrdTradingXchng().getOrdTradingXchngReference().setValue(ctx.getTrdOrderPair().getTrdExchangeReference());
			ctx.getOrdTradeid().getOrdTradeidReference().setValue(ctx.getTrdOrderPair().getTrdOrderIdReference());
			ctx.getOrdFigi().getOrdFigiReference().setValue(ctx.getTrdOrderPair().getTrdFigiReference());
			ctx.getOrdBuySellInd().setOrdBuySellInd("B");
			updateOrder(ctx, ctrl);
			ctx.getOrdBuySellInd().setOrdBuySellInd("S");
			updateOrder(ctx, ctrl);
		} else {
			ctx.getWsExcpType().setApplException(true);
			ctx.getWsAccDisp().getWsAccDispReference().setValue(ctx.getMacNumber().getMacNumber());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Buyer Money Account")
				.addDelimitedBySize(" Select Failed - SQLCODE  = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
	}

	/**
	 * Process operation sellerMoneyAccount.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void sellerMoneyAccount(final Trdpb000Context ctx, final ExecutionController ctrl) {
		ctx.getMacCurrency().getMacCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
		ctx.getMacCustomerId().getMacCustomerIdReference().setValue(ctx.getTrdOrderPair().getTrdSellerIdReference());
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getMacCurrency().getMacCurrency()))
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getMacCustomerId().getMacCustomerId()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getMacNumber().getMacNumberReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getMacStatus().getMacStatusReference()))
			.execute("TRDPB000_12");
		ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
		if (ctx.getSqlca().getSqlcode() == 0) {
			if (DataUtils.compare(ctx.getMacStatus().getMacStatusReference(), "A") == 0) {
				ctx.getTrdOrderPair().getTrdSellerMoneyAccNumReference().setValue(ctx.getMacNumber().getMacNumberReference());
			} else {
				ctx.getWsExcpType().setDataException(true);
				ctx.getWsAccDisp().getWsAccDispReference().setValue(ctx.getMacNumber().getMacNumber());
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("TradeId = ")
					.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
					.addDelimitedBySize(" : ")
					.addDelimitedBySize("Rejected - Reason : Seller Money Account")
					.addDelimitedBySize(" Not active - MAC Numnber  = ")
					.addDelimitedBySize(ctx.getWsAccDisp().getWsAccDisp())
					.end();
				reportException(ctx, ctrl);
				
				/* 
				Update Buyer/Seller side order to Overdue */
				ctx.getWsOrderStatus().setOverdueSellerAcInvld(true);
				ctx.getOrdStatus().getOrdStatusReference().setValue(ctx.getWsOrderStatus().getWsOrderStatusReference());
				ctx.getOrdCurrency().getOrdCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
				ctx.getOrdTradingXchng().getOrdTradingXchngReference().setValue(ctx.getTrdOrderPair().getTrdExchangeReference());
				ctx.getOrdTradeid().getOrdTradeidReference().setValue(ctx.getTrdOrderPair().getTrdOrderIdReference());
				ctx.getOrdFigi().getOrdFigiReference().setValue(ctx.getTrdOrderPair().getTrdFigiReference());
				ctx.getOrdBuySellInd().setOrdBuySellInd("B");
				updateOrder(ctx, ctrl);
				ctx.getOrdBuySellInd().setOrdBuySellInd("S");
				updateOrder(ctx, ctrl);
			}
		} else if (ctx.getSqlca().getSqlcode() == 100) {
			ctx.getWsExcpType().setDataException(true);
			ctx.getWsAccDisp().getWsAccDispReference().setValue(ctx.getMacNumber().getMacNumber());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("TradeId = ")
				.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
				.addDelimitedBySize(" : ")
				.addDelimitedBySize("Rejected - Reason : Seller Money Account")
				.addDelimitedBySize(" Not Found  - MAC Numnber  = ")
				.addDelimitedBySize(ctx.getWsAccDisp().getWsAccDisp())
				.end();
			reportException(ctx, ctrl);
			
			/* 
			Update Buyer/Seller side order to Overdue */
			ctx.getWsOrderStatus().setOverdueSellerAcInvld(true);
			ctx.getOrdStatus().getOrdStatusReference().setValue(ctx.getWsOrderStatus().getWsOrderStatusReference());
			ctx.getOrdCurrency().getOrdCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
			ctx.getOrdTradingXchng().getOrdTradingXchngReference().setValue(ctx.getTrdOrderPair().getTrdExchangeReference());
			ctx.getOrdTradeid().getOrdTradeidReference().setValue(ctx.getTrdOrderPair().getTrdOrderIdReference());
			ctx.getOrdFigi().getOrdFigiReference().setValue(ctx.getTrdOrderPair().getTrdFigiReference());
			ctx.getOrdBuySellInd().setOrdBuySellInd("B");
			updateOrder(ctx, ctrl);
			ctx.getOrdBuySellInd().setOrdBuySellInd("S");
			updateOrder(ctx, ctrl);
		} else {
			ctx.getWsExcpType().setApplException(true);
			ctx.getWsAccDisp().getWsAccDispReference().setValue(ctx.getMacNumber().getMacNumber());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Seller Money Account")
				.addDelimitedBySize(" Select Failed - SQLCODE  = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
	}

	/**
	 * Process operation updateOrderMatched.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void updateOrderMatched(final Trdpb000Context ctx, final ExecutionController ctrl) {
		ctx.getWsOrderStatus().setMatched(true);
		ctx.getOrdStatus().getOrdStatusReference().setValue(ctx.getWsOrderStatus().getWsOrderStatusReference());
		ctx.getOrdCurrency().getOrdCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
		ctx.getOrdTradingXchng().getOrdTradingXchngReference().setValue(ctx.getTrdOrderPair().getTrdExchangeReference());
		ctx.getOrdTradeid().getOrdTradeidReference().setValue(ctx.getTrdOrderPair().getTrdOrderIdReference());
		ctx.getOrdFigi().getOrdFigiReference().setValue(ctx.getTrdOrderPair().getTrdFigiReference());
		ctx.getOrdBuySellInd().setOrdBuySellInd("B");
		updateOrder(ctx, ctrl);
		ctx.getOrdBuySellInd().setOrdBuySellInd("S");
		updateOrder(ctx, ctrl);
	}

	/**
	 * Process operation writeToStlmtQueue.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void writeToStlmtQueue(final Trdpb000Context ctx, final ExecutionController ctrl) {
		ctx.getWsSettlmentQueueTable().setWsStqIndex(ctx.getWsSettlmentQueueTable().getWsStqIndex() + 1);
		ctx.getWsSettlmentQueueTable().getItemFromWsStqTrdpairReference(ctx.getWsSettlmentQueueTable().getWsStqIndex() - 1).setBytes(ctx.getTrdOrderPair().getBytes());
		DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}{}" , "(" , DataUtils.toString(ctx.getTrdOrderPair().getBytes()) , ")");
		if (ctx.getWsSettlmentQueueTable().getWsStqIndex() == 100) {
			insertToStq(ctx, ctrl);
			ctx.getWsSettlmentQueueTable().setWsStqIndex(0);
		}
	}

	/**
	 * Process operation insertToStq.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void insertToStq(final Trdpb000Context ctx, final ExecutionController ctrl) {
		/* 
		EXEC SQL
		INSERT INTO TBTRDSTQ
		(
		STQ_CURRENCY
		,STQ_TRADE_DATA
		)
		VALUES
		(
		:WS-STQ-CURRENCY
		,:WS-STQ-TRDPAIR
		)
		FOR :WS-STQ-INDEX ROWS
		NOT ATOMIC
		CONTINUE ON SQLEXCEPTION
		END-EXEC
		RMDTN: replaces the DB2 multi-row INSERT commented out above.
		Rows 1..WS-STQ-INDEX are all still attempted, and a
		failing row still does not stop the rest, matching
		NOT ATOMIC CONTINUE ON SQLEXCEPTION.  The first
		non-zero SQLCODE is restored into SQLCODE so the
		EVALUATE below behaves exactly as before.
		WS-STQ-INDEX is left unchanged.
		See docs/AWS_TRANSFORM_REMEDIATION.md */
		ctx.getWsStqSqlcode().setWsStqSqlcode(0);
		ctx.getWsStqSub().setWsStqSub(1);
		while (ctx.getWsStqSub().getWsStqSub() <= ctx.getWsSettlmentQueueTable().getWsStqIndex()) {
			ctx.getWsStqRowCcy().getWsStqRowCcyReference().setValue(ctx.getWsSettlmentQueueTable().getItemFromWsStqCurrencyReference(ctx.getWsStqSub().getWsStqSub() - 1));
			ctx.getWsStqRowData().getWsStqRowDataReference().setValue(ctx.getWsSettlmentQueueTable().getItemFromWsStqTrdpairReference(ctx.getWsStqSub().getWsStqSub() - 1));
			SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getWsStqRowCcy().getWsStqRowCcy()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getWsStqRowData().getWsStqRowData()))
				.execute("TRDPB000_13");
			if (ctx.getSqlca().getSqlcode() != 0) {
				if (ctx.getWsStqSqlcode().getWsStqSqlcode() == 0) {
					ctx.getWsStqSqlcode().getWsStqSqlcodeReference().setValue(ctx.getSqlca().getSqlcodeReference());
				} 
			} 
			ctx.getWsStqSub().setWsStqSub(ctx.getWsStqSub().getWsStqSub() + 1);
		}
		ctx.getSqlca().getSqlcodeReference().setValue(ctx.getWsStqSqlcode().getWsStqSqlcodeReference());
		if (ctx.getSqlca().getSqlcode() == 0) {
			
			/* 
			Do nothing */
		} else {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			ctx.getWsExcpType().setApplException(true);
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Settlement Queue Insert Failed with SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
		
		/* 
		Do nothing */
		return;
	}

	/**
	 * Process operation updateOrder.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void updateOrder(final Trdpb000Context ctx, final ExecutionController ctrl) {
		ctx.getWsRetrySwitch().setDoSql(true);
		while (!(ctx.getWsRetrySwitch().isSqlDone())) {
			ctx.getSqlca().setSqlcode(0);
			SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getOrdStatus().getOrdStatus()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getOrdCurrency().getOrdCurrency()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getOrdTradingXchng().getOrdTradingXchng()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getOrdTradeid().getOrdTradeid()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getOrdFigi().getOrdFigi()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getOrdBuySellInd().getOrdBuySellInd()))
				.execute("TRDPB000_14");
			if (ctx.getSqlca().getSqlcode() == -911 || ctx.getSqlca().getSqlcode() == -913) {
				ctx.getWsRetrySwitch().setRetrySql(true);
			} else {
				ctx.getWsRetrySwitch().setSqlDone(true);
			}
		}
		if (ctx.getSqlca().getSqlcode() != 0) {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			ctx.getWsExcpType().setApplException(true);
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Update of Order failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		} 
		ctx.getWsOrderStatus().getWsOrderStatusReference().setValue(ctx.getOrdStatus().getOrdStatusReference());
		if (ctx.getWsOrderStatus().isOverdue()) {
			ctx.getWsCustomerSummaryRec().getField().initialize();
			ctx.getWsSummaryDebitCreditSw().setSummaryNoBooking(true);
			if (DataUtils.compare(ctx.getOrdBuySellInd().getOrdBuySellIndReference(), "B") == 0) {
				ctx.getWsCustomerSummaryRec().getWsSummaryCustomerIdReference().setValue(ctx.getTrdOrderPair().getTrdBuyerIdReference());
			} else {
				ctx.getWsCustomerSummaryRec().getWsSummaryCustomerIdReference().setValue(ctx.getTrdOrderPair().getTrdSellerIdReference());
			}
			ctx.getWsCustomerSummaryRec().getWsSummaryCurrencyReference().setValue(ctx.getLkParm().getLkCurrencyReference());
			logSummary(ctx, ctrl);
		}
	}

	/**
	 * Process operation reportException.
	 * 
	 * *****************************************************
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void reportException(final Trdpb000Context ctx, final ExecutionController ctrl) {
		/* 
		EXEC SQL
		SET :EXCEPTION-TIMESTAMP = CURRENT_TIMESTAMP
		END-EXEC */
		ctx.getExceptionRecord().setExceptionDesc(ctx.getWsException().getWsException());
		ctx.getExceptionRecordLen().setExceptionRecordLen(ctx.getWsException().getWsExceptionReference().getRecord().getSize());
		if (ctx.getWsExcpType().isSystemException()) {
			ctx.getExceptionRecord().setExceptionType("SYSTEM");
		} else if (ctx.getWsExcpType().isApplException()) {
			ctx.getExceptionRecord().setExceptionType("APPLICATION");
		} else if (ctx.getWsExcpType().isDataException()) {
			ctx.getExceptionRecord().setExceptionType("DATA");
		} 
		ctx.getExceptionRecordLen().setExceptionRecordLen(ctx.getExceptionRecordLen().getExceptionRecordLen() + 46);
		
		/* 
		REMEDIATION: was CALL WS-EXCEPTION-HANDLER (VALUE 'TRDPBEXC') */
		ctrl.callSubProgram("TRDPBEXC", CallBuilder.newInstance()
			.byReference(ctx.getExceptionRecordLen().getExceptionRecordLenReference())
			.byReference(ctx.getExceptionRecord())
			.getArguments(), ctx);
		
		/* 
		Do nothing */
		return;
	}

	/**
	 * Process operation logSummary.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void logSummary(final Trdpb000Context ctx, final ExecutionController ctrl) {
		/* 
		CHECK IF CUSTOMER SUMMARY ROW EXITS */
		ctx.getDcltbtrdsum().getSumCustomerIdReference().setValue(ctx.getWsCustomerSummaryRec().getWsSummaryCustomerIdReference());
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumCustomerId()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumCustomerIdReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumOverdueReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumRejectedReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumSettledReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumCurrencyReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumOpenBalanceReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumTotalDebitReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumTotalCreditReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumCloseBalanceReference()))
			.execute("TRDPB000_15");
		if (ctx.getSqlca().getSqlcode() == 0 || ctx.getSqlca().getSqlcode() == 100) {
			
			/* 
			Do nothing */
		} else {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			ctx.getWsExcpType().setApplException(true);
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Summary Cursor OPEN Failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
		if (ctx.getSqlca().getSqlcode() == 100) {
			ctx.getWsCustomerSummaryWriteSw().setCustomerSummaryWrite(true);
			DataUtils.setToZeroes(ctx.getDcltbtrdsum().getSumOverdueReference());
			DataUtils.setToZeroes(ctx.getDcltbtrdsum().getSumRejectedReference());
			DataUtils.setToZeroes(ctx.getDcltbtrdsum().getSumSettledReference());
			DataUtils.setToZeroes(ctx.getDcltbtrdsum().getSumCurrencyReference());
			DataUtils.setToZeroes(ctx.getDcltbtrdsum().getSumOpenBalanceReference());
			DataUtils.setToZeroes(ctx.getDcltbtrdsum().getSumTotalDebitReference());
			DataUtils.setToZeroes(ctx.getDcltbtrdsum().getSumTotalCreditReference());
			DataUtils.setToZeroes(ctx.getDcltbtrdsum().getSumCloseBalanceReference());
		} else {
			ctx.getWsCustomerSummaryWriteSw().setCustomerSummaryRewrite(true);
			ctx.getWsCustomerSummaryRec().setBytes(ctx.getDcltbtrdsum().getBytes());
		}
		if ((ctx.getWsSummaryDebitCreditSw().isSummaryDebit() || ctx.getWsSummaryDebitCreditSw().isSummaryCredit()) && NumberUtils.compare(ctx.getDcltbtrdsum().getSumOpenBalance(), 0) == 0) {
			ctx.getMacCurrency().getMacCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
			if (DataUtils.compare(ctx.getTrdOrderPair().getTrdBuyerIdReference(), ctx.getDcltbtrdsum().getSumCustomerIdReference()) == 0) {
				ctx.getMacNumber().getMacNumberReference().setValue(ctx.getTrdOrderPair().getTrdBuyerMoneyAccNumReference());
			} else {
				ctx.getMacNumber().getMacNumberReference().setValue(ctx.getTrdOrderPair().getTrdSellerMoneyAccNumReference());
			}
			SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getMacCurrency().getMacCurrency()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getMacNumber().getMacNumber()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getMacBalance().getMacBalanceReference()))
				.execute("TRDPB000_16");
			if (ctx.getSqlca().getSqlcode() == 0) {
				if (DataUtils.compare(ctx.getTrdOrderPair().getTrdBuyerIdReference(), ctx.getDcltbtrdsum().getSumCustomerIdReference()) == 0) {
					ctx.getDcltbtrdsum().setSumOpenBalance(ctx.getMacBalance().getMacBalance().add(ctx.getTrdOrderPair().getTrdOrderAmount()));
				} else {
					ctx.getDcltbtrdsum().setSumOpenBalance(ctx.getMacBalance().getMacBalance().subtract(ctx.getTrdOrderPair().getTrdOrderAmount()));
				}
				ctx.getDcltbtrdsum().getSumCloseBalanceReference().setValue(ctx.getDcltbtrdsum().getSumOpenBalanceReference());
			} 
		} 
		if (ctx.getWsOrderStatus().isOverdue()) {
			ctx.getDcltbtrdsum().setSumOverdue(ctx.getDcltbtrdsum().getSumOverdue() + 1);
		} else if (ctx.getWsOrderStatus().isRejected()) {
			ctx.getDcltbtrdsum().setSumRejected(ctx.getDcltbtrdsum().getSumRejected() + 1);
		} else if (ctx.getWsOrderStatus().isSettled()) {
			ctx.getDcltbtrdsum().setSumSettled(ctx.getDcltbtrdsum().getSumSettled() + 1);
		} 
		if (ctx.getWsSummaryDebitCreditSw().isSummaryDebit()) {
			ctx.getDcltbtrdsum().getSumCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
			ctx.getDcltbtrdsum().setSumTotalDebit(ctx.getDcltbtrdsum().getSumTotalDebit().add(ctx.getTrdOrderPair().getTrdOrderAmount()));
			ctx.getDcltbtrdsum().setSumCloseBalance(ctx.getDcltbtrdsum().getSumCloseBalance().subtract(ctx.getTrdOrderPair().getTrdOrderAmount()));
		} else if (ctx.getWsSummaryDebitCreditSw().isSummaryCredit()) {
			ctx.getDcltbtrdsum().getSumCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
			ctx.getDcltbtrdsum().setSumTotalCredit(ctx.getDcltbtrdsum().getSumTotalCredit().add(ctx.getTrdOrderPair().getTrdOrderAmount()));
			ctx.getDcltbtrdsum().setSumCloseBalance(ctx.getDcltbtrdsum().getSumCloseBalance().add(ctx.getTrdOrderPair().getTrdOrderAmount()));
		} else if (ctx.getWsSummaryDebitCreditSw().isSummaryNoBooking()) {
			
			/* 
			Do nothing */
		} 
		if (ctx.getWsCustomerSummaryWriteSw().isCustomerSummaryWrite()) {
			
			/* 
			INSERT   CUSTOMER SUMMARY */
			ctx.getDcltbtrdsum().setBytes(ctx.getWsCustomerSummaryRec().getBytes());
			SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumCustomerId()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumOverdue()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumRejected()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumSettled()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumCurrency()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumOpenBalance()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumTotalDebit()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumTotalCredit()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumCloseBalance()))
				.execute("TRDPB000_17");
		} else {
			SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumOverdue()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumRejected()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumSettled()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumCurrency()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumOpenBalance()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumTotalDebit()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumTotalCredit()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumCloseBalance()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdsum().getSumCustomerId()))
				.execute("TRDPB000_18");
		}
		
		/* 
		WHERE CURRENT OF SUMMARY_CSR */
		if (ctx.getSqlca().getSqlcode() == 0) {
			
			/* 
			Do nothing */
		} else {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			ctx.getWsExcpType().setApplException(true);
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Summary Insert/Update Failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
	}

}
