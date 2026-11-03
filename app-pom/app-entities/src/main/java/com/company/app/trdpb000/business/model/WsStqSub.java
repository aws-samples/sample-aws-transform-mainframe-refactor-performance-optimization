package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity WsStqSub.
<pre>
 * 
 * Legacy Documentation:<br>
 *  <br>
 *   RMDTN: work fields for the row-at-a-time settlement-queue<br>
 *          insert in 5009-INSERT-TO-STQ.<br>
</pre>
 * 
 * <p>About 'wsStqSub' field, <br>
 *  <br>
 *   RMDTN: work fields for the row-at-a-time settlement-queue<br>
 *          insert in 5009-INSERT-TO-STQ.<br></p>
 * 
 * @see RecordEntity
 */
public class WsStqSub extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * 
	 * RMDTN: work fields for the row-at-a-time settlement-queue
	 * insert in 5009-INSERT-TO-STQ.
	 */
	private final Elementary wsStqSub = new Elementary(root,new BinaryType(4, 0, "STD", false, false, true));
	
	/**
	 * Instantiate a new WsStqSub with a default record.
	 * @param configuration the configuration
	 */
	public WsStqSub(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsStqSub bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsStqSub(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsStqSub.
	 * @return the wsStqSub attribute reference
	 */
	public ElementaryRangeReference getWsStqSubReference() {
		return wsStqSub.getReference();
	}

	/**
	 * Getter for wsStqSub attribute.
	 * @return wsStqSub attribute
	 */
	public int getWsStqSub() {
		return wsStqSub.getValue();
	}

	/**
	 * Setter for wsStqSub attribute.
	 * @param wsStqSub the new value of wsStqSub
	 */
	public void setWsStqSub(int wsStqSub) {
		this.wsStqSub.setValue(wsStqSub);
	}
}
