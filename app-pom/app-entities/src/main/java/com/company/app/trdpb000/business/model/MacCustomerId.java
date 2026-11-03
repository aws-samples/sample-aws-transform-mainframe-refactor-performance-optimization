package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity MacCustomerId.
 * 
 * <p>About 'macCustomerId' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class MacCustomerId extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary macCustomerId = new Elementary(root,new AlphanumericType(12));
	
	/**
	 * Instantiate a new MacCustomerId with a default record.
	 * @param configuration the configuration
	 */
	public MacCustomerId(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new MacCustomerId bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public MacCustomerId(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute macCustomerId.
	 * @return the macCustomerId attribute reference
	 */
	public ElementaryRangeReference getMacCustomerIdReference() {
		return macCustomerId.getReference();
	}

	/**
	 * Getter for macCustomerId attribute.
	 * @return macCustomerId attribute
	 */
	public String getMacCustomerId() {
		return macCustomerId.getValue();
	}

	/**
	 * Setter for macCustomerId attribute.
	 * @param macCustomerId the new value of macCustomerId
	 */
	public void setMacCustomerId(String macCustomerId) {
		this.macCustomerId.setValue(macCustomerId);
	}
}
