package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity WsOrderCount.
 * 
 * <p>About 'wsOrderCount' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsOrderCount extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * 
	 */
	private final Elementary wsOrderCount = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	
	/**
	 * Instantiate a new WsOrderCount with a default record.
	 * @param configuration the configuration
	 */
	public WsOrderCount(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsOrderCount bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsOrderCount(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsOrderCount.
	 * @return the wsOrderCount attribute reference
	 */
	public ElementaryRangeReference getWsOrderCountReference() {
		return wsOrderCount.getReference();
	}

	/**
	 * Getter for wsOrderCount attribute.
	 * @return wsOrderCount attribute
	 */
	public int getWsOrderCount() {
		return wsOrderCount.getValue();
	}

	/**
	 * Setter for wsOrderCount attribute.
	 * @param wsOrderCount the new value of wsOrderCount
	 */
	public void setWsOrderCount(int wsOrderCount) {
		this.wsOrderCount.setValue(wsOrderCount);
	}
}
