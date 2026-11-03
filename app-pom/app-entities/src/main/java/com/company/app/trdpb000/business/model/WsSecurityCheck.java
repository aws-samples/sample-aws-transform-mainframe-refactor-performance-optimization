package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsSecurityCheck.
 * 
 * <p>About 'wsSecurityCheck' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsSecurityCheck extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsSecurityCheck = new Elementary(root,new AlphanumericType(8),"MSTPB002");
	
	/**
	 * Instantiate a new WsSecurityCheck with a default record.
	 * @param configuration the configuration
	 */
	public WsSecurityCheck(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsSecurityCheck bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsSecurityCheck(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsSecurityCheck.
	 * @return the wsSecurityCheck attribute reference
	 */
	public ElementaryRangeReference getWsSecurityCheckReference() {
		return wsSecurityCheck.getReference();
	}

	/**
	 * Getter for wsSecurityCheck attribute.
	 * @return wsSecurityCheck attribute
	 */
	public String getWsSecurityCheck() {
		return wsSecurityCheck.getValue();
	}

	/**
	 * Setter for wsSecurityCheck attribute.
	 * @param wsSecurityCheck the new value of wsSecurityCheck
	 */
	public void setWsSecurityCheck(String wsSecurityCheck) {
		this.wsSecurityCheck.setValue(wsSecurityCheck);
	}
}
