package com.company.app.mstpb001.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity CusStatus.
 * 
 * <p>About 'cusStatus' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class CusStatus extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary cusStatus = new Elementary(root,new AlphanumericType(1));
	
	/**
	 * Instantiate a new CusStatus with a default record.
	 * @param configuration the configuration
	 */
	public CusStatus(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new CusStatus bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public CusStatus(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute cusStatus.
	 * @return the cusStatus attribute reference
	 */
	public ElementaryRangeReference getCusStatusReference() {
		return cusStatus.getReference();
	}

	/**
	 * Getter for cusStatus attribute.
	 * @return cusStatus attribute
	 */
	public String getCusStatus() {
		return cusStatus.getValue();
	}

	/**
	 * Setter for cusStatus attribute.
	 * @param cusStatus the new value of cusStatus
	 */
	public void setCusStatus(String cusStatus) {
		this.cusStatus.setValue(cusStatus);
	}
}
