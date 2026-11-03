package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Filler;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity PrtRunlogRec.
 * 
 * <p>About 'prtRunlogTransaction' field, <br>
 * </p>
 * 
 * <p>About 'prtRunlogCurrency' field, <br>
 * </p>
 * 
 * <p>About 'prtRunlogStartTs' field, <br>
 * </p>
 * 
 * <p>About 'prtRunlogEndTs' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class PrtRunlogRec extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(2),"| ");
	private final Elementary prtRunlogTransaction = new Elementary(root,new AlphanumericType(12));
	@SuppressWarnings("unused")
	private final Filler filler1 = new Filler(root,new AlphanumericType(3)," | ");
	private final Elementary prtRunlogCurrency = new Elementary(root,new AlphanumericType(8));
	@SuppressWarnings("unused")
	private final Filler filler2 = new Filler(root,new AlphanumericType(3)," | ");
	private final Elementary prtRunlogStartTs = new Elementary(root,new AlphanumericType(26));
	@SuppressWarnings("unused")
	private final Filler filler3 = new Filler(root,new AlphanumericType(3)," | ");
	private final Elementary prtRunlogEndTs = new Elementary(root,new AlphanumericType(26));
	@SuppressWarnings("unused")
	private final Filler filler4 = new Filler(root,new AlphanumericType(3)," | ");
	
	/**
	 * Instantiate a new PrtRunlogRec with a default record.
	 * @param configuration the configuration
	 */
	public PrtRunlogRec(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new PrtRunlogRec bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public PrtRunlogRec(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute prtRunlogTransaction.
	 * @return the prtRunlogTransaction attribute reference
	 */
	public ElementaryRangeReference getPrtRunlogTransactionReference() {
		return prtRunlogTransaction.getReference();
	}

	/**
	 * Getter for prtRunlogTransaction attribute.
	 * @return prtRunlogTransaction attribute
	 */
	public String getPrtRunlogTransaction() {
		return prtRunlogTransaction.getValue();
	}

	/**
	 * Setter for prtRunlogTransaction attribute.
	 * @param prtRunlogTransaction the new value of prtRunlogTransaction
	 */
	public void setPrtRunlogTransaction(String prtRunlogTransaction) {
		this.prtRunlogTransaction.setValue(prtRunlogTransaction);
	}
	/**
	 * Gets the reference for attribute prtRunlogCurrency.
	 * @return the prtRunlogCurrency attribute reference
	 */
	public ElementaryRangeReference getPrtRunlogCurrencyReference() {
		return prtRunlogCurrency.getReference();
	}

	/**
	 * Getter for prtRunlogCurrency attribute.
	 * @return prtRunlogCurrency attribute
	 */
	public String getPrtRunlogCurrency() {
		return prtRunlogCurrency.getValue();
	}

	/**
	 * Setter for prtRunlogCurrency attribute.
	 * @param prtRunlogCurrency the new value of prtRunlogCurrency
	 */
	public void setPrtRunlogCurrency(String prtRunlogCurrency) {
		this.prtRunlogCurrency.setValue(prtRunlogCurrency);
	}
	/**
	 * Gets the reference for attribute prtRunlogStartTs.
	 * @return the prtRunlogStartTs attribute reference
	 */
	public ElementaryRangeReference getPrtRunlogStartTsReference() {
		return prtRunlogStartTs.getReference();
	}

	/**
	 * Getter for prtRunlogStartTs attribute.
	 * @return prtRunlogStartTs attribute
	 */
	public String getPrtRunlogStartTs() {
		return prtRunlogStartTs.getValue();
	}

	/**
	 * Setter for prtRunlogStartTs attribute.
	 * @param prtRunlogStartTs the new value of prtRunlogStartTs
	 */
	public void setPrtRunlogStartTs(String prtRunlogStartTs) {
		this.prtRunlogStartTs.setValue(prtRunlogStartTs);
	}
	/**
	 * Gets the reference for attribute prtRunlogEndTs.
	 * @return the prtRunlogEndTs attribute reference
	 */
	public ElementaryRangeReference getPrtRunlogEndTsReference() {
		return prtRunlogEndTs.getReference();
	}

	/**
	 * Getter for prtRunlogEndTs attribute.
	 * @return prtRunlogEndTs attribute
	 */
	public String getPrtRunlogEndTs() {
		return prtRunlogEndTs.getValue();
	}

	/**
	 * Setter for prtRunlogEndTs attribute.
	 * @param prtRunlogEndTs the new value of prtRunlogEndTs
	 */
	public void setPrtRunlogEndTs(String prtRunlogEndTs) {
		this.prtRunlogEndTs.setValue(prtRunlogEndTs);
	}
}
