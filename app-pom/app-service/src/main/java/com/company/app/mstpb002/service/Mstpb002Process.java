package com.company.app.mstpb002.service;

import com.company.app.mstpb002.business.context.Mstpb002Context;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;

/**
 * Interface Mstpb002Process.
 * 
 * Defines application services for Mstpb002Process
 */
public interface Mstpb002Process {

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
	void mainline(final Mstpb002Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation getSecurity.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void getSecurity(final Mstpb002Context ctx, final ExecutionController ctrl);

}
