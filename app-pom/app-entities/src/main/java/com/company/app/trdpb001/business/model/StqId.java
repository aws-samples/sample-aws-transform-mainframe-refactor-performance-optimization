package com.company.app.trdpb001.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity StqId.
 * 
 * <p>About 'stqId' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class StqId extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary stqId = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	
	/**
	 * Instantiate a new StqId with a default record.
	 * @param configuration the configuration
	 */
	public StqId(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new StqId bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public StqId(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute stqId.
	 * @return the stqId attribute reference
	 */
	public ElementaryRangeReference getStqIdReference() {
		return stqId.getReference();
	}

	/**
	 * Getter for stqId attribute.
	 * @return stqId attribute
	 */
	public int getStqId() {
		return stqId.getValue();
	}

	/**
	 * Setter for stqId attribute.
	 * @param stqId the new value of stqId
	 */
	public void setStqId(int stqId) {
		this.stqId.setValue(stqId);
	}
}
