package com.company.app.trdpb001.business.model;

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
 * Data simplifier entity WsOrderAccpRunning.
 * 
 * <p>About 'wsOrderAccpRunning' field, <br>
 * </p>
 * 
 * <p>About 'orderAccpRunning' field, <br>
 * </p>
 * 
 * <p>About 'orderAccpNotRunning' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsOrderAccpRunning extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * 
	 */
	private final Elementary wsOrderAccpRunning = new Elementary(root,new AlphanumericType(1)," ");
	private final ConditionName orderAccpRunning = new ConditionName(wsOrderAccpRunning,
		Arrays.asList("Y"));
	private final ConditionName orderAccpNotRunning = new ConditionName(wsOrderAccpRunning,
		Arrays.asList("N"));
	
	/**
	 * Instantiate a new WsOrderAccpRunning with a default record.
	 * @param configuration the configuration
	 */
	public WsOrderAccpRunning(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsOrderAccpRunning bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsOrderAccpRunning(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsOrderAccpRunning.
	 * @return the wsOrderAccpRunning attribute reference
	 */
	public ElementaryRangeReference getWsOrderAccpRunningReference() {
		return wsOrderAccpRunning.getReference();
	}

	/**
	 * Getter for wsOrderAccpRunning attribute.
	 * @return wsOrderAccpRunning attribute
	 */
	public String getWsOrderAccpRunning() {
		return wsOrderAccpRunning.getValue();
	}

	/**
	 * Setter for wsOrderAccpRunning attribute.
	 * @param wsOrderAccpRunning the new value of wsOrderAccpRunning
	 */
	public void setWsOrderAccpRunning(String wsOrderAccpRunning) {
		this.wsOrderAccpRunning.setValue(wsOrderAccpRunning);
	}
	/**
	 * Gets the reference for attribute orderAccpRunning.
	 * @return the orderAccpRunning attribute reference
	 */
	public ConditionReference getOrderAccpRunningReference() {
		return wsOrderAccpRunning.getCondition(orderAccpRunning);	
	}

	/**
	 * Getter for orderAccpRunning attribute.
	 * @return orderAccpRunning attribute
	 */
	public boolean isOrderAccpRunning() {
		return getOrderAccpRunningReference().getValue();	
	}

	/**
	 * Setter for orderAccpRunning attribute.
	 * @param orderAccpRunning the new value of orderAccpRunning
	 */
	public void setOrderAccpRunning(boolean orderAccpRunning) {
		getOrderAccpRunningReference().setValue(orderAccpRunning);	
	}
	/**
	 * Gets the reference for attribute orderAccpNotRunning.
	 * @return the orderAccpNotRunning attribute reference
	 */
	public ConditionReference getOrderAccpNotRunningReference() {
		return wsOrderAccpRunning.getCondition(orderAccpNotRunning);	
	}

	/**
	 * Getter for orderAccpNotRunning attribute.
	 * @return orderAccpNotRunning attribute
	 */
	public boolean isOrderAccpNotRunning() {
		return getOrderAccpNotRunningReference().getValue();	
	}

	/**
	 * Setter for orderAccpNotRunning attribute.
	 * @param orderAccpNotRunning the new value of orderAccpNotRunning
	 */
	public void setOrderAccpNotRunning(boolean orderAccpNotRunning) {
		getOrderAccpNotRunningReference().setValue(orderAccpNotRunning);	
	}
}
