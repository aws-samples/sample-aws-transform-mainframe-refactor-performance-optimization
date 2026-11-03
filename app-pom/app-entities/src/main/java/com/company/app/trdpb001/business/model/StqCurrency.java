package com.company.app.trdpb001.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity StqCurrency.
<pre>
 * 
 * Legacy Documentation:<br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDSTQ                     *<br>
 *  ****************************************************************<br>
</pre>
 * 
 * <p>About 'stqCurrency' field, <br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDSTQ                     *<br>
 *  ****************************************************************<br></p>
 * 
 * @see RecordEntity
 */
public class StqCurrency extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * ****************************************************************
	 * COBOL DECLARATION FOR TABLE TRADE.TBTRDSTQ                     *
	 * ****************************************************************
	 */
	private final Elementary stqCurrency = new Elementary(root,new AlphanumericType(3));
	
	/**
	 * Instantiate a new StqCurrency with a default record.
	 * @param configuration the configuration
	 */
	public StqCurrency(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new StqCurrency bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public StqCurrency(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute stqCurrency.
	 * @return the stqCurrency attribute reference
	 */
	public ElementaryRangeReference getStqCurrencyReference() {
		return stqCurrency.getReference();
	}

	/**
	 * Getter for stqCurrency attribute.
	 * @return stqCurrency attribute
	 */
	public String getStqCurrency() {
		return stqCurrency.getValue();
	}

	/**
	 * Setter for stqCurrency attribute.
	 * @param stqCurrency the new value of stqCurrency
	 */
	public void setStqCurrency(String stqCurrency) {
		this.stqCurrency.setValue(stqCurrency);
	}
}
