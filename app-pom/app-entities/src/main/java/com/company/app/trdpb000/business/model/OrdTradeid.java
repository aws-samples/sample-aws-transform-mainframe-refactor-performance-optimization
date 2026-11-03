package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity OrdTradeid.
 * 
 * <p>About 'ordTradeid' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class OrdTradeid extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary ordTradeid = new Elementary(root,new AlphanumericType(12));
	
	/**
	 * Instantiate a new OrdTradeid with a default record.
	 * @param configuration the configuration
	 */
	public OrdTradeid(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new OrdTradeid bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public OrdTradeid(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute ordTradeid.
	 * @return the ordTradeid attribute reference
	 */
	public ElementaryRangeReference getOrdTradeidReference() {
		return ordTradeid.getReference();
	}

	/**
	 * Getter for ordTradeid attribute.
	 * @return ordTradeid attribute
	 */
	public String getOrdTradeid() {
		return ordTradeid.getValue();
	}

	/**
	 * Setter for ordTradeid attribute.
	 * @param ordTradeid the new value of ordTradeid
	 */
	public void setOrdTradeid(String ordTradeid) {
		this.ordTradeid.setValue(ordTradeid);
	}
}
