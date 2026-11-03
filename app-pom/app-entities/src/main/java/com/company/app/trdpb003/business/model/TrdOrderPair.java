package com.company.app.trdpb003.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ConditionReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.ConditionName;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.PackedType;
import java.math.BigDecimal;
import java.util.Arrays;
/**
 * Data simplifier entity TrdOrderPair.
 * 
 * <p>About 'trdExchange' field, <br>
 * </p>
 * 
 * <p>About 'trdBuyerId' field, <br>
 * </p>
 * 
 * <p>About 'trdSellerId' field, <br>
 * </p>
 * 
 * <p>About 'trdOrderId' field, <br>
 * </p>
 * 
 * <p>About 'trdFigi' field, <br>
 * </p>
 * 
 * <p>About 'trdOrderQty' field, <br>
 * </p>
 * 
 * <p>About 'trdCurrency' field, <br>
 * </p>
 * 
 * <p>About 'trdOrderAmount' field, <br>
 * </p>
 * 
 * <p>About 'trdBuyerSecAccNum' field, <br>
 * </p>
 * 
 * <p>About 'trdBuyerMoneyAccNum' field, <br>
 * </p>
 * 
 * <p>About 'trdSellerSecAccNum' field, <br>
 * </p>
 * 
 * <p>About 'trdSellerMoneyAccNum' field, <br>
 * </p>
 * 
 * <p>About 'trdStatus' field, <br>
 * </p>
 * 
 * <p>About 'trdAccepted' field, <br>
 * </p>
 * 
 * <p>About 'trdSacBookingDone' field, <br>
 * </p>
 * 
 * <p>About 'trdSacBookingFailed' field, <br>
 * </p>
 * 
 * <p>About 'trdMacBookingDone' field, <br>
 * </p>
 * 
 * <p>About 'trdMacBookingFailed' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class TrdOrderPair extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary trdExchange = new Elementary(root,new AlphanumericType(10));
	private final Elementary trdBuyerId = new Elementary(root,new AlphanumericType(12));
	private final Elementary trdSellerId = new Elementary(root,new AlphanumericType(12));
	private final Elementary trdOrderId = new Elementary(root,new AlphanumericType(12));
	private final Elementary trdFigi = new Elementary(root,new AlphanumericType(12));
	private final Elementary trdOrderQty = new Elementary(root,new PackedType(7, 2, false, false, true));
	private final Elementary trdCurrency = new Elementary(root,new AlphanumericType(3));
	private final Elementary trdOrderAmount = new Elementary(root,new PackedType(7, 2, false, false, true));
	private final Elementary trdBuyerSecAccNum = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	private final Elementary trdBuyerMoneyAccNum = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	private final Elementary trdSellerSecAccNum = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	private final Elementary trdSellerMoneyAccNum = new Elementary(root,new BinaryType(9, 0, "STD", false, false, true));
	private final Elementary trdStatus = new Elementary(root,new AlphanumericType(1));
	private final ConditionName trdAccepted = new ConditionName(trdStatus,
		Arrays.asList("A"));
	private final ConditionName trdSacBookingDone = new ConditionName(trdStatus,
		Arrays.asList("S"));
	private final ConditionName trdSacBookingFailed = new ConditionName(trdStatus,
		Arrays.asList("F"));
	private final ConditionName trdMacBookingDone = new ConditionName(trdStatus,
		Arrays.asList("M"));
	private final ConditionName trdMacBookingFailed = new ConditionName(trdStatus,
		Arrays.asList("N"));
	
	/**
	 * Instantiate a new TrdOrderPair with a default record.
	 * @param configuration the configuration
	 */
	public TrdOrderPair(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new TrdOrderPair bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public TrdOrderPair(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute trdExchange.
	 * @return the trdExchange attribute reference
	 */
	public ElementaryRangeReference getTrdExchangeReference() {
		return trdExchange.getReference();
	}

	/**
	 * Getter for trdExchange attribute.
	 * @return trdExchange attribute
	 */
	public String getTrdExchange() {
		return trdExchange.getValue();
	}

	/**
	 * Setter for trdExchange attribute.
	 * @param trdExchange the new value of trdExchange
	 */
	public void setTrdExchange(String trdExchange) {
		this.trdExchange.setValue(trdExchange);
	}
	/**
	 * Gets the reference for attribute trdBuyerId.
	 * @return the trdBuyerId attribute reference
	 */
	public ElementaryRangeReference getTrdBuyerIdReference() {
		return trdBuyerId.getReference();
	}

	/**
	 * Getter for trdBuyerId attribute.
	 * @return trdBuyerId attribute
	 */
	public String getTrdBuyerId() {
		return trdBuyerId.getValue();
	}

	/**
	 * Setter for trdBuyerId attribute.
	 * @param trdBuyerId the new value of trdBuyerId
	 */
	public void setTrdBuyerId(String trdBuyerId) {
		this.trdBuyerId.setValue(trdBuyerId);
	}
	/**
	 * Gets the reference for attribute trdSellerId.
	 * @return the trdSellerId attribute reference
	 */
	public ElementaryRangeReference getTrdSellerIdReference() {
		return trdSellerId.getReference();
	}

	/**
	 * Getter for trdSellerId attribute.
	 * @return trdSellerId attribute
	 */
	public String getTrdSellerId() {
		return trdSellerId.getValue();
	}

	/**
	 * Setter for trdSellerId attribute.
	 * @param trdSellerId the new value of trdSellerId
	 */
	public void setTrdSellerId(String trdSellerId) {
		this.trdSellerId.setValue(trdSellerId);
	}
	/**
	 * Gets the reference for attribute trdOrderId.
	 * @return the trdOrderId attribute reference
	 */
	public ElementaryRangeReference getTrdOrderIdReference() {
		return trdOrderId.getReference();
	}

	/**
	 * Getter for trdOrderId attribute.
	 * @return trdOrderId attribute
	 */
	public String getTrdOrderId() {
		return trdOrderId.getValue();
	}

	/**
	 * Setter for trdOrderId attribute.
	 * @param trdOrderId the new value of trdOrderId
	 */
	public void setTrdOrderId(String trdOrderId) {
		this.trdOrderId.setValue(trdOrderId);
	}
	/**
	 * Gets the reference for attribute trdFigi.
	 * @return the trdFigi attribute reference
	 */
	public ElementaryRangeReference getTrdFigiReference() {
		return trdFigi.getReference();
	}

	/**
	 * Getter for trdFigi attribute.
	 * @return trdFigi attribute
	 */
	public String getTrdFigi() {
		return trdFigi.getValue();
	}

	/**
	 * Setter for trdFigi attribute.
	 * @param trdFigi the new value of trdFigi
	 */
	public void setTrdFigi(String trdFigi) {
		this.trdFigi.setValue(trdFigi);
	}
	/**
	 * Gets the reference for attribute trdOrderQty.
	 * @return the trdOrderQty attribute reference
	 */
	public ElementaryRangeReference getTrdOrderQtyReference() {
		return trdOrderQty.getReference();
	}

	/**
	 * Getter for trdOrderQty attribute.
	 * @return trdOrderQty attribute
	 */
	public BigDecimal getTrdOrderQty() {
		return trdOrderQty.getValue();
	}

	/**
	 * Setter for trdOrderQty attribute.
	 * @param trdOrderQty the new value of trdOrderQty
	 */
	public void setTrdOrderQty(BigDecimal trdOrderQty) {
		this.trdOrderQty.setValue(trdOrderQty);
	}
	/**
	 * Gets the reference for attribute trdCurrency.
	 * @return the trdCurrency attribute reference
	 */
	public ElementaryRangeReference getTrdCurrencyReference() {
		return trdCurrency.getReference();
	}

	/**
	 * Getter for trdCurrency attribute.
	 * @return trdCurrency attribute
	 */
	public String getTrdCurrency() {
		return trdCurrency.getValue();
	}

	/**
	 * Setter for trdCurrency attribute.
	 * @param trdCurrency the new value of trdCurrency
	 */
	public void setTrdCurrency(String trdCurrency) {
		this.trdCurrency.setValue(trdCurrency);
	}
	/**
	 * Gets the reference for attribute trdOrderAmount.
	 * @return the trdOrderAmount attribute reference
	 */
	public ElementaryRangeReference getTrdOrderAmountReference() {
		return trdOrderAmount.getReference();
	}

	/**
	 * Getter for trdOrderAmount attribute.
	 * @return trdOrderAmount attribute
	 */
	public BigDecimal getTrdOrderAmount() {
		return trdOrderAmount.getValue();
	}

	/**
	 * Setter for trdOrderAmount attribute.
	 * @param trdOrderAmount the new value of trdOrderAmount
	 */
	public void setTrdOrderAmount(BigDecimal trdOrderAmount) {
		this.trdOrderAmount.setValue(trdOrderAmount);
	}
	/**
	 * Gets the reference for attribute trdBuyerSecAccNum.
	 * @return the trdBuyerSecAccNum attribute reference
	 */
	public ElementaryRangeReference getTrdBuyerSecAccNumReference() {
		return trdBuyerSecAccNum.getReference();
	}

	/**
	 * Getter for trdBuyerSecAccNum attribute.
	 * @return trdBuyerSecAccNum attribute
	 */
	public int getTrdBuyerSecAccNum() {
		return trdBuyerSecAccNum.getValue();
	}

	/**
	 * Setter for trdBuyerSecAccNum attribute.
	 * @param trdBuyerSecAccNum the new value of trdBuyerSecAccNum
	 */
	public void setTrdBuyerSecAccNum(int trdBuyerSecAccNum) {
		this.trdBuyerSecAccNum.setValue(trdBuyerSecAccNum);
	}
	/**
	 * Gets the reference for attribute trdBuyerMoneyAccNum.
	 * @return the trdBuyerMoneyAccNum attribute reference
	 */
	public ElementaryRangeReference getTrdBuyerMoneyAccNumReference() {
		return trdBuyerMoneyAccNum.getReference();
	}

	/**
	 * Getter for trdBuyerMoneyAccNum attribute.
	 * @return trdBuyerMoneyAccNum attribute
	 */
	public int getTrdBuyerMoneyAccNum() {
		return trdBuyerMoneyAccNum.getValue();
	}

	/**
	 * Setter for trdBuyerMoneyAccNum attribute.
	 * @param trdBuyerMoneyAccNum the new value of trdBuyerMoneyAccNum
	 */
	public void setTrdBuyerMoneyAccNum(int trdBuyerMoneyAccNum) {
		this.trdBuyerMoneyAccNum.setValue(trdBuyerMoneyAccNum);
	}
	/**
	 * Gets the reference for attribute trdSellerSecAccNum.
	 * @return the trdSellerSecAccNum attribute reference
	 */
	public ElementaryRangeReference getTrdSellerSecAccNumReference() {
		return trdSellerSecAccNum.getReference();
	}

	/**
	 * Getter for trdSellerSecAccNum attribute.
	 * @return trdSellerSecAccNum attribute
	 */
	public int getTrdSellerSecAccNum() {
		return trdSellerSecAccNum.getValue();
	}

	/**
	 * Setter for trdSellerSecAccNum attribute.
	 * @param trdSellerSecAccNum the new value of trdSellerSecAccNum
	 */
	public void setTrdSellerSecAccNum(int trdSellerSecAccNum) {
		this.trdSellerSecAccNum.setValue(trdSellerSecAccNum);
	}
	/**
	 * Gets the reference for attribute trdSellerMoneyAccNum.
	 * @return the trdSellerMoneyAccNum attribute reference
	 */
	public ElementaryRangeReference getTrdSellerMoneyAccNumReference() {
		return trdSellerMoneyAccNum.getReference();
	}

	/**
	 * Getter for trdSellerMoneyAccNum attribute.
	 * @return trdSellerMoneyAccNum attribute
	 */
	public int getTrdSellerMoneyAccNum() {
		return trdSellerMoneyAccNum.getValue();
	}

	/**
	 * Setter for trdSellerMoneyAccNum attribute.
	 * @param trdSellerMoneyAccNum the new value of trdSellerMoneyAccNum
	 */
	public void setTrdSellerMoneyAccNum(int trdSellerMoneyAccNum) {
		this.trdSellerMoneyAccNum.setValue(trdSellerMoneyAccNum);
	}
	/**
	 * Gets the reference for attribute trdStatus.
	 * @return the trdStatus attribute reference
	 */
	public ElementaryRangeReference getTrdStatusReference() {
		return trdStatus.getReference();
	}

	/**
	 * Getter for trdStatus attribute.
	 * @return trdStatus attribute
	 */
	public String getTrdStatus() {
		return trdStatus.getValue();
	}

	/**
	 * Setter for trdStatus attribute.
	 * @param trdStatus the new value of trdStatus
	 */
	public void setTrdStatus(String trdStatus) {
		this.trdStatus.setValue(trdStatus);
	}
	/**
	 * Gets the reference for attribute trdAccepted.
	 * @return the trdAccepted attribute reference
	 */
	public ConditionReference getTrdAcceptedReference() {
		return trdStatus.getCondition(trdAccepted);	
	}

	/**
	 * Getter for trdAccepted attribute.
	 * @return trdAccepted attribute
	 */
	public boolean isTrdAccepted() {
		return getTrdAcceptedReference().getValue();	
	}

	/**
	 * Setter for trdAccepted attribute.
	 * @param trdAccepted the new value of trdAccepted
	 */
	public void setTrdAccepted(boolean trdAccepted) {
		getTrdAcceptedReference().setValue(trdAccepted);	
	}
	/**
	 * Gets the reference for attribute trdSacBookingDone.
	 * @return the trdSacBookingDone attribute reference
	 */
	public ConditionReference getTrdSacBookingDoneReference() {
		return trdStatus.getCondition(trdSacBookingDone);	
	}

	/**
	 * Getter for trdSacBookingDone attribute.
	 * @return trdSacBookingDone attribute
	 */
	public boolean isTrdSacBookingDone() {
		return getTrdSacBookingDoneReference().getValue();	
	}

	/**
	 * Setter for trdSacBookingDone attribute.
	 * @param trdSacBookingDone the new value of trdSacBookingDone
	 */
	public void setTrdSacBookingDone(boolean trdSacBookingDone) {
		getTrdSacBookingDoneReference().setValue(trdSacBookingDone);	
	}
	/**
	 * Gets the reference for attribute trdSacBookingFailed.
	 * @return the trdSacBookingFailed attribute reference
	 */
	public ConditionReference getTrdSacBookingFailedReference() {
		return trdStatus.getCondition(trdSacBookingFailed);	
	}

	/**
	 * Getter for trdSacBookingFailed attribute.
	 * @return trdSacBookingFailed attribute
	 */
	public boolean isTrdSacBookingFailed() {
		return getTrdSacBookingFailedReference().getValue();	
	}

	/**
	 * Setter for trdSacBookingFailed attribute.
	 * @param trdSacBookingFailed the new value of trdSacBookingFailed
	 */
	public void setTrdSacBookingFailed(boolean trdSacBookingFailed) {
		getTrdSacBookingFailedReference().setValue(trdSacBookingFailed);	
	}
	/**
	 * Gets the reference for attribute trdMacBookingDone.
	 * @return the trdMacBookingDone attribute reference
	 */
	public ConditionReference getTrdMacBookingDoneReference() {
		return trdStatus.getCondition(trdMacBookingDone);	
	}

	/**
	 * Getter for trdMacBookingDone attribute.
	 * @return trdMacBookingDone attribute
	 */
	public boolean isTrdMacBookingDone() {
		return getTrdMacBookingDoneReference().getValue();	
	}

	/**
	 * Setter for trdMacBookingDone attribute.
	 * @param trdMacBookingDone the new value of trdMacBookingDone
	 */
	public void setTrdMacBookingDone(boolean trdMacBookingDone) {
		getTrdMacBookingDoneReference().setValue(trdMacBookingDone);	
	}
	/**
	 * Gets the reference for attribute trdMacBookingFailed.
	 * @return the trdMacBookingFailed attribute reference
	 */
	public ConditionReference getTrdMacBookingFailedReference() {
		return trdStatus.getCondition(trdMacBookingFailed);	
	}

	/**
	 * Getter for trdMacBookingFailed attribute.
	 * @return trdMacBookingFailed attribute
	 */
	public boolean isTrdMacBookingFailed() {
		return getTrdMacBookingFailedReference().getValue();	
	}

	/**
	 * Setter for trdMacBookingFailed attribute.
	 * @param trdMacBookingFailed the new value of trdMacBookingFailed
	 */
	public void setTrdMacBookingFailed(boolean trdMacBookingFailed) {
		getTrdMacBookingFailedReference().setValue(trdMacBookingFailed);	
	}
}
