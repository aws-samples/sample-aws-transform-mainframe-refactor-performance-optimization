package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity SumCustomerId.
<pre>
 * 
 * Legacy Documentation:<br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDSUM                     *<br>
 *  ****************************************************************<br>
</pre>
 * 
 * <p>About 'sumCustomerId' field, <br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDSUM                     *<br>
 *  ****************************************************************<br></p>
 * 
 * @see RecordEntity
 */
public class SumCustomerId extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * ****************************************************************
	 * COBOL DECLARATION FOR TABLE TRADE.TBTRDSUM                     *
	 * ****************************************************************
	 */
	private final Elementary sumCustomerId = new Elementary(root,new AlphanumericType(12));
	
	/**
	 * Instantiate a new SumCustomerId with a default record.
	 * @param configuration the configuration
	 */
	public SumCustomerId(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SumCustomerId bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SumCustomerId(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute sumCustomerId.
	 * @return the sumCustomerId attribute reference
	 */
	public ElementaryRangeReference getSumCustomerIdReference() {
		return sumCustomerId.getReference();
	}

	/**
	 * Getter for sumCustomerId attribute.
	 * @return sumCustomerId attribute
	 */
	public String getSumCustomerId() {
		return sumCustomerId.getValue();
	}

	/**
	 * Setter for sumCustomerId attribute.
	 * @param sumCustomerId the new value of sumCustomerId
	 */
	public void setSumCustomerId(String sumCustomerId) {
		this.sumCustomerId.setValue(sumCustomerId);
	}
}
