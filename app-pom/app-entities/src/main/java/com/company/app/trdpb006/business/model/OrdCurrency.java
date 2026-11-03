package com.company.app.trdpb006.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity OrdCurrency.
 * 
 * <p>About 'ordCurrency' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class OrdCurrency extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary ordCurrency = new Elementary(root,new AlphanumericType(3));
	
	/**
	 * Instantiate a new OrdCurrency with a default record.
	 * @param configuration the configuration
	 */
	public OrdCurrency(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new OrdCurrency bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public OrdCurrency(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute ordCurrency.
	 * @return the ordCurrency attribute reference
	 */
	public ElementaryRangeReference getOrdCurrencyReference() {
		return ordCurrency.getReference();
	}

	/**
	 * Getter for ordCurrency attribute.
	 * @return ordCurrency attribute
	 */
	public String getOrdCurrency() {
		return ordCurrency.getValue();
	}

	/**
	 * Setter for ordCurrency attribute.
	 * @param ordCurrency the new value of ordCurrency
	 */
	public void setOrdCurrency(String ordCurrency) {
		this.ordCurrency.setValue(ordCurrency);
	}
}
