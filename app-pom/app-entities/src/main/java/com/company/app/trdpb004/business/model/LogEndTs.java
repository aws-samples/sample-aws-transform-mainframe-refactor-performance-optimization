package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity LogEndTs.
 * 
 * <p>About 'logEndTs' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class LogEndTs extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary logEndTs = new Elementary(root,new AlphanumericType(26));
	
	/**
	 * Instantiate a new LogEndTs with a default record.
	 * @param configuration the configuration
	 */
	public LogEndTs(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new LogEndTs bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public LogEndTs(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute logEndTs.
	 * @return the logEndTs attribute reference
	 */
	public ElementaryRangeReference getLogEndTsReference() {
		return logEndTs.getReference();
	}

	/**
	 * Getter for logEndTs attribute.
	 * @return logEndTs attribute
	 */
	public String getLogEndTs() {
		return logEndTs.getValue();
	}

	/**
	 * Setter for logEndTs attribute.
	 * @param logEndTs the new value of logEndTs
	 */
	public void setLogEndTs(String logEndTs) {
		this.logEndTs.setValue(logEndTs);
	}
}
