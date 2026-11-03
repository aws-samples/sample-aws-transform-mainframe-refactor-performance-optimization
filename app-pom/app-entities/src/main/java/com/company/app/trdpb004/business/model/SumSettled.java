package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity SumSettled.
 * 
 * <p>About 'sumSettled' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SumSettled extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary sumSettled = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	
	/**
	 * Instantiate a new SumSettled with a default record.
	 * @param configuration the configuration
	 */
	public SumSettled(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SumSettled bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SumSettled(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute sumSettled.
	 * @return the sumSettled attribute reference
	 */
	public ElementaryRangeReference getSumSettledReference() {
		return sumSettled.getReference();
	}

	/**
	 * Getter for sumSettled attribute.
	 * @return sumSettled attribute
	 */
	public int getSumSettled() {
		return sumSettled.getValue();
	}

	/**
	 * Setter for sumSettled attribute.
	 * @param sumSettled the new value of sumSettled
	 */
	public void setSumSettled(int sumSettled) {
		this.sumSettled.setValue(sumSettled);
	}
}
