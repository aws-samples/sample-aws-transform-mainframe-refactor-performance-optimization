package com.company.app.trdpb006.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity OrdBuySellInd.
 * 
 * <p>About 'ordBuySellInd' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class OrdBuySellInd extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary ordBuySellInd = new Elementary(root,new AlphanumericType(1));
	
	/**
	 * Instantiate a new OrdBuySellInd with a default record.
	 * @param configuration the configuration
	 */
	public OrdBuySellInd(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new OrdBuySellInd bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public OrdBuySellInd(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute ordBuySellInd.
	 * @return the ordBuySellInd attribute reference
	 */
	public ElementaryRangeReference getOrdBuySellIndReference() {
		return ordBuySellInd.getReference();
	}

	/**
	 * Getter for ordBuySellInd attribute.
	 * @return ordBuySellInd attribute
	 */
	public String getOrdBuySellInd() {
		return ordBuySellInd.getValue();
	}

	/**
	 * Setter for ordBuySellInd attribute.
	 * @param ordBuySellInd the new value of ordBuySellInd
	 */
	public void setOrdBuySellInd(String ordBuySellInd) {
		this.ordBuySellInd.setValue(ordBuySellInd);
	}
}
