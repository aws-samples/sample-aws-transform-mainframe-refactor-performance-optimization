package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity OrdCustomerId.
 * 
 * <p>About 'ordCustomerId' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class OrdCustomerId extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary ordCustomerId = new Elementary(root,new AlphanumericType(12));
	
	/**
	 * Instantiate a new OrdCustomerId with a default record.
	 * @param configuration the configuration
	 */
	public OrdCustomerId(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new OrdCustomerId bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public OrdCustomerId(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute ordCustomerId.
	 * @return the ordCustomerId attribute reference
	 */
	public ElementaryRangeReference getOrdCustomerIdReference() {
		return ordCustomerId.getReference();
	}

	/**
	 * Getter for ordCustomerId attribute.
	 * @return ordCustomerId attribute
	 */
	public String getOrdCustomerId() {
		return ordCustomerId.getValue();
	}

	/**
	 * Setter for ordCustomerId attribute.
	 * @param ordCustomerId the new value of ordCustomerId
	 */
	public void setOrdCustomerId(String ordCustomerId) {
		this.ordCustomerId.setValue(ordCustomerId);
	}
}
