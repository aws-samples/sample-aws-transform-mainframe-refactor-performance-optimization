package com.company.app.trdpb003.service;

import com.company.app.trdpb003.business.context.Trdpb003Context;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;

/**
 * Interface Trdpb003Process.
 * 
 * Defines application services for Trdpb003Process
 */
public interface Trdpb003Process {

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
	void mainline(final Trdpb003Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation macBooking.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void macBooking(final Trdpb003Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation reportException.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void reportException(final Trdpb003Context ctx, final ExecutionController ctrl);

}
