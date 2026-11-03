package com.company.app.trdpb006.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity SecType.
 * 
 * <p>About 'secType' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SecType extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary secType = new Elementary(root,new AlphanumericType(20));
	
	/**
	 * Instantiate a new SecType with a default record.
	 * @param configuration the configuration
	 */
	public SecType(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SecType bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SecType(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute secType.
	 * @return the secType attribute reference
	 */
	public ElementaryRangeReference getSecTypeReference() {
		return secType.getReference();
	}

	/**
	 * Getter for secType attribute.
	 * @return secType attribute
	 */
	public String getSecType() {
		return secType.getValue();
	}

	/**
	 * Setter for secType attribute.
	 * @param secType the new value of secType
	 */
	public void setSecType(String secType) {
		this.secType.setValue(secType);
	}
}
