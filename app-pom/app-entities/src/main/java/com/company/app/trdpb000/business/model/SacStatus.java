package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity SacStatus.
 * 
 * <p>About 'sacStatus' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SacStatus extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary sacStatus = new Elementary(root,new AlphanumericType(1));
	
	/**
	 * Instantiate a new SacStatus with a default record.
	 * @param configuration the configuration
	 */
	public SacStatus(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SacStatus bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SacStatus(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute sacStatus.
	 * @return the sacStatus attribute reference
	 */
	public ElementaryRangeReference getSacStatusReference() {
		return sacStatus.getReference();
	}

	/**
	 * Getter for sacStatus attribute.
	 * @return sacStatus attribute
	 */
	public String getSacStatus() {
		return sacStatus.getValue();
	}

	/**
	 * Setter for sacStatus attribute.
	 * @param sacStatus the new value of sacStatus
	 */
	public void setSacStatus(String sacStatus) {
		this.sacStatus.setValue(sacStatus);
	}
}
