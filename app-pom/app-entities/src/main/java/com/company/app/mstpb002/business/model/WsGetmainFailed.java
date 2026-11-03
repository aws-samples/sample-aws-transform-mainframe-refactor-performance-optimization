package com.company.app.mstpb002.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.NumericEditedType;
/**
 * Data simplifier entity WsGetmainFailed.
 * 
 * <p>About 'filler' field, <br>
 * </p>
 * 
 * <p>About 'wsGetmainCode' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsGetmainFailed extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary filler = new Elementary(root,new AlphanumericType(40),"Getmain Failed in MSTPB002  EIBRESP = ");
	private final Elementary wsGetmainCode = new Elementary(root,new NumericEditedType("----9"));
	
	/**
	 * Instantiate a new WsGetmainFailed with a default record.
	 * @param configuration the configuration
	 */
	public WsGetmainFailed(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsGetmainFailed bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsGetmainFailed(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute filler.
	 * @return the filler attribute reference
	 */
	public ElementaryRangeReference getFillerReference() {
		return filler.getReference();
	}

	/**
	 * Getter for filler attribute.
	 * @return filler attribute
	 */
	public String getFiller() {
		return filler.getValue();
	}

	/**
	 * Setter for filler attribute.
	 * @param filler the new value of filler
	 */
	public void setFiller(String filler) {
		this.filler.setValue(filler);
	}
	/**
	 * Gets the reference for attribute wsGetmainCode.
	 * @return the wsGetmainCode attribute reference
	 */
	public ElementaryRangeReference getWsGetmainCodeReference() {
		return wsGetmainCode.getReference();
	}

	/**
	 * Getter for wsGetmainCode attribute.
	 * @return wsGetmainCode attribute
	 */
	public String getWsGetmainCode() {
		return wsGetmainCode.getValue();
	}

	/**
	 * Setter for wsGetmainCode attribute.
	 * @param wsGetmainCode the new value of wsGetmainCode
	 */
	public void setWsGetmainCode(String wsGetmainCode) {
		this.wsGetmainCode.setValue(wsGetmainCode);
	}
}
