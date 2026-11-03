package com.company.app.trdpbexc.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity ExcType.
 * 
 * <p>About 'excType' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class ExcType extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary excType = new Elementary(root,new AlphanumericType(20));
	
	/**
	 * Instantiate a new ExcType with a default record.
	 * @param configuration the configuration
	 */
	public ExcType(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new ExcType bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public ExcType(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute excType.
	 * @return the excType attribute reference
	 */
	public ElementaryRangeReference getExcTypeReference() {
		return excType.getReference();
	}

	/**
	 * Getter for excType attribute.
	 * @return excType attribute
	 */
	public String getExcType() {
		return excType.getValue();
	}

	/**
	 * Setter for excType attribute.
	 * @param excType the new value of excType
	 */
	public void setExcType(String excType) {
		this.excType.setValue(excType);
	}
}
