
package com.company.app.trdpbexc.service.impl;

import com.company.app.trdpbexc.business.context.TrdpbexcContext;
import com.company.app.trdpbexc.service.TrdpbexcProcess;
import com.netfective.bluage.gapwalk.database.support.central.SQLExecutorBuilder;
import com.netfective.bluage.gapwalk.database.support.central.SQLParameterBuilder;
import com.netfective.bluage.gapwalk.database.support.central.functions.SqlcaHandler;
import com.netfective.bluage.gapwalk.datasimplifier.utils.DataUtils;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;
import com.netfective.bluage.gapwalk.rt.utils.ArgUtils;
import com.netfective.bluage.gapwalk.runtime.statements.CallBuilder;
import com.netfective.bluage.gapwalk.runtime.tool.DisplayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Class TrdpbexcProcessImpl
 * 
 * Defines application services for TrdpbexcProcess
 * @see TrdpbexcProcess
 */
@Service("com.company.app.trdpbexc.service.TrdpbexcProcess")
@Lazy

public class TrdpbexcProcessImpl implements TrdpbexcProcess {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(TrdpbexcProcessImpl.class);


	/**
	 * Process operation mainline.
	 * 
	 * Legacy: 0000-MAINLINE
	 * PROGRAM-ID.TRDPBEXC.
	 * ****************************************************************
	 *                                                                *
	 *  TRDPBEXC : Exception Hander                                   *
	 *                                                                *
	 * ****************************************************************
	 * ****************************************************************
	 *  THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 3       *
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void mainline(final TrdpbexcContext ctx, final ExecutionController ctrl) {
		ctx.getExceptionRecordLen().bind(ArgUtils.get(ctx, 0));
		ctx.getExceptionRecord().bind(ArgUtils.get(ctx, 1));
		
		/* 
		Data Exceptions are tolerated and application continues */
		if (ctx.getExceptionRecord().isExceptionData()) {
			
			/* 
			Do nothing */
		} else {
			ctrl.getExecutionContext().rollbackConnection(SqlcaHandler.setSqlcodeAndSqlstate, ctx.getSqlca());
		}
		
		/* 
		MOVE EXCEPTION-TIMESTAMP     TO EXC-TIMESTAMP */
		ctx.getExcType().getExcTypeReference().setValue(ctx.getExceptionRecord().getExceptionTypeReference());
		ctx.getExcDescription().getExcDescriptionLenReference().setValue(ctx.getExceptionRecordLen().getExceptionRecordLenReference());
		ctx.getExcDescription().getExcDescriptionTextReference().setValue(ctx.getExceptionRecord().getExceptionDescReference());
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getExcType().getExcType()))
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getExcDescription()))
			.execute("TRDPBEXC_1");
		if (ctx.getSqlca().getSqlcode() == 0) {
			
			/* 
			Do nothing */
		} else if (ctx.getSqlca().getSqlcode() == -803) {
			
			/* 
			Retry Insert if it failed with SQLCODE -803 (Duplicate) */
			while (ctx.getSqlca().getSqlcode() != 0) {
				
				/* 
				EXEC SQL
				SET :EXC-TIMESTAMP  = CURRENT_TIMESTAMP
				END-EXEC */
				SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
					.mapInParameter(SQLParameterBuilder.newInstance(ctx.getExcType().getExcType()))
					.mapInParameter(SQLParameterBuilder.newInstance(ctx.getExcDescription()))
					.execute("TRDPBEXC_2");
			}
		} else {
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "Error Logging Exception.. Sqlcode = " , ctx.getWsSqlcode().getWsSqlcode());
			abendDump(ctx, ctrl);
		}
		
		/* 
		Tolerate Data Exception */
		if (ctx.getExceptionRecord().isExceptionData()) {
			
			/* 
			Do nothing */
		} else {
			
			/* 
			Commit Exception log database insert */
			ctrl.getExecutionContext().commitConnection(SqlcaHandler.setSqlcodeAndSqlstate, ctx.getSqlca());
			abendDump(ctx, ctrl);
		}
		if (ctx.isMainProgram()) {
			ctrl.stopRunUnit();
		}
	}

	/**
	 * Process operation abendDump.
	 * 
	 * Legacy: 9999-ABEND-DUMP
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void abendDump(final TrdpbexcContext ctx, final ExecutionController ctrl) {
		DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}{}" , ctx.getExcType().getExcType() , " Exception : " , DataUtils.toString(ctx.getExcDescription().getExcDescriptionTextReference().getBytes(0, 100)));
		ctx.getWsAbendCode().setWsAbendCode(255);
		ctrl.callSubProgram("ILBOABN0", CallBuilder.newInstance()
			.byReference(ctx.getWsAbendCode().getWsAbendCodeReference())
			.getArguments(), ctx);
	}

}
