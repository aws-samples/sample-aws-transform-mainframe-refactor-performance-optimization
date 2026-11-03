package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity OrdFigi.
 * 
 * <p>About 'ordFigi' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class OrdFigi extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary ordFigi = new Elementary(root,new AlphanumericType(12));
	
	/**
	 * Instantiate a new OrdFigi with a default record.
	 * @param configuration the configuration
	 */
	public OrdFigi(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new OrdFigi bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public OrdFigi(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute ordFigi.
	 * @return the ordFigi attribute reference
	 */
	public ElementaryRangeReference getOrdFigiReference() {
		return ordFigi.getReference();
	}

	/**
	 * Getter for ordFigi attribute.
	 * @return ordFigi attribute
	 */
	public String getOrdFigi() {
		return ordFigi.getValue();
	}

	/**
	 * Setter for ordFigi attribute.
	 * @param ordFigi the new value of ordFigi
	 */
	public void setOrdFigi(String ordFigi) {
		this.ordFigi.setValue(ordFigi);
	}
}
