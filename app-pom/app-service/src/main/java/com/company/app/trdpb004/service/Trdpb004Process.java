package com.company.app.trdpb004.service;

import com.company.app.trdpb004.business.context.Trdpb004Context;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;

/**
 * Interface Trdpb004Process.
 * 
 * Defines application services for Trdpb004Process
 */
public interface Trdpb004Process {

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
	void mainline(final Trdpb004Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation initialize.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void initialize(final Trdpb004Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation processException.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void processException(final Trdpb004Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation processTimings.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void processTimings(final Trdpb004Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation processSummaryRpt.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void processSummaryRpt(final Trdpb004Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation cleanup.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void cleanup(final Trdpb004Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation reportException.
	 * 
	 * Legacy: 9000-REPORT-EXCEPTION
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void reportException(final Trdpb004Context ctx, final ExecutionController ctrl);

}
