package com.company.app.trdpb000.business.model;

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
 * Data simplifier entity WsOrdersSwitch.
 * 
 * <p>About 'wsOrdersSwitch' field, <br>
 * </p>
 * 
 * <p>About 'noMoreOrders' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsOrdersSwitch extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * 
	 */
	private final Elementary wsOrdersSwitch = new Elementary(root,new AlphanumericType(1)," ");
	private final ConditionName noMoreOrders = new ConditionName(wsOrdersSwitch,
		Arrays.asList("Y"));
	
	/**
	 * Instantiate a new WsOrdersSwitch with a default record.
	 * @param configuration the configuration
	 */
	public WsOrdersSwitch(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsOrdersSwitch bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsOrdersSwitch(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsOrdersSwitch.
	 * @return the wsOrdersSwitch attribute reference
	 */
	public ElementaryRangeReference getWsOrdersSwitchReference() {
		return wsOrdersSwitch.getReference();
	}

	/**
	 * Getter for wsOrdersSwitch attribute.
	 * @return wsOrdersSwitch attribute
	 */
	public String getWsOrdersSwitch() {
		return wsOrdersSwitch.getValue();
	}

	/**
	 * Setter for wsOrdersSwitch attribute.
	 * @param wsOrdersSwitch the new value of wsOrdersSwitch
	 */
	public void setWsOrdersSwitch(String wsOrdersSwitch) {
		this.wsOrdersSwitch.setValue(wsOrdersSwitch);
	}
	/**
	 * Gets the reference for attribute noMoreOrders.
	 * @return the noMoreOrders attribute reference
	 */
	public ConditionReference getNoMoreOrdersReference() {
		return wsOrdersSwitch.getCondition(noMoreOrders);	
	}

	/**
	 * Getter for noMoreOrders attribute.
	 * @return noMoreOrders attribute
	 */
	public boolean isNoMoreOrders() {
		return getNoMoreOrdersReference().getValue();	
	}

	/**
	 * Setter for noMoreOrders attribute.
	 * @param noMoreOrders the new value of noMoreOrders
	 */
	public void setNoMoreOrders(boolean noMoreOrders) {
		getNoMoreOrdersReference().setValue(noMoreOrders);	
	}
}
