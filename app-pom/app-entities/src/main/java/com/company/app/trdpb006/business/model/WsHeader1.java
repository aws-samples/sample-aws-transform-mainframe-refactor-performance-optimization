package com.company.app.trdpb006.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Filler;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.ZonedType;
/**
 * Data simplifier entity WsHeader1.
 * 
 * <p>About 'wsH1OrderStatusCode' field, <br>
 * </p>
 * 
 * <p>About 'wsH1OrderStatusDesc' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsHeader1 extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(15),"Order Status : ");
	private final Elementary wsH1OrderStatusCode = new Elementary(root,new ZonedType(3, 0, false));
	@SuppressWarnings("unused")
	private final Filler filler1 = new Filler(root,new AlphanumericType(3)," - ");
	private final Elementary wsH1OrderStatusDesc = new Elementary(root,new AlphanumericType(20));
	@SuppressWarnings("unused")
	private final Filler filler2 = new Filler(root,new AlphanumericType(119)," ");
	
	/**
	 * Instantiate a new WsHeader1 with a default record.
	 * @param configuration the configuration
	 */
	public WsHeader1(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsHeader1 bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsHeader1(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsH1OrderStatusCode.
	 * @return the wsH1OrderStatusCode attribute reference
	 */
	public ElementaryRangeReference getWsH1OrderStatusCodeReference() {
		return wsH1OrderStatusCode.getReference();
	}

	/**
	 * Getter for wsH1OrderStatusCode attribute.
	 * @return wsH1OrderStatusCode attribute
	 */
	public int getWsH1OrderStatusCode() {
		return wsH1OrderStatusCode.getValue();
	}

	/**
	 * Setter for wsH1OrderStatusCode attribute.
	 * @param wsH1OrderStatusCode the new value of wsH1OrderStatusCode
	 */
	public void setWsH1OrderStatusCode(int wsH1OrderStatusCode) {
		this.wsH1OrderStatusCode.setValue(wsH1OrderStatusCode);
	}
	/**
	 * Gets the reference for attribute wsH1OrderStatusDesc.
	 * @return the wsH1OrderStatusDesc attribute reference
	 */
	public ElementaryRangeReference getWsH1OrderStatusDescReference() {
		return wsH1OrderStatusDesc.getReference();
	}

	/**
	 * Getter for wsH1OrderStatusDesc attribute.
	 * @return wsH1OrderStatusDesc attribute
	 */
	public String getWsH1OrderStatusDesc() {
		return wsH1OrderStatusDesc.getValue();
	}

	/**
	 * Setter for wsH1OrderStatusDesc attribute.
	 * @param wsH1OrderStatusDesc the new value of wsH1OrderStatusDesc
	 */
	public void setWsH1OrderStatusDesc(String wsH1OrderStatusDesc) {
		this.wsH1OrderStatusDesc.setValue(wsH1OrderStatusDesc);
	}
}
