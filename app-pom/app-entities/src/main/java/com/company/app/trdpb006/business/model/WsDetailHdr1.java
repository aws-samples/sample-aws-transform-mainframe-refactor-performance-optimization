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
import java.util.Arrays;
/**
 * Data simplifier entity WsDetailHdr1.
 * 
 * <p>About 'wsDh1BuyerSeller' field, <br>
 * </p>
 * 
 * <p>About 'dh1Buyer' field, <br>
 * </p>
 * 
 * <p>About 'dh1Seller' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsDetailHdr1 extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(1),"|");
	@SuppressWarnings("unused")
	private final Filler filler1 = new Filler(root,new AlphanumericType(10),"Trade ID");
	@SuppressWarnings("unused")
	private final Filler filler2 = new Filler(root,new AlphanumericType(1),"|");
	private final Elementary wsDh1BuyerSeller = new Elementary(root,new AlphanumericType(12));
	private final ConditionName dh1Buyer = new ConditionName(wsDh1BuyerSeller,
		Arrays.asList("Buyer"));
	private final ConditionName dh1Seller = new ConditionName(wsDh1BuyerSeller,
		Arrays.asList("Seller"));
	@SuppressWarnings("unused")
	private final Filler filler3 = new Filler(root,new AlphanumericType(1),"|");
	@SuppressWarnings("unused")
	private final Filler filler4 = new Filler(root,new AlphanumericType(12),"Exchange");
	@SuppressWarnings("unused")
	private final Filler filler5 = new Filler(root,new AlphanumericType(1),"|");
	@SuppressWarnings("unused")
	private final Filler filler6 = new Filler(root,new AlphanumericType(12),"FIGI ID");
	@SuppressWarnings("unused")
	private final Filler filler7 = new Filler(root,new AlphanumericType(1),"|");
	@SuppressWarnings("unused")
	private final Filler filler8 = new Filler(root,new AlphanumericType(20),"Security Symbol");
	@SuppressWarnings("unused")
	private final Filler filler9 = new Filler(root,new AlphanumericType(1),"|");
	@SuppressWarnings("unused")
	private final Filler filler10 = new Filler(root,new AlphanumericType(40),"Security Description");
	@SuppressWarnings("unused")
	private final Filler filler11 = new Filler(root,new AlphanumericType(1),"|");
	@SuppressWarnings("unused")
	private final Filler filler12 = new Filler(root,new AlphanumericType(15),"Security Type");
	@SuppressWarnings("unused")
	private final Filler filler13 = new Filler(root,new AlphanumericType(1),"|");
	@SuppressWarnings("unused")
	private final Filler filler14 = new Filler(root,new AlphanumericType(12),"    Quantity");
	@SuppressWarnings("unused")
	private final Filler filler15 = new Filler(root,new AlphanumericType(1),"|");
	@SuppressWarnings("unused")
	private final Filler filler16 = new Filler(root,new AlphanumericType(3),"Cur");
	@SuppressWarnings("unused")
	private final Filler filler17 = new Filler(root,new AlphanumericType(1),"|");
	@SuppressWarnings("unused")
	private final Filler filler18 = new Filler(root,new AlphanumericType(12),"      Amount");
	@SuppressWarnings("unused")
	private final Filler filler19 = new Filler(root,new AlphanumericType(1),"|");
	
	/**
	 * Instantiate a new WsDetailHdr1 with a default record.
	 * @param configuration the configuration
	 */
	public WsDetailHdr1(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsDetailHdr1 bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsDetailHdr1(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsDh1BuyerSeller.
	 * @return the wsDh1BuyerSeller attribute reference
	 */
	public ElementaryRangeReference getWsDh1BuyerSellerReference() {
		return wsDh1BuyerSeller.getReference();
	}

	/**
	 * Getter for wsDh1BuyerSeller attribute.
	 * @return wsDh1BuyerSeller attribute
	 */
	public String getWsDh1BuyerSeller() {
		return wsDh1BuyerSeller.getValue();
	}

	/**
	 * Setter for wsDh1BuyerSeller attribute.
	 * @param wsDh1BuyerSeller the new value of wsDh1BuyerSeller
	 */
	public void setWsDh1BuyerSeller(String wsDh1BuyerSeller) {
		this.wsDh1BuyerSeller.setValue(wsDh1BuyerSeller);
	}
	/**
	 * Gets the reference for attribute dh1Buyer.
	 * @return the dh1Buyer attribute reference
	 */
	public ConditionReference getDh1BuyerReference() {
		return wsDh1BuyerSeller.getCondition(dh1Buyer);	
	}

	/**
	 * Getter for dh1Buyer attribute.
	 * @return dh1Buyer attribute
	 */
	public boolean isDh1Buyer() {
		return getDh1BuyerReference().getValue();	
	}

	/**
	 * Setter for dh1Buyer attribute.
	 * @param dh1Buyer the new value of dh1Buyer
	 */
	public void setDh1Buyer(boolean dh1Buyer) {
		getDh1BuyerReference().setValue(dh1Buyer);	
	}
	/**
	 * Gets the reference for attribute dh1Seller.
	 * @return the dh1Seller attribute reference
	 */
	public ConditionReference getDh1SellerReference() {
		return wsDh1BuyerSeller.getCondition(dh1Seller);	
	}

	/**
	 * Getter for dh1Seller attribute.
	 * @return dh1Seller attribute
	 */
	public boolean isDh1Seller() {
		return getDh1SellerReference().getValue();	
	}

	/**
	 * Setter for dh1Seller attribute.
	 * @param dh1Seller the new value of dh1Seller
	 */
	public void setDh1Seller(boolean dh1Seller) {
		getDh1SellerReference().setValue(dh1Seller);	
	}
}
