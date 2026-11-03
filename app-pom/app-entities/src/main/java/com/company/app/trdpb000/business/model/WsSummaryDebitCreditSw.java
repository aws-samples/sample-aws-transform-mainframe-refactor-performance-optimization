package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ConditionReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.ConditionName;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import java.util.Arrays;
/**
 * Data simplifier entity WsSummaryDebitCreditSw.
 * 
 * <p>About 'wsSummaryDebitCreditSw' field, <br>
 * </p>
 * 
 * <p>About 'summaryDebit' field, <br>
 * </p>
 * 
 * <p>About 'summaryCredit' field, <br>
 * </p>
 * 
 * <p>About 'summaryNoBooking' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsSummaryDebitCreditSw extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsSummaryDebitCreditSw = new Elementary(root,new AlphanumericType(1));
	private final ConditionName summaryDebit = new ConditionName(wsSummaryDebitCreditSw,
		Arrays.asList("D"));
	private final ConditionName summaryCredit = new ConditionName(wsSummaryDebitCreditSw,
		Arrays.asList("C"));
	private final ConditionName summaryNoBooking = new ConditionName(wsSummaryDebitCreditSw,
		Arrays.asList("N"));
	
	/**
	 * Instantiate a new WsSummaryDebitCreditSw with a default record.
	 * @param configuration the configuration
	 */
	public WsSummaryDebitCreditSw(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsSummaryDebitCreditSw bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsSummaryDebitCreditSw(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsSummaryDebitCreditSw.
	 * @return the wsSummaryDebitCreditSw attribute reference
	 */
	public ElementaryRangeReference getWsSummaryDebitCreditSwReference() {
		return wsSummaryDebitCreditSw.getReference();
	}

	/**
	 * Getter for wsSummaryDebitCreditSw attribute.
	 * @return wsSummaryDebitCreditSw attribute
	 */
	public String getWsSummaryDebitCreditSw() {
		return wsSummaryDebitCreditSw.getValue();
	}

	/**
	 * Setter for wsSummaryDebitCreditSw attribute.
	 * @param wsSummaryDebitCreditSw the new value of wsSummaryDebitCreditSw
	 */
	public void setWsSummaryDebitCreditSw(String wsSummaryDebitCreditSw) {
		this.wsSummaryDebitCreditSw.setValue(wsSummaryDebitCreditSw);
	}
	/**
	 * Gets the reference for attribute summaryDebit.
	 * @return the summaryDebit attribute reference
	 */
	public ConditionReference getSummaryDebitReference() {
		return wsSummaryDebitCreditSw.getCondition(summaryDebit);	
	}

	/**
	 * Getter for summaryDebit attribute.
	 * @return summaryDebit attribute
	 */
	public boolean isSummaryDebit() {
		return getSummaryDebitReference().getValue();	
	}

	/**
	 * Setter for summaryDebit attribute.
	 * @param summaryDebit the new value of summaryDebit
	 */
	public void setSummaryDebit(boolean summaryDebit) {
		getSummaryDebitReference().setValue(summaryDebit);	
	}
	/**
	 * Gets the reference for attribute summaryCredit.
	 * @return the summaryCredit attribute reference
	 */
	public ConditionReference getSummaryCreditReference() {
		return wsSummaryDebitCreditSw.getCondition(summaryCredit);	
	}

	/**
	 * Getter for summaryCredit attribute.
	 * @return summaryCredit attribute
	 */
	public boolean isSummaryCredit() {
		return getSummaryCreditReference().getValue();	
	}

	/**
	 * Setter for summaryCredit attribute.
	 * @param summaryCredit the new value of summaryCredit
	 */
	public void setSummaryCredit(boolean summaryCredit) {
		getSummaryCreditReference().setValue(summaryCredit);	
	}
	/**
	 * Gets the reference for attribute summaryNoBooking.
	 * @return the summaryNoBooking attribute reference
	 */
	public ConditionReference getSummaryNoBookingReference() {
		return wsSummaryDebitCreditSw.getCondition(summaryNoBooking);	
	}

	/**
	 * Getter for summaryNoBooking attribute.
	 * @return summaryNoBooking attribute
	 */
	public boolean isSummaryNoBooking() {
		return getSummaryNoBookingReference().getValue();	
	}

	/**
	 * Setter for summaryNoBooking attribute.
	 * @param summaryNoBooking the new value of summaryNoBooking
	 */
	public void setSummaryNoBooking(boolean summaryNoBooking) {
		getSummaryNoBookingReference().setValue(summaryNoBooking);	
	}
}
