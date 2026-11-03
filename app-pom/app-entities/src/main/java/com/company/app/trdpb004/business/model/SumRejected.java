package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity SumRejected.
 * 
 * <p>About 'sumRejected' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SumRejected extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary sumRejected = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	
	/**
	 * Instantiate a new SumRejected with a default record.
	 * @param configuration the configuration
	 */
	public SumRejected(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SumRejected bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SumRejected(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute sumRejected.
	 * @return the sumRejected attribute reference
	 */
	public ElementaryRangeReference getSumRejectedReference() {
		return sumRejected.getReference();
	}

	/**
	 * Getter for sumRejected attribute.
	 * @return sumRejected attribute
	 */
	public int getSumRejected() {
		return sumRejected.getValue();
	}

	/**
	 * Setter for sumRejected attribute.
	 * @param sumRejected the new value of sumRejected
	 */
	public void setSumRejected(int sumRejected) {
		this.sumRejected.setValue(sumRejected);
	}
}
