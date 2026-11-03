
package com.company.app.trdpb002.service.impl;

import com.company.app.core.helper.BluageUtils;
import com.company.app.trdpb002.business.context.Trdpb002Context;
import com.company.app.trdpb002.service.Trdpb002Process;
import com.netfective.bluage.gapwalk.database.support.central.SQLExecutorBuilder;
import com.netfective.bluage.gapwalk.datasimplifier.utils.DataUtils;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;
import com.netfective.bluage.gapwalk.rt.utils.ArgUtils;
import com.netfective.bluage.gapwalk.runtime.statements.CallBuilder;
import com.netfective.bluage.gapwalk.runtime.statements.StringConcatenationBuilder;
import com.netfective.bluage.gapwalk.runtime.tool.DisplayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Class Trdpb002ProcessImpl
 * 
 * Defines application services for Trdpb002Process
 * @see Trdpb002Process
 */
@Service("com.company.app.trdpb002.service.Trdpb002Process")
@Lazy

public class Trdpb002ProcessImpl implements Trdpb002Process {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Trdpb002ProcessImpl.class);


	/**
	 * Process operation mainline.
	 * 
	 * Legacy: 0000-MAINLINE
	 * PROGRAM-ID.TRDPB002.
	 * ****************************************************************
	 *                                                                *
	 *  TRDPB002 : Securities Book-keeping Program                    *
	 *                                                                *
	 *   - Settles Securities Account of Buyer/Seller by debiting     *
	 *     Seller Security Account and Crediting Buyer Security       *
	 *     Account                                                    *
	 *                                                                *
	 * ****************************************************************
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void mainline(final Trdpb002Context ctx, final ExecutionController ctrl) {
		ctx.getTrdOrderPair().bind(ArgUtils.get(ctx, 0));
		
		/* 
		FIXME:EXEC SQL
		DECLARE POS_BOOKING  CURSOR FOR
		SELECT  POS_BALANCE
		FROM TBTRDPOS
		WHERE
		POS_CURRENCY      = :POS-CURRENCY
		AND POS_SAC_NUMBER    = :POS-SAC-NUMBER
		AND POS_FIGI          = :POS-FIGI
		FOR UPDATE OF POS_BALANCE
		END-EXEC */
		BluageUtils.unsupported();
		
		/* 
		Set default to Booking Failed */
		ctx.getTrdOrderPair().setTrdSacBookingFailed(true);
		ctx.getWsCrDbSwtich().setDebitSeller(true);
		sacBooking(ctx, ctrl);
		if (ctx.getTrdOrderPair().isTrdSacBookingDone()) {
			
			/* 
			Reset back to Booking Failed and attempt Crediting Seller */
			ctx.getTrdOrderPair().setTrdSacBookingFailed(true);
			ctx.getWsCrDbSwtich().setCreditBuyer(true);
			sacBooking(ctx, ctrl);
		} 
		if (ctx.isMainProgram()) {
			ctrl.stopRunUnit();
		}
	}

	/**
	 * Process operation sacBooking.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void sacBooking(final Trdpb002Context ctx, final ExecutionController ctrl) {
		if (ctx.getWsCrDbSwtich().isDebitSeller()) {
			
			/* 
			FIXME: POS-CURRENCY */
			BluageUtils.unsupported();
			
			/* 
			FIXME: POS-SAC-NUMBER */
			BluageUtils.unsupported();
			
			/* 
			FIXME: POS-FIGI */
			BluageUtils.unsupported();
			DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "TRD-CURRENCY          =" , ctx.getTrdOrderPair().getTrdCurrency());
			DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "TRD-SELLER-SEC-ACC-NUM=" , ctx.getTrdOrderPair().getTrdSellerSecAccNumReference().getDisplayValue(String.class));
			DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "TRD-FIGI              =" , ctx.getTrdOrderPair().getTrdFigi());
		} else {
			
			/* 
			FIXME: POS-CURRENCY */
			BluageUtils.unsupported();
			
			/* 
			FIXME: POS-SAC-NUMBER */
			BluageUtils.unsupported();
			
			/* 
			FIXME: POS-FIGI */
			BluageUtils.unsupported();
			DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "TRD-CURRENCY          =" , ctx.getTrdOrderPair().getTrdCurrency());
			DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "TRD-BUYER-SEC-ACC-NUM =" , ctx.getTrdOrderPair().getTrdBuyerSecAccNumReference().getDisplayValue(String.class));
			DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "TRD-FIGI              =" , ctx.getTrdOrderPair().getTrdFigi());
		}
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB002_1");
		if (ctx.getSqlca().getSqlcode() != 0) {
			ctx.getTrdOrderPair().setTrdSacBookingFailed(true);
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			ctx.getWsExcpType().setDataException(true);
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Open POS_BOOKING Cursor failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
			return;
		} else {
			
			/* 
			FIXME:EXEC SQL
			FETCH POS_BOOKING
			INTO :POS-BALANCE
			END-EXEC */
			BluageUtils.unsupported();
			if (ctx.getSqlca().getSqlcode() == 0) {
				if (ctx.getWsCrDbSwtich().isDebitSeller()) {
					
					/* 
					FIXME: POS-BALANCE */
					BluageUtils.unsupported();
				} else {
					
					/* 
					FIXME: POS-BALANCE */
					BluageUtils.unsupported();
				}
				
				/* 
				FIXME:EXEC SQL
				UPDATE TBTRDPOS
				SET POS_BALANCE      = :POS-BALANCE
				WHERE POS_CURRENCY     = :POS-CURRENCY
				AND POS_SAC_NUMBER   = :POS-SAC-NUMBER
				AND POS_FIGI         = :POS-FIGI
				END-EXEC */
				BluageUtils.unsupported();
				
				/* 
				WHERE CURRENT OF POS_BOOKING */
				if (ctx.getSqlca().getSqlcode() == 0) {
					ctx.getTrdOrderPair().setTrdSacBookingDone(true);
				} else {
					ctx.getTrdOrderPair().setTrdSacBookingFailed(true);
					ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
					ctx.getWsExcpType().setDataException(true);
					DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
					StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
						.addDelimitedBySize("Update using POS_BOOKING Cursor failed : ")
						.addDelimitedBySize("SQLCODE = ")
						.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
						.end();
					reportException(ctx, ctrl);
				}
			} else {
				ctx.getTrdOrderPair().setTrdSacBookingFailed(true);
				ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
				ctx.getWsExcpType().setDataException(true);
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "SQLCODE = " , ctx.getWsSqlcode().getWsSqlcode());
				DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "POS-CURRENCY   = " , BluageUtils.unsupported());
				DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "POS-SAC-NUMBER = " , BluageUtils.unsupported());
				DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "POS-FIGI       = " , BluageUtils.unsupported());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("Fetch POS_BOOKING Cursor failed : SQLCODE = ")
					.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
					.end();
				reportException(ctx, ctrl);
			}
			SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
				.execute("TRDPB002_2");
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
	public void reportException(final Trdpb002Context ctx, final ExecutionController ctrl) {
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

}
