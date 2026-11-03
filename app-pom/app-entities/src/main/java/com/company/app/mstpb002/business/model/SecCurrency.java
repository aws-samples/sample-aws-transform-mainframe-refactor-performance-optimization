package com.company.app.mstpb002.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity SecCurrency.
 * 
 * <p>About 'secCurrency' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SecCurrency extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary secCurrency = new Elementary(root,new AlphanumericType(3));
	
	/**
	 * Instantiate a new SecCurrency with a default record.
	 * @param configuration the configuration
	 */
	public SecCurrency(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SecCurrency bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SecCurrency(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute secCurrency.
	 * @return the secCurrency attribute reference
	 */
	public ElementaryRangeReference getSecCurrencyReference() {
		return secCurrency.getReference();
	}

	/**
	 * Getter for secCurrency attribute.
	 * @return secCurrency attribute
	 */
	public String getSecCurrency() {
		return secCurrency.getValue();
	}

	/**
	 * Setter for secCurrency attribute.
	 * @param secCurrency the new value of secCurrency
	 */
	public void setSecCurrency(String secCurrency) {
		this.secCurrency.setValue(secCurrency);
	}
}
