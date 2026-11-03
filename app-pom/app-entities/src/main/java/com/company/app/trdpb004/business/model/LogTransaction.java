package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity LogTransaction.
<pre>
 * 
 * Legacy Documentation:<br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDLOG                     *<br>
 *  ****************************************************************<br>
</pre>
 * 
 * <p>About 'logTransaction' field, <br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDLOG                     *<br>
 *  ****************************************************************<br></p>
 * 
 * @see RecordEntity
 */
public class LogTransaction extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * ****************************************************************
	 * COBOL DECLARATION FOR TABLE TRADE.TBTRDLOG                     *
	 * ****************************************************************
	 */
	private final Elementary logTransaction = new Elementary(root,new AlphanumericType(10));
	
	/**
	 * Instantiate a new LogTransaction with a default record.
	 * @param configuration the configuration
	 */
	public LogTransaction(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new LogTransaction bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public LogTransaction(Configuration configuration, RecordAdaptable existingRecord) {
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
}
