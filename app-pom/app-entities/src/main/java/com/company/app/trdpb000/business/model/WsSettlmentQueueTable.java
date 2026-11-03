package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.FixedArray;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity WsSettlmentQueueTable.
 * 
 * <p>About 'wsStqIndex' field, <br>
 * </p>
 * 
 * <p>About 'wsStqCurrency' field, <br>
 * </p>
 * 
 * <p>About 'wsStqTrdpair' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsSettlmentQueueTable extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsStqIndex = new Elementary(root,new BinaryType(4, 0, "STD", false, false, true));
	private final Elementary wsStqCurrency = new Elementary(root,new FixedArray(100),new AlphanumericType(3));
	private final Elementary wsStqTrdpair = new Elementary(root,new FixedArray(100),new AlphanumericType(88));
	
	/**
	 * Instantiate a new WsSettlmentQueueTable with a default record.
	 * @param configuration the configuration
	 */
	public WsSettlmentQueueTable(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsSettlmentQueueTable bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsSettlmentQueueTable(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsStqIndex.
	 * @return the wsStqIndex attribute reference
	 */
	public ElementaryRangeReference getWsStqIndexReference() {
		return wsStqIndex.getReference();
	}

	/**
	 * Getter for wsStqIndex attribute.
	 * @return wsStqIndex attribute
	 */
	public int getWsStqIndex() {
		return wsStqIndex.getValue();
	}

	/**
	 * Setter for wsStqIndex attribute.
	 * @param wsStqIndex the new value of wsStqIndex
	 */
	public void setWsStqIndex(int wsStqIndex) {
		this.wsStqIndex.setValue(wsStqIndex);
	}
	/**
	 * Indexed getter for wsStqCurrency attribute.
	 * @param indexes the indexes
	 * @return wsStqCurrency attribute
	 */
	public ElementaryRangeReference getItemFromWsStqCurrencyReference(Integer... indexes) {
		return wsStqCurrency.getIndexedReference(indexes);
	}
	
	/**
	 * Indexed getter for wsStqCurrency attribute.
	 * @param indexes the indexes
	 * @return wsStqCurrency attribute
	 */
	public String getItemFromWsStqCurrency(Integer... indexes) {
		return wsStqCurrency.getIndexedValue(indexes);
	}
	
	/**
	 * Indexed setter for wsStqCurrency attribute.
	 * @param wsStqCurrency the new value of wsStqCurrency for given indexes
	 * @param indexes the indexes
	 */
	public void setItemFromWsStqCurrency(String wsStqCurrency,Integer... indexes) {
		this.wsStqCurrency.setIndexedValue(wsStqCurrency,indexes);
	}
	
	/**
	 * Collection size getter for wsStqCurrency attribute.
	 * @return  the collection size for attributewsStqCurrency
	 */
	public int getWsStqCurrencySize(){
		return wsStqCurrency.getRepetition().getCount();
	}
	
	/**
	 * Indexed getter for wsStqCurrency attribute.
	 * @param indexes the indexes
	 * @return wsStqCurrency attribute
	 */
	public ElementaryRangeReference getWsStqCurrencyReference() {
		return wsStqCurrency.getReference();
	}
	
	/**
	 * Indexed getter for wsStqCurrency attribute.
	 * @param indexes the indexes
	 * @return wsStqCurrency attribute
	 */
	public String getWsStqCurrency() {
		return wsStqCurrency.getValue();
	}
	
	/**
	 * Indexed setter for wsStqCurrency attribute.
	 * @param wsStqCurrency the new value of wsStqCurrency for given indexes
	 * @param indexes the indexes
	 */
	public void setWsStqCurrency(String wsStqCurrency) {
		this.wsStqCurrency.setValue(wsStqCurrency);
	}
	
	/**
	 * Indexed getter for wsStqTrdpair attribute.
	 * @param indexes the indexes
	 * @return wsStqTrdpair attribute
	 */
	public ElementaryRangeReference getItemFromWsStqTrdpairReference(Integer... indexes) {
		return wsStqTrdpair.getIndexedReference(indexes);
	}
	
	/**
	 * Indexed getter for wsStqTrdpair attribute.
	 * @param indexes the indexes
	 * @return wsStqTrdpair attribute
	 */
	public String getItemFromWsStqTrdpair(Integer... indexes) {
		return wsStqTrdpair.getIndexedValue(indexes);
	}
	
	/**
	 * Indexed setter for wsStqTrdpair attribute.
	 * @param wsStqTrdpair the new value of wsStqTrdpair for given indexes
	 * @param indexes the indexes
	 */
	public void setItemFromWsStqTrdpair(String wsStqTrdpair,Integer... indexes) {
		this.wsStqTrdpair.setIndexedValue(wsStqTrdpair,indexes);
	}
	
	/**
	 * Collection size getter for wsStqTrdpair attribute.
	 * @return  the collection size for attributewsStqTrdpair
	 */
	public int getWsStqTrdpairSize(){
		return wsStqTrdpair.getRepetition().getCount();
	}
	
	/**
	 * Indexed getter for wsStqTrdpair attribute.
	 * @param indexes the indexes
	 * @return wsStqTrdpair attribute
	 */
	public ElementaryRangeReference getWsStqTrdpairReference() {
		return wsStqTrdpair.getReference();
	}
	
	/**
	 * Indexed getter for wsStqTrdpair attribute.
	 * @param indexes the indexes
	 * @return wsStqTrdpair attribute
	 */
	public String getWsStqTrdpair() {
		return wsStqTrdpair.getValue();
	}
	
	/**
	 * Indexed setter for wsStqTrdpair attribute.
	 * @param wsStqTrdpair the new value of wsStqTrdpair for given indexes
	 * @param indexes the indexes
	 */
	public void setWsStqTrdpair(String wsStqTrdpair) {
		this.wsStqTrdpair.setValue(wsStqTrdpair);
	}
	
}
