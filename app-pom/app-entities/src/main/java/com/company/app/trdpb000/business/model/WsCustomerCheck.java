package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsCustomerCheck.
 * 
 * <p>About 'wsCustomerCheck' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsCustomerCheck extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * 
	 */
	private final Elementary wsCustomerCheck = new Elementary(root,new AlphanumericType(8),"MSTPB001");
	
	/**
	 * Instantiate a new WsCustomerCheck with a default record.
	 * @param configuration the configuration
	 */
	public WsCustomerCheck(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsCustomerCheck bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsCustomerCheck(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsCustomerCheck.
	 * @return the wsCustomerCheck attribute reference
	 */
	public ElementaryRangeReference getWsCustomerCheckReference() {
		return wsCustomerCheck.getReference();
	}

	/**
	 * Getter for wsCustomerCheck attribute.
	 * @return wsCustomerCheck attribute
	 */
	public String getWsCustomerCheck() {
		return wsCustomerCheck.getValue();
	}

	/**
	 * Setter for wsCustomerCheck attribute.
	 * @param wsCustomerCheck the new value of wsCustomerCheck
	 */
	public void setWsCustomerCheck(String wsCustomerCheck) {
		this.wsCustomerCheck.setValue(wsCustomerCheck);
	}
}
