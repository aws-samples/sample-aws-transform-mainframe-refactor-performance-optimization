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
 * Data simplifier entity WsNoMoreExcpRecsSw.
 * 
 * <p>About 'wsNoMoreExcpRecsSw' field, <br>
 * </p>
 * 
 * <p>About 'noMoreExcpRecords' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsNoMoreExcpRecsSw extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * 
	 */
	private final Elementary wsNoMoreExcpRecsSw = new Elementary(root,new AlphanumericType(1)," ");
	private final ConditionName noMoreExcpRecords = new ConditionName(wsNoMoreExcpRecsSw,
		Arrays.asList("Y"));
	
	/**
	 * Instantiate a new WsNoMoreExcpRecsSw with a default record.
	 * @param configuration the configuration
	 */
	public WsNoMoreExcpRecsSw(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsNoMoreExcpRecsSw bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsNoMoreExcpRecsSw(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsNoMoreExcpRecsSw.
	 * @return the wsNoMoreExcpRecsSw attribute reference
	 */
	public ElementaryRangeReference getWsNoMoreExcpRecsSwReference() {
		return wsNoMoreExcpRecsSw.getReference();
	}

	/**
	 * Getter for wsNoMoreExcpRecsSw attribute.
	 * @return wsNoMoreExcpRecsSw attribute
	 */
	public String getWsNoMoreExcpRecsSw() {
		return wsNoMoreExcpRecsSw.getValue();
	}

	/**
	 * Setter for wsNoMoreExcpRecsSw attribute.
	 * @param wsNoMoreExcpRecsSw the new value of wsNoMoreExcpRecsSw
	 */
	public void setWsNoMoreExcpRecsSw(String wsNoMoreExcpRecsSw) {
		this.wsNoMoreExcpRecsSw.setValue(wsNoMoreExcpRecsSw);
	}
	/**
	 * Gets the reference for attribute noMoreExcpRecords.
	 * @return the noMoreExcpRecords attribute reference
	 */
	public ConditionReference getNoMoreExcpRecordsReference() {
		return wsNoMoreExcpRecsSw.getCondition(noMoreExcpRecords);	
	}

	/**
	 * Getter for noMoreExcpRecords attribute.
	 * @return noMoreExcpRecords attribute
	 */
	public boolean isNoMoreExcpRecords() {
		return getNoMoreExcpRecordsReference().getValue();	
	}

	/**
	 * Setter for noMoreExcpRecords attribute.
	 * @param noMoreExcpRecords the new value of noMoreExcpRecords
	 */
	public void setNoMoreExcpRecords(boolean noMoreExcpRecords) {
		getNoMoreExcpRecordsReference().setValue(noMoreExcpRecords);	
	}
}
