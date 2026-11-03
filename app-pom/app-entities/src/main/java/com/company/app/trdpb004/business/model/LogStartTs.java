package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity LogStartTs.
 * 
 * <p>About 'logStartTs' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class LogStartTs extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary logStartTs = new Elementary(root,new AlphanumericType(26));
	
	/**
	 * Instantiate a new LogStartTs with a default record.
	 * @param configuration the configuration
	 */
	public LogStartTs(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new LogStartTs bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public LogStartTs(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute logStartTs.
	 * @return the logStartTs attribute reference
	 */
	public ElementaryRangeReference getLogStartTsReference() {
		return logStartTs.getReference();
	}

	/**
	 * Getter for logStartTs attribute.
	 * @return logStartTs attribute
	 */
	public String getLogStartTs() {
		return logStartTs.getValue();
	}

	/**
	 * Setter for logStartTs attribute.
	 * @param logStartTs the new value of logStartTs
	 */
	public void setLogStartTs(String logStartTs) {
		this.logStartTs.setValue(logStartTs);
	}
}
