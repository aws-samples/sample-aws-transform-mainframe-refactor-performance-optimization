package com.company.app.trdpb002.business.model;

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
 * <p>About 'debitSeller' field, <br>
 * </p>
 * 
 * <p>About 'creditBuyer' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsCrDbSwtich extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsCrDbSwtich = new Elementary(root,new AlphanumericType(1));
	private final ConditionName debitSeller = new ConditionName(wsCrDbSwtich,
		Arrays.asList("D"));
	private final ConditionName creditBuyer = new ConditionName(wsCrDbSwtich,
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
	 * Gets the reference for attribute debitSeller.
	 * @return the debitSeller attribute reference
	 */
	public ConditionReference getDebitSellerReference() {
		return wsCrDbSwtich.getCondition(debitSeller);	
	}

	/**
	 * Getter for debitSeller attribute.
	 * @return debitSeller attribute
	 */
	public boolean isDebitSeller() {
		return getDebitSellerReference().getValue();	
	}

	/**
	 * Setter for debitSeller attribute.
	 * @param debitSeller the new value of debitSeller
	 */
	public void setDebitSeller(boolean debitSeller) {
		getDebitSellerReference().setValue(debitSeller);	
	}
	/**
	 * Gets the reference for attribute creditBuyer.
	 * @return the creditBuyer attribute reference
	 */
	public ConditionReference getCreditBuyerReference() {
		return wsCrDbSwtich.getCondition(creditBuyer);	
	}

	/**
	 * Getter for creditBuyer attribute.
	 * @return creditBuyer attribute
	 */
	public boolean isCreditBuyer() {
		return getCreditBuyerReference().getValue();	
	}

	/**
	 * Setter for creditBuyer attribute.
	 * @param creditBuyer the new value of creditBuyer
	 */
	public void setCreditBuyer(boolean creditBuyer) {
		getCreditBuyerReference().setValue(creditBuyer);	
	}
}
