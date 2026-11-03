
package com.company.app.trdpb004.service.impl;

import com.company.app.trdpb004.business.context.Trdpb004Context;
import com.company.app.trdpb004.service.Trdpb004Process;
import com.netfective.bluage.gapwalk.database.support.central.ESQLAttribute;
import com.netfective.bluage.gapwalk.database.support.central.SQLExecutorBuilder;
import com.netfective.bluage.gapwalk.database.support.central.SQLParameterBuilder;
import com.netfective.bluage.gapwalk.database.support.central.functions.SqlcaHandler;
import com.netfective.bluage.gapwalk.datasimplifier.utils.DataUtils;
import com.netfective.bluage.gapwalk.datasimplifier.utils.NumberUtils;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;
import com.netfective.bluage.gapwalk.rt.io.OpenMode;
import com.netfective.bluage.gapwalk.rt.io.SequentialFile;
import com.netfective.bluage.gapwalk.runtime.statements.StringConcatenationBuilder;
import com.netfective.bluage.gapwalk.runtime.tool.DisplayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Class Trdpb004ProcessImpl
 * 
 * Defines application services for Trdpb004Process
 * @see Trdpb004Process
 */
@Service("com.company.app.trdpb004.service.Trdpb004Process")
@Lazy

public class Trdpb004ProcessImpl implements Trdpb004Process {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Trdpb004ProcessImpl.class);


	/**
	 * Process operation mainline.
	 * 
	 * Legacy: 0000-MAINLINE
	 * PROGRAM-ID.TRDPB004.
	 * ****************************************************************
	 *                                                                *
	 *  TRDPB004 : Exception, Execution Statistics, Customer Summary  *
	 *             Reports                                            *
	 *                                                                *
	 *                                                                *
	 * ****************************************************************
	 *                                                                *
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void mainline(final Trdpb004Context ctx, final ExecutionController ctrl) {
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.setAttribute(ESQLAttribute.WITH_HOLD)
			.setAttribute(ESQLAttribute.FOR_READ_ONLY)
			.execute("TRDPB004_1");
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.setAttribute(ESQLAttribute.WITH_HOLD)
			.setAttribute(ESQLAttribute.FOR_READ_ONLY)
			.execute("TRDPB004_2");
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.setAttribute(ESQLAttribute.WITH_HOLD)
			.setAttribute(ESQLAttribute.FOR_READ_ONLY)
			.execute("TRDPB004_3");
		
		/* 
		****************************************************************
		THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 4       *
		WITH UR */
		initialize(ctx, ctrl);
		processException(ctx, ctrl);
		processTimings(ctx, ctrl);
		processSummaryRpt(ctx, ctrl);
		cleanup(ctx, ctrl);
		ctx.setReturnCode(0);
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
	public void initialize(final Trdpb004Context ctx, final ExecutionController ctrl) {
		DataUtils.setAll("-", ctx.getHdrRunlogRecDash().getFiller1Reference());
		ctx.getHdrRunlogRecDash().setFiller2("--------");
		DataUtils.setAll("-", ctx.getHdrRunlogRecDash().getFiller3Reference());
		DataUtils.setAll("-", ctx.getHdrRunlogRecDash().getFiller4Reference());
		DataUtils.setAll("-", ctx.getHdrExcptionRecDash().getFiller1Reference());
		DataUtils.setAll("-", ctx.getHdrExcptionRecDash().getFiller2Reference());
		DataUtils.setAll("-", ctx.getHdrSummaryRecDash().getFiller1Reference());
		DataUtils.setAll("-", ctx.getHdrSummaryRecDash().getFiller2Reference());
		DataUtils.setAll("-", ctx.getHdrSummaryRecDash().getFiller3Reference());
		DataUtils.setAll("-", ctx.getHdrSummaryRecDash().getFiller4Reference());
		ctx.getHdrSummaryRecDash().setFiller5("--------");
		DataUtils.setAll("-", ctx.getHdrSummaryRecDash().getFiller6Reference());
		DataUtils.setAll("-", ctx.getHdrSummaryRecDash().getFiller7Reference());
		DataUtils.setAll("-", ctx.getHdrSummaryRecDash().getFiller8Reference());
		DataUtils.setAll("-", ctx.getHdrSummaryRecDash().getFiller9Reference());
		
		/* 
		Do nothing */
		return;
	}

	/**
	 * Process operation processException.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void processException(final Trdpb004Context ctx, final ExecutionController ctrl) {
		SequentialFile excptionReport = ctx.getExcptionReportHandler(ctrl.getExecutionContext()); 
		excptionReport.open(OpenMode.OUTPUT);
		if (NumberUtils.ne(ctx.getExcptionFileStatus().getExcptionFileStatusReference(), 0)) {
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Open EXCEPTION FILE failed : File-Status = ")
				.addDelimitedBySize(ctx.getExcptionFileStatus().getExcptionFileStatusReference().getValue(String.class))
				.end();
			reportException(ctx, ctrl);
		} 
		ctx.getExcptionReport().getExcptionRecordReference().setBytes(ctx.getHdrExcptionRecDash().getBytes());
		excptionReport.write(ctx.getExcptionReport().getExcptionRecordReference());
		ctx.getExcptionReport().getExcptionRecordReference().setBytes(ctx.getHdrExcptionRec().getBytes());
		excptionReport.write(ctx.getExcptionReport().getExcptionRecordReference());
		ctx.getExcptionReport().getExcptionRecordReference().setBytes(ctx.getHdrExcptionRecDash().getBytes());
		excptionReport.write(ctx.getExcptionReport().getExcptionRecordReference());
		if (NumberUtils.ne(ctx.getExcptionFileStatus().getExcptionFileStatusReference(), 0)) {
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Write EXCEPTION Header failed : File-Status = ")
				.addDelimitedBySize(ctx.getExcptionFileStatus().getExcptionFileStatusReference().getValue(String.class))
				.end();
			reportException(ctx, ctrl);
		} 
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB004_4");
		if (ctx.getSqlca().getSqlcode() != 0) {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Open EXCPTION_CURSOR Cursor failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		} 
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getExcType().getExcTypeReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getExcDescription()))
			.execute("TRDPB004_5");
		if (ctx.getSqlca().getSqlcode() == 0) {
			
			/* 
			Do nothing */
		} else if (ctx.getSqlca().getSqlcode() == 100) {
			ctx.getExcptionReport().setExcptionRecord("*** No Exceptions ****");
			excptionReport.write(ctx.getExcptionReport().getExcptionRecordReference());
			if (NumberUtils.ne(ctx.getExcptionFileStatus().getExcptionFileStatusReference(), 0)) {
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("Write EXCEPTION FILE failed : File-Status = ")
					.addDelimitedBySize(ctx.getExcptionFileStatus().getExcptionFileStatusReference().getValue(String.class))
					.end();
				reportException(ctx, ctrl);
			} 
		} else {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Fetch EXCPTION_CURSOR Cursor failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
		while (ctx.getSqlca().getSqlcode() == 0) {
			
			/* 
			MOVE EXC-TIMESTAMP     TO PRT-EXCPTION-TS */
			ctx.getPrtExcptionRec().getPrtExcptionTypeReference().setValue(ctx.getExcType().getExcTypeReference());
			int len = ctx.getExcDescription().getExcDescriptionLen();
			ctx.getPrtExcptionRec().getPrtExcptionDescReference().setBytes(ctx.getExcDescription().getExcDescriptionTextReference().getBytes(0, len));
			ctx.getExcptionReport().getExcptionRecordReference().setBytes(ctx.getPrtExcptionRec().getBytes());
			excptionReport.write(ctx.getExcptionReport().getExcptionRecordReference());
			if (NumberUtils.ne(ctx.getExcptionFileStatus().getExcptionFileStatusReference(), 0)) {
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("Write EXCEPTION Header failed : File-Status = ")
					.addDelimitedBySize(ctx.getExcptionFileStatus().getExcptionFileStatusReference().getValue(String.class))
					.end();
				reportException(ctx, ctrl);
			} 
			SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getExcType().getExcTypeReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getExcDescription()))
				.execute("TRDPB004_6");
			if (ctx.getSqlca().getSqlcode() == 0 || ctx.getSqlca().getSqlcode() == 100) {
				
				/* 
				Do nothing */
			} else {
				ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("Fetch EXCPTION_CURSOR Cursor failed : SQLCODE = ")
					.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
					.end();
				reportException(ctx, ctrl);
			}
		}
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB004_7");
		if (ctx.getSqlca().getSqlcode() == 0) {
			
			/* 
			Do nothing */
		} else {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Close EXCPTION_CURSOR failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
		ctx.getExcptionReport().getExcptionRecordReference().setBytes(ctx.getHdrExcptionRecDash().getBytes());
		excptionReport.write(ctx.getExcptionReport().getExcptionRecordReference());
		excptionReport.close();
		if (NumberUtils.ne(ctx.getExcptionFileStatus().getExcptionFileStatusReference(), 0)) {
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Close EXCEPTION FILE failed : File-Status = ")
				.addDelimitedBySize(ctx.getExcptionFileStatus().getExcptionFileStatusReference().getValue(String.class))
				.end();
			reportException(ctx, ctrl);
		} 
		
		/* 
		Do nothing */
		return;
	}

	/**
	 * Process operation processTimings.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void processTimings(final Trdpb004Context ctx, final ExecutionController ctrl) {
		SequentialFile runlogReport = ctx.getRunlogReportHandler(ctrl.getExecutionContext()); 
		runlogReport.open(OpenMode.OUTPUT);
		if (NumberUtils.ne(ctx.getRunlogFileStatus().getRunlogFileStatusReference(), 0)) {
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Open RUNLOG FILE failed : File-Status = ")
				.addDelimitedBySize(ctx.getRunlogFileStatus().getRunlogFileStatusReference().getValue(String.class))
				.end();
			reportException(ctx, ctrl);
		} 
		ctx.getRunlogReport().getRunlogRecordReference().setBytes(ctx.getHdrRunlogRecDash().getBytes());
		runlogReport.write(ctx.getRunlogReport().getRunlogRecordReference());
		ctx.getRunlogReport().getRunlogRecordReference().setBytes(ctx.getHdrRunlogRec().getBytes());
		runlogReport.write(ctx.getRunlogReport().getRunlogRecordReference());
		ctx.getRunlogReport().getRunlogRecordReference().setBytes(ctx.getHdrRunlogRecDash().getBytes());
		runlogReport.write(ctx.getRunlogReport().getRunlogRecordReference());
		if (NumberUtils.ne(ctx.getRunlogFileStatus().getRunlogFileStatusReference(), 0)) {
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Write EXCEPTION Header failed : File-Status = ")
				.addDelimitedBySize(ctx.getRunlogFileStatus().getRunlogFileStatusReference().getValue(String.class))
				.end();
			reportException(ctx, ctrl);
		} 
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB004_8");
		if (ctx.getSqlca().getSqlcode() != 0) {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Open RUNLOG_CURSOR Cursor failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		} 
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getLogTransaction().getLogTransactionReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getLogCurrency().getLogCurrencyReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getLogStartTs().getLogStartTsReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getLogEndTs().getLogEndTsReference()))
			.execute("TRDPB004_9");
		if (ctx.getSqlca().getSqlcode() == 0 || ctx.getSqlca().getSqlcode() == 100) {
			
			/* 
			Do nothing */
		} else {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Fetch RUNLOG_CURSOR Cursor failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
		while (ctx.getSqlca().getSqlcode() == 0) {
			ctx.getPrtRunlogRec().setPrtRunlogTransaction(ctx.getLogTransaction().getLogTransaction());
			ctx.getPrtRunlogRec().setPrtRunlogCurrency(ctx.getLogCurrency().getLogCurrency());
			ctx.getPrtRunlogRec().getPrtRunlogStartTsReference().setValue(ctx.getLogStartTs().getLogStartTsReference());
			ctx.getPrtRunlogRec().getPrtRunlogEndTsReference().setValue(ctx.getLogEndTs().getLogEndTsReference());
			ctx.getRunlogReport().getRunlogRecordReference().setBytes(ctx.getPrtRunlogRec().getBytes());
			runlogReport.write(ctx.getRunlogReport().getRunlogRecordReference());
			if (NumberUtils.ne(ctx.getRunlogFileStatus().getRunlogFileStatusReference(), 0)) {
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("Write EXCEPTION Header failed : File-Status = ")
					.addDelimitedBySize(ctx.getRunlogFileStatus().getRunlogFileStatusReference().getValue(String.class))
					.end();
				reportException(ctx, ctrl);
			} 
			SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getLogTransaction().getLogTransactionReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getLogCurrency().getLogCurrencyReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getLogStartTs().getLogStartTsReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getLogEndTs().getLogEndTsReference()))
				.execute("TRDPB004_10");
			if (ctx.getSqlca().getSqlcode() == 0 || ctx.getSqlca().getSqlcode() == 100) {
				
				/* 
				Do nothing */
			} else {
				ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("Fetch RUNLOG_CURSOR Cursor failed : SQLCODE = ")
					.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
					.end();
				reportException(ctx, ctrl);
			}
		}
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB004_11");
		if (ctx.getSqlca().getSqlcode() == 0) {
			
			/* 
			Do nothing */
		} else {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Close RUNLOG_CURSOR failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
		ctx.getRunlogReport().getRunlogRecordReference().setBytes(ctx.getHdrRunlogRecDash().getBytes());
		runlogReport.write(ctx.getRunlogReport().getRunlogRecordReference());
		runlogReport.close();
		if (NumberUtils.ne(ctx.getRunlogFileStatus().getRunlogFileStatusReference(), 0)) {
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Close RUNLOG FILE failed : File-Status = ")
				.addDelimitedBySize(ctx.getRunlogFileStatus().getRunlogFileStatusReference().getValue(String.class))
				.end();
			reportException(ctx, ctrl);
		} 
		
		/* 
		Do nothing */
		return;
	}

	/**
	 * Process operation processSummaryRpt.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void processSummaryRpt(final Trdpb004Context ctx, final ExecutionController ctrl) {
		SequentialFile summaryReport = ctx.getSummaryReportHandler(ctrl.getExecutionContext()); 
		summaryReport.open(OpenMode.OUTPUT);
		if (NumberUtils.ne(ctx.getSummaryFileStatus().getSummaryFileStatusReference(), 0)) {
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Open SUMMARY FILE failed : File-Status = ")
				.addDelimitedBySize(ctx.getSummaryFileStatus().getSummaryFileStatusReference().getValue(String.class))
				.end();
			reportException(ctx, ctrl);
		} 
		ctx.getSummaryReport().getSummaryRecordReference().setBytes(ctx.getHdrSummaryRecDash().getBytes());
		summaryReport.write(ctx.getSummaryReport().getSummaryRecordReference());
		ctx.getSummaryReport().getSummaryRecordReference().setBytes(ctx.getHdrSummaryRec().getBytes());
		summaryReport.write(ctx.getSummaryReport().getSummaryRecordReference());
		ctx.getSummaryReport().getSummaryRecordReference().setBytes(ctx.getHdrSummaryRecDash().getBytes());
		summaryReport.write(ctx.getSummaryReport().getSummaryRecordReference());
		if (NumberUtils.ne(ctx.getSummaryFileStatus().getSummaryFileStatusReference(), 0)) {
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Write EXCEPTION Header failed : File-Status = ")
				.addDelimitedBySize(ctx.getSummaryFileStatus().getSummaryFileStatusReference().getValue(String.class))
				.end();
			reportException(ctx, ctrl);
		} 
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB004_12");
		if (ctx.getSqlca().getSqlcode() != 0) {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Open SUMMARY_CURSOR Cursor failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		} 
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumCustomerId().getSumCustomerIdReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumOverdue().getSumOverdueReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumRejected().getSumRejectedReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumSettled().getSumSettledReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumCurrency().getSumCurrencyReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumOpenBalance().getSumOpenBalanceReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumTotalDebit().getSumTotalDebitReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumTotalCredit().getSumTotalCreditReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumCloseBalance().getSumCloseBalanceReference()))
			.execute("TRDPB004_13");
		if (ctx.getSqlca().getSqlcode() == 0 || ctx.getSqlca().getSqlcode() == 100) {
			
			/* 
			Do nothing */
		} else {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Fetch SUMMARY_CURSOR Cursor failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
		while (ctx.getSqlca().getSqlcode() == 0) {
			ctx.getPrtSummaryRec().getPrtSummaryCustomerIdReference().setValue(ctx.getSumCustomerId().getSumCustomerIdReference());
			ctx.getPrtSummaryRec().getPrtSummaryOverdueReference().setValue(ctx.getSumOverdue().getSumOverdue());
			ctx.getPrtSummaryRec().getPrtSummaryRejectedReference().setValue(ctx.getSumRejected().getSumRejected());
			ctx.getPrtSummaryRec().getPrtSummarySettledReference().setValue(ctx.getSumSettled().getSumSettled());
			ctx.getPrtSummaryRec().setPrtSummaryCurrency(ctx.getSumCurrency().getSumCurrency());
			ctx.getPrtSummaryRec().getPrtSummaryOpenBalanceReference().setValue(ctx.getSumOpenBalance().getSumOpenBalance());
			ctx.getPrtSummaryRec().getPrtSummaryTotalDebitReference().setValue(ctx.getSumTotalDebit().getSumTotalDebit());
			ctx.getPrtSummaryRec().getPrtSummaryTotalCreditReference().setValue(ctx.getSumTotalCredit().getSumTotalCredit());
			ctx.getPrtSummaryRec().getPrtSummaryCloseBalanceReference().setValue(ctx.getSumCloseBalance().getSumCloseBalance());
			ctx.getSummaryReport().getSummaryRecordReference().setBytes(ctx.getPrtSummaryRec().getBytes());
			summaryReport.write(ctx.getSummaryReport().getSummaryRecordReference());
			if (NumberUtils.ne(ctx.getSummaryFileStatus().getSummaryFileStatusReference(), 0)) {
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("Write EXCEPTION Header failed : File-Status = ")
					.addDelimitedBySize(ctx.getSummaryFileStatus().getSummaryFileStatusReference().getValue(String.class))
					.end();
				reportException(ctx, ctrl);
			} 
			SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumCustomerId().getSumCustomerIdReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumOverdue().getSumOverdueReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumRejected().getSumRejectedReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumSettled().getSumSettledReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumCurrency().getSumCurrencyReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumOpenBalance().getSumOpenBalanceReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumTotalDebit().getSumTotalDebitReference()))
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSumTotalCredit().getSumTotalCreditReference()))
				.execute("TRDPB004_14");
			if (ctx.getSqlca().getSqlcode() == 0 || ctx.getSqlca().getSqlcode() == 100) {
				
				/* 
				Do nothing */
			} else {
				ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("Fetch SUMMARY_CURSOR Cursor failed : SQLCODE = ")
					.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
					.end();
				reportException(ctx, ctrl);
			}
		}
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB004_15");
		if (ctx.getSqlca().getSqlcode() == 0) {
			
			/* 
			Do nothing */
		} else {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Close SUMMARY_CURSOR failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
		}
		ctx.getSummaryReport().getSummaryRecordReference().setBytes(ctx.getHdrSummaryRecDash().getBytes());
		summaryReport.write(ctx.getSummaryReport().getSummaryRecordReference());
		summaryReport.close();
		if (NumberUtils.ne(ctx.getSummaryFileStatus().getSummaryFileStatusReference(), 0)) {
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Close SUMMARY FILE failed : File-Status = ")
				.addDelimitedBySize(ctx.getSummaryFileStatus().getSummaryFileStatusReference().getValue(String.class))
				.end();
			reportException(ctx, ctrl);
		} 
		
		/* 
		Do nothing */
		return;
	}

	/**
	 * Process operation cleanup.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void cleanup(final Trdpb004Context ctx, final ExecutionController ctrl) {
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB004_16");
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB004_17");
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB004_18");
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB004_19");
		ctrl.getExecutionContext().commitConnection(SqlcaHandler.setSqlcodeAndSqlstate, ctx.getSqlca());
	}

	/**
	 * Process operation reportException.
	 * 
	 * Legacy: 9000-REPORT-EXCEPTION
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void reportException(final Trdpb004Context ctx, final ExecutionController ctrl) {
		DisplayUtils.display(ctx, ctrl, LOGGER, ctx.getWsException().getWsException());
		ctx.setReturnCode(16);
		if (ctx.isMainProgram()) {
			ctrl.stopRunUnit();
		} 
		ctrl.stopProgram();
	}

}
