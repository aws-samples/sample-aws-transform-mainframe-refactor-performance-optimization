package com.company.app.mstpb001.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity CusCustomerId.
<pre>
 * 
 * Legacy Documentation:<br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDCUS                     *<br>
 *  ****************************************************************<br>
</pre>
 * 
 * <p>About 'cusCustomerId' field, <br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDCUS                     *<br>
 *  ****************************************************************<br></p>
 * 
 * @see RecordEntity
 */
public class CusCustomerId extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * ****************************************************************
	 * COBOL DECLARATION FOR TABLE TRADE.TBTRDCUS                     *
	 * ****************************************************************
	 */
	private final Elementary cusCustomerId = new Elementary(root,new AlphanumericType(12));
	
	/**
	 * Instantiate a new CusCustomerId with a default record.
	 * @param configuration the configuration
	 */
	public CusCustomerId(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new CusCustomerId bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public CusCustomerId(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute cusCustomerId.
	 * @return the cusCustomerId attribute reference
	 */
	public ElementaryRangeReference getCusCustomerIdReference() {
		return cusCustomerId.getReference();
	}

	/**
	 * Getter for cusCustomerId attribute.
	 * @return cusCustomerId attribute
	 */
	public String getCusCustomerId() {
		return cusCustomerId.getValue();
	}

	/**
	 * Setter for cusCustomerId attribute.
	 * @param cusCustomerId the new value of cusCustomerId
	 */
	public void setCusCustomerId(String cusCustomerId) {
		this.cusCustomerId.setValue(cusCustomerId);
	}
}
