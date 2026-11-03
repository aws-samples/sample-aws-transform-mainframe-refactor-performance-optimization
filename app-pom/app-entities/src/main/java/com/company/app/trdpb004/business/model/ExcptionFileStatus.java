package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.ZonedType;
/**
 * Data simplifier entity ExcptionFileStatus.
 * 
 * <p>About 'excptionFileStatus' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class ExcptionFileStatus extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary excptionFileStatus = new Elementary(root,new ZonedType(2, 0, false));
	
	/**
	 * Instantiate a new ExcptionFileStatus with a default record.
	 * @param configuration the configuration
	 */
	public ExcptionFileStatus(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new ExcptionFileStatus bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public ExcptionFileStatus(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute excptionFileStatus.
	 * @return the excptionFileStatus attribute reference
	 */
	public ElementaryRangeReference getExcptionFileStatusReference() {
		return excptionFileStatus.getReference();
	}

	/**
	 * Getter for excptionFileStatus attribute.
	 * @return excptionFileStatus attribute
	 */
	public int getExcptionFileStatus() {
		return excptionFileStatus.getValue();
	}

	/**
	 * Setter for excptionFileStatus attribute.
	 * @param excptionFileStatus the new value of excptionFileStatus
	 */
	public void setExcptionFileStatus(int excptionFileStatus) {
		this.excptionFileStatus.setValue(excptionFileStatus);
	}
}
