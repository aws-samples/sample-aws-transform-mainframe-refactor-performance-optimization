package com.company.app.mstpb001.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity CusCurrency.
 * 
 * <p>About 'cusCurrency' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class CusCurrency extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary cusCurrency = new Elementary(root,new AlphanumericType(3));
	
	/**
	 * Instantiate a new CusCurrency with a default record.
	 * @param configuration the configuration
	 */
	public CusCurrency(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new CusCurrency bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public CusCurrency(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute cusCurrency.
	 * @return the cusCurrency attribute reference
	 */
	public ElementaryRangeReference getCusCurrencyReference() {
		return cusCurrency.getReference();
	}

	/**
	 * Getter for cusCurrency attribute.
	 * @return cusCurrency attribute
	 */
	public String getCusCurrency() {
		return cusCurrency.getValue();
	}

	/**
	 * Setter for cusCurrency attribute.
	 * @param cusCurrency the new value of cusCurrency
	 */
	public void setCusCurrency(String cusCurrency) {
		this.cusCurrency.setValue(cusCurrency);
	}
}
