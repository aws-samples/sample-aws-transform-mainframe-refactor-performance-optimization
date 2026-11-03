package com.company.app.trdpb006.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Filler;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ConditionReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.ConditionName;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.NumericEditedType;
import java.util.Arrays;
/**
 * Data simplifier entity WsPageHeader.
 * 
 * <p>About 'wsPhHeaderFlg' field, <br>
 * </p>
 * 
 * <p>About 'phBuyOrders' field, <br>
 * </p>
 * 
 * <p>About 'phSellOrders' field, <br>
 * </p>
 * 
 * <p>About 'wsPhCustomer' field, <br>
 * </p>
 * 
 * <p>About 'wsPhCustomerDesc' field, <br>
 * </p>
 * 
 * <p>About 'wsPhPagenum' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsPageHeader extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(55)," ");
	private final Elementary wsPhHeaderFlg = new Elementary(root,new AlphanumericType(32));
	private final ConditionName phBuyOrders = new ConditionName(wsPhHeaderFlg,
		Arrays.asList(" Buy Orders Report for Client : "));
	private final ConditionName phSellOrders = new ConditionName(wsPhHeaderFlg,
		Arrays.asList("Sell Orders Report for Client : "));
	private final Elementary wsPhCustomer = new Elementary(root,new AlphanumericType(12));
	@SuppressWarnings("unused")
	private final Filler filler1 = new Filler(root,new AlphanumericType(3)," : ");
	private final Elementary wsPhCustomerDesc = new Elementary(root,new AlphanumericType(30));
	@SuppressWarnings("unused")
	private final Filler filler2 = new Filler(root,new AlphanumericType(17)," ");
	@SuppressWarnings("unused")
	private final Filler filler3 = new Filler(root,new AlphanumericType(7),"Page : ");
	private final Elementary wsPhPagenum = new Elementary(root,new NumericEditedType("Z(3)"));
	
	/**
	 * Instantiate a new WsPageHeader with a default record.
	 * @param configuration the configuration
	 */
	public WsPageHeader(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsPageHeader bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsPageHeader(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsPhHeaderFlg.
	 * @return the wsPhHeaderFlg attribute reference
	 */
	public ElementaryRangeReference getWsPhHeaderFlgReference() {
		return wsPhHeaderFlg.getReference();
	}

	/**
	 * Getter for wsPhHeaderFlg attribute.
	 * @return wsPhHeaderFlg attribute
	 */
	public String getWsPhHeaderFlg() {
		return wsPhHeaderFlg.getValue();
	}

	/**
	 * Setter for wsPhHeaderFlg attribute.
	 * @param wsPhHeaderFlg the new value of wsPhHeaderFlg
	 */
	public void setWsPhHeaderFlg(String wsPhHeaderFlg) {
		this.wsPhHeaderFlg.setValue(wsPhHeaderFlg);
	}
	/**
	 * Gets the reference for attribute phBuyOrders.
	 * @return the phBuyOrders attribute reference
	 */
	public ConditionReference getPhBuyOrdersReference() {
		return wsPhHeaderFlg.getCondition(phBuyOrders);	
	}

	/**
	 * Getter for phBuyOrders attribute.
	 * @return phBuyOrders attribute
	 */
	public boolean isPhBuyOrders() {
		return getPhBuyOrdersReference().getValue();	
	}

	/**
	 * Setter for phBuyOrders attribute.
	 * @param phBuyOrders the new value of phBuyOrders
	 */
	public void setPhBuyOrders(boolean phBuyOrders) {
		getPhBuyOrdersReference().setValue(phBuyOrders);	
	}
	/**
	 * Gets the reference for attribute phSellOrders.
	 * @return the phSellOrders attribute reference
	 */
	public ConditionReference getPhSellOrdersReference() {
		return wsPhHeaderFlg.getCondition(phSellOrders);	
	}

	/**
	 * Getter for phSellOrders attribute.
	 * @return phSellOrders attribute
	 */
	public boolean isPhSellOrders() {
		return getPhSellOrdersReference().getValue();	
	}

	/**
	 * Setter for phSellOrders attribute.
	 * @param phSellOrders the new value of phSellOrders
	 */
	public void setPhSellOrders(boolean phSellOrders) {
		getPhSellOrdersReference().setValue(phSellOrders);	
	}
	/**
	 * Gets the reference for attribute wsPhCustomer.
	 * @return the wsPhCustomer attribute reference
	 */
	public ElementaryRangeReference getWsPhCustomerReference() {
		return wsPhCustomer.getReference();
	}

	/**
	 * Getter for wsPhCustomer attribute.
	 * @return wsPhCustomer attribute
	 */
	public String getWsPhCustomer() {
		return wsPhCustomer.getValue();
	}

	/**
	 * Setter for wsPhCustomer attribute.
	 * @param wsPhCustomer the new value of wsPhCustomer
	 */
	public void setWsPhCustomer(String wsPhCustomer) {
		this.wsPhCustomer.setValue(wsPhCustomer);
	}
	/**
	 * Gets the reference for attribute wsPhCustomerDesc.
	 * @return the wsPhCustomerDesc attribute reference
	 */
	public ElementaryRangeReference getWsPhCustomerDescReference() {
		return wsPhCustomerDesc.getReference();
	}

	/**
	 * Getter for wsPhCustomerDesc attribute.
	 * @return wsPhCustomerDesc attribute
	 */
	public String getWsPhCustomerDesc() {
		return wsPhCustomerDesc.getValue();
	}

	/**
	 * Setter for wsPhCustomerDesc attribute.
	 * @param wsPhCustomerDesc the new value of wsPhCustomerDesc
	 */
	public void setWsPhCustomerDesc(String wsPhCustomerDesc) {
		this.wsPhCustomerDesc.setValue(wsPhCustomerDesc);
	}
	/**
	 * Gets the reference for attribute wsPhPagenum.
	 * @return the wsPhPagenum attribute reference
	 */
	public ElementaryRangeReference getWsPhPagenumReference() {
		return wsPhPagenum.getReference();
	}

	/**
	 * Getter for wsPhPagenum attribute.
	 * @return wsPhPagenum attribute
	 */
	public String getWsPhPagenum() {
		return wsPhPagenum.getValue();
	}

	/**
	 * Setter for wsPhPagenum attribute.
	 * @param wsPhPagenum the new value of wsPhPagenum
	 */
	public void setWsPhPagenum(String wsPhPagenum) {
		this.wsPhPagenum.setValue(wsPhPagenum);
	}
}
