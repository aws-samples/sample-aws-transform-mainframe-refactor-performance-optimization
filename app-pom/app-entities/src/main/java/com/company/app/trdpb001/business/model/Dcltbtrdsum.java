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
 * Data simplifier entity Dcltbtrdsum.
<pre>
 * 
 * Legacy Documentation:<br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDSUM                     *<br>
 *  ****************************************************************<br>
</pre>
 * 
 * <p>About 'sumCustomerId' field, <br>
 * </p>
 * 
 * <p>About 'sumOverdue' field, <br>
 * </p>
 * 
 * <p>About 'sumRejected' field, <br>
 * </p>
 * 
 * <p>About 'sumSettled' field, <br>
 * </p>
 * 
 * <p>About 'sumCurrency' field, <br>
 * </p>
 * 
 * <p>About 'sumOpenBalance' field, <br>
 * </p>
 * 
 * <p>About 'sumTotalDebit' field, <br>
 * </p>
 * 
 * <p>About 'sumTotalCredit' field, <br>
 * </p>
 * 
 * <p>About 'sumCloseBalance' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class Dcltbtrdsum extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary sumCustomerId = new Elementary(root,new AlphanumericType(12));
	private final Elementary sumOverdue = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	private final Elementary sumRejected = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	private final Elementary sumSettled = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	private final Elementary sumCurrency = new Elementary(root,new AlphanumericType(3));
	private final Elementary sumOpenBalance = new Elementary(root,new PackedType(10, 2, false, false, true));
	private final Elementary sumTotalDebit = new Elementary(root,new PackedType(10, 2, false, false, true));
	private final Elementary sumTotalCredit = new Elementary(root,new PackedType(10, 2, false, false, true));
	private final Elementary sumCloseBalance = new Elementary(root,new PackedType(10, 2, false, false, true));
	
	/**
	 * Instantiate a new Dcltbtrdsum with a default record.
	 * @param configuration the configuration
	 */
	public Dcltbtrdsum(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new Dcltbtrdsum bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public Dcltbtrdsum(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute sumCustomerId.
	 * @return the sumCustomerId attribute reference
	 */
	public ElementaryRangeReference getSumCustomerIdReference() {
		return sumCustomerId.getReference();
	}

	/**
	 * Getter for sumCustomerId attribute.
	 * @return sumCustomerId attribute
	 */
	public String getSumCustomerId() {
		return sumCustomerId.getValue();
	}

	/**
	 * Setter for sumCustomerId attribute.
	 * @param sumCustomerId the new value of sumCustomerId
	 */
	public void setSumCustomerId(String sumCustomerId) {
		this.sumCustomerId.setValue(sumCustomerId);
	}
	/**
	 * Gets the reference for attribute sumOverdue.
	 * @return the sumOverdue attribute reference
	 */
	public ElementaryRangeReference getSumOverdueReference() {
		return sumOverdue.getReference();
	}

	/**
	 * Getter for sumOverdue attribute.
	 * @return sumOverdue attribute
	 */
	public int getSumOverdue() {
		return sumOverdue.getValue();
	}

	/**
	 * Setter for sumOverdue attribute.
	 * @param sumOverdue the new value of sumOverdue
	 */
	public void setSumOverdue(int sumOverdue) {
		this.sumOverdue.setValue(sumOverdue);
	}
	/**
	 * Gets the reference for attribute sumRejected.
	 * @return the sumRejected attribute reference
	 */
	public ElementaryRangeReference getSumRejectedReference() {
		return sumRejected.getReference();
	}

	/**
	 * Getter for sumRejected attribute.
	 * @return sumRejected attribute
	 */
	public int getSumRejected() {
		return sumRejected.getValue();
	}

	/**
	 * Setter for sumRejected attribute.
	 * @param sumRejected the new value of sumRejected
	 */
	public void setSumRejected(int sumRejected) {
		this.sumRejected.setValue(sumRejected);
	}
	/**
	 * Gets the reference for attribute sumSettled.
	 * @return the sumSettled attribute reference
	 */
	public ElementaryRangeReference getSumSettledReference() {
		return sumSettled.getReference();
	}

	/**
	 * Getter for sumSettled attribute.
	 * @return sumSettled attribute
	 */
	public int getSumSettled() {
		return sumSettled.getValue();
	}

	/**
	 * Setter for sumSettled attribute.
	 * @param sumSettled the new value of sumSettled
	 */
	public void setSumSettled(int sumSettled) {
		this.sumSettled.setValue(sumSettled);
	}
	/**
	 * Gets the reference for attribute sumCurrency.
	 * @return the sumCurrency attribute reference
	 */
	public ElementaryRangeReference getSumCurrencyReference() {
		return sumCurrency.getReference();
	}

	/**
	 * Getter for sumCurrency attribute.
	 * @return sumCurrency attribute
	 */
	public String getSumCurrency() {
		return sumCurrency.getValue();
	}

	/**
	 * Setter for sumCurrency attribute.
	 * @param sumCurrency the new value of sumCurrency
	 */
	public void setSumCurrency(String sumCurrency) {
		this.sumCurrency.setValue(sumCurrency);
	}
	/**
	 * Gets the reference for attribute sumOpenBalance.
	 * @return the sumOpenBalance attribute reference
	 */
	public ElementaryRangeReference getSumOpenBalanceReference() {
		return sumOpenBalance.getReference();
	}

	/**
	 * Getter for sumOpenBalance attribute.
	 * @return sumOpenBalance attribute
	 */
	public BigDecimal getSumOpenBalance() {
		return sumOpenBalance.getValue();
	}

	/**
	 * Setter for sumOpenBalance attribute.
	 * @param sumOpenBalance the new value of sumOpenBalance
	 */
	public void setSumOpenBalance(BigDecimal sumOpenBalance) {
		this.sumOpenBalance.setValue(sumOpenBalance);
	}
	/**
	 * Gets the reference for attribute sumTotalDebit.
	 * @return the sumTotalDebit attribute reference
	 */
	public ElementaryRangeReference getSumTotalDebitReference() {
		return sumTotalDebit.getReference();
	}

	/**
	 * Getter for sumTotalDebit attribute.
	 * @return sumTotalDebit attribute
	 */
	public BigDecimal getSumTotalDebit() {
		return sumTotalDebit.getValue();
	}

	/**
	 * Setter for sumTotalDebit attribute.
	 * @param sumTotalDebit the new value of sumTotalDebit
	 */
	public void setSumTotalDebit(BigDecimal sumTotalDebit) {
		this.sumTotalDebit.setValue(sumTotalDebit);
	}
	/**
	 * Gets the reference for attribute sumTotalCredit.
	 * @return the sumTotalCredit attribute reference
	 */
	public ElementaryRangeReference getSumTotalCreditReference() {
		return sumTotalCredit.getReference();
	}

	/**
	 * Getter for sumTotalCredit attribute.
	 * @return sumTotalCredit attribute
	 */
	public BigDecimal getSumTotalCredit() {
		return sumTotalCredit.getValue();
	}

	/**
	 * Setter for sumTotalCredit attribute.
	 * @param sumTotalCredit the new value of sumTotalCredit
	 */
	public void setSumTotalCredit(BigDecimal sumTotalCredit) {
		this.sumTotalCredit.setValue(sumTotalCredit);
	}
	/**
	 * Gets the reference for attribute sumCloseBalance.
	 * @return the sumCloseBalance attribute reference
	 */
	public ElementaryRangeReference getSumCloseBalanceReference() {
		return sumCloseBalance.getReference();
	}

	/**
	 * Getter for sumCloseBalance attribute.
	 * @return sumCloseBalance attribute
	 */
	public BigDecimal getSumCloseBalance() {
		return sumCloseBalance.getValue();
	}

	/**
	 * Setter for sumCloseBalance attribute.
	 * @param sumCloseBalance the new value of sumCloseBalance
	 */
	public void setSumCloseBalance(BigDecimal sumCloseBalance) {
		this.sumCloseBalance.setValue(sumCloseBalance);
	}
}
