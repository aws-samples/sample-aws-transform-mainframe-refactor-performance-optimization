package com.company.app.trdpb006.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsBuyerSellerCustId.
 * 
 * <p>About 'wsBuyerSellerCustId' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsBuyerSellerCustId extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsBuyerSellerCustId = new Elementary(root,new AlphanumericType(12));
	
	/**
	 * Instantiate a new WsBuyerSellerCustId with a default record.
	 * @param configuration the configuration
	 */
	public WsBuyerSellerCustId(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsBuyerSellerCustId bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsBuyerSellerCustId(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsBuyerSellerCustId.
	 * @return the wsBuyerSellerCustId attribute reference
	 */
	public ElementaryRangeReference getWsBuyerSellerCustIdReference() {
		return wsBuyerSellerCustId.getReference();
	}

	/**
	 * Getter for wsBuyerSellerCustId attribute.
	 * @return wsBuyerSellerCustId attribute
	 */
	public String getWsBuyerSellerCustId() {
		return wsBuyerSellerCustId.getValue();
	}

	/**
	 * Setter for wsBuyerSellerCustId attribute.
	 * @param wsBuyerSellerCustId the new value of wsBuyerSellerCustId
	 */
	public void setWsBuyerSellerCustId(String wsBuyerSellerCustId) {
		this.wsBuyerSellerCustId.setValue(wsBuyerSellerCustId);
	}
}
