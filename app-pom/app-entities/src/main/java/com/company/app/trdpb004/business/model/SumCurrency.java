package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity SumCurrency.
 * 
 * <p>About 'sumCurrency' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SumCurrency extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary sumCurrency = new Elementary(root,new AlphanumericType(3));
	
	/**
	 * Instantiate a new SumCurrency with a default record.
	 * @param configuration the configuration
	 */
	public SumCurrency(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SumCurrency bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SumCurrency(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
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
}
