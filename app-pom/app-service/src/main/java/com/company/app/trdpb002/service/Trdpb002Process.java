package com.company.app.trdpb002.service;

import com.company.app.trdpb002.business.context.Trdpb002Context;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;

/**
 * Interface Trdpb002Process.
 * 
 * Defines application services for Trdpb002Process
 */
public interface Trdpb002Process {

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
	void mainline(final Trdpb002Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation sacBooking.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void sacBooking(final Trdpb002Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation reportException.
	 * 
	 * *****************************************************
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void reportException(final Trdpb002Context ctx, final ExecutionController ctrl);

}
