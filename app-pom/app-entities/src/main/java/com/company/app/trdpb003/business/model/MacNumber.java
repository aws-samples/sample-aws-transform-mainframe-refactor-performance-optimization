package com.company.app.trdpb003.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity MacNumber.
 * 
 * <p>About 'macNumber' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class MacNumber extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary macNumber = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	
	/**
	 * Instantiate a new MacNumber with a default record.
	 * @param configuration the configuration
	 */
	public MacNumber(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new MacNumber bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public MacNumber(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute macNumber.
	 * @return the macNumber attribute reference
	 */
	public ElementaryRangeReference getMacNumberReference() {
		return macNumber.getReference();
	}

	/**
	 * Getter for macNumber attribute.
	 * @return macNumber attribute
	 */
	public int getMacNumber() {
		return macNumber.getValue();
	}

	/**
	 * Setter for macNumber attribute.
	 * @param macNumber the new value of macNumber
	 */
	public void setMacNumber(int macNumber) {
		this.macNumber.setValue(macNumber);
	}
}
