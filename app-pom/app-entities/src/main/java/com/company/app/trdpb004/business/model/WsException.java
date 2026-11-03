package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsException.
 * 
 * <p>About 'wsException' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsException extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * 
	 */
	private final Elementary wsException = new Elementary(root,new AlphanumericType(200));
	
	/**
	 * Instantiate a new WsException with a default record.
	 * @param configuration the configuration
	 */
	public WsException(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsException bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsException(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsException.
	 * @return the wsException attribute reference
	 */
	public ElementaryRangeReference getWsExceptionReference() {
		return wsException.getReference();
	}

	/**
	 * Getter for wsException attribute.
	 * @return wsException attribute
	 */
	public String getWsException() {
		return wsException.getValue();
	}

	/**
	 * Setter for wsException attribute.
	 * @param wsException the new value of wsException
	 */
	public void setWsException(String wsException) {
		this.wsException.setValue(wsException);
	}
}
