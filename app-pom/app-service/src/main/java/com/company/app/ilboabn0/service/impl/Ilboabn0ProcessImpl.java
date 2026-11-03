
package com.company.app.ilboabn0.service.impl;

import com.company.app.ilboabn0.business.context.Ilboabn0Context;
import com.company.app.ilboabn0.service.Ilboabn0Process;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;
import com.netfective.bluage.gapwalk.rt.utils.ArgUtils;
import com.netfective.bluage.gapwalk.runtime.tool.DisplayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Class Ilboabn0ProcessImpl
 * 
 * Defines application services for Ilboabn0Process
 * @see Ilboabn0Process
 */
@Service("com.company.app.ilboabn0.service.Ilboabn0Process")
@Lazy

public class Ilboabn0ProcessImpl implements Ilboabn0Process {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Ilboabn0ProcessImpl.class);


	/**
	 * Process operation mainline.
	 * 
	 * Legacy: 0000-MAINLINE
	 * PROGRAM-ID.ILBOABN0.
	 * ****************************************************************
	 *                                                                *
	 *  ILBOABN0 : Abend routine                                      *
	 *                                                                *
	 *   - cobol/TRDPBEXC ends its 9999-ABEND-DUMP paragraph with     *
	 *     CALL 'ILBOABN0' USING WS-ABEND-CODE, which on z/OS invoked *
	 *     the IBM Language Environment assembler module of that      *
	 *     name to force a user abend (U0255).                        *
	 *                                                                *
	 *   - No COBOL source for that module exists or ever did, so the *
	 *     static CALL cannot be resolved by a refactor.  This stub   *
	 *     stands in for it and preserves the behaviour the batch     *
	 *     job stream actually depends on:                            *
	 *                                                                *
	 *       a) it does NOT return to the caller, so TRDPBEXC cannot  *
	 *          fall through to 9999-EXIT and carry on after a fatal  *
	 *          error, and                                            *
	 *       b) it terminates with the abend code as the return code, *
	 *          which is what COND=(8,LT) on the ACCP* and SETL* jobs *
	 *          tests in order to stop the downstream steps.          *
	 *                                                                *
	 *   - Difference from the original: z/OS produced a U0255 abend  *
	 *     with a SYSUDUMP and let DB2 back out the in-flight unit of *
	 *     work.  Here the step ends with return code 255 and no      *
	 *     dump.  If the target runtime offers a native abend         *
	 *     primitive, call that instead.                              *
	 *                                                                *
	 *   - Added during AWS Transform remediation; not a mainframe    *
	 *     export.  See docs/AWS_TRANSFORM_REMEDIATION.md.            *
	 *                                                                *
	 * ****************************************************************
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void mainline(final Ilboabn0Context ctx, final ExecutionController ctrl) {
		ctx.getLkAbendCode().bind(ArgUtils.get(ctx, 0));
		ctx.getWsDisplayCode().setWsDisplayCode(ctx.getLkAbendCode().getLkAbendCode());
		DisplayUtils.display(ctx, ctrl, LOGGER, "{}{}" , "ILBOABN0 : ABEND REQUESTED - USER CODE " , ctx.getWsDisplayCode().getWsDisplayCodeReference().getDisplayValue(String.class));
		
		/* 
		Surface the abend code as the step return code, then end the
		run unit.  STOP RUN rather than GOBACK is deliberate: the
		module it replaces never gave control back. */
		ctx.setReturnCode(ctx.getLkAbendCode().getLkAbendCode());
		ctrl.stopRunUnit();
	}

	/**
	 * Process operation exit.
	 * 
	 * Legacy: 0000-EXIT
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void exit(final Ilboabn0Context ctx, final ExecutionController ctrl) {
		return;
	}

}
