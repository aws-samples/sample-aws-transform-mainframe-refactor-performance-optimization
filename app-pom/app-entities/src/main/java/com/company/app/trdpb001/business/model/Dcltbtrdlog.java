package com.company.app.trdpb001.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity Dcltbtrdlog.
<pre>
 * 
 * Legacy Documentation:<br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDLOG                     *<br>
 *  ****************************************************************<br>
</pre>
 * 
 * <p>About 'logTransaction' field, <br>
 * </p>
 * 
 * <p>About 'logCurrency' field, <br>
 * </p>
 * 
 * <p>About 'logStartTs' field, <br>
 * </p>
 * 
 * <p>About 'logEndTs' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class Dcltbtrdlog extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary logTransaction = new Elementary(root,new AlphanumericType(10));
	private final Elementary logCurrency = new Elementary(root,new AlphanumericType(3));
	private final Elementary logStartTs = new Elementary(root,new AlphanumericType(26));
	private final Elementary logEndTs = new Elementary(root,new AlphanumericType(26));
	
	/**
	 * Instantiate a new Dcltbtrdlog with a default record.
	 * @param configuration the configuration
	 */
	public Dcltbtrdlog(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new Dcltbtrdlog bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public Dcltbtrdlog(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute logTransaction.
	 * @return the logTransaction attribute reference
	 */
	public ElementaryRangeReference getLogTransactionReference() {
		return logTransaction.getReference();
	}

	/**
	 * Getter for logTransaction attribute.
	 * @return logTransaction attribute
	 */
	public String getLogTransaction() {
		return logTransaction.getValue();
	}

	/**
	 * Setter for logTransaction attribute.
	 * @param logTransaction the new value of logTransaction
	 */
	public void setLogTransaction(String logTransaction) {
		this.logTransaction.setValue(logTransaction);
	}
	/**
	 * Gets the reference for attribute logCurrency.
	 * @return the logCurrency attribute reference
	 */
	public ElementaryRangeReference getLogCurrencyReference() {
		return logCurrency.getReference();
	}

	/**
	 * Getter for logCurrency attribute.
	 * @return logCurrency attribute
	 */
	public String getLogCurrency() {
		return logCurrency.getValue();
	}

	/**
	 * Setter for logCurrency attribute.
	 * @param logCurrency the new value of logCurrency
	 */
	public void setLogCurrency(String logCurrency) {
		this.logCurrency.setValue(logCurrency);
	}
	/**
	 * Gets the reference for attribute logStartTs.
	 * @return the logStartTs attribute reference
	 */
	public ElementaryRangeReference getLogStartTsReference() {
		return logStartTs.getReference();
	}

	/**
	 * Getter for logStartTs attribute.
	 * @return logStartTs attribute
	 */
	public String getLogStartTs() {
		return logStartTs.getValue();
	}

	/**
	 * Setter for logStartTs attribute.
	 * @param logStartTs the new value of logStartTs
	 */
	public void setLogStartTs(String logStartTs) {
		this.logStartTs.setValue(logStartTs);
	}
	/**
	 * Gets the reference for attribute logEndTs.
	 * @return the logEndTs attribute reference
	 */
	public ElementaryRangeReference getLogEndTsReference() {
		return logEndTs.getReference();
	}

	/**
	 * Getter for logEndTs attribute.
	 * @return logEndTs attribute
	 */
	public String getLogEndTs() {
		return logEndTs.getValue();
	}

	/**
	 * Setter for logEndTs attribute.
	 * @param logEndTs the new value of logEndTs
	 */
	public void setLogEndTs(String logEndTs) {
		this.logEndTs.setValue(logEndTs);
	}
}
