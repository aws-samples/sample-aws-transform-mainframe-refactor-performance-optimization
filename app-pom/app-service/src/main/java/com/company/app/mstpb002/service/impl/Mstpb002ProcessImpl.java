
package com.company.app.mstpb002.service.impl;

import com.company.app.mstpb002.business.context.Mstpb002Context;
import com.company.app.mstpb002.service.Mstpb002Process;
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
 * Class Mstpb002ProcessImpl
 * 
 * Defines application services for Mstpb002Process
 * @see Mstpb002Process
 */
@Service("com.company.app.mstpb002.service.Mstpb002Process")
@Lazy

public class Mstpb002ProcessImpl implements Mstpb002Process {

	/**
	 * The logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Mstpb002ProcessImpl.class);


	/**
	 * Process operation mainline.
	 * 
	 * Legacy: 0000-MAINLINE
	 * PROGRAM-ID.MSTPB002.
	 * ****************************************************************
	 *                                                                *
	 *  MSTPB002 : Master Database API to get Security Details        *
	 *                                                                *
	 *   - This is a Common Master Data access API and while          *
	 *     Trading application is migrated CloudFrame, this           *
	 *     program can be retained back on mainframe for Call         *
	 *     backs                                                      *
	 *                                                                *
	 * ****************************************************************
	 * ****************************************************************
	 *  THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 6       *
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void mainline(final Mstpb002Context ctx, final ExecutionController ctrl) {
		ctx.getLsSecurityIo().bind(ArgUtils.get(ctx, 0));
		
		/* 
		Set default to Exception */
		ctx.getLsSecurityIo().setSecurityException(true);
		DataUtils.setToBlank(ctx.getLsSecurityIo().getLsSecurityErrorMsgReference());
		getSecurity(ctx, ctrl);
		if (ctx.isMainProgram()) {
			ctrl.stopRunUnit();
		}
	}

	/**
	 * Process operation getSecurity.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	@Override
	public void getSecurity(final Mstpb002Context ctx, final ExecutionController ctrl) {
		ctx.getSecFigi().getSecFigiReference().setValue(ctx.getLsSecurityIo().getLsFigiReference());
		SQLExecutorBuilder.newInstance(ctrl, ctx, ctx.getSqlca())
			.mapInParameter(SQLParameterBuilder.newInstance(ctx.getSecFigi().getSecFigi()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSecCurrency().getSecCurrencyReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSecDescription().getSecDescriptionReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSecSymbol().getSecSymbolReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSecShareClassFigi().getSecShareClassFigiReference()))
			.mapOutParameter(SQLParameterBuilder.newInstance(ctx.getSecType().getSecTypeReference()))
			.execute("MSTPB002_1");
		ctx.getWsSqlcode().getWsSqlcodeReference().setValue(ctx.getSqlca().getSqlcode());
		if (ctx.getSqlca().getSqlcode() == 0) {
			ctx.getLsSecurityIo().getLsCurrencyReference().setValue(ctx.getSecCurrency().getSecCurrencyReference());
			ctx.getLsSecurityIo().getLsDescriptionReference().setValue(ctx.getSecDescription().getSecDescriptionReference());
			ctx.getLsSecurityIo().getLsSymbolReference().setValue(ctx.getSecSymbol().getSecSymbolReference());
			ctx.getLsSecurityIo().getLsShareClassFigiReference().setValue(ctx.getSecShareClassFigi().getSecShareClassFigiReference());
			ctx.getLsSecurityIo().getLsTypeReference().setValue(ctx.getSecType().getSecTypeReference());
			ctx.getLsSecurityIo().setSecurityActive(true);
		} else if (ctx.getSqlca().getSqlcode() == 100) {
			ctx.getLsSecurityIo().setSecurityNotFound(true);
			ctx.getLsSecurityIo().setLsSecurityErrorMsg("SECURITY Not Found");
		} else {
			ctx.getLsSecurityIo().setSecurityException(true);
			DataUtils.setToBlank(ctx.getLsSecurityIo().getLsSecurityErrorMsgReference());
			StringConcatenationBuilder.newInstance(ctx.getLsSecurityIo().getLsSecurityErrorMsgReference())
				.addDelimitedBySize("SECURITY Access failed. SQLCODE = ")
				.addDelimitedBySize(ctx.getWsSqlcode().getWsSqlcode())
				.end();
		}
	}

}
