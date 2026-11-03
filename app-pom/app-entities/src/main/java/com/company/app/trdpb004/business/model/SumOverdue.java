package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity SumOverdue.
 * 
 * <p>About 'sumOverdue' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SumOverdue extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary sumOverdue = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	
	/**
	 * Instantiate a new SumOverdue with a default record.
	 * @param configuration the configuration
	 */
	public SumOverdue(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SumOverdue bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SumOverdue(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute sumOverdue.
	 * @return the sumOverdue attribute reference
	 */
	public ElementaryRangeReference getSumOverdueReference() {
		return sumOverdue.getReference();
	}

	/**
	 * Getter for sumOverdue attribute.
	 * @return sumOverdue attribute
	 */
	public int getSumOverdue() {
		return sumOverdue.getValue();
	}

	/**
	 * Setter for sumOverdue attribute.
	 * @param sumOverdue the new value of sumOverdue
	 */
	public void setSumOverdue(int sumOverdue) {
		this.sumOverdue.setValue(sumOverdue);
	}
}
