package com.company.app.trdpb006.business.model;

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
 * Data simplifier entity WsEndOfOrdersSw.
 * 
 * <p>About 'wsEndOfOrdersSw' field, <br>
 * </p>
 * 
 * <p>About 'endOfOrders' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsEndOfOrdersSw extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsEndOfOrdersSw = new Elementary(root,new AlphanumericType(1)," ");
	private final ConditionName endOfOrders = new ConditionName(wsEndOfOrdersSw,
		Arrays.asList("Y"));
	
	/**
	 * Instantiate a new WsEndOfOrdersSw with a default record.
	 * @param configuration the configuration
	 */
	public WsEndOfOrdersSw(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsEndOfOrdersSw bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsEndOfOrdersSw(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsEndOfOrdersSw.
	 * @return the wsEndOfOrdersSw attribute reference
	 */
	public ElementaryRangeReference getWsEndOfOrdersSwReference() {
		return wsEndOfOrdersSw.getReference();
	}

	/**
	 * Getter for wsEndOfOrdersSw attribute.
	 * @return wsEndOfOrdersSw attribute
	 */
	public String getWsEndOfOrdersSw() {
		return wsEndOfOrdersSw.getValue();
	}

	/**
	 * Setter for wsEndOfOrdersSw attribute.
	 * @param wsEndOfOrdersSw the new value of wsEndOfOrdersSw
	 */
	public void setWsEndOfOrdersSw(String wsEndOfOrdersSw) {
		this.wsEndOfOrdersSw.setValue(wsEndOfOrdersSw);
	}
	/**
	 * Gets the reference for attribute endOfOrders.
	 * @return the endOfOrders attribute reference
	 */
	public ConditionReference getEndOfOrdersReference() {
		return wsEndOfOrdersSw.getCondition(endOfOrders);	
	}

	/**
	 * Getter for endOfOrders attribute.
	 * @return endOfOrders attribute
	 */
	public boolean isEndOfOrders() {
		return getEndOfOrdersReference().getValue();	
	}

	/**
	 * Setter for endOfOrders attribute.
	 * @param endOfOrders the new value of endOfOrders
	 */
	public void setEndOfOrders(boolean endOfOrders) {
		getEndOfOrdersReference().setValue(endOfOrders);	
	}
}
