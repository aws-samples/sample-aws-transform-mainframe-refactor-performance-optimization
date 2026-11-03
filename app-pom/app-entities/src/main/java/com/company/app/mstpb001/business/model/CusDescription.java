package com.company.app.mstpb001.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity CusDescription.
 * 
 * <p>About 'cusDescription' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class CusDescription extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary cusDescription = new Elementary(root,new AlphanumericType(40));
	
	/**
	 * Instantiate a new CusDescription with a default record.
	 * @param configuration the configuration
	 */
	public CusDescription(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new CusDescription bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public CusDescription(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute cusDescription.
	 * @return the cusDescription attribute reference
	 */
	public ElementaryRangeReference getCusDescriptionReference() {
		return cusDescription.getReference();
	}

	/**
	 * Getter for cusDescription attribute.
	 * @return cusDescription attribute
	 */
	public String getCusDescription() {
		return cusDescription.getValue();
	}

	/**
	 * Setter for cusDescription attribute.
	 * @param cusDescription the new value of cusDescription
	 */
	public void setCusDescription(String cusDescription) {
		this.cusDescription.setValue(cusDescription);
	}
}
