package com.company.app.trdpbexc.service;

import com.company.app.trdpbexc.business.context.TrdpbexcContext;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;

/**
 * Interface TrdpbexcProcess.
 * 
 * Defines application services for TrdpbexcProcess
 */
public interface TrdpbexcProcess {

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
	void mainline(final TrdpbexcContext ctx, final ExecutionController ctrl);

	/**
	 * Process operation abendDump.
	 * 
	 * Legacy: 9999-ABEND-DUMP
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void abendDump(final TrdpbexcContext ctx, final ExecutionController ctrl);

}
