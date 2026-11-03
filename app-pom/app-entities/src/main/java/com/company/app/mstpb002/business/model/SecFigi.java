package com.company.app.mstpb002.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity SecFigi.
<pre>
 * 
 * Legacy Documentation:<br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDSEC                     *<br>
 *  ****************************************************************<br>
</pre>
 * 
 * <p>About 'secFigi' field, <br>
 *  ****************************************************************<br>
 *   COBOL DECLARATION FOR TABLE TRADE.TBTRDSEC                     *<br>
 *  ****************************************************************<br></p>
 * 
 * @see RecordEntity
 */
public class SecFigi extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * ****************************************************************
	 * COBOL DECLARATION FOR TABLE TRADE.TBTRDSEC                     *
	 * ****************************************************************
	 */
	private final Elementary secFigi = new Elementary(root,new AlphanumericType(12));
	
	/**
	 * Instantiate a new SecFigi with a default record.
	 * @param configuration the configuration
	 */
	public SecFigi(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SecFigi bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SecFigi(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute secFigi.
	 * @return the secFigi attribute reference
	 */
	public ElementaryRangeReference getSecFigiReference() {
		return secFigi.getReference();
	}

	/**
	 * Getter for secFigi attribute.
	 * @return secFigi attribute
	 */
	public String getSecFigi() {
		return secFigi.getValue();
	}

	/**
	 * Setter for secFigi attribute.
	 * @param secFigi the new value of secFigi
	 */
	public void setSecFigi(String secFigi) {
		this.secFigi.setValue(secFigi);
	}
}
