package com.company.app.trdpb001.business.model;

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
 * Data simplifier entity WsExcpType.
 * 
 * <p>About 'wsExcpType' field, <br>
 * </p>
 * 
 * <p>About 'noExceptions' field, <br>
 * </p>
 * 
 * <p>About 'systemException' field, <br>
 * </p>
 * 
 * <p>About 'applException' field, <br>
 * </p>
 * 
 * <p>About 'dataException' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsExcpType extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * 
	 */
	private final Elementary wsExcpType = new Elementary(root,new AlphanumericType(1));
	private final ConditionName noExceptions = new ConditionName(wsExcpType,
		Arrays.asList("N"));
	private final ConditionName systemException = new ConditionName(wsExcpType,
		Arrays.asList("S"));
	private final ConditionName applException = new ConditionName(wsExcpType,
		Arrays.asList("A"));
	private final ConditionName dataException = new ConditionName(wsExcpType,
		Arrays.asList("D"));
	
	/**
	 * Instantiate a new WsExcpType with a default record.
	 * @param configuration the configuration
	 */
	public WsExcpType(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsExcpType bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsExcpType(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsExcpType.
	 * @return the wsExcpType attribute reference
	 */
	public ElementaryRangeReference getWsExcpTypeReference() {
		return wsExcpType.getReference();
	}

	/**
	 * Getter for wsExcpType attribute.
	 * @return wsExcpType attribute
	 */
	public String getWsExcpType() {
		return wsExcpType.getValue();
	}

	/**
	 * Setter for wsExcpType attribute.
	 * @param wsExcpType the new value of wsExcpType
	 */
	public void setWsExcpType(String wsExcpType) {
		this.wsExcpType.setValue(wsExcpType);
	}
	/**
	 * Gets the reference for attribute noExceptions.
	 * @return the noExceptions attribute reference
	 */
	public ConditionReference getNoExceptionsReference() {
		return wsExcpType.getCondition(noExceptions);	
	}

	/**
	 * Getter for noExceptions attribute.
	 * @return noExceptions attribute
	 */
	public boolean isNoExceptions() {
		return getNoExceptionsReference().getValue();	
	}

	/**
	 * Setter for noExceptions attribute.
	 * @param noExceptions the new value of noExceptions
	 */
	public void setNoExceptions(boolean noExceptions) {
		getNoExceptionsReference().setValue(noExceptions);	
	}
	/**
	 * Gets the reference for attribute systemException.
	 * @return the systemException attribute reference
	 */
	public ConditionReference getSystemExceptionReference() {
		return wsExcpType.getCondition(systemException);	
	}

	/**
	 * Getter for systemException attribute.
	 * @return systemException attribute
	 */
	public boolean isSystemException() {
		return getSystemExceptionReference().getValue();	
	}

	/**
	 * Setter for systemException attribute.
	 * @param systemException the new value of systemException
	 */
	public void setSystemException(boolean systemException) {
		getSystemExceptionReference().setValue(systemException);	
	}
	/**
	 * Gets the reference for attribute applException.
	 * @return the applException attribute reference
	 */
	public ConditionReference getApplExceptionReference() {
		return wsExcpType.getCondition(applException);	
	}

	/**
	 * Getter for applException attribute.
	 * @return applException attribute
	 */
	public boolean isApplException() {
		return getApplExceptionReference().getValue();	
	}

	/**
	 * Setter for applException attribute.
	 * @param applException the new value of applException
	 */
	public void setApplException(boolean applException) {
		getApplExceptionReference().setValue(applException);	
	}
	/**
	 * Gets the reference for attribute dataException.
	 * @return the dataException attribute reference
	 */
	public ConditionReference getDataExceptionReference() {
		return wsExcpType.getCondition(dataException);	
	}

	/**
	 * Getter for dataException attribute.
	 * @return dataException attribute
	 */
	public boolean isDataException() {
		return getDataExceptionReference().getValue();	
	}

	/**
	 * Setter for dataException attribute.
	 * @param dataException the new value of dataException
	 */
	public void setDataException(boolean dataException) {
		getDataExceptionReference().setValue(dataException);	
	}
}
