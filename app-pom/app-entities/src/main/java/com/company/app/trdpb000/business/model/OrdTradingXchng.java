package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity OrdTradingXchng.
<pre>
 * 
 * Legacy Documentation:<br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDORD                     *<br>
 *  ****************************************************************<br>
</pre>
 * 
 * <p>About 'ordTradingXchng' field, <br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDORD                     *<br>
 *  ****************************************************************<br></p>
 * 
 * @see RecordEntity
 */
public class OrdTradingXchng extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * ****************************************************************
	 * COBOL DECLARATION FOR TABLE TRADE.TBTRDORD                     *
	 * ****************************************************************
	 */
	private final Elementary ordTradingXchng = new Elementary(root,new AlphanumericType(10));
	
	/**
	 * Instantiate a new OrdTradingXchng with a default record.
	 * @param configuration the configuration
	 */
	public OrdTradingXchng(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new OrdTradingXchng bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public OrdTradingXchng(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute ordTradingXchng.
	 * @return the ordTradingXchng attribute reference
	 */
	public ElementaryRangeReference getOrdTradingXchngReference() {
		return ordTradingXchng.getReference();
	}

	/**
	 * Getter for ordTradingXchng attribute.
	 * @return ordTradingXchng attribute
	 */
	public String getOrdTradingXchng() {
		return ordTradingXchng.getValue();
	}

	/**
	 * Setter for ordTradingXchng attribute.
	 * @param ordTradingXchng the new value of ordTradingXchng
	 */
	public void setOrdTradingXchng(String ordTradingXchng) {
		this.ordTradingXchng.setValue(ordTradingXchng);
	}
}
