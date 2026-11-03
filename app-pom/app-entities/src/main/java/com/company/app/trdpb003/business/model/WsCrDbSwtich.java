package com.company.app.trdpb003.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ConditionReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.ConditionName;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import java.util.Arrays;
/**
 * Data simplifier entity WsCrDbSwtich.
 * 
 * <p>About 'wsCrDbSwtich' field, <br>
 * </p>
 * 
 * <p>About 'creditSeller' field, <br>
 * </p>
 * 
 * <p>About 'debitBuyer' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsCrDbSwtich extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsCrDbSwtich = new Elementary(root,new AlphanumericType(1));
	private final ConditionName creditSeller = new ConditionName(wsCrDbSwtich,
		Arrays.asList("D"));
	private final ConditionName debitBuyer = new ConditionName(wsCrDbSwtich,
		Arrays.asList("C"));
	
	/**
	 * Instantiate a new WsCrDbSwtich with a default record.
	 * @param configuration the configuration
	 */
	public WsCrDbSwtich(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsCrDbSwtich bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsCrDbSwtich(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsCrDbSwtich.
	 * @return the wsCrDbSwtich attribute reference
	 */
	public ElementaryRangeReference getWsCrDbSwtichReference() {
		return wsCrDbSwtich.getReference();
	}

	/**
	 * Getter for wsCrDbSwtich attribute.
	 * @return wsCrDbSwtich attribute
	 */
	public String getWsCrDbSwtich() {
		return wsCrDbSwtich.getValue();
	}

	/**
	 * Setter for wsCrDbSwtich attribute.
	 * @param wsCrDbSwtich the new value of wsCrDbSwtich
	 */
	public void setWsCrDbSwtich(String wsCrDbSwtich) {
		this.wsCrDbSwtich.setValue(wsCrDbSwtich);
	}
	/**
	 * Gets the reference for attribute creditSeller.
	 * @return the creditSeller attribute reference
	 */
	public ConditionReference getCreditSellerReference() {
		return wsCrDbSwtich.getCondition(creditSeller);	
	}

	/**
	 * Getter for creditSeller attribute.
	 * @return creditSeller attribute
	 */
	public boolean isCreditSeller() {
		return getCreditSellerReference().getValue();	
	}

	/**
	 * Setter for creditSeller attribute.
	 * @param creditSeller the new value of creditSeller
	 */
	public void setCreditSeller(boolean creditSeller) {
		getCreditSellerReference().setValue(creditSeller);	
	}
	/**
	 * Gets the reference for attribute debitBuyer.
	 * @return the debitBuyer attribute reference
	 */
	public ConditionReference getDebitBuyerReference() {
		return wsCrDbSwtich.getCondition(debitBuyer);	
	}

	/**
	 * Getter for debitBuyer attribute.
	 * @return debitBuyer attribute
	 */
	public boolean isDebitBuyer() {
		return getDebitBuyerReference().getValue();	
	}

	/**
	 * Setter for debitBuyer attribute.
	 * @param debitBuyer the new value of debitBuyer
	 */
	public void setDebitBuyer(boolean debitBuyer) {
		getDebitBuyerReference().setValue(debitBuyer);	
	}
}
