package com.company.app.trdpb001.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.PackedType;
import java.math.BigDecimal;
/**
 * Data simplifier entity WsCustomerSummaryRec.
 * 
 * <p>About 'wsSummaryCustomerId' field, <br>
 * </p>
 * 
 * <p>About 'wsSummaryOverdue' field, <br>
 * </p>
 * 
 * <p>About 'wsSummaryRejected' field, <br>
 * </p>
 * 
 * <p>About 'wsSummarySettled' field, <br>
 * </p>
 * 
 * <p>About 'wsSummaryCurrency' field, <br>
 * </p>
 * 
 * <p>About 'wsSummaryOpenBalance' field, <br>
 * </p>
 * 
 * <p>About 'wsSummaryTotalDebit' field, <br>
 * </p>
 * 
 * <p>About 'wsSummaryTotalCredit' field, <br>
 * </p>
 * 
 * <p>About 'wsSummaryCloseBalance' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsCustomerSummaryRec extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsSummaryCustomerId = new Elementary(root,new AlphanumericType(12));
	private final Elementary wsSummaryOverdue = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	private final Elementary wsSummaryRejected = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	private final Elementary wsSummarySettled = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	private final Elementary wsSummaryCurrency = new Elementary(root,new AlphanumericType(3));
	private final Elementary wsSummaryOpenBalance = new Elementary(root,new PackedType(10, 2, false, false, true));
	private final Elementary wsSummaryTotalDebit = new Elementary(root,new PackedType(10, 2, false, false, true));
	private final Elementary wsSummaryTotalCredit = new Elementary(root,new PackedType(10, 2, false, false, true));
	private final Elementary wsSummaryCloseBalance = new Elementary(root,new PackedType(10, 2, false, false, true));
	
	/**
	 * Instantiate a new WsCustomerSummaryRec with a default record.
	 * @param configuration the configuration
	 */
	public WsCustomerSummaryRec(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsCustomerSummaryRec bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsCustomerSummaryRec(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsSummaryCustomerId.
	 * @return the wsSummaryCustomerId attribute reference
	 */
	public ElementaryRangeReference getWsSummaryCustomerIdReference() {
		return wsSummaryCustomerId.getReference();
	}

	/**
	 * Getter for wsSummaryCustomerId attribute.
	 * @return wsSummaryCustomerId attribute
	 */
	public String getWsSummaryCustomerId() {
		return wsSummaryCustomerId.getValue();
	}

	/**
	 * Setter for wsSummaryCustomerId attribute.
	 * @param wsSummaryCustomerId the new value of wsSummaryCustomerId
	 */
	public void setWsSummaryCustomerId(String wsSummaryCustomerId) {
		this.wsSummaryCustomerId.setValue(wsSummaryCustomerId);
	}
	/**
	 * Gets the reference for attribute wsSummaryOverdue.
	 * @return the wsSummaryOverdue attribute reference
	 */
	public ElementaryRangeReference getWsSummaryOverdueReference() {
		return wsSummaryOverdue.getReference();
	}

	/**
	 * Getter for wsSummaryOverdue attribute.
	 * @return wsSummaryOverdue attribute
	 */
	public int getWsSummaryOverdue() {
		return wsSummaryOverdue.getValue();
	}

	/**
	 * Setter for wsSummaryOverdue attribute.
	 * @param wsSummaryOverdue the new value of wsSummaryOverdue
	 */
	public void setWsSummaryOverdue(int wsSummaryOverdue) {
		this.wsSummaryOverdue.setValue(wsSummaryOverdue);
	}
	/**
	 * Gets the reference for attribute wsSummaryRejected.
	 * @return the wsSummaryRejected attribute reference
	 */
	public ElementaryRangeReference getWsSummaryRejectedReference() {
		return wsSummaryRejected.getReference();
	}

	/**
	 * Getter for wsSummaryRejected attribute.
	 * @return wsSummaryRejected attribute
	 */
	public int getWsSummaryRejected() {
		return wsSummaryRejected.getValue();
	}

	/**
	 * Setter for wsSummaryRejected attribute.
	 * @param wsSummaryRejected the new value of wsSummaryRejected
	 */
	public void setWsSummaryRejected(int wsSummaryRejected) {
		this.wsSummaryRejected.setValue(wsSummaryRejected);
	}
	/**
	 * Gets the reference for attribute wsSummarySettled.
	 * @return the wsSummarySettled attribute reference
	 */
	public ElementaryRangeReference getWsSummarySettledReference() {
		return wsSummarySettled.getReference();
	}

	/**
	 * Getter for wsSummarySettled attribute.
	 * @return wsSummarySettled attribute
	 */
	public int getWsSummarySettled() {
		return wsSummarySettled.getValue();
	}

	/**
	 * Setter for wsSummarySettled attribute.
	 * @param wsSummarySettled the new value of wsSummarySettled
	 */
	public void setWsSummarySettled(int wsSummarySettled) {
		this.wsSummarySettled.setValue(wsSummarySettled);
	}
	/**
	 * Gets the reference for attribute wsSummaryCurrency.
	 * @return the wsSummaryCurrency attribute reference
	 */
	public ElementaryRangeReference getWsSummaryCurrencyReference() {
		return wsSummaryCurrency.getReference();
	}

	/**
	 * Getter for wsSummaryCurrency attribute.
	 * @return wsSummaryCurrency attribute
	 */
	public String getWsSummaryCurrency() {
		return wsSummaryCurrency.getValue();
	}

	/**
	 * Setter for wsSummaryCurrency attribute.
	 * @param wsSummaryCurrency the new value of wsSummaryCurrency
	 */
	public void setWsSummaryCurrency(String wsSummaryCurrency) {
		this.wsSummaryCurrency.setValue(wsSummaryCurrency);
	}
	/**
	 * Gets the reference for attribute wsSummaryOpenBalance.
	 * @return the wsSummaryOpenBalance attribute reference
	 */
	public ElementaryRangeReference getWsSummaryOpenBalanceReference() {
		return wsSummaryOpenBalance.getReference();
	}

	/**
	 * Getter for wsSummaryOpenBalance attribute.
	 * @return wsSummaryOpenBalance attribute
	 */
	public BigDecimal getWsSummaryOpenBalance() {
		return wsSummaryOpenBalance.getValue();
	}

	/**
	 * Setter for wsSummaryOpenBalance attribute.
	 * @param wsSummaryOpenBalance the new value of wsSummaryOpenBalance
	 */
	public void setWsSummaryOpenBalance(BigDecimal wsSummaryOpenBalance) {
		this.wsSummaryOpenBalance.setValue(wsSummaryOpenBalance);
	}
	/**
	 * Gets the reference for attribute wsSummaryTotalDebit.
	 * @return the wsSummaryTotalDebit attribute reference
	 */
	public ElementaryRangeReference getWsSummaryTotalDebitReference() {
		return wsSummaryTotalDebit.getReference();
	}

	/**
	 * Getter for wsSummaryTotalDebit attribute.
	 * @return wsSummaryTotalDebit attribute
	 */
	public BigDecimal getWsSummaryTotalDebit() {
		return wsSummaryTotalDebit.getValue();
	}

	/**
	 * Setter for wsSummaryTotalDebit attribute.
	 * @param wsSummaryTotalDebit the new value of wsSummaryTotalDebit
	 */
	public void setWsSummaryTotalDebit(BigDecimal wsSummaryTotalDebit) {
		this.wsSummaryTotalDebit.setValue(wsSummaryTotalDebit);
	}
	/**
	 * Gets the reference for attribute wsSummaryTotalCredit.
	 * @return the wsSummaryTotalCredit attribute reference
	 */
	public ElementaryRangeReference getWsSummaryTotalCreditReference() {
		return wsSummaryTotalCredit.getReference();
	}

	/**
	 * Getter for wsSummaryTotalCredit attribute.
	 * @return wsSummaryTotalCredit attribute
	 */
	public BigDecimal getWsSummaryTotalCredit() {
		return wsSummaryTotalCredit.getValue();
	}

	/**
	 * Setter for wsSummaryTotalCredit attribute.
	 * @param wsSummaryTotalCredit the new value of wsSummaryTotalCredit
	 */
	public void setWsSummaryTotalCredit(BigDecimal wsSummaryTotalCredit) {
		this.wsSummaryTotalCredit.setValue(wsSummaryTotalCredit);
	}
	/**
	 * Gets the reference for attribute wsSummaryCloseBalance.
	 * @return the wsSummaryCloseBalance attribute reference
	 */
	public ElementaryRangeReference getWsSummaryCloseBalanceReference() {
		return wsSummaryCloseBalance.getReference();
	}

	/**
	 * Getter for wsSummaryCloseBalance attribute.
	 * @return wsSummaryCloseBalance attribute
	 */
	public BigDecimal getWsSummaryCloseBalance() {
		return wsSummaryCloseBalance.getValue();
	}

	/**
	 * Setter for wsSummaryCloseBalance attribute.
	 * @param wsSummaryCloseBalance the new value of wsSummaryCloseBalance
	 */
	public void setWsSummaryCloseBalance(BigDecimal wsSummaryCloseBalance) {
		this.wsSummaryCloseBalance.setValue(wsSummaryCloseBalance);
	}
}
