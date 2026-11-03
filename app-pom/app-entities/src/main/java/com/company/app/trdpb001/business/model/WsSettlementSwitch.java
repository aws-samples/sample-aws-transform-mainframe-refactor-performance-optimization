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
 * Data simplifier entity WsSettlementSwitch.
 * 
 * <p>About 'wsSettlementSwitch' field, <br>
 * </p>
 * 
 * <p>About 'continueSettlement' field, <br>
 * </p>
 * 
 * <p>About 'stopSettlement' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsSettlementSwitch extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsSettlementSwitch = new Elementary(root,new AlphanumericType(1)," ");
	private final ConditionName continueSettlement = new ConditionName(wsSettlementSwitch,
		Arrays.asList("C"));
	private final ConditionName stopSettlement = new ConditionName(wsSettlementSwitch,
		Arrays.asList("S"));
	
	/**
	 * Instantiate a new WsSettlementSwitch with a default record.
	 * @param configuration the configuration
	 */
	public WsSettlementSwitch(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsSettlementSwitch bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsSettlementSwitch(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsSettlementSwitch.
	 * @return the wsSettlementSwitch attribute reference
	 */
	public ElementaryRangeReference getWsSettlementSwitchReference() {
		return wsSettlementSwitch.getReference();
	}

	/**
	 * Getter for wsSettlementSwitch attribute.
	 * @return wsSettlementSwitch attribute
	 */
	public String getWsSettlementSwitch() {
		return wsSettlementSwitch.getValue();
	}

	/**
	 * Setter for wsSettlementSwitch attribute.
	 * @param wsSettlementSwitch the new value of wsSettlementSwitch
	 */
	public void setWsSettlementSwitch(String wsSettlementSwitch) {
		this.wsSettlementSwitch.setValue(wsSettlementSwitch);
	}
	/**
	 * Gets the reference for attribute continueSettlement.
	 * @return the continueSettlement attribute reference
	 */
	public ConditionReference getContinueSettlementReference() {
		return wsSettlementSwitch.getCondition(continueSettlement);	
	}

	/**
	 * Getter for continueSettlement attribute.
	 * @return continueSettlement attribute
	 */
	public boolean isContinueSettlement() {
		return getContinueSettlementReference().getValue();	
	}

	/**
	 * Setter for continueSettlement attribute.
	 * @param continueSettlement the new value of continueSettlement
	 */
	public void setContinueSettlement(boolean continueSettlement) {
		getContinueSettlementReference().setValue(continueSettlement);	
	}
	/**
	 * Gets the reference for attribute stopSettlement.
	 * @return the stopSettlement attribute reference
	 */
	public ConditionReference getStopSettlementReference() {
		return wsSettlementSwitch.getCondition(stopSettlement);	
	}

	/**
	 * Getter for stopSettlement attribute.
	 * @return stopSettlement attribute
	 */
	public boolean isStopSettlement() {
		return getStopSettlementReference().getValue();	
	}

	/**
	 * Setter for stopSettlement attribute.
	 * @param stopSettlement the new value of stopSettlement
	 */
	public void setStopSettlement(boolean stopSettlement) {
		getStopSettlementReference().setValue(stopSettlement);	
	}
}
