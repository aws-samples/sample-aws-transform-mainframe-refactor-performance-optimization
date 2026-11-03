package com.company.app.trdpb006.service;

import com.company.app.trdpb006.business.context.Trdpb006Context;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;

/**
 * Interface Trdpb006Process.
 * 
 * Defines application services for Trdpb006Process
 */
public interface Trdpb006Process {

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
	void mainline(final Trdpb006Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation initialize.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void initialize(final Trdpb006Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation openOrderCursorRptfile.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void openOrderCursorRptfile(final Trdpb006Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation fetchProcessOrders.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void fetchProcessOrders(final Trdpb006Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation closOrderCursorRptfile.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void closOrderCursorRptfile(final Trdpb006Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation terminate.
	 * 
	 * Legacy: 9999-TERMINATE
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void terminate(final Trdpb006Context ctx, final ExecutionController ctrl);

}
