package com.company.app.mstpb002.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity SecShareClassFigi.
 * 
 * <p>About 'secShareClassFigi' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SecShareClassFigi extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary secShareClassFigi = new Elementary(root,new AlphanumericType(12));
	
	/**
	 * Instantiate a new SecShareClassFigi with a default record.
	 * @param configuration the configuration
	 */
	public SecShareClassFigi(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SecShareClassFigi bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SecShareClassFigi(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute secShareClassFigi.
	 * @return the secShareClassFigi attribute reference
	 */
	public ElementaryRangeReference getSecShareClassFigiReference() {
		return secShareClassFigi.getReference();
	}

	/**
	 * Getter for secShareClassFigi attribute.
	 * @return secShareClassFigi attribute
	 */
	public String getSecShareClassFigi() {
		return secShareClassFigi.getValue();
	}

	/**
	 * Setter for secShareClassFigi attribute.
	 * @param secShareClassFigi the new value of secShareClassFigi
	 */
	public void setSecShareClassFigi(String secShareClassFigi) {
		this.secShareClassFigi.setValue(secShareClassFigi);
	}
}
