package com.company.app.trdpb001.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity StqTradeData.
 * 
 * <p>About 'stqTradeData' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class StqTradeData extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary stqTradeData = new Elementary(root,new AlphanumericType(88));
	
	/**
	 * Instantiate a new StqTradeData with a default record.
	 * @param configuration the configuration
	 */
	public StqTradeData(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new StqTradeData bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public StqTradeData(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute stqTradeData.
	 * @return the stqTradeData attribute reference
	 */
	public ElementaryRangeReference getStqTradeDataReference() {
		return stqTradeData.getReference();
	}

	/**
	 * Getter for stqTradeData attribute.
	 * @return stqTradeData attribute
	 */
	public String getStqTradeData() {
		return stqTradeData.getValue();
	}

	/**
	 * Setter for stqTradeData attribute.
	 * @param stqTradeData the new value of stqTradeData
	 */
	public void setStqTradeData(String stqTradeData) {
		this.stqTradeData.setValue(stqTradeData);
	}
}
