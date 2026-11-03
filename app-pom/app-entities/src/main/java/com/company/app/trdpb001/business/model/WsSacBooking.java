package com.company.app.trdpb001.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsSacBooking.
 * 
 * <p>About 'wsSacBooking' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsSacBooking extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * 
	 */
	private final Elementary wsSacBooking = new Elementary(root,new AlphanumericType(8),"TRDPB002");
	
	/**
	 * Instantiate a new WsSacBooking with a default record.
	 * @param configuration the configuration
	 */
	public WsSacBooking(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsSacBooking bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsSacBooking(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsSacBooking.
	 * @return the wsSacBooking attribute reference
	 */
	public ElementaryRangeReference getWsSacBookingReference() {
		return wsSacBooking.getReference();
	}

	/**
	 * Getter for wsSacBooking attribute.
	 * @return wsSacBooking attribute
	 */
	public String getWsSacBooking() {
		return wsSacBooking.getValue();
	}

	/**
	 * Setter for wsSacBooking attribute.
	 * @param wsSacBooking the new value of wsSacBooking
	 */
	public void setWsSacBooking(String wsSacBooking) {
		this.wsSacBooking.setValue(wsSacBooking);
	}
}
