package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Filler;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsProgramStartParms.
 * 
 * <p>About 'wsInpChkpFrequency' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsProgramStartParms extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(5));
	private final Elementary wsInpChkpFrequency = new Elementary(root,new AlphanumericType(5));
	
	/**
	 * Instantiate a new WsProgramStartParms with a default record.
	 * @param configuration the configuration
	 */
	public WsProgramStartParms(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsProgramStartParms bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsProgramStartParms(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsInpChkpFrequency.
	 * @return the wsInpChkpFrequency attribute reference
	 */
	public ElementaryRangeReference getWsInpChkpFrequencyReference() {
		return wsInpChkpFrequency.getReference();
	}

	/**
	 * Getter for wsInpChkpFrequency attribute.
	 * @return wsInpChkpFrequency attribute
	 */
	public String getWsInpChkpFrequency() {
		return wsInpChkpFrequency.getValue();
	}

	/**
	 * Setter for wsInpChkpFrequency attribute.
	 * @param wsInpChkpFrequency the new value of wsInpChkpFrequency
	 */
	public void setWsInpChkpFrequency(String wsInpChkpFrequency) {
		this.wsInpChkpFrequency.setValue(wsInpChkpFrequency);
	}
}
