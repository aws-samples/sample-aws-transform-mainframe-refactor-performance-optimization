package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsStqRowCcy.
 * 
 * <p>About 'wsStqRowCcy' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsStqRowCcy extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsStqRowCcy = new Elementary(root,new AlphanumericType(3));
	
	/**
	 * Instantiate a new WsStqRowCcy with a default record.
	 * @param configuration the configuration
	 */
	public WsStqRowCcy(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsStqRowCcy bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsStqRowCcy(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsStqRowCcy.
	 * @return the wsStqRowCcy attribute reference
	 */
	public ElementaryRangeReference getWsStqRowCcyReference() {
		return wsStqRowCcy.getReference();
	}

	/**
	 * Getter for wsStqRowCcy attribute.
	 * @return wsStqRowCcy attribute
	 */
	public String getWsStqRowCcy() {
		return wsStqRowCcy.getValue();
	}

	/**
	 * Setter for wsStqRowCcy attribute.
	 * @param wsStqRowCcy the new value of wsStqRowCcy
	 */
	public void setWsStqRowCcy(String wsStqRowCcy) {
		this.wsStqRowCcy.setValue(wsStqRowCcy);
	}
}
