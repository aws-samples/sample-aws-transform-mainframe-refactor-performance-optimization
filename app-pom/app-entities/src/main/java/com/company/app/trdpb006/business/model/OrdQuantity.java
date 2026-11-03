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
 * Data simplifier entity OrdQuantity.
 * 
 * <p>About 'ordQuantity' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class OrdQuantity extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary ordQuantity = new Elementary(root,new PackedType(7, 2, false, false, true));
	
	/**
	 * Instantiate a new OrdQuantity with a default record.
	 * @param configuration the configuration
	 */
	public OrdQuantity(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new OrdQuantity bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public OrdQuantity(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute ordQuantity.
	 * @return the ordQuantity attribute reference
	 */
	public ElementaryRangeReference getOrdQuantityReference() {
		return ordQuantity.getReference();
	}

	/**
	 * Getter for ordQuantity attribute.
	 * @return ordQuantity attribute
	 */
	public BigDecimal getOrdQuantity() {
		return ordQuantity.getValue();
	}

	/**
	 * Setter for ordQuantity attribute.
	 * @param ordQuantity the new value of ordQuantity
	 */
	public void setOrdQuantity(BigDecimal ordQuantity) {
		this.ordQuantity.setValue(ordQuantity);
	}
}
