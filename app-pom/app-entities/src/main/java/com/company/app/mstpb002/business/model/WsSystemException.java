package com.company.app.mstpb002.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Filler;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsSystemException.
 * 
 * <p>About 'wsAbcode' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsSystemException extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(6),"Abend ");
	private final Elementary wsAbcode = new Elementary(root,new AlphanumericType(4)," ");
	@SuppressWarnings("unused")
	private final Filler filler1 = new Filler(root,new AlphanumericType(31)," encountered while processing, ");
	@SuppressWarnings("unused")
	private final Filler filler2 = new Filler(root,new AlphanumericType(36),"abend caught by  MSTPB002           ");
	
	/**
	 * Instantiate a new WsSystemException with a default record.
	 * @param configuration the configuration
	 */
	public WsSystemException(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsSystemException bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsSystemException(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsAbcode.
	 * @return the wsAbcode attribute reference
	 */
	public ElementaryRangeReference getWsAbcodeReference() {
		return wsAbcode.getReference();
	}

	/**
	 * Getter for wsAbcode attribute.
	 * @return wsAbcode attribute
	 */
	public String getWsAbcode() {
		return wsAbcode.getValue();
	}

	/**
	 * Setter for wsAbcode attribute.
	 * @param wsAbcode the new value of wsAbcode
	 */
	public void setWsAbcode(String wsAbcode) {
		this.wsAbcode.setValue(wsAbcode);
	}
}
