package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity MacStatus.
 * 
 * <p>About 'macStatus' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class MacStatus extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary macStatus = new Elementary(root,new AlphanumericType(1));
	
	/**
	 * Instantiate a new MacStatus with a default record.
	 * @param configuration the configuration
	 */
	public MacStatus(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new MacStatus bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public MacStatus(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute macStatus.
	 * @return the macStatus attribute reference
	 */
	public ElementaryRangeReference getMacStatusReference() {
		return macStatus.getReference();
	}

	/**
	 * Getter for macStatus attribute.
	 * @return macStatus attribute
	 */
	public String getMacStatus() {
		return macStatus.getValue();
	}

	/**
	 * Setter for macStatus attribute.
	 * @param macStatus the new value of macStatus
	 */
	public void setMacStatus(String macStatus) {
		this.macStatus.setValue(macStatus);
	}
}
