package com.company.app.trdpb001.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity ExceptionRecordLen.
 * 
 * <p>About 'exceptionRecordLen' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class ExceptionRecordLen extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * 
	 */
	private final Elementary exceptionRecordLen = new Elementary(root,new BinaryType(4, 0, "STD", false, false, true));
	
	/**
	 * Instantiate a new ExceptionRecordLen with a default record.
	 * @param configuration the configuration
	 */
	public ExceptionRecordLen(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new ExceptionRecordLen bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public ExceptionRecordLen(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute exceptionRecordLen.
	 * @return the exceptionRecordLen attribute reference
	 */
	public ElementaryRangeReference getExceptionRecordLenReference() {
		return exceptionRecordLen.getReference();
	}

	/**
	 * Getter for exceptionRecordLen attribute.
	 * @return exceptionRecordLen attribute
	 */
	public int getExceptionRecordLen() {
		return exceptionRecordLen.getValue();
	}

	/**
	 * Setter for exceptionRecordLen attribute.
	 * @param exceptionRecordLen the new value of exceptionRecordLen
	 */
	public void setExceptionRecordLen(int exceptionRecordLen) {
		this.exceptionRecordLen.setValue(exceptionRecordLen);
	}
}
