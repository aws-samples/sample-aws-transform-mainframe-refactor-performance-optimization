package com.company.app.trdpb004.business.model;

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
 * Data simplifier entity WsNoMoreRunlogRecsSw.
 * 
 * <p>About 'wsNoMoreRunlogRecsSw' field, <br>
 * </p>
 * 
 * <p>About 'noMoreRunlogRecords' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsNoMoreRunlogRecsSw extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsNoMoreRunlogRecsSw = new Elementary(root,new AlphanumericType(1)," ");
	private final ConditionName noMoreRunlogRecords = new ConditionName(wsNoMoreRunlogRecsSw,
		Arrays.asList("Y"));
	
	/**
	 * Instantiate a new WsNoMoreRunlogRecsSw with a default record.
	 * @param configuration the configuration
	 */
	public WsNoMoreRunlogRecsSw(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsNoMoreRunlogRecsSw bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsNoMoreRunlogRecsSw(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsNoMoreRunlogRecsSw.
	 * @return the wsNoMoreRunlogRecsSw attribute reference
	 */
	public ElementaryRangeReference getWsNoMoreRunlogRecsSwReference() {
		return wsNoMoreRunlogRecsSw.getReference();
	}

	/**
	 * Getter for wsNoMoreRunlogRecsSw attribute.
	 * @return wsNoMoreRunlogRecsSw attribute
	 */
	public String getWsNoMoreRunlogRecsSw() {
		return wsNoMoreRunlogRecsSw.getValue();
	}

	/**
	 * Setter for wsNoMoreRunlogRecsSw attribute.
	 * @param wsNoMoreRunlogRecsSw the new value of wsNoMoreRunlogRecsSw
	 */
	public void setWsNoMoreRunlogRecsSw(String wsNoMoreRunlogRecsSw) {
		this.wsNoMoreRunlogRecsSw.setValue(wsNoMoreRunlogRecsSw);
	}
	/**
	 * Gets the reference for attribute noMoreRunlogRecords.
	 * @return the noMoreRunlogRecords attribute reference
	 */
	public ConditionReference getNoMoreRunlogRecordsReference() {
		return wsNoMoreRunlogRecsSw.getCondition(noMoreRunlogRecords);	
	}

	/**
	 * Getter for noMoreRunlogRecords attribute.
	 * @return noMoreRunlogRecords attribute
	 */
	public boolean isNoMoreRunlogRecords() {
		return getNoMoreRunlogRecordsReference().getValue();	
	}

	/**
	 * Setter for noMoreRunlogRecords attribute.
	 * @param noMoreRunlogRecords the new value of noMoreRunlogRecords
	 */
	public void setNoMoreRunlogRecords(boolean noMoreRunlogRecords) {
		getNoMoreRunlogRecordsReference().setValue(noMoreRunlogRecords);	
	}
}
