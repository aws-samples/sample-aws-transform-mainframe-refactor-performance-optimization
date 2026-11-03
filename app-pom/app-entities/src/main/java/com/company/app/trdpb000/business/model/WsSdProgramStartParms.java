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
 * Data simplifier entity WsSdProgramStartParms.
 * 
 * <p>About 'wsSdInpChkpFrequency' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsSdProgramStartParms extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsSdInpChkpFrequency = new Elementary(root,new AlphanumericType(5));
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(80));
	
	/**
	 * Instantiate a new WsSdProgramStartParms with a default record.
	 * @param configuration the configuration
	 */
	public WsSdProgramStartParms(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsSdProgramStartParms bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsSdProgramStartParms(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsSdInpChkpFrequency.
	 * @return the wsSdInpChkpFrequency attribute reference
	 */
	public ElementaryRangeReference getWsSdInpChkpFrequencyReference() {
		return wsSdInpChkpFrequency.getReference();
	}

	/**
	 * Getter for wsSdInpChkpFrequency attribute.
	 * @return wsSdInpChkpFrequency attribute
	 */
	public String getWsSdInpChkpFrequency() {
		return wsSdInpChkpFrequency.getValue();
	}

	/**
	 * Setter for wsSdInpChkpFrequency attribute.
	 * @param wsSdInpChkpFrequency the new value of wsSdInpChkpFrequency
	 */
	public void setWsSdInpChkpFrequency(String wsSdInpChkpFrequency) {
		this.wsSdInpChkpFrequency.setValue(wsSdInpChkpFrequency);
	}
}
