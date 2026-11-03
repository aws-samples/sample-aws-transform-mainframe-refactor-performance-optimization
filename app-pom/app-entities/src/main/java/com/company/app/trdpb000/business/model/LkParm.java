package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Filler;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ConditionReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.ConditionName;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.ZonedType;
import java.util.Arrays;
/**
 * Data simplifier entity LkParm.
 * 
 * <p>About 'lkParmLen' field, <br>
 * </p>
 * 
 * <p>About 'lkCurrency' field, <br>
 * </p>
 * 
 * <p>About 'validCurrency' field, <br>
 * </p>
 * 
 * <p>About 'lkChkpFrequency' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class LkParm extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary lkParmLen = new Elementary(root,new BinaryType(4, 0, "STD", false, false, true));
	private final Elementary lkCurrency = new Elementary(root,new AlphanumericType(3));
	private final ConditionName validCurrency = new ConditionName(lkCurrency,
		Arrays.asList("CAD", "CHF", "CNY", "EUR", "GBX", "INR", "JPY", "KRW", "MXN", "USD"));
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(1));
	private final Elementary lkChkpFrequency = new Elementary(root,new ZonedType(4, 0, false));
	
	/**
	 * Instantiate a new LkParm with a default record.
	 * @param configuration the configuration
	 */
	public LkParm(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new LkParm bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public LkParm(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute lkParmLen.
	 * @return the lkParmLen attribute reference
	 */
	public ElementaryRangeReference getLkParmLenReference() {
		return lkParmLen.getReference();
	}

	/**
	 * Getter for lkParmLen attribute.
	 * @return lkParmLen attribute
	 */
	public int getLkParmLen() {
		return lkParmLen.getValue();
	}

	/**
	 * Setter for lkParmLen attribute.
	 * @param lkParmLen the new value of lkParmLen
	 */
	public void setLkParmLen(int lkParmLen) {
		this.lkParmLen.setValue(lkParmLen);
	}
	/**
	 * Gets the reference for attribute lkCurrency.
	 * @return the lkCurrency attribute reference
	 */
	public ElementaryRangeReference getLkCurrencyReference() {
		return lkCurrency.getReference();
	}

	/**
	 * Getter for lkCurrency attribute.
	 * @return lkCurrency attribute
	 */
	public String getLkCurrency() {
		return lkCurrency.getValue();
	}

	/**
	 * Setter for lkCurrency attribute.
	 * @param lkCurrency the new value of lkCurrency
	 */
	public void setLkCurrency(String lkCurrency) {
		this.lkCurrency.setValue(lkCurrency);
	}
	/**
	 * Gets the reference for attribute validCurrency.
	 * @return the validCurrency attribute reference
	 */
	public ConditionReference getValidCurrencyReference() {
		return lkCurrency.getCondition(validCurrency);	
	}

	/**
	 * Getter for validCurrency attribute.
	 * @return validCurrency attribute
	 */
	public boolean isValidCurrency() {
		return getValidCurrencyReference().getValue();	
	}

	/**
	 * Setter for validCurrency attribute.
	 * @param validCurrency the new value of validCurrency
	 */
	public void setValidCurrency(boolean validCurrency) {
		getValidCurrencyReference().setValue(validCurrency);	
	}
	/**
	 * Gets the reference for attribute lkChkpFrequency.
	 * @return the lkChkpFrequency attribute reference
	 */
	public ElementaryRangeReference getLkChkpFrequencyReference() {
		return lkChkpFrequency.getReference();
	}

	/**
	 * Getter for lkChkpFrequency attribute.
	 * @return lkChkpFrequency attribute
	 */
	public int getLkChkpFrequency() {
		return lkChkpFrequency.getValue();
	}

	/**
	 * Setter for lkChkpFrequency attribute.
	 * @param lkChkpFrequency the new value of lkChkpFrequency
	 */
	public void setLkChkpFrequency(int lkChkpFrequency) {
		this.lkChkpFrequency.setValue(lkChkpFrequency);
	}
}
