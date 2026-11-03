package com.company.app.ilboabn0.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity LkAbendCode.
<pre>
 * 
 * Legacy Documentation:<br>
 *  <br>
 *  <br>
 *   Must match WS-ABEND-CODE in cobol/TRDPBEXC: PIC 9(04) COMP.<br>
 *  <br>
</pre>
 * 
 * <p>About 'lkAbendCode' field, <br>
 *  <br>
 *  <br>
 *   Must match WS-ABEND-CODE in cobol/TRDPBEXC: PIC 9(04) COMP.<br>
 *  <br></p>
 * 
 * @see RecordEntity
 */
public class LkAbendCode extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * 
	 * 
	 * Must match WS-ABEND-CODE in cobol/TRDPBEXC: PIC 9(04) COMP.
	 * 
	 */
	private final Elementary lkAbendCode = new Elementary(root,new BinaryType(4, 0, "STD", false));
	
	/**
	 * Instantiate a new LkAbendCode with a default record.
	 * @param configuration the configuration
	 */
	public LkAbendCode(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new LkAbendCode bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public LkAbendCode(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute lkAbendCode.
	 * @return the lkAbendCode attribute reference
	 */
	public ElementaryRangeReference getLkAbendCodeReference() {
		return lkAbendCode.getReference();
	}

	/**
	 * Getter for lkAbendCode attribute.
	 * @return lkAbendCode attribute
	 */
	public int getLkAbendCode() {
		return lkAbendCode.getValue();
	}

	/**
	 * Setter for lkAbendCode attribute.
	 * @param lkAbendCode the new value of lkAbendCode
	 */
	public void setLkAbendCode(int lkAbendCode) {
		this.lkAbendCode.setValue(lkAbendCode);
	}
}
