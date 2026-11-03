package com.company.app.trdpb001.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity WsTradeCount.
 * 
 * <p>About 'wsTradeCount' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsTradeCount extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsTradeCount = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	
	/**
	 * Instantiate a new WsTradeCount with a default record.
	 * @param configuration the configuration
	 */
	public WsTradeCount(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsTradeCount bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsTradeCount(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsTradeCount.
	 * @return the wsTradeCount attribute reference
	 */
	public ElementaryRangeReference getWsTradeCountReference() {
		return wsTradeCount.getReference();
	}

	/**
	 * Getter for wsTradeCount attribute.
	 * @return wsTradeCount attribute
	 */
	public int getWsTradeCount() {
		return wsTradeCount.getValue();
	}

	/**
	 * Setter for wsTradeCount attribute.
	 * @param wsTradeCount the new value of wsTradeCount
	 */
	public void setWsTradeCount(int wsTradeCount) {
		this.wsTradeCount.setValue(wsTradeCount);
	}
}
