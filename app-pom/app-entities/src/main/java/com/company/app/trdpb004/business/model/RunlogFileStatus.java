package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.ZonedType;
/**
 * Data simplifier entity RunlogFileStatus.
 * 
 * <p>About 'runlogFileStatus' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class RunlogFileStatus extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary runlogFileStatus = new Elementary(root,new ZonedType(2, 0, false));
	
	/**
	 * Instantiate a new RunlogFileStatus with a default record.
	 * @param configuration the configuration
	 */
	public RunlogFileStatus(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new RunlogFileStatus bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public RunlogFileStatus(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute runlogFileStatus.
	 * @return the runlogFileStatus attribute reference
	 */
	public ElementaryRangeReference getRunlogFileStatusReference() {
		return runlogFileStatus.getReference();
	}

	/**
	 * Getter for runlogFileStatus attribute.
	 * @return runlogFileStatus attribute
	 */
	public int getRunlogFileStatus() {
		return runlogFileStatus.getValue();
	}

	/**
	 * Setter for runlogFileStatus attribute.
	 * @param runlogFileStatus the new value of runlogFileStatus
	 */
	public void setRunlogFileStatus(int runlogFileStatus) {
		this.runlogFileStatus.setValue(runlogFileStatus);
	}
}
