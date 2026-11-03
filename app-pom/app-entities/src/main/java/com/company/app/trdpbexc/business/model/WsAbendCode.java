package com.company.app.trdpbexc.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity WsAbendCode.
 * 
 * <p>About 'wsAbendCode' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsAbendCode extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsAbendCode = new Elementary(root,new BinaryType(4, 0, "STD", false));
	
	/**
	 * Instantiate a new WsAbendCode with a default record.
	 * @param configuration the configuration
	 */
	public WsAbendCode(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsAbendCode bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsAbendCode(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsAbendCode.
	 * @return the wsAbendCode attribute reference
	 */
	public ElementaryRangeReference getWsAbendCodeReference() {
		return wsAbendCode.getReference();
	}

	/**
	 * Getter for wsAbendCode attribute.
	 * @return wsAbendCode attribute
	 */
	public int getWsAbendCode() {
		return wsAbendCode.getValue();
	}

	/**
	 * Setter for wsAbendCode attribute.
	 * @param wsAbendCode the new value of wsAbendCode
	 */
	public void setWsAbendCode(int wsAbendCode) {
		this.wsAbendCode.setValue(wsAbendCode);
	}
}
