package com.company.app.trdpb006.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.PackedType;
import java.math.BigDecimal;
/**
 * Data simplifier entity OrdAmount.
 * 
 * <p>About 'ordAmount' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class OrdAmount extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary ordAmount = new Elementary(root,new PackedType(7, 2, false, false, true));
	
	/**
	 * Instantiate a new OrdAmount with a default record.
	 * @param configuration the configuration
	 */
	public OrdAmount(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new OrdAmount bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public OrdAmount(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute ordAmount.
	 * @return the ordAmount attribute reference
	 */
	public ElementaryRangeReference getOrdAmountReference() {
		return ordAmount.getReference();
	}

	/**
	 * Getter for ordAmount attribute.
	 * @return ordAmount attribute
	 */
	public BigDecimal getOrdAmount() {
		return ordAmount.getValue();
	}

	/**
	 * Setter for ordAmount attribute.
	 * @param ordAmount the new value of ordAmount
	 */
	public void setOrdAmount(BigDecimal ordAmount) {
		this.ordAmount.setValue(ordAmount);
	}
}
