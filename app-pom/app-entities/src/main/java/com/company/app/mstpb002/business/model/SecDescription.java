package com.company.app.mstpb002.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity SecDescription.
 * 
 * <p>About 'secDescription' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SecDescription extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary secDescription = new Elementary(root,new AlphanumericType(40));
	
	/**
	 * Instantiate a new SecDescription with a default record.
	 * @param configuration the configuration
	 */
	public SecDescription(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SecDescription bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SecDescription(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute secDescription.
	 * @return the secDescription attribute reference
	 */
	public ElementaryRangeReference getSecDescriptionReference() {
		return secDescription.getReference();
	}

	/**
	 * Getter for secDescription attribute.
	 * @return secDescription attribute
	 */
	public String getSecDescription() {
		return secDescription.getValue();
	}

	/**
	 * Setter for secDescription attribute.
	 * @param secDescription the new value of secDescription
	 */
	public void setSecDescription(String secDescription) {
		this.secDescription.setValue(secDescription);
	}
}
