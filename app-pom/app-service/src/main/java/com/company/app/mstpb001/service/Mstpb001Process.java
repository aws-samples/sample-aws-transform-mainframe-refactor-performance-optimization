package com.company.app.mstpb001.service;

import com.company.app.mstpb001.business.context.Mstpb001Context;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;

/**
 * Interface Mstpb001Process.
 * 
 * Defines application services for Mstpb001Process
 */
public interface Mstpb001Process {

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
	void mainline(final Mstpb001Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation getCustomer.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void getCustomer(final Mstpb001Context ctx, final ExecutionController ctrl);

}
