package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity WsStqSqlcode.
 * 
 * <p>About 'wsStqSqlcode' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsStqSqlcode extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsStqSqlcode = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	
	/**
	 * Instantiate a new WsStqSqlcode with a default record.
	 * @param configuration the configuration
	 */
	public WsStqSqlcode(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsStqSqlcode bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsStqSqlcode(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsStqSqlcode.
	 * @return the wsStqSqlcode attribute reference
	 */
	public ElementaryRangeReference getWsStqSqlcodeReference() {
		return wsStqSqlcode.getReference();
	}

	/**
	 * Getter for wsStqSqlcode attribute.
	 * @return wsStqSqlcode attribute
	 */
	public int getWsStqSqlcode() {
		return wsStqSqlcode.getValue();
	}

	/**
	 * Setter for wsStqSqlcode attribute.
	 * @param wsStqSqlcode the new value of wsStqSqlcode
	 */
	public void setWsStqSqlcode(int wsStqSqlcode) {
		this.wsStqSqlcode.setValue(wsStqSqlcode);
	}
}
