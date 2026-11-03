package com.company.app.trdpbexc.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsDateTimeVars.
 * 
 * <p>About 'wsCurrdate' field, <br>
 * </p>
 * 
 * <p>About 'wsCurrtime' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsDateTimeVars extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsCurrdate = new Elementary(root,new AlphanumericType(10));
	private final Elementary wsCurrtime = new Elementary(root,new AlphanumericType(8));
	
	/**
	 * Instantiate a new WsDateTimeVars with a default record.
	 * @param configuration the configuration
	 */
	public WsDateTimeVars(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsDateTimeVars bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsDateTimeVars(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsCurrdate.
	 * @return the wsCurrdate attribute reference
	 */
	public ElementaryRangeReference getWsCurrdateReference() {
		return wsCurrdate.getReference();
	}

	/**
	 * Getter for wsCurrdate attribute.
	 * @return wsCurrdate attribute
	 */
	public String getWsCurrdate() {
		return wsCurrdate.getValue();
	}

	/**
	 * Setter for wsCurrdate attribute.
	 * @param wsCurrdate the new value of wsCurrdate
	 */
	public void setWsCurrdate(String wsCurrdate) {
		this.wsCurrdate.setValue(wsCurrdate);
	}
	/**
	 * Gets the reference for attribute wsCurrtime.
	 * @return the wsCurrtime attribute reference
	 */
	public ElementaryRangeReference getWsCurrtimeReference() {
		return wsCurrtime.getReference();
	}

	/**
	 * Getter for wsCurrtime attribute.
	 * @return wsCurrtime attribute
	 */
	public String getWsCurrtime() {
		return wsCurrtime.getValue();
	}

	/**
	 * Setter for wsCurrtime attribute.
	 * @param wsCurrtime the new value of wsCurrtime
	 */
	public void setWsCurrtime(String wsCurrtime) {
		this.wsCurrtime.setValue(wsCurrtime);
	}
}
