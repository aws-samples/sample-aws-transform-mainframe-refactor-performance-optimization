package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity SacCurrency.
<pre>
 * 
 * Legacy Documentation:<br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDSAC                     *<br>
 *  ****************************************************************<br>
</pre>
 * 
 * <p>About 'sacCurrency' field, <br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDSAC                     *<br>
 *  ****************************************************************<br></p>
 * 
 * @see RecordEntity
 */
public class SacCurrency extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * ****************************************************************
	 * COBOL DECLARATION FOR TABLE TRADE.TBTRDSAC                     *
	 * ****************************************************************
	 */
	private final Elementary sacCurrency = new Elementary(root,new AlphanumericType(3));
	
	/**
	 * Instantiate a new SacCurrency with a default record.
	 * @param configuration the configuration
	 */
	public SacCurrency(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SacCurrency bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SacCurrency(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute sacCurrency.
	 * @return the sacCurrency attribute reference
	 */
	public ElementaryRangeReference getSacCurrencyReference() {
		return sacCurrency.getReference();
	}

	/**
	 * Getter for sacCurrency attribute.
	 * @return sacCurrency attribute
	 */
	public String getSacCurrency() {
		return sacCurrency.getValue();
	}

	/**
	 * Setter for sacCurrency attribute.
	 * @param sacCurrency the new value of sacCurrency
	 */
	public void setSacCurrency(String sacCurrency) {
		this.sacCurrency.setValue(sacCurrency);
	}
}
