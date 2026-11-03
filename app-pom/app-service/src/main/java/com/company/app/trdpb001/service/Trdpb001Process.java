package com.company.app.trdpb001.service;

import com.company.app.trdpb001.business.context.Trdpb001Context;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;

/**
 * Interface Trdpb001Process.
 * 
 * Defines application services for Trdpb001Process
 */
public interface Trdpb001Process {

	/**
	 * Process operation mainline.
	 * 
	 * Legacy: 0000-MAINLINE
	 * PROGRAM-ID.TRDPB001.
	 * ****************************************************************
	 *                                                                *
	 *  TRDPB001 : Order Settlement                                   *
	 *                                                                *
	 *   - Multi-threading of this process is based on running        *
	 *     multiple batch jobs for settling trades based on           *
	 *     currency                                                   *
	 *                                                                *
	 * ****************************************************************
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void mainline(final Trdpb001Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation tradeSettlement.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void tradeSettlement(final Trdpb001Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation accounting.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void accounting(final Trdpb001Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation sacBooking.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void sacBooking(final Trdpb001Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation macBooking.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void macBooking(final Trdpb001Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation readFromStlmtQueue.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void readFromStlmtQueue(final Trdpb001Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation updateOrder.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void updateOrder(final Trdpb001Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation reportException.
	 * 
	 * *****************************************************
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void reportException(final Trdpb001Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation logSummary.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void logSummary(final Trdpb001Context ctx, final ExecutionController ctrl);

}
