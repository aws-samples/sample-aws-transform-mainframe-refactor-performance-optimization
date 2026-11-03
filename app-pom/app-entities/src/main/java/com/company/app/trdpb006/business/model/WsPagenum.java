package com.company.app.trdpb006.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.ZonedType;
/**
 * Data simplifier entity WsPagenum.
 * 
 * <p>About 'wsPagenum' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsPagenum extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsPagenum = new Elementary(root,new ZonedType(3, 0, false),Short.valueOf("0"));
	
	/**
	 * Instantiate a new WsPagenum with a default record.
	 * @param configuration the configuration
	 */
	public WsPagenum(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsPagenum bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsPagenum(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsPagenum.
	 * @return the wsPagenum attribute reference
	 */
	public ElementaryRangeReference getWsPagenumReference() {
		return wsPagenum.getReference();
	}

	/**
	 * Getter for wsPagenum attribute.
	 * @return wsPagenum attribute
	 */
	public int getWsPagenum() {
		return wsPagenum.getValue();
	}

	/**
	 * Setter for wsPagenum attribute.
	 * @param wsPagenum the new value of wsPagenum
	 */
	public void setWsPagenum(int wsPagenum) {
		this.wsPagenum.setValue(wsPagenum);
	}
}
