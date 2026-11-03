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
 * Data simplifier entity WsNoMoreSummaryRecsSw.
 * 
 * <p>About 'wsNoMoreSummaryRecsSw' field, <br>
 * </p>
 * 
 * <p>About 'noMoreSummaryRecords' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsNoMoreSummaryRecsSw extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsNoMoreSummaryRecsSw = new Elementary(root,new AlphanumericType(1)," ");
	private final ConditionName noMoreSummaryRecords = new ConditionName(wsNoMoreSummaryRecsSw,
		Arrays.asList("Y"));
	
	/**
	 * Instantiate a new WsNoMoreSummaryRecsSw with a default record.
	 * @param configuration the configuration
	 */
	public WsNoMoreSummaryRecsSw(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsNoMoreSummaryRecsSw bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsNoMoreSummaryRecsSw(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsNoMoreSummaryRecsSw.
	 * @return the wsNoMoreSummaryRecsSw attribute reference
	 */
	public ElementaryRangeReference getWsNoMoreSummaryRecsSwReference() {
		return wsNoMoreSummaryRecsSw.getReference();
	}

	/**
	 * Getter for wsNoMoreSummaryRecsSw attribute.
	 * @return wsNoMoreSummaryRecsSw attribute
	 */
	public String getWsNoMoreSummaryRecsSw() {
		return wsNoMoreSummaryRecsSw.getValue();
	}

	/**
	 * Setter for wsNoMoreSummaryRecsSw attribute.
	 * @param wsNoMoreSummaryRecsSw the new value of wsNoMoreSummaryRecsSw
	 */
	public void setWsNoMoreSummaryRecsSw(String wsNoMoreSummaryRecsSw) {
		this.wsNoMoreSummaryRecsSw.setValue(wsNoMoreSummaryRecsSw);
	}
	/**
	 * Gets the reference for attribute noMoreSummaryRecords.
	 * @return the noMoreSummaryRecords attribute reference
	 */
	public ConditionReference getNoMoreSummaryRecordsReference() {
		return wsNoMoreSummaryRecsSw.getCondition(noMoreSummaryRecords);	
	}

	/**
	 * Getter for noMoreSummaryRecords attribute.
	 * @return noMoreSummaryRecords attribute
	 */
	public boolean isNoMoreSummaryRecords() {
		return getNoMoreSummaryRecordsReference().getValue();	
	}

	/**
	 * Setter for noMoreSummaryRecords attribute.
	 * @param noMoreSummaryRecords the new value of noMoreSummaryRecords
	 */
	public void setNoMoreSummaryRecords(boolean noMoreSummaryRecords) {
		getNoMoreSummaryRecordsReference().setValue(noMoreSummaryRecords);	
	}
}
