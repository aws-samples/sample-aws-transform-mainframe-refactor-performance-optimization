package com.company.app.trdpb000.business.model;

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
 * Data simplifier entity WsCustomerIo.
 * 
 * <p>About 'wsCustomerId' field, <br>
 * </p>
 * 
 * <p>About 'wsCustomerCurrency' field, <br>
 * </p>
 * 
 * <p>About 'wsCustomerDescription' field, <br>
 * </p>
 * 
 * <p>About 'wsCustomerErrorMsg' field, <br>
 * </p>
 * 
 * <p>About 'wsCustomerStatus' field, <br>
 * </p>
 * 
 * <p>About 'customerNotFound' field, <br>
 * </p>
 * 
 * <p>About 'customerActive' field, <br>
 * </p>
 * 
 * <p>About 'customerInactive' field, <br>
 * </p>
 * 
 * <p>About 'customerException' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsCustomerIo extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsCustomerId = new Elementary(root,new AlphanumericType(12));
	private final Elementary wsCustomerCurrency = new Elementary(root,new AlphanumericType(3));
	private final Elementary wsCustomerDescription = new Elementary(root,new AlphanumericType(40));
	private final Elementary wsCustomerErrorMsg = new Elementary(root,new AlphanumericType(200));
	private final Elementary wsCustomerStatus = new Elementary(root,new AlphanumericType(1));
	private final ConditionName customerNotFound = new ConditionName(wsCustomerStatus,
		Arrays.asList("N"));
	private final ConditionName customerActive = new ConditionName(wsCustomerStatus,
		Arrays.asList("A"));
	private final ConditionName customerInactive = new ConditionName(wsCustomerStatus,
		Arrays.asList("I"));
	private final ConditionName customerException = new ConditionName(wsCustomerStatus,
		Arrays.asList("S"));
	
	/**
	 * Instantiate a new WsCustomerIo with a default record.
	 * @param configuration the configuration
	 */
	public WsCustomerIo(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsCustomerIo bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsCustomerIo(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsCustomerId.
	 * @return the wsCustomerId attribute reference
	 */
	public ElementaryRangeReference getWsCustomerIdReference() {
		return wsCustomerId.getReference();
	}

	/**
	 * Getter for wsCustomerId attribute.
	 * @return wsCustomerId attribute
	 */
	public String getWsCustomerId() {
		return wsCustomerId.getValue();
	}

	/**
	 * Setter for wsCustomerId attribute.
	 * @param wsCustomerId the new value of wsCustomerId
	 */
	public void setWsCustomerId(String wsCustomerId) {
		this.wsCustomerId.setValue(wsCustomerId);
	}
	/**
	 * Gets the reference for attribute wsCustomerCurrency.
	 * @return the wsCustomerCurrency attribute reference
	 */
	public ElementaryRangeReference getWsCustomerCurrencyReference() {
		return wsCustomerCurrency.getReference();
	}

	/**
	 * Getter for wsCustomerCurrency attribute.
	 * @return wsCustomerCurrency attribute
	 */
	public String getWsCustomerCurrency() {
		return wsCustomerCurrency.getValue();
	}

	/**
	 * Setter for wsCustomerCurrency attribute.
	 * @param wsCustomerCurrency the new value of wsCustomerCurrency
	 */
	public void setWsCustomerCurrency(String wsCustomerCurrency) {
		this.wsCustomerCurrency.setValue(wsCustomerCurrency);
	}
	/**
	 * Gets the reference for attribute wsCustomerDescription.
	 * @return the wsCustomerDescription attribute reference
	 */
	public ElementaryRangeReference getWsCustomerDescriptionReference() {
		return wsCustomerDescription.getReference();
	}

	/**
	 * Getter for wsCustomerDescription attribute.
	 * @return wsCustomerDescription attribute
	 */
	public String getWsCustomerDescription() {
		return wsCustomerDescription.getValue();
	}

	/**
	 * Setter for wsCustomerDescription attribute.
	 * @param wsCustomerDescription the new value of wsCustomerDescription
	 */
	public void setWsCustomerDescription(String wsCustomerDescription) {
		this.wsCustomerDescription.setValue(wsCustomerDescription);
	}
	/**
	 * Gets the reference for attribute wsCustomerErrorMsg.
	 * @return the wsCustomerErrorMsg attribute reference
	 */
	public ElementaryRangeReference getWsCustomerErrorMsgReference() {
		return wsCustomerErrorMsg.getReference();
	}

	/**
	 * Getter for wsCustomerErrorMsg attribute.
	 * @return wsCustomerErrorMsg attribute
	 */
	public String getWsCustomerErrorMsg() {
		return wsCustomerErrorMsg.getValue();
	}

	/**
	 * Setter for wsCustomerErrorMsg attribute.
	 * @param wsCustomerErrorMsg the new value of wsCustomerErrorMsg
	 */
	public void setWsCustomerErrorMsg(String wsCustomerErrorMsg) {
		this.wsCustomerErrorMsg.setValue(wsCustomerErrorMsg);
	}
	/**
	 * Gets the reference for attribute wsCustomerStatus.
	 * @return the wsCustomerStatus attribute reference
	 */
	public ElementaryRangeReference getWsCustomerStatusReference() {
		return wsCustomerStatus.getReference();
	}

	/**
	 * Getter for wsCustomerStatus attribute.
	 * @return wsCustomerStatus attribute
	 */
	public String getWsCustomerStatus() {
		return wsCustomerStatus.getValue();
	}

	/**
	 * Setter for wsCustomerStatus attribute.
	 * @param wsCustomerStatus the new value of wsCustomerStatus
	 */
	public void setWsCustomerStatus(String wsCustomerStatus) {
		this.wsCustomerStatus.setValue(wsCustomerStatus);
	}
	/**
	 * Gets the reference for attribute customerNotFound.
	 * @return the customerNotFound attribute reference
	 */
	public ConditionReference getCustomerNotFoundReference() {
		return wsCustomerStatus.getCondition(customerNotFound);	
	}

	/**
	 * Getter for customerNotFound attribute.
	 * @return customerNotFound attribute
	 */
	public boolean isCustomerNotFound() {
		return getCustomerNotFoundReference().getValue();	
	}

	/**
	 * Setter for customerNotFound attribute.
	 * @param customerNotFound the new value of customerNotFound
	 */
	public void setCustomerNotFound(boolean customerNotFound) {
		getCustomerNotFoundReference().setValue(customerNotFound);	
	}
	/**
	 * Gets the reference for attribute customerActive.
	 * @return the customerActive attribute reference
	 */
	public ConditionReference getCustomerActiveReference() {
		return wsCustomerStatus.getCondition(customerActive);	
	}

	/**
	 * Getter for customerActive attribute.
	 * @return customerActive attribute
	 */
	public boolean isCustomerActive() {
		return getCustomerActiveReference().getValue();	
	}

	/**
	 * Setter for customerActive attribute.
	 * @param customerActive the new value of customerActive
	 */
	public void setCustomerActive(boolean customerActive) {
		getCustomerActiveReference().setValue(customerActive);	
	}
	/**
	 * Gets the reference for attribute customerInactive.
	 * @return the customerInactive attribute reference
	 */
	public ConditionReference getCustomerInactiveReference() {
		return wsCustomerStatus.getCondition(customerInactive);	
	}

	/**
	 * Getter for customerInactive attribute.
	 * @return customerInactive attribute
	 */
	public boolean isCustomerInactive() {
		return getCustomerInactiveReference().getValue();	
	}

	/**
	 * Setter for customerInactive attribute.
	 * @param customerInactive the new value of customerInactive
	 */
	public void setCustomerInactive(boolean customerInactive) {
		getCustomerInactiveReference().setValue(customerInactive);	
	}
	/**
	 * Gets the reference for attribute customerException.
	 * @return the customerException attribute reference
	 */
	public ConditionReference getCustomerExceptionReference() {
		return wsCustomerStatus.getCondition(customerException);	
	}

	/**
	 * Getter for customerException attribute.
	 * @return customerException attribute
	 */
	public boolean isCustomerException() {
		return getCustomerExceptionReference().getValue();	
	}

	/**
	 * Setter for customerException attribute.
	 * @param customerException the new value of customerException
	 */
	public void setCustomerException(boolean customerException) {
		getCustomerExceptionReference().setValue(customerException);	
	}
}
