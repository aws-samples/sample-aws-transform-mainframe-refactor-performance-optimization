
package com.company.app.trdpb001.service.impl;

import com.company.app.trdpb001.business.context.Trdpb001Context;
import com.company.app.trdpb001.service.Trdpb001Process;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Class Trdpb001ProcessImpl
 * 
 * Defines application services for Trdpb001Process
 * @see Trdpb001Process
 */
@Service("com.company.app.trdpb001.service.Trdpb001Process")
@Lazy

public class Trdpb001ProcessImpl implements Trdpb001Process {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Trdpb001ProcessImpl.class);


	/**
	 * Process operation mainline.
	 * 
	 * Legacy: 0000-MAINLINE
	 * PROGRAM-ID.TRDPB001.
	 * ****************************************************************
	 *                                                                *
	 *  TRDPB001 : Order Settlement                                   *
	 *                                                                *
	 *   - Multi-threading of this process is based on running        *
	 *     multiple batch jobs for settling trades based on           *
	 *     currency                                                   *
	 *                                                                *
	 * ****************************************************************
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void mainline(final Trdpb001Context ctx, final ExecutionController ctrl) {
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.setAttribute(ESQLAttribute.WITH_HOLD)
			.setAttribute(ESQLAttribute.FOR_READ_ONLY)
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getStqCurrency().getStqCurrencyReference()))
			.execute("TRDPB001_1");
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
		ctx.getDcltbtrdlog().setLogTransaction("SETTLEMENT");
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
		ctx.getStqCurrency().getStqCurrencyReference().setValue(ctx.getLkParm().getLkCurrencyReference());
		ctx.getWsSettlementSwitch().setContinueSettlement(true);
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB001_2");
		if (ctx.getSqlca().getSqlcode() != 0) {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			ctx.getWsExcpType().setApplException(true);
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Open SETTLEMENT_QUEUE Cursor failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		} 
		ctx.getWsTradeCount().setWsTradeCount(0);
		while (!(ctx.getWsSettlementSwitch().isStopSettlement())) {
			tradeSettlement(ctx, ctrl);
		}
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
			.execute("TRDPB001_3");
		if (ctx.getSqlca().getSqlcode() == 0) {
			
			/* 
			Do nothing */
		} else if (ctx.getSqlca().getSqlcode() == -803) {
			SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdlog().getLogEndTs()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdlog().getLogTransaction()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getDcltbtrdlog().getLogCurrency()))
				.execute("TRDPB001_4");
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
	 * Process operation tradeSettlement.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void tradeSettlement(final Trdpb001Context ctx, final ExecutionController ctrl) {
		ctx.getWsTradeCount().setWsTradeCount(ctx.getWsTradeCount().getWsTradeCount() + 1);
		readFromStlmtQueue(ctx, ctrl);
		if (ctx.getWsSettlementSwitch().isContinueSettlement()) {
			accounting(ctx, ctrl);
			if (NumberUtils.ge(ctx.getWsTradeCount().getWsTradeCountReference(), ctx.getLkParm().getLkChkpFrequencyReference())) {
				ctrl.getExecutionContext().commitConnection(SqlcaHandler.setSqlcodeAndSqlstate, ctx.getSqlca());
				ctx.getWsTradeCount().setWsTradeCount(0);
			} 
		}
	}

	/**
	 * Process operation accounting.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void accounting(final Trdpb001Context ctx, final ExecutionController ctrl) {
		sacBooking(ctx, ctrl);
		if (ctx.getTrdOrderPair().isTrdSacBookingDone()) {
			macBooking(ctx, ctrl);
		} 
		if (ctx.getTrdOrderPair().isTrdMacBookingDone()) {
			
			/* 
			Update Buyer/Seller Order status to SETTLED */
			ctx.getWsOrderStatus().setSettled(true);
		} else {
			
			/* 
			Update Buyer/Seller Order status to REJECTED */
			ctx.getWsOrderStatus().setRejected(true);
		}
		ctx.getOrdStatus().getOrdStatusReference().setValue(ctx.getWsOrderStatus().getWsOrderStatusReference());
		ctx.getOrdCurrency().getOrdCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
		ctx.getOrdTradingXchng().getOrdTradingXchngReference().setValue(ctx.getTrdOrderPair().getTrdExchangeReference());
		ctx.getOrdTradeid().getOrdTradeidReference().setValue(ctx.getTrdOrderPair().getTrdOrderIdReference());
		ctx.getOrdFigi().getOrdFigiReference().setValue(ctx.getTrdOrderPair().getTrdFigiReference());
		ctx.getOrdBuySellInd().setOrdBuySellInd("B");
		updateOrder(ctx, ctrl);
		ctx.getOrdBuySellInd().setOrdBuySellInd("S");
		updateOrder(ctx, ctrl);
		
		/* 
		Do nothing */
		return;
	}

	/**
	 * Process operation sacBooking.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void sacBooking(final Trdpb001Context ctx, final ExecutionController ctrl) {
		ctrl.callSubProgram(ctx.getWsSacBooking().getWsSacBooking(), CallBuilder.newInstance()
			.byReference(ctx.getTrdOrderPair())
			.getArguments(), ctx);
		if (ctx.getTrdOrderPair().isTrdSacBookingDone()) {
			
			/* 
			Do nothing */
		} else {
			ctx.getWsExcpType().setDataException(true);
			ctx.getWsTradeid().setWsTradeid(NumberUtils.convert(ctx.getTrdOrderPair().getTrdOrderId()).intValue());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("TradeId = ")
				.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
				.addDelimitedBySize(" : ")
				.addDelimitedBySize("Rejected - Reason : Security Bookings Failed")
				.end();
			reportException(ctx, ctrl);
		}
		
		/* 
		Do nothing */
		return;
	}

	/**
	 * Process operation macBooking.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void macBooking(final Trdpb001Context ctx, final ExecutionController ctrl) {
		ctrl.callSubProgram(ctx.getWsMacBooking().getWsMacBooking(), CallBuilder.newInstance()
			.byReference(ctx.getTrdOrderPair())
			.getArguments(), ctx);
		if (ctx.getTrdOrderPair().isTrdMacBookingDone()) {
			
			/* 
			Do nothing */
		} else {
			ctx.getWsExcpType().setDataException(true);
			ctx.getWsTradeid().setWsTradeid(NumberUtils.convert(ctx.getTrdOrderPair().getTrdOrderId()).intValue());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("TradeId = ")
				.addDelimitedBySize(ctx.getWsTradeid().getWsTradeidReference().getValue(String.class))
				.addDelimitedBySize(" : ")
				.addDelimitedBySize("Rejected - Reason : Money Bookings Failed")
				.end();
			reportException(ctx, ctrl);
		}
		
		/* 
		Do nothing */
		return;
	}

	/**
	 * Process operation readFromStlmtQueue.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void readFromStlmtQueue(final Trdpb001Context ctx, final ExecutionController ctrl) {
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getStqId().getStqIdReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getStqTradeData().getStqTradeDataReference()))
			.execute("TRDPB001_5");
		if (ctx.getSqlca().getSqlcode() == 0) {
			ctx.getTrdOrderPair().setBytes(ctx.getStqTradeData().getStqTradeDataReference().getBytes());
			SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getStqCurrency().getStqCurrency()))
				.mapInParameter(SQLParameterBuilder.newInstance(ctx.getStqId().getStqId()))
				.execute("TRDPB001_6");
			if (ctx.getSqlca().getSqlcode() != 0) {
				ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
				ctx.getWsExcpType().setApplException(true);
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("Delete on TBTRDSTQ failed : ")
					.addDelimitedBySize("SQLCODE = ")
					.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
					.end();
				reportException(ctx, ctrl);
			} 
		} else if (ctx.getSqlca().getSqlcode() == 100) {
			ctx.getWsSettlementSwitch().setStopSettlement(true);
		} else {
			ctx.getWsSettlementSwitch().setStopSettlement(true);
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			ctx.getWsExcpType().setApplException(true);
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Fetch SETTLEMENT_QUEUE Cursor failed : ")
				.addDelimitedBySize("SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
	}

	/**
	 * Process operation updateOrder.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void updateOrder(final Trdpb001Context ctx, final ExecutionController ctrl) {
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
				.execute("TRDPB001_7");
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
		if (ctx.getWsOrderStatus().isRejected() || ctx.getWsOrderStatus().isSettled()) {
			ctx.getWsCustomerSummaryRec().getField().initialize();
			if (ctx.getWsOrderStatus().isRejected()) {
				ctx.getWsSummaryDebitCreditSw().setSummaryNoBooking(true);
			} else {
				if (DataUtils.compare(ctx.getOrdBuySellInd().getOrdBuySellIndReference(), "B") == 0) {
					ctx.getWsCustomerSummaryRec().getWsSummaryCustomerIdReference().setValue(ctx.getTrdOrderPair().getTrdBuyerIdReference());
					ctx.getWsSummaryDebitCreditSw().setSummaryDebit(true);
				} else {
					ctx.getWsCustomerSummaryRec().getWsSummaryCustomerIdReference().setValue(ctx.getTrdOrderPair().getTrdSellerIdReference());
					ctx.getWsSummaryDebitCreditSw().setSummaryCredit(true);
				}
			}
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
	public void reportException(final Trdpb001Context ctx, final ExecutionController ctrl) {
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
	public void logSummary(final Trdpb001Context ctx, final ExecutionController ctrl) {
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
			.execute("TRDPB001_8");
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
				.execute("TRDPB001_9");
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
				.execute("TRDPB001_10");
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
				.execute("TRDPB001_11");
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
