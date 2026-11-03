package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity SacNumber.
 * 
 * <p>About 'sacNumber' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SacNumber extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary sacNumber = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	
	/**
	 * Instantiate a new SacNumber with a default record.
	 * @param configuration the configuration
	 */
	public SacNumber(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SacNumber bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SacNumber(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute sacNumber.
	 * @return the sacNumber attribute reference
	 */
	public ElementaryRangeReference getSacNumberReference() {
		return sacNumber.getReference();
	}

	/**
	 * Getter for sacNumber attribute.
	 * @return sacNumber attribute
	 */
	public int getSacNumber() {
		return sacNumber.getValue();
	}

	/**
	 * Setter for sacNumber attribute.
	 * @param sacNumber the new value of sacNumber
	 */
	public void setSacNumber(int sacNumber) {
		this.sacNumber.setValue(sacNumber);
	}
}
