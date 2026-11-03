
package com.company.app.mstpb001.service.impl;

import com.company.app.mstpb001.business.context.Mstpb001Context;
import com.company.app.mstpb001.service.Mstpb001Process;
import com.netfective.bluage.gapwalk.database.support.central.SQLExecutorBuilder;
import com.netfective.bluage.gapwalk.database.support.central.SQLParameterBuilder;
import com.netfective.bluage.gapwalk.datasimplifier.utils.DataUtils;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;
import com.netfective.bluage.gapwalk.rt.utils.ArgUtils;
import com.netfective.bluage.gapwalk.runtime.statements.StringConcatenationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Class Mstpb001ProcessImpl
 * 
 * Defines application services for Mstpb001Process
 * @see Mstpb001Process
 */
@Service("com.company.app.mstpb001.service.Mstpb001Process")
@Lazy

public class Mstpb001ProcessImpl implements Mstpb001Process {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Mstpb001ProcessImpl.class);


	/**
	 * Process operation mainline.
	 * 
	 * Legacy: 0000-MAINLINE
	 * PROGRAM-ID.MSTPB001.
	 * ****************************************************************
	 *                                                                *
	 *  MSTPB001 : Master Database API to get Customer Details        *
	 *                                                                *
	 *   - This is a Common Master Data access API and while          *
	 *     Trading application is migrated CloudFrame, this           *
	 *     program can be retained back on mainframe for Call         *
	 *     backs                                                      *
	 *                                                                *
	 * ****************************************************************
	 * ****************************************************************
	 *  THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 4       *
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void mainline(final Mstpb001Context ctx, final ExecutionController ctrl) {
		ctx.getLsCustomerIo().bind(ArgUtils.get(ctx, 0));
		
		/* 
		Set default to Exception */
		ctx.getLsCustomerIo().setCustomerException(true);
		DataUtils.setToBlank(ctx.getLsCustomerIo().getLsCustomerErrorMsgReference());
		getCustomer(ctx, ctrl);
		if (ctx.isMainProgram()) {
			ctrl.stopRunUnit();
		}
	}

	/**
	 * Process operation getCustomer.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void getCustomer(final Mstpb001Context ctx, final ExecutionController ctrl) {
		ctx.getCusCustomerId().getCusCustomerIdReference().setValue(ctx.getLsCustomerIo().getLsCustomerIdReference());
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getCusCustomerId().getCusCustomerId()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getCusCurrency().getCusCurrencyReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getCusDescription().getCusDescriptionReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getCusStatus().getCusStatusReference()))
			.execute("MSTPB001_1");
		ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
		if (ctx.getSqlca().getSqlcode() == 0) {
			ctx.getLsCustomerIo().getLsCustomerCurrencyReference().setValue(ctx.getCusCurrency().getCusCurrencyReference());
			ctx.getLsCustomerIo().getLsCustomerDescriptionReference().setValue(ctx.getCusDescription().getCusDescriptionReference());
			if (DataUtils.compare(ctx.getCusStatus().getCusStatusReference(), "A") == 0) {
				ctx.getLsCustomerIo().setCustomerActive(true);
			} else {
				ctx.getLsCustomerIo().setCustomerInactive(true);
				ctx.getLsCustomerIo().setLsCustomerErrorMsg("Customer is Inactive");
			}
		} else if (ctx.getSqlca().getSqlcode() == 100) {
			ctx.getLsCustomerIo().setCustomerNotFound(true);
			ctx.getLsCustomerIo().setLsCustomerErrorMsg("Customer Not Found");
		} else {
			ctx.getLsCustomerIo().setCustomerException(true);
			DataUtils.setToBlank(ctx.getLsCustomerIo().getLsCustomerErrorMsgReference());
			StringConcatenationBuilder.newInstance(ctx.getLsCustomerIo().getLsCustomerErrorMsgReference())
				.addDelimitedBySize("Customer Access failed. SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
		}
	}

}
