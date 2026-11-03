package com.company.app.trdpbexc.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity ExcDescription.
 * 
 * <p>About 'excDescriptionLen' field, <br>
 * </p>
 * 
 * <p>About 'excDescriptionText' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class ExcDescription extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary excDescriptionLen = new Elementary(root,new BinaryType(4, 0, "STD", false, false, true));
	private final Elementary excDescriptionText = new Elementary(root,new AlphanumericType(1000));
	
	/**
	 * Instantiate a new ExcDescription with a default record.
	 * @param configuration the configuration
	 */
	public ExcDescription(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new ExcDescription bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public ExcDescription(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute excDescriptionLen.
	 * @return the excDescriptionLen attribute reference
	 */
	public ElementaryRangeReference getExcDescriptionLenReference() {
		return excDescriptionLen.getReference();
	}

	/**
	 * Getter for excDescriptionLen attribute.
	 * @return excDescriptionLen attribute
	 */
	public int getExcDescriptionLen() {
		return excDescriptionLen.getValue();
	}

	/**
	 * Setter for excDescriptionLen attribute.
	 * @param excDescriptionLen the new value of excDescriptionLen
	 */
	public void setExcDescriptionLen(int excDescriptionLen) {
		this.excDescriptionLen.setValue(excDescriptionLen);
	}
	/**
	 * Gets the reference for attribute excDescriptionText.
	 * @return the excDescriptionText attribute reference
	 */
	public ElementaryRangeReference getExcDescriptionTextReference() {
		return excDescriptionText.getReference();
	}

	/**
	 * Getter for excDescriptionText attribute.
	 * @return excDescriptionText attribute
	 */
	public String getExcDescriptionText() {
		return excDescriptionText.getValue();
	}

	/**
	 * Setter for excDescriptionText attribute.
	 * @param excDescriptionText the new value of excDescriptionText
	 */
	public void setExcDescriptionText(String excDescriptionText) {
		this.excDescriptionText.setValue(excDescriptionText);
	}
}
