package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.ZonedType;
/**
 * Data simplifier entity WsTradeid.
 * 
 * <p>About 'wsTradeid' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsTradeid extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsTradeid = new Elementary(root,new ZonedType(9, 0, false));
	
	/**
	 * Instantiate a new WsTradeid with a default record.
	 * @param configuration the configuration
	 */
	public WsTradeid(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsTradeid bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsTradeid(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsTradeid.
	 * @return the wsTradeid attribute reference
	 */
	public ElementaryRangeReference getWsTradeidReference() {
		return wsTradeid.getReference();
	}

	/**
	 * Getter for wsTradeid attribute.
	 * @return wsTradeid attribute
	 */
	public int getWsTradeid() {
		return wsTradeid.getValue();
	}

	/**
	 * Setter for wsTradeid attribute.
	 * @param wsTradeid the new value of wsTradeid
	 */
	public void setWsTradeid(int wsTradeid) {
		this.wsTradeid.setValue(wsTradeid);
	}
}
