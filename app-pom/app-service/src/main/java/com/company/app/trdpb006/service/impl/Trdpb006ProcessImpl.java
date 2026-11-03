
package com.company.app.trdpb006.service.impl;

import com.company.app.trdpb006.business.context.Trdpb006Context;
import com.company.app.trdpb006.service.Trdpb006Process;
import com.netfective.bluage.gapwalk.database.support.central.ESQLAttribute;
import com.netfective.bluage.gapwalk.database.support.central.SQLExecutorBuilder;
import com.netfective.bluage.gapwalk.database.support.central.SQLParameterBuilder;
import com.netfective.bluage.gapwalk.database.support.central.functions.SqlcaHandler;
import com.netfective.bluage.gapwalk.datasimplifier.utils.DataUtils;
import com.netfective.bluage.gapwalk.datasimplifier.utils.NumberUtils;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;
import com.netfective.bluage.gapwalk.rt.io.OpenMode;
import com.netfective.bluage.gapwalk.rt.io.SequentialFile;
import com.netfective.bluage.gapwalk.runtime.tool.DisplayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Class Trdpb006ProcessImpl
 * 
 * Defines application services for Trdpb006Process
 * @see Trdpb006Process
 */
@Service("com.company.app.trdpb006.service.Trdpb006Process")
@Lazy

