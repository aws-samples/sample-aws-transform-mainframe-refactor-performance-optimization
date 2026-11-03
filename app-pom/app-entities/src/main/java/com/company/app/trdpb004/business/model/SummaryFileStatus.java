package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.ZonedType;
/**
 * Data simplifier entity SummaryFileStatus.
 * 
 * <p>About 'summaryFileStatus' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SummaryFileStatus extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary summaryFileStatus = new Elementary(root,new ZonedType(2, 0, false));
	
	/**
	 * Instantiate a new SummaryFileStatus with a default record.
	 * @param configuration the configuration
	 */
	public SummaryFileStatus(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SummaryFileStatus bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SummaryFileStatus(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute summaryFileStatus.
	 * @return the summaryFileStatus attribute reference
	 */
	public ElementaryRangeReference getSummaryFileStatusReference() {
		return summaryFileStatus.getReference();
	}

	/**
	 * Getter for summaryFileStatus attribute.
	 * @return summaryFileStatus attribute
	 */
	public int getSummaryFileStatus() {
		return summaryFileStatus.getValue();
	}

	/**
	 * Setter for summaryFileStatus attribute.
	 * @param summaryFileStatus the new value of summaryFileStatus
	 */
	public void setSummaryFileStatus(int summaryFileStatus) {
		this.summaryFileStatus.setValue(summaryFileStatus);
	}
}
