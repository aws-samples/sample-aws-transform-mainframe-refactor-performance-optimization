package com.company.app.trdpb001.business.model;

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
 * Data simplifier entity WsTriggerSwitch.
 * 
 * <p>About 'wsTriggerSwitch' field, <br>
 * </p>
 * 
 * <p>About 'triggerRead' field, <br>
 * </p>
 * 
 * <p>About 'noTrigger' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsTriggerSwitch extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsTriggerSwitch = new Elementary(root,new AlphanumericType(1)," ");
	private final ConditionName triggerRead = new ConditionName(wsTriggerSwitch,
		Arrays.asList("Y"));
	private final ConditionName noTrigger = new ConditionName(wsTriggerSwitch,
		Arrays.asList("N"));
	
	/**
	 * Instantiate a new WsTriggerSwitch with a default record.
	 * @param configuration the configuration
	 */
	public WsTriggerSwitch(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsTriggerSwitch bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsTriggerSwitch(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsTriggerSwitch.
	 * @return the wsTriggerSwitch attribute reference
	 */
	public ElementaryRangeReference getWsTriggerSwitchReference() {
		return wsTriggerSwitch.getReference();
	}

	/**
	 * Getter for wsTriggerSwitch attribute.
	 * @return wsTriggerSwitch attribute
	 */
	public String getWsTriggerSwitch() {
		return wsTriggerSwitch.getValue();
	}

	/**
	 * Setter for wsTriggerSwitch attribute.
	 * @param wsTriggerSwitch the new value of wsTriggerSwitch
	 */
	public void setWsTriggerSwitch(String wsTriggerSwitch) {
		this.wsTriggerSwitch.setValue(wsTriggerSwitch);
	}
	/**
	 * Gets the reference for attribute triggerRead.
	 * @return the triggerRead attribute reference
	 */
	public ConditionReference getTriggerReadReference() {
		return wsTriggerSwitch.getCondition(triggerRead);	
	}

	/**
	 * Getter for triggerRead attribute.
	 * @return triggerRead attribute
	 */
	public boolean isTriggerRead() {
		return getTriggerReadReference().getValue();	
	}

	/**
	 * Setter for triggerRead attribute.
	 * @param triggerRead the new value of triggerRead
	 */
	public void setTriggerRead(boolean triggerRead) {
		getTriggerReadReference().setValue(triggerRead);	
	}
	/**
	 * Gets the reference for attribute noTrigger.
	 * @return the noTrigger attribute reference
	 */
	public ConditionReference getNoTriggerReference() {
		return wsTriggerSwitch.getCondition(noTrigger);	
	}

	/**
	 * Getter for noTrigger attribute.
	 * @return noTrigger attribute
	 */
	public boolean isNoTrigger() {
		return getNoTriggerReference().getValue();	
	}

	/**
	 * Setter for noTrigger attribute.
	 * @param noTrigger the new value of noTrigger
	 */
	public void setNoTrigger(boolean noTrigger) {
		getNoTriggerReference().setValue(noTrigger);	
	}
}