public class Trdpb006ProcessImpl implements Trdpb006Process {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Trdpb006ProcessImpl.class);


	/**
	 * Process operation mainline.
	 * 
	 * Legacy: 0000-MAINLINE
	 * PROGRAM-ID.TRDPB006.
	 * ****************************************************************
	 *                                                                *
	 *  TRDPB006 : Generate Trading Order Report                      *
	 *                                                                *
	 *                                                                *
	 * ****************************************************************
	 *                                                                *
	 *                                                                *
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void mainline(final Trdpb006Context ctx, final ExecutionController ctrl) {
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.setAttribute(ESQLAttribute.WITH_HOLD)
			.setAttribute(ESQLAttribute.FOR_READ_ONLY)
			.execute("TRDPB006_1");
		
		/* 
		****************************************************************
		THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 4       * */
		initialize(ctx, ctrl);
		openOrderCursorRptfile(ctx, ctrl);
		while (!(ctx.getWsEndOfOrdersSw().isEndOfOrders())) {
			fetchProcessOrders(ctx, ctrl);
		}
		closOrderCursorRptfile(ctx, ctrl);
		ctrl.getExecutionContext().commitConnection(SqlcaHandler.setSqlcodeAndSqlstate, ctx.getSqlca());
		if (ctx.isMainProgram()) {
			ctrl.stopRunUnit();
		}
	}

	/**
	 * Process operation initialize.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void initialize(final Trdpb006Context ctx, final ExecutionController ctrl) {
		ctx.getWsPrintHeader().setPrintPageHeader(true);
		DataUtils.setToBlank(ctx.getWsEndOfOrdersSw().getWsEndOfOrdersSwReference());
		
		/* 
		Do nothing */
		return;
	}

	/**
	 * Process operation openOrderCursorRptfile.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void openOrderCursorRptfile(final Trdpb006Context ctx, final ExecutionController ctrl) {
		SequentialFile reporder = ctx.getReporderHandler(ctrl.getExecutionContext()); 
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB006_2");
		if (ctx.getSqlca().getSqlcode() != 0) {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "Open Client_orders Cursor Failed - SQLCode = " , ctx.getWsSqlcode().getWsSqlcode());
			terminate(ctx, ctrl);
		} 
		reporder.open(OpenMode.OUTPUT);
		if (DataUtils.compare(ctx.getReporderFileStatus().getReporderFileStatusReference(), "00") == 0) {
			
			/* 
			Do nothing */
		} else {
			DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "Open Order Report Failed - FileStatus = " , ctx.getReporderFileStatus().getReporderFileStatus());
			terminate(ctx, ctrl);
		}
		
		/* 
		Do nothing */
		return;
	}

	/**
	 * Process operation fetchProcessOrders.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void fetchProcessOrders(final Trdpb006Context ctx, final ExecutionController ctrl) {
		SequentialFile reporder = ctx.getReporderHandler(ctrl.getExecutionContext()); 
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdTradeid().getOrdTradeidReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdTradingXchng().getOrdTradingXchngReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdBuySellInd().getOrdBuySellIndReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdCustomerId().getOrdCustomerIdReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getCusDescription().getCusDescriptionReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdFigi().getOrdFigiReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSecSymbol().getSecSymbolReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSecDescription().getSecDescriptionReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSecType().getSecTypeReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdQuantity().getOrdQuantityReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdCurrency().getOrdCurrencyReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdAmount().getOrdAmountReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getOrdStatus().getOrdStatusReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getWsBuyerSellerCustId().getWsBuyerSellerCustIdReference()))
			.execute("TRDPB006_3");
		ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
		if (ctx.getSqlca().getSqlcode() == 0) {
			
			/* 
			Do nothing */
		} else if (ctx.getSqlca().getSqlcode() == 100) {
			ctx.getWsEndOfOrdersSw().setEndOfOrders(true);
			ctx.getReporder().getReporderRecordReference().setBytes(ctx.getWsDetailHdr2().getBytes());
			reporder.write(ctx.getReporder().getReporderRecordReference());
			return;
		} else {
			DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "Fetch of Client_orders Cursor Failed - SQLCode = " , ctx.getWsSqlcode().getWsSqlcode());
			terminate(ctx, ctrl);
		}
		if (DataUtils.compare(ctx.getOrdCustomerId().getOrdCustomerId(), ctx.getWsPrevCustid()) != 0 || DataUtils.compare(ctx.getOrdBuySellInd().getOrdBuySellInd(), ctx.getWsPrevBuySell()) != 0) {
			ctx.getWsPrintHeader().setPrintPageHeader(true);
		} else {
			if (DataUtils.compare(ctx.getOrdStatus().getOrdStatus(), ctx.getWsPrevOrderStatus()) != 0) {
				ctx.getWsPrintHeader().setPrintHeader1(true);
			} 
		}
		ctx.setWsPrevCustid(ctx.getOrdCustomerId().getOrdCustomerId());
		ctx.setWsPrevBuySell(ctx.getOrdBuySellInd().getOrdBuySellInd());
		ctx.setWsPrevOrderStatus(ctx.getOrdStatus().getOrdStatus());
		if (ctx.getWsPrintHeader().isPrintPageHeader()) {
			ctx.getWsPagenum().setWsPagenum(ctx.getWsPagenum().getWsPagenum() + 1);
			ctx.getWsPageHeader().getWsPhPagenumReference().setValue(ctx.getWsPagenum().getWsPagenum());
			ctx.getWsPageHeader().getWsPhCustomerReference().setValue(ctx.getOrdCustomerId().getOrdCustomerIdReference());
			ctx.getWsPageHeader().setWsPhCustomerDesc(ctx.getCusDescription().getCusDescription());
			if (DataUtils.compare(ctx.getOrdBuySellInd().getOrdBuySellIndReference(), "B") == 0) {
				ctx.getWsPageHeader().setPhBuyOrders(true);
			} else {
				ctx.getWsPageHeader().setPhSellOrders(true);
			}
			ctx.getReporder().setReporderRecord(ctx.getWsEmptyHdr());
			reporder.write(ctx.getReporder().getReporderRecordReference());
			reporder.advancePage(true);
			ctx.getReporder().getReporderRecordReference().setBytes(ctx.getWsPageHeader().getBytes());
			reporder.write(ctx.getReporder().getReporderRecordReference());
			ctx.getWsPrintHeader().setPrintHeader1(true);
			ctx.getWsOrderCount().setWsOrderCount(0);
		} 
		if (ctx.getWsPrintHeader().isPrintHeader1()) {
			ctx.getWsHeader1().setWsH1OrderStatusCode(NumberUtils.convert(ctx.getOrdStatus().getOrdStatus()).intValue());
			if (DataUtils.compare(ctx.getOrdStatus().getOrdStatusReference(), "101") == 0) {
				ctx.getWsHeader1().setWsH1OrderStatusDesc("Accepted");
			} else if (DataUtils.compare(ctx.getOrdStatus().getOrdStatusReference(), "201") == 0) {
				ctx.getWsHeader1().setWsH1OrderStatusDesc("Matched");
			} else if (DataUtils.compare(ctx.getOrdStatus().getOrdStatusReference(), "301") == 0) {
				ctx.getWsHeader1().setWsH1OrderStatusDesc("Overdue-Buyer Invld");
			} else if (DataUtils.compare(ctx.getOrdStatus().getOrdStatusReference(), "302") == 0) {
				ctx.getWsHeader1().setWsH1OrderStatusDesc("Overdue-SellerInvld");
			} else if (DataUtils.compare(ctx.getOrdStatus().getOrdStatusReference(), "303") == 0) {
				ctx.getWsHeader1().setWsH1OrderStatusDesc("Overdue-Security");
			} else if (DataUtils.compare(ctx.getOrdStatus().getOrdStatusReference(), "304") == 0) {
				ctx.getWsHeader1().setWsH1OrderStatusDesc("Overdue-Buyer Acct");
			} else if (DataUtils.compare(ctx.getOrdStatus().getOrdStatusReference(), "305") == 0) {
				ctx.getWsHeader1().setWsH1OrderStatusDesc("Overdue-Seller Acct");
			} else if (DataUtils.compare(ctx.getOrdStatus().getOrdStatusReference(), "306") == 0 || DataUtils.compare(ctx.getOrdStatus().getOrdStatusReference(), "307") == 0) {
				ctx.getWsHeader1().setWsH1OrderStatusDesc("Overdue-OrderStatus");
			} else if (DataUtils.compare(ctx.getOrdStatus().getOrdStatusReference(), "308") == 0) {
				ctx.getWsHeader1().setWsH1OrderStatusDesc("Overdue-MissingOrdr");
			} else if (DataUtils.compare(ctx.getOrdStatus().getOrdStatusReference(), "401") == 0) {
				ctx.getWsHeader1().setWsH1OrderStatusDesc("Overdue-Rejected");
			} else if (DataUtils.compare(ctx.getOrdStatus().getOrdStatusReference(), "601") == 0) {
				ctx.getWsHeader1().setWsH1OrderStatusDesc("Settled");
			} else {
				ctx.getWsHeader1().setWsH1OrderStatusDesc("Unknown");
			}
			ctx.getReporder().setReporderRecord(ctx.getWsEmptyHdr());
			reporder.write(ctx.getReporder().getReporderRecordReference());
			reporder.advanceLines(2, true);
			ctx.getReporder().getReporderRecordReference().setBytes(ctx.getWsHeader1().getBytes());
			reporder.write(ctx.getReporder().getReporderRecordReference());
			ctx.getReporder().setReporderRecord(ctx.getWsEmptyHdr());
			reporder.write(ctx.getReporder().getReporderRecordReference());
			ctx.getWsPrintHeader().setPrintDetailHdr(true);
		} 
		if (ctx.getWsPrintHeader().isPrintDetailHdr()) {
			if (DataUtils.compare(ctx.getOrdBuySellInd().getOrdBuySellIndReference(), "B") == 0) {
				ctx.getWsDetailHdr1().setDh1Seller(true);
			} else {
				ctx.getWsDetailHdr1().setDh1Buyer(true);
			}
			ctx.getReporder().getReporderRecordReference().setBytes(ctx.getWsDetailHdr2().getBytes());
			reporder.write(ctx.getReporder().getReporderRecordReference());
			reporder.advanceLines(1, true);
			ctx.getReporder().getReporderRecordReference().setBytes(ctx.getWsDetailHdr1().getBytes());
			reporder.write(ctx.getReporder().getReporderRecordReference());
			ctx.getReporder().getReporderRecordReference().setBytes(ctx.getWsDetailHdr2().getBytes());
			reporder.write(ctx.getReporder().getReporderRecordReference());
			ctx.getWsPrintHeader().setPrintDetail(true);
		} 
		ctx.getWsDetailRec().setWsDetTradeid(ctx.getOrdTradeid().getOrdTradeid());
		ctx.getWsDetailRec().setWsDetTradingXchng(ctx.getOrdTradingXchng().getOrdTradingXchng());
		ctx.getWsDetailRec().getWsDetFigiReference().setValue(ctx.getOrdFigi().getOrdFigiReference());
		ctx.getWsDetailRec().getWsDetSymbolReference().setValue(ctx.getSecSymbol().getSecSymbolReference());
		ctx.getWsDetailRec().getWsDetDescriptionReference().setValue(ctx.getSecDescription().getSecDescriptionReference());
		ctx.getWsDetailRec().setWsDetType(ctx.getSecType().getSecType());
		ctx.getWsDetailRec().getWsDetQuantityReference().setValue(ctx.getOrdQuantity().getOrdQuantity());
		ctx.getWsDetailRec().getWsDetCurrencyReference().setValue(ctx.getOrdCurrency().getOrdCurrencyReference());
		ctx.getWsDetailRec().getWsDetAmountReference().setValue(ctx.getOrdAmount().getOrdAmount());
		ctx.getWsDetailRec().getWsDetBuyerSellerReference().setValue(ctx.getWsBuyerSellerCustId().getWsBuyerSellerCustIdReference());
		ctx.getWsOrderCount().setWsOrderCount(ctx.getWsOrderCount().getWsOrderCount() + 1);
		ctx.getWsPrintHeader().setPrintDetail(true);
		ctx.getReporder().getReporderRecordReference().setBytes(ctx.getWsDetailRec().getBytes());
		reporder.write(ctx.getReporder().getReporderRecordReference());
		if (ctx.getWsOrderCount().getWsOrderCount() > ctx.getWsMaxOrdersPerPage().getWsMaxOrdersPerPage()) {
			ctx.getReporder().getReporderRecordReference().setBytes(ctx.getWsDetailHdr2().getBytes());
			reporder.write(ctx.getReporder().getReporderRecordReference());
			ctx.getWsPrintHeader().setPrintPageHeader(true);
		} 
		
		/* 
		Do nothing */
		return;
	}

	/**
	 * Process operation closOrderCursorRptfile.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void closOrderCursorRptfile(final Trdpb006Context ctx, final ExecutionController ctrl) {
		SequentialFile reporder = ctx.getReporderHandler(ctrl.getExecutionContext()); 
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB006_4");
		if (ctx.getSqlca().getSqlcode() != 0) {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "Close Client_orders Cursor Failed - SQLCode = " , ctx.getWsSqlcode().getWsSqlcode());
			terminate(ctx, ctrl);
		} 
		reporder.close();
		if (DataUtils.compare(ctx.getReporderFileStatus().getReporderFileStatusReference(), "00") == 0) {
			
			/* 
			Do nothing */
		} else {
			DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "Close Order Report Failed - FileStatus = " , ctx.getReporderFileStatus().getReporderFileStatus());
			terminate(ctx, ctrl);
		}
		
		/* 
		Do nothing */
		return;
	}

	/**
	 * Process operation terminate.
	 * 
	 * Legacy: 9999-TERMINATE
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void terminate(final Trdpb006Context ctx, final ExecutionController ctrl) {
		ctx.setReturnCode(16);
		DisplayUtils.display(ctx, ctrl, LOGGER, "Terminating TRDBP006 due to error!!");
		if (ctx.isMainProgram()) {
			ctrl.stopRunUnit();
		} 
		ctrl.stopProgram();
	}

}
