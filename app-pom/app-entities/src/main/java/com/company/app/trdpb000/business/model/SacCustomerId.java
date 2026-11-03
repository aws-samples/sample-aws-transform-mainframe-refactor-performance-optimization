package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity SacCustomerId.
 * 
 * <p>About 'sacCustomerId' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SacCustomerId extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary sacCustomerId = new Elementary(root,new AlphanumericType(12));
	
	/**
	 * Instantiate a new SacCustomerId with a default record.
	 * @param configuration the configuration
	 */
	public SacCustomerId(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SacCustomerId bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SacCustomerId(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute sacCustomerId.
	 * @return the sacCustomerId attribute reference
	 */
	public ElementaryRangeReference getSacCustomerIdReference() {
		return sacCustomerId.getReference();
	}

	/**
	 * Getter for sacCustomerId attribute.
	 * @return sacCustomerId attribute
	 */
	public String getSacCustomerId() {
		return sacCustomerId.getValue();
	}

	/**
	 * Setter for sacCustomerId attribute.
	 * @param sacCustomerId the new value of sacCustomerId
	 */
	public void setSacCustomerId(String sacCustomerId) {
		this.sacCustomerId.setValue(sacCustomerId);
	}
}
