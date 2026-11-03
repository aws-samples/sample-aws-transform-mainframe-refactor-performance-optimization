package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Filler;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.NumericEditedType;
/**
 * Data simplifier entity PrtSummaryRec.
 * 
 * <p>About 'prtSummaryCustomerId' field, <br>
 * </p>
 * 
 * <p>About 'prtSummaryOverdue' field, <br>
 * </p>
 * 
 * <p>About 'prtSummaryRejected' field, <br>
 * </p>
 * 
 * <p>About 'prtSummarySettled' field, <br>
 * </p>
 * 
 * <p>About 'prtSummaryCurrency' field, <br>
 * </p>
 * 
 * <p>About 'prtSummaryOpenBalance' field, <br>
 * </p>
 * 
 * <p>About 'prtSummaryTotalDebit' field, <br>
 * </p>
 * 
 * <p>About 'prtSummaryTotalCredit' field, <br>
 * </p>
 * 
 * <p>About 'prtSummaryCloseBalance' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class PrtSummaryRec extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(2),"| ");
	private final Elementary prtSummaryCustomerId = new Elementary(root,new AlphanumericType(12));
	@SuppressWarnings("unused")
	private final Filler filler1 = new Filler(root,new AlphanumericType(3)," | ");
	private final Elementary prtSummaryOverdue = new Elementary(root,new NumericEditedType("ZZZ,ZZZ,ZZ9"));
	@SuppressWarnings("unused")
	private final Filler filler2 = new Filler(root,new AlphanumericType(3)," | ");
	private final Elementary prtSummaryRejected = new Elementary(root,new NumericEditedType("ZZZ,ZZZ,ZZ9"));
	@SuppressWarnings("unused")
	private final Filler filler3 = new Filler(root,new AlphanumericType(3)," | ");
	private final Elementary prtSummarySettled = new Elementary(root,new NumericEditedType("ZZZ,ZZZ,ZZ9"));
	@SuppressWarnings("unused")
	private final Filler filler4 = new Filler(root,new AlphanumericType(3)," | ");
	private final Elementary prtSummaryCurrency = new Elementary(root,new AlphanumericType(8));
	@SuppressWarnings("unused")
	private final Filler filler5 = new Filler(root,new AlphanumericType(3)," | ");
	private final Elementary prtSummaryOpenBalance = new Elementary(root,new NumericEditedType("---,---,--9.99"));
	@SuppressWarnings("unused")
	private final Filler filler6 = new Filler(root,new AlphanumericType(4)," | -");
	private final Elementary prtSummaryTotalDebit = new Elementary(root,new NumericEditedType("---,---,--9.99"));
	@SuppressWarnings("unused")
	private final Filler filler7 = new Filler(root,new AlphanumericType(4)," | +");
	private final Elementary prtSummaryTotalCredit = new Elementary(root,new NumericEditedType("---,---,--9.99"));
	@SuppressWarnings("unused")
	private final Filler filler8 = new Filler(root,new AlphanumericType(3)," | ");
	private final Elementary prtSummaryCloseBalance = new Elementary(root,new NumericEditedType("---,---,--9.99"));
	@SuppressWarnings("unused")
	private final Filler filler9 = new Filler(root,new AlphanumericType(3)," | ");
	
	/**
	 * Instantiate a new PrtSummaryRec with a default record.
	 * @param configuration the configuration
	 */
	public PrtSummaryRec(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new PrtSummaryRec bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public PrtSummaryRec(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute prtSummaryCustomerId.
	 * @return the prtSummaryCustomerId attribute reference
	 */
	public ElementaryRangeReference getPrtSummaryCustomerIdReference() {
		return prtSummaryCustomerId.getReference();
	}

	/**
	 * Getter for prtSummaryCustomerId attribute.
	 * @return prtSummaryCustomerId attribute
	 */
	public String getPrtSummaryCustomerId() {
		return prtSummaryCustomerId.getValue();
	}

	/**
	 * Setter for prtSummaryCustomerId attribute.
	 * @param prtSummaryCustomerId the new value of prtSummaryCustomerId
	 */
	public void setPrtSummaryCustomerId(String prtSummaryCustomerId) {
		this.prtSummaryCustomerId.setValue(prtSummaryCustomerId);
	}
	/**
	 * Gets the reference for attribute prtSummaryOverdue.
	 * @return the prtSummaryOverdue attribute reference
	 */
	public ElementaryRangeReference getPrtSummaryOverdueReference() {
		return prtSummaryOverdue.getReference();
	}

	/**
	 * Getter for prtSummaryOverdue attribute.
	 * @return prtSummaryOverdue attribute
	 */
	public String getPrtSummaryOverdue() {
		return prtSummaryOverdue.getValue();
	}

	/**
	 * Setter for prtSummaryOverdue attribute.
	 * @param prtSummaryOverdue the new value of prtSummaryOverdue
	 */
	public void setPrtSummaryOverdue(String prtSummaryOverdue) {
		this.prtSummaryOverdue.setValue(prtSummaryOverdue);
	}
	/**
	 * Gets the reference for attribute prtSummaryRejected.
	 * @return the prtSummaryRejected attribute reference
	 */
	public ElementaryRangeReference getPrtSummaryRejectedReference() {
		return prtSummaryRejected.getReference();
	}

	/**
	 * Getter for prtSummaryRejected attribute.
	 * @return prtSummaryRejected attribute
	 */
	public String getPrtSummaryRejected() {
		return prtSummaryRejected.getValue();
	}

	/**
	 * Setter for prtSummaryRejected attribute.
	 * @param prtSummaryRejected the new value of prtSummaryRejected
	 */
	public void setPrtSummaryRejected(String prtSummaryRejected) {
		this.prtSummaryRejected.setValue(prtSummaryRejected);
	}
	/**
	 * Gets the reference for attribute prtSummarySettled.
	 * @return the prtSummarySettled attribute reference
	 */
	public ElementaryRangeReference getPrtSummarySettledReference() {
		return prtSummarySettled.getReference();
	}

	/**
	 * Getter for prtSummarySettled attribute.
	 * @return prtSummarySettled attribute
	 */
	public String getPrtSummarySettled() {
		return prtSummarySettled.getValue();
	}

	/**
	 * Setter for prtSummarySettled attribute.
	 * @param prtSummarySettled the new value of prtSummarySettled
	 */
	public void setPrtSummarySettled(String prtSummarySettled) {
		this.prtSummarySettled.setValue(prtSummarySettled);
	}
	/**
	 * Gets the reference for attribute prtSummaryCurrency.
	 * @return the prtSummaryCurrency attribute reference
	 */
	public ElementaryRangeReference getPrtSummaryCurrencyReference() {
		return prtSummaryCurrency.getReference();
	}

	/**
	 * Getter for prtSummaryCurrency attribute.
	 * @return prtSummaryCurrency attribute
	 */
	public String getPrtSummaryCurrency() {
		return prtSummaryCurrency.getValue();
	}

	/**
	 * Setter for prtSummaryCurrency attribute.
	 * @param prtSummaryCurrency the new value of prtSummaryCurrency
	 */
	public void setPrtSummaryCurrency(String prtSummaryCurrency) {
		this.prtSummaryCurrency.setValue(prtSummaryCurrency);
	}
	/**
	 * Gets the reference for attribute prtSummaryOpenBalance.
	 * @return the prtSummaryOpenBalance attribute reference
	 */
	public ElementaryRangeReference getPrtSummaryOpenBalanceReference() {
		return prtSummaryOpenBalance.getReference();
	}

	/**
	 * Getter for prtSummaryOpenBalance attribute.
	 * @return prtSummaryOpenBalance attribute
	 */
	public String getPrtSummaryOpenBalance() {
		return prtSummaryOpenBalance.getValue();
	}

	/**
	 * Setter for prtSummaryOpenBalance attribute.
	 * @param prtSummaryOpenBalance the new value of prtSummaryOpenBalance
	 */
	public void setPrtSummaryOpenBalance(String prtSummaryOpenBalance) {
		this.prtSummaryOpenBalance.setValue(prtSummaryOpenBalance);
	}
	/**
	 * Gets the reference for attribute prtSummaryTotalDebit.
	 * @return the prtSummaryTotalDebit attribute reference
	 */
	public ElementaryRangeReference getPrtSummaryTotalDebitReference() {
		return prtSummaryTotalDebit.getReference();
	}

	/**
	 * Getter for prtSummaryTotalDebit attribute.
	 * @return prtSummaryTotalDebit attribute
	 */
	public String getPrtSummaryTotalDebit() {
		return prtSummaryTotalDebit.getValue();
	}

	/**
	 * Setter for prtSummaryTotalDebit attribute.
	 * @param prtSummaryTotalDebit the new value of prtSummaryTotalDebit
	 */
	public void setPrtSummaryTotalDebit(String prtSummaryTotalDebit) {
		this.prtSummaryTotalDebit.setValue(prtSummaryTotalDebit);
	}
	/**
	 * Gets the reference for attribute prtSummaryTotalCredit.
	 * @return the prtSummaryTotalCredit attribute reference
	 */
	public ElementaryRangeReference getPrtSummaryTotalCreditReference() {
		return prtSummaryTotalCredit.getReference();
	}

	/**
	 * Getter for prtSummaryTotalCredit attribute.
	 * @return prtSummaryTotalCredit attribute
	 */
	public String getPrtSummaryTotalCredit() {
		return prtSummaryTotalCredit.getValue();
	}

	/**
	 * Setter for prtSummaryTotalCredit attribute.
	 * @param prtSummaryTotalCredit the new value of prtSummaryTotalCredit
	 */
	public void setPrtSummaryTotalCredit(String prtSummaryTotalCredit) {
		this.prtSummaryTotalCredit.setValue(prtSummaryTotalCredit);
	}
	/**
	 * Gets the reference for attribute prtSummaryCloseBalance.
	 * @return the prtSummaryCloseBalance attribute reference
	 */
	public ElementaryRangeReference getPrtSummaryCloseBalanceReference() {
		return prtSummaryCloseBalance.getReference();
	}

	/**
	 * Getter for prtSummaryCloseBalance attribute.
	 * @return prtSummaryCloseBalance attribute
	 */
	public String getPrtSummaryCloseBalance() {
		return prtSummaryCloseBalance.getValue();
	}

	/**
	 * Setter for prtSummaryCloseBalance attribute.
	 * @param prtSummaryCloseBalance the new value of prtSummaryCloseBalance
	 */
	public void setPrtSummaryCloseBalance(String prtSummaryCloseBalance) {
		this.prtSummaryCloseBalance.setValue(prtSummaryCloseBalance);
	}
}
