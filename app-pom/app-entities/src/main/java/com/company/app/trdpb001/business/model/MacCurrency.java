package com.company.app.trdpb001.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity MacCurrency.
<pre>
 * 
 * Legacy Documentation:<br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDMAC                     *<br>
 *  ****************************************************************<br>
</pre>
 * 
 * <p>About 'macCurrency' field, <br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDMAC                     *<br>
 *  ****************************************************************<br></p>
 * 
 * @see RecordEntity
 */
public class MacCurrency extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * ****************************************************************
	 * COBOL DECLARATION FOR TABLE TRADE.TBTRDMAC                     *
	 * ****************************************************************
	 */
	private final Elementary macCurrency = new Elementary(root,new AlphanumericType(3));
	
	/**
	 * Instantiate a new MacCurrency with a default record.
	 * @param configuration the configuration
	 */
	public MacCurrency(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new MacCurrency bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public MacCurrency(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute macCurrency.
	 * @return the macCurrency attribute reference
	 */
	public ElementaryRangeReference getMacCurrencyReference() {
		return macCurrency.getReference();
	}

	/**
	 * Getter for macCurrency attribute.
	 * @return macCurrency attribute
	 */
	public String getMacCurrency() {
		return macCurrency.getValue();
	}

	/**
	 * Setter for macCurrency attribute.
	 * @param macCurrency the new value of macCurrency
	 */
	public void setMacCurrency(String macCurrency) {
		this.macCurrency.setValue(macCurrency);
	}
}
