package com.company.app.trdpb002.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.NumericEditedType;
/**
 * Data simplifier entity WsSqlcode.
 * 
 * <p>About 'wsSqlcode' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsSqlcode extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * 
	 */
	private final Elementary wsSqlcode = new Elementary(root,new NumericEditedType("-(4)"));
	
	/**
	 * Instantiate a new WsSqlcode with a default record.
	 * @param configuration the configuration
	 */
	public WsSqlcode(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsSqlcode bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsSqlcode(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsSqlcode.
	 * @return the wsSqlcode attribute reference
	 */
	public ElementaryRangeReference getWsSqlcodeReference() {
		return wsSqlcode.getReference();
	}

	/**
	 * Getter for wsSqlcode attribute.
	 * @return wsSqlcode attribute
	 */
	public String getWsSqlcode() {
		return wsSqlcode.getValue();
	}

	/**
	 * Setter for wsSqlcode attribute.
	 * @param wsSqlcode the new value of wsSqlcode
	 */
	public void setWsSqlcode(String wsSqlcode) {
		this.wsSqlcode.setValue(wsSqlcode);
	}
}
