
package com.company.app.trdpb003.service.impl;

import com.company.app.trdpb003.business.context.Trdpb003Context;
import com.company.app.trdpb003.service.Trdpb003Process;
import com.netfective.bluage.gapwalk.database.support.central.SQLExecutorBuilder;
import com.netfective.bluage.gapwalk.database.support.central.SQLParameterBuilder;
import com.netfective.bluage.gapwalk.datasimplifier.utils.DataUtils;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;
import com.netfective.bluage.gapwalk.rt.utils.ArgUtils;
import com.netfective.bluage.gapwalk.runtime.statements.CallBuilder;
import com.netfective.bluage.gapwalk.runtime.statements.StringConcatenationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Class Trdpb003ProcessImpl
 * 
 * Defines application services for Trdpb003Process
 * @see Trdpb003Process
 */
@Service("com.company.app.trdpb003.service.Trdpb003Process")
@Lazy

public class Trdpb003ProcessImpl implements Trdpb003Process {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Trdpb003ProcessImpl.class);


	/**
	 * Process operation mainline.
	 * 
	 * Legacy: 0000-MAINLINE
	 * PROGRAM-ID.TRDPB002.
	 * ****************************************************************
	 *                                                                *
	 *  TRDPB002 : Money Book-keeping Program                         *
	 *                                                                *
	 *   - Settles Securities Account of Buyer/Seller by crediting    *
	 *     Seller Security Account and Debiting  Buyer Security       *
	 *     Account                                                    *
	 *                                                                *
	 * ****************************************************************
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void mainline(final Trdpb003Context ctx, final ExecutionController ctrl) {
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getMacCurrency().getMacCurrencyReference()))
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getMacNumber().getMacNumberReference()))
			.execute("TRDPB002_1");
		ctx.getTrdOrderPair().bind(ArgUtils.get(ctx, 0));
		
		/* 
		****************************************************************
		THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 5       *
		Set default to Booking Failed */
		ctx.getTrdOrderPair().setTrdMacBookingFailed(true);
		ctx.getWsCrDbSwtich().setDebitBuyer(true);
		macBooking(ctx, ctrl);
		if (ctx.getTrdOrderPair().isTrdMacBookingDone()) {
			
			/* 
			Reset back to Booking Failed and attempt Crediting Seller */
			ctx.getTrdOrderPair().setTrdMacBookingFailed(true);
			ctx.getWsCrDbSwtich().setCreditSeller(true);
			macBooking(ctx, ctrl);
		} 
		if (ctx.isMainProgram()) {
			ctrl.stopRunUnit();
		}
	}

	/**
	 * Process operation macBooking.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void macBooking(final Trdpb003Context ctx, final ExecutionController ctrl) {
		if (ctx.getWsCrDbSwtich().isCreditSeller()) {
			ctx.getMacCurrency().getMacCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
			ctx.getMacNumber().getMacNumberReference().setValue(ctx.getTrdOrderPair().getTrdSellerMoneyAccNumReference());
		} else {
			ctx.getMacCurrency().getMacCurrencyReference().setValue(ctx.getTrdOrderPair().getTrdCurrencyReference());
			ctx.getMacNumber().getMacNumberReference().setValue(ctx.getTrdOrderPair().getTrdBuyerMoneyAccNumReference());
		}
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.execute("TRDPB002_2");
		if (ctx.getSqlca().getSqlcode() != 0) {
			ctx.getTrdOrderPair().setTrdMacBookingFailed(true);
			ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
			ctx.getWsExcpType().setDataException(true);
			DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
			StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
				.addDelimitedBySize("Open MAC_BOOKING Cursor failed : SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
			reportException(ctx, ctrl);
			return;
		} else {
			SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
				.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getMacBalance().getMacBalanceReference()))
				.execute("TRDPB002_3");
			if (ctx.getSqlca().getSqlcode() == 0) {
				if (ctx.getWsCrDbSwtich().isCreditSeller()) {
					ctx.getMacBalance().setMacBalance(ctx.getMacBalance().getMacBalance().add(ctx.getTrdOrderPair().getTrdOrderAmount()));
				} else {
					ctx.getMacBalance().setMacBalance(ctx.getMacBalance().getMacBalance().subtract(ctx.getTrdOrderPair().getTrdOrderAmount()));
				}
				SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
					.mapInParameter(SQLParameterBuilder.newInstance(ctx.getMacBalance().getMacBalance()))
					.mapInParameter(SQLParameterBuilder.newInstance(ctx.getMacCurrency().getMacCurrency()))
					.mapInParameter(SQLParameterBuilder.newInstance(ctx.getMacNumber().getMacNumber()))
					.execute("TRDPB002_4");
				
				/* 
				WHERE CURRENT OF MAC_BOOKING */
				if (ctx.getSqlca().getSqlcode() == 0) {
					ctx.getTrdOrderPair().setTrdMacBookingDone(true);
				} else {
					ctx.getTrdOrderPair().setTrdMacBookingFailed(true);
					ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
					ctx.getWsExcpType().setDataException(true);
					DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
					StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
						.addDelimitedBySize("Update using MAC_BOOKING Cursor failed : ")
						.addDelimitedBySize("SQLCODE = ")
						.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
						.end();
					reportException(ctx, ctrl);
				}
			} else {
				ctx.getTrdOrderPair().setTrdMacBookingFailed(true);
				ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
				ctx.getWsExcpType().setDataException(true);
				DataUtils.setToBlank(ctx.getWsException().getWsExceptionReference());
				StringConcatenationBuilder.newInstance(ctx.getWsException().getWsExceptionReference())
					.addDelimitedBySize("Fetch MAC_BOOKING Cursor failed : SQLCODE = ")
					.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
					.end();
				reportException(ctx, ctrl);
			}
			SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
				.execute("TRDPB002_5");
		}
	}

	/**
	 * Process operation reportException.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void reportException(final Trdpb003Context ctx, final ExecutionController ctrl) {
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
