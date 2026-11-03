package com.company.app.trdpb001.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsMacBooking.
 * 
 * <p>About 'wsMacBooking' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsMacBooking extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsMacBooking = new Elementary(root,new AlphanumericType(8),"TRDPB003");
	
	/**
	 * Instantiate a new WsMacBooking with a default record.
	 * @param configuration the configuration
	 */
	public WsMacBooking(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsMacBooking bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsMacBooking(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsMacBooking.
	 * @return the wsMacBooking attribute reference
	 */
	public ElementaryRangeReference getWsMacBookingReference() {
		return wsMacBooking.getReference();
	}

	/**
	 * Getter for wsMacBooking attribute.
	 * @return wsMacBooking attribute
	 */
	public String getWsMacBooking() {
		return wsMacBooking.getValue();
	}

	/**
	 * Setter for wsMacBooking attribute.
	 * @param wsMacBooking the new value of wsMacBooking
	 */
	public void setWsMacBooking(String wsMacBooking) {
		this.wsMacBooking.setValue(wsMacBooking);
	}
}
