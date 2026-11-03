package com.company.app.trdpb006.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Filler;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.NumericEditedType;
/**
 * Data simplifier entity WsDetailRec.
 * 
 * <p>About 'wsDetTradeid' field, <br>
 * </p>
 * 
 * <p>About 'wsDetBuyerSeller' field, <br>
 * </p>
 * 
 * <p>About 'wsDetTradingXchng' field, <br>
 * </p>
 * 
 * <p>About 'wsDetFigi' field, <br>
 * </p>
 * 
 * <p>About 'wsDetSymbol' field, <br>
 * </p>
 * 
 * <p>About 'wsDetDescription' field, <br>
 * </p>
 * 
 * <p>About 'wsDetType' field, <br>
 * </p>
 * 
 * <p>About 'wsDetQuantity' field, <br>
 * </p>
 * 
 * <p>About 'wsDetCurrency' field, <br>
 * </p>
 * 
 * <p>About 'wsDetAmount' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsDetailRec extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(1),"|");
	private final Elementary wsDetTradeid = new Elementary(root,new AlphanumericType(10));
	@SuppressWarnings("unused")
	private final Filler filler1 = new Filler(root,new AlphanumericType(1),"|");
	private final Elementary wsDetBuyerSeller = new Elementary(root,new AlphanumericType(12));
	@SuppressWarnings("unused")
	private final Filler filler2 = new Filler(root,new AlphanumericType(1),"|");
	private final Elementary wsDetTradingXchng = new Elementary(root,new AlphanumericType(12));
	@SuppressWarnings("unused")
	private final Filler filler3 = new Filler(root,new AlphanumericType(1),"|");
	private final Elementary wsDetFigi = new Elementary(root,new AlphanumericType(12));
	@SuppressWarnings("unused")
	private final Filler filler4 = new Filler(root,new AlphanumericType(1),"|");
	private final Elementary wsDetSymbol = new Elementary(root,new AlphanumericType(20));
	@SuppressWarnings("unused")
	private final Filler filler5 = new Filler(root,new AlphanumericType(1),"|");
	private final Elementary wsDetDescription = new Elementary(root,new AlphanumericType(40));
	@SuppressWarnings("unused")
	private final Filler filler6 = new Filler(root,new AlphanumericType(1),"|");
	private final Elementary wsDetType = new Elementary(root,new AlphanumericType(15));
	@SuppressWarnings("unused")
	private final Filler filler7 = new Filler(root,new AlphanumericType(1),"|");
	private final Elementary wsDetQuantity = new Elementary(root,new NumericEditedType("-,---,---.00"));
	@SuppressWarnings("unused")
	private final Filler filler8 = new Filler(root,new AlphanumericType(1),"|");
	private final Elementary wsDetCurrency = new Elementary(root,new AlphanumericType(3));
	@SuppressWarnings("unused")
	private final Filler filler9 = new Filler(root,new AlphanumericType(1),"|");
	private final Elementary wsDetAmount = new Elementary(root,new NumericEditedType("-,---,---.00"));
	@SuppressWarnings("unused")
	private final Filler filler10 = new Filler(root,new AlphanumericType(1),"|");
	
	/**
	 * Instantiate a new WsDetailRec with a default record.
	 * @param configuration the configuration
	 */
	public WsDetailRec(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsDetailRec bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsDetailRec(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsDetTradeid.
	 * @return the wsDetTradeid attribute reference
	 */
	public ElementaryRangeReference getWsDetTradeidReference() {
		return wsDetTradeid.getReference();
	}

	/**
	 * Getter for wsDetTradeid attribute.
	 * @return wsDetTradeid attribute
	 */
	public String getWsDetTradeid() {
		return wsDetTradeid.getValue();
	}

	/**
	 * Setter for wsDetTradeid attribute.
	 * @param wsDetTradeid the new value of wsDetTradeid
	 */
	public void setWsDetTradeid(String wsDetTradeid) {
		this.wsDetTradeid.setValue(wsDetTradeid);
	}
	/**
	 * Gets the reference for attribute wsDetBuyerSeller.
	 * @return the wsDetBuyerSeller attribute reference
	 */
	public ElementaryRangeReference getWsDetBuyerSellerReference() {
		return wsDetBuyerSeller.getReference();
	}

	/**
	 * Getter for wsDetBuyerSeller attribute.
	 * @return wsDetBuyerSeller attribute
	 */
	public String getWsDetBuyerSeller() {
		return wsDetBuyerSeller.getValue();
	}

	/**
	 * Setter for wsDetBuyerSeller attribute.
	 * @param wsDetBuyerSeller the new value of wsDetBuyerSeller
	 */
	public void setWsDetBuyerSeller(String wsDetBuyerSeller) {
		this.wsDetBuyerSeller.setValue(wsDetBuyerSeller);
	}
	/**
	 * Gets the reference for attribute wsDetTradingXchng.
	 * @return the wsDetTradingXchng attribute reference
	 */
	public ElementaryRangeReference getWsDetTradingXchngReference() {
		return wsDetTradingXchng.getReference();
	}

	/**
	 * Getter for wsDetTradingXchng attribute.
	 * @return wsDetTradingXchng attribute
	 */
	public String getWsDetTradingXchng() {
		return wsDetTradingXchng.getValue();
	}

	/**
	 * Setter for wsDetTradingXchng attribute.
	 * @param wsDetTradingXchng the new value of wsDetTradingXchng
	 */
	public void setWsDetTradingXchng(String wsDetTradingXchng) {
		this.wsDetTradingXchng.setValue(wsDetTradingXchng);
	}
	/**
	 * Gets the reference for attribute wsDetFigi.
	 * @return the wsDetFigi attribute reference
	 */
	public ElementaryRangeReference getWsDetFigiReference() {
		return wsDetFigi.getReference();
	}

	/**
	 * Getter for wsDetFigi attribute.
	 * @return wsDetFigi attribute
	 */
	public String getWsDetFigi() {
		return wsDetFigi.getValue();
	}

	/**
	 * Setter for wsDetFigi attribute.
	 * @param wsDetFigi the new value of wsDetFigi
	 */
	public void setWsDetFigi(String wsDetFigi) {
		this.wsDetFigi.setValue(wsDetFigi);
	}
	/**
	 * Gets the reference for attribute wsDetSymbol.
	 * @return the wsDetSymbol attribute reference
	 */
	public ElementaryRangeReference getWsDetSymbolReference() {
		return wsDetSymbol.getReference();
	}

	/**
	 * Getter for wsDetSymbol attribute.
	 * @return wsDetSymbol attribute
	 */
	public String getWsDetSymbol() {
		return wsDetSymbol.getValue();
	}

	/**
	 * Setter for wsDetSymbol attribute.
	 * @param wsDetSymbol the new value of wsDetSymbol
	 */
	public void setWsDetSymbol(String wsDetSymbol) {
		this.wsDetSymbol.setValue(wsDetSymbol);
	}
	/**
	 * Gets the reference for attribute wsDetDescription.
	 * @return the wsDetDescription attribute reference
	 */
	public ElementaryRangeReference getWsDetDescriptionReference() {
		return wsDetDescription.getReference();
	}

	/**
	 * Getter for wsDetDescription attribute.
	 * @return wsDetDescription attribute
	 */
	public String getWsDetDescription() {
		return wsDetDescription.getValue();
	}

	/**
	 * Setter for wsDetDescription attribute.
	 * @param wsDetDescription the new value of wsDetDescription
	 */
	public void setWsDetDescription(String wsDetDescription) {
		this.wsDetDescription.setValue(wsDetDescription);
	}
	/**
	 * Gets the reference for attribute wsDetType.
	 * @return the wsDetType attribute reference
	 */
	public ElementaryRangeReference getWsDetTypeReference() {
		return wsDetType.getReference();
	}

	/**
	 * Getter for wsDetType attribute.
	 * @return wsDetType attribute
	 */
	public String getWsDetType() {
		return wsDetType.getValue();
	}

	/**
	 * Setter for wsDetType attribute.
	 * @param wsDetType the new value of wsDetType
	 */
	public void setWsDetType(String wsDetType) {
		this.wsDetType.setValue(wsDetType);
	}
	/**
	 * Gets the reference for attribute wsDetQuantity.
	 * @return the wsDetQuantity attribute reference
	 */
	public ElementaryRangeReference getWsDetQuantityReference() {
		return wsDetQuantity.getReference();
	}

	/**
	 * Getter for wsDetQuantity attribute.
	 * @return wsDetQuantity attribute
	 */
	public String getWsDetQuantity() {
		return wsDetQuantity.getValue();
	}

	/**
	 * Setter for wsDetQuantity attribute.
	 * @param wsDetQuantity the new value of wsDetQuantity
	 */
	public void setWsDetQuantity(String wsDetQuantity) {
		this.wsDetQuantity.setValue(wsDetQuantity);
	}
	/**
	 * Gets the reference for attribute wsDetCurrency.
	 * @return the wsDetCurrency attribute reference
	 */
	public ElementaryRangeReference getWsDetCurrencyReference() {
		return wsDetCurrency.getReference();
	}

	/**
	 * Getter for wsDetCurrency attribute.
	 * @return wsDetCurrency attribute
	 */
	public String getWsDetCurrency() {
		return wsDetCurrency.getValue();
	}

	/**
	 * Setter for wsDetCurrency attribute.
	 * @param wsDetCurrency the new value of wsDetCurrency
	 */
	public void setWsDetCurrency(String wsDetCurrency) {
		this.wsDetCurrency.setValue(wsDetCurrency);
	}
	/**
	 * Gets the reference for attribute wsDetAmount.
	 * @return the wsDetAmount attribute reference
	 */
	public ElementaryRangeReference getWsDetAmountReference() {
		return wsDetAmount.getReference();
	}

	/**
	 * Getter for wsDetAmount attribute.
	 * @return wsDetAmount attribute
	 */
	public String getWsDetAmount() {
		return wsDetAmount.getValue();
	}

	/**
	 * Setter for wsDetAmount attribute.
	 * @param wsDetAmount the new value of wsDetAmount
	 */
	public void setWsDetAmount(String wsDetAmount) {
		this.wsDetAmount.setValue(wsDetAmount);
	}
}
