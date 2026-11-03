package com.company.app.trdpb000.service;

import com.company.app.trdpb000.business.context.Trdpb000Context;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;

/**
 * Interface Trdpb000Process.
 * 
 * Defines application services for Trdpb000Process
 */
public interface Trdpb000Process {

	/**
	 * Process operation mainline.
	 * 
	 * Legacy: 0000-MAINLINE
	 * PROGRAM-ID.TRDPB000.
	 * ****************************************************************
	 *                                                                *
	 *  TRDPB000 : Process Trading Orders                             *
	 *                                                                *
	 *   - Transaction starting this program is of format             *
	 *     T<CurrencyCode> viz. TUSD, TINR, TCHF and so on.           *
	 *   - This Program is the first series of programs that          *
	 *     Validates & Matches Buy & Sell Side Orders.                *
	 *   - Multi-threading of this process is based on running        *
	 *     multiple background transactions for settling trades       *
	 *     based on currency                                          *
	 *   - Once trades are matched, Settlement batch for that         *
	 *     trade currency should be done                              *
	 *   - Any validation issues will be logged in TBTRDEXP table     *
	 *                                                                *
	 * ****************************************************************
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void mainline(final Trdpb000Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation orderAcceptance.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void orderAcceptance(final Trdpb000Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation getSellSideOrder.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void getSellSideOrder(final Trdpb000Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation validateCustomers.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void validateCustomers(final Trdpb000Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation validateSecurity.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void validateSecurity(final Trdpb000Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation buyerSecAccount.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void buyerSecAccount(final Trdpb000Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation sellerSecAccount.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void sellerSecAccount(final Trdpb000Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation buyerMoneyAccount.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void buyerMoneyAccount(final Trdpb000Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation sellerMoneyAccount.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void sellerMoneyAccount(final Trdpb000Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation updateOrderMatched.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void updateOrderMatched(final Trdpb000Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation writeToStlmtQueue.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void writeToStlmtQueue(final Trdpb000Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation insertToStq.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void insertToStq(final Trdpb000Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation updateOrder.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void updateOrder(final Trdpb000Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation reportException.
	 * 
	 * *****************************************************
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void reportException(final Trdpb000Context ctx, final ExecutionController ctrl);

	/**
	 * Process operation logSummary.
	 * 
	 * @param ctx 
	 * @param ctrl 
	 */
	void logSummary(final Trdpb000Context ctx, final ExecutionController ctrl);

}
