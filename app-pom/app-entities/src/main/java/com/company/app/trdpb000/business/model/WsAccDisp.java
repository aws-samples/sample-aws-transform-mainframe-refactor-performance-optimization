package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.NumericEditedType;
/**
 * Data simplifier entity WsAccDisp.
 * 
 * <p>About 'wsAccDisp' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsAccDisp extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsAccDisp = new Elementary(root,new NumericEditedType("Z(9)"));
	
	/**
	 * Instantiate a new WsAccDisp with a default record.
	 * @param configuration the configuration
	 */
	public WsAccDisp(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsAccDisp bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsAccDisp(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsAccDisp.
	 * @return the wsAccDisp attribute reference
	 */
	public ElementaryRangeReference getWsAccDispReference() {
		return wsAccDisp.getReference();
	}

	/**
	 * Getter for wsAccDisp attribute.
	 * @return wsAccDisp attribute
	 */
	public String getWsAccDisp() {
		return wsAccDisp.getValue();
	}

	/**
	 * Setter for wsAccDisp attribute.
	 * @param wsAccDisp the new value of wsAccDisp
	 */
	public void setWsAccDisp(String wsAccDisp) {
		this.wsAccDisp.setValue(wsAccDisp);
	}
}
