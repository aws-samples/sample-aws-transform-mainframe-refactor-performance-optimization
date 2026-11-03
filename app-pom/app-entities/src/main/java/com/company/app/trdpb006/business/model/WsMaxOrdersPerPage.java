package com.company.app.trdpb006.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity WsMaxOrdersPerPage.
 * 
 * <p>About 'wsMaxOrdersPerPage' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsMaxOrdersPerPage extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * 
	 */
	private final Elementary wsMaxOrdersPerPage = new Elementary(root,new BinaryType(4, 0, "STD", false),Short.valueOf("60"));
	
	/**
	 * Instantiate a new WsMaxOrdersPerPage with a default record.
	 * @param configuration the configuration
	 */
	public WsMaxOrdersPerPage(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsMaxOrdersPerPage bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsMaxOrdersPerPage(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsMaxOrdersPerPage.
	 * @return the wsMaxOrdersPerPage attribute reference
	 */
	public ElementaryRangeReference getWsMaxOrdersPerPageReference() {
		return wsMaxOrdersPerPage.getReference();
	}

	/**
	 * Getter for wsMaxOrdersPerPage attribute.
	 * @return wsMaxOrdersPerPage attribute
	 */
	public int getWsMaxOrdersPerPage() {
		return wsMaxOrdersPerPage.getValue();
	}

	/**
	 * Setter for wsMaxOrdersPerPage attribute.
	 * @param wsMaxOrdersPerPage the new value of wsMaxOrdersPerPage
	 */
	public void setWsMaxOrdersPerPage(int wsMaxOrdersPerPage) {
		this.wsMaxOrdersPerPage.setValue(wsMaxOrdersPerPage);
	}
}
