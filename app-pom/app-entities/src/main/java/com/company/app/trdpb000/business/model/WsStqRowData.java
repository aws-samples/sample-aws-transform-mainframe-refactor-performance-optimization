package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsStqRowData.
 * 
 * <p>About 'wsStqRowData' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsStqRowData extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsStqRowData = new Elementary(root,new AlphanumericType(88));
	
	/**
	 * Instantiate a new WsStqRowData with a default record.
	 * @param configuration the configuration
	 */
	public WsStqRowData(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsStqRowData bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsStqRowData(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsStqRowData.
	 * @return the wsStqRowData attribute reference
	 */
	public ElementaryRangeReference getWsStqRowDataReference() {
		return wsStqRowData.getReference();
	}

	/**
	 * Getter for wsStqRowData attribute.
	 * @return wsStqRowData attribute
	 */
	public String getWsStqRowData() {
		return wsStqRowData.getValue();
	}

	/**
	 * Setter for wsStqRowData attribute.
	 * @param wsStqRowData the new value of wsStqRowData
	 */
	public void setWsStqRowData(String wsStqRowData) {
		this.wsStqRowData.setValue(wsStqRowData);
	}
}
