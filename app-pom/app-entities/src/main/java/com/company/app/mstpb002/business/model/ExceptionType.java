package com.company.app.mstpb002.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ConditionReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.ConditionName;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import java.util.Arrays;
/**
 * Data simplifier entity ExceptionType.
<pre>
 * 
 * Legacy Documentation:<br>
 *     05 EXCEPTION-TIMESTAMP            PIC X(26).<br>
 *  <br>
</pre>
 * 
 * <p>About 'exceptionType' field, <br>
 *     05 EXCEPTION-TIMESTAMP            PIC X(26).<br>
 *  <br></p>
 * 
 * <p>About 'exceptionSystem' field, <br>
 * </p>
 * 
 * <p>About 'exceptionApplication' field, <br>
 * </p>
 * 
 * <p>About 'exceptionData' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class ExceptionType extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * 05 EXCEPTION-TIMESTAMP            PIC X(26).
	 * 
	 */
	private final Elementary exceptionType = new Elementary(root,new AlphanumericType(20));
	private final ConditionName exceptionSystem = new ConditionName(exceptionType,
		Arrays.asList("SYSTEM"));
	private final ConditionName exceptionApplication = new ConditionName(exceptionType,
		Arrays.asList("APPLICATION"));
	private final ConditionName exceptionData = new ConditionName(exceptionType,
		Arrays.asList("DATA"));
	
	/**
	 * Instantiate a new ExceptionType with a default record.
	 * @param configuration the configuration
	 */
	public ExceptionType(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new ExceptionType bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public ExceptionType(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute exceptionType.
	 * @return the exceptionType attribute reference
	 */
	public ElementaryRangeReference getExceptionTypeReference() {
		return exceptionType.getReference();
	}

	/**
	 * Getter for exceptionType attribute.
	 * @return exceptionType attribute
	 */
	public String getExceptionType() {
		return exceptionType.getValue();
	}

	/**
	 * Setter for exceptionType attribute.
	 * @param exceptionType the new value of exceptionType
	 */
	public void setExceptionType(String exceptionType) {
		this.exceptionType.setValue(exceptionType);
	}
	/**
	 * Gets the reference for attribute exceptionSystem.
	 * @return the exceptionSystem attribute reference
	 */
	public ConditionReference getExceptionSystemReference() {
		return exceptionType.getCondition(exceptionSystem);	
	}

	/**
	 * Getter for exceptionSystem attribute.
	 * @return exceptionSystem attribute
	 */
	public boolean isExceptionSystem() {
		return getExceptionSystemReference().getValue();	
	}

	/**
	 * Setter for exceptionSystem attribute.
	 * @param exceptionSystem the new value of exceptionSystem
	 */
	public void setExceptionSystem(boolean exceptionSystem) {
		getExceptionSystemReference().setValue(exceptionSystem);	
	}
	/**
	 * Gets the reference for attribute exceptionApplication.
	 * @return the exceptionApplication attribute reference
	 */
	public ConditionReference getExceptionApplicationReference() {
		return exceptionType.getCondition(exceptionApplication);	
	}

	/**
	 * Getter for exceptionApplication attribute.
	 * @return exceptionApplication attribute
	 */
	public boolean isExceptionApplication() {
		return getExceptionApplicationReference().getValue();	
	}

	/**
	 * Setter for exceptionApplication attribute.
	 * @param exceptionApplication the new value of exceptionApplication
	 */
	public void setExceptionApplication(boolean exceptionApplication) {
		getExceptionApplicationReference().setValue(exceptionApplication);	
	}
	/**
	 * Gets the reference for attribute exceptionData.
	 * @return the exceptionData attribute reference
	 */
	public ConditionReference getExceptionDataReference() {
		return exceptionType.getCondition(exceptionData);	
	}

	/**
	 * Getter for exceptionData attribute.
	 * @return exceptionData attribute
	 */
	public boolean isExceptionData() {
		return getExceptionDataReference().getValue();	
	}

	/**
	 * Setter for exceptionData attribute.
	 * @param exceptionData the new value of exceptionData
	 */
	public void setExceptionData(boolean exceptionData) {
		getExceptionDataReference().setValue(exceptionData);	
	}
}
