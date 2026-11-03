package com.company.app.mstpb001.business.model;

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
 * Data simplifier entity LsCustomerIo.
<pre>
 * 
 * Legacy Documentation:<br>
 *  ****************************************************************<br>
 *   THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 4       *<br>
 *  <br>
 *  <br>
</pre>
 * 
 * <p>About 'lsCustomerId' field, <br>
 * </p>
 * 
 * <p>About 'lsCustomerCurrency' field, <br>
 * </p>
 * 
 * <p>About 'lsCustomerDescription' field, <br>
 * </p>
 * 
 * <p>About 'lsCustomerErrorMsg' field, <br>
 * </p>
 * 
 * <p>About 'lsCustomerStatus' field, <br>
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
public class LsCustomerIo extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary lsCustomerId = new Elementary(root,new AlphanumericType(12));
	private final Elementary lsCustomerCurrency = new Elementary(root,new AlphanumericType(3));
	private final Elementary lsCustomerDescription = new Elementary(root,new AlphanumericType(40));
	private final Elementary lsCustomerErrorMsg = new Elementary(root,new AlphanumericType(200));
	private final Elementary lsCustomerStatus = new Elementary(root,new AlphanumericType(1));
	private final ConditionName customerNotFound = new ConditionName(lsCustomerStatus,
		Arrays.asList("N"));
	private final ConditionName customerActive = new ConditionName(lsCustomerStatus,
		Arrays.asList("A"));
	private final ConditionName customerInactive = new ConditionName(lsCustomerStatus,
		Arrays.asList("I"));
	private final ConditionName customerException = new ConditionName(lsCustomerStatus,
		Arrays.asList("S"));
	
	/**
	 * Instantiate a new LsCustomerIo with a default record.
	 * @param configuration the configuration
	 */
	public LsCustomerIo(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new LsCustomerIo bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public LsCustomerIo(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute lsCustomerId.
	 * @return the lsCustomerId attribute reference
	 */
	public ElementaryRangeReference getLsCustomerIdReference() {
		return lsCustomerId.getReference();
	}

	/**
	 * Getter for lsCustomerId attribute.
	 * @return lsCustomerId attribute
	 */
	public String getLsCustomerId() {
		return lsCustomerId.getValue();
	}

	/**
	 * Setter for lsCustomerId attribute.
	 * @param lsCustomerId the new value of lsCustomerId
	 */
	public void setLsCustomerId(String lsCustomerId) {
		this.lsCustomerId.setValue(lsCustomerId);
	}
	/**
	 * Gets the reference for attribute lsCustomerCurrency.
	 * @return the lsCustomerCurrency attribute reference
	 */
	public ElementaryRangeReference getLsCustomerCurrencyReference() {
		return lsCustomerCurrency.getReference();
	}

	/**
	 * Getter for lsCustomerCurrency attribute.
	 * @return lsCustomerCurrency attribute
	 */
	public String getLsCustomerCurrency() {
		return lsCustomerCurrency.getValue();
	}

	/**
	 * Setter for lsCustomerCurrency attribute.
	 * @param lsCustomerCurrency the new value of lsCustomerCurrency
	 */
	public void setLsCustomerCurrency(String lsCustomerCurrency) {
		this.lsCustomerCurrency.setValue(lsCustomerCurrency);
	}
	/**
	 * Gets the reference for attribute lsCustomerDescription.
	 * @return the lsCustomerDescription attribute reference
	 */
	public ElementaryRangeReference getLsCustomerDescriptionReference() {
		return lsCustomerDescription.getReference();
	}

	/**
	 * Getter for lsCustomerDescription attribute.
	 * @return lsCustomerDescription attribute
	 */
	public String getLsCustomerDescription() {
		return lsCustomerDescription.getValue();
	}

	/**
	 * Setter for lsCustomerDescription attribute.
	 * @param lsCustomerDescription the new value of lsCustomerDescription
	 */
	public void setLsCustomerDescription(String lsCustomerDescription) {
		this.lsCustomerDescription.setValue(lsCustomerDescription);
	}
	/**
	 * Gets the reference for attribute lsCustomerErrorMsg.
	 * @return the lsCustomerErrorMsg attribute reference
	 */
	public ElementaryRangeReference getLsCustomerErrorMsgReference() {
		return lsCustomerErrorMsg.getReference();
	}

	/**
	 * Getter for lsCustomerErrorMsg attribute.
	 * @return lsCustomerErrorMsg attribute
	 */
	public String getLsCustomerErrorMsg() {
		return lsCustomerErrorMsg.getValue();
	}

	/**
	 * Setter for lsCustomerErrorMsg attribute.
	 * @param lsCustomerErrorMsg the new value of lsCustomerErrorMsg
	 */
	public void setLsCustomerErrorMsg(String lsCustomerErrorMsg) {
		this.lsCustomerErrorMsg.setValue(lsCustomerErrorMsg);
	}
	/**
	 * Gets the reference for attribute lsCustomerStatus.
	 * @return the lsCustomerStatus attribute reference
	 */
	public ElementaryRangeReference getLsCustomerStatusReference() {
		return lsCustomerStatus.getReference();
	}

	/**
	 * Getter for lsCustomerStatus attribute.
	 * @return lsCustomerStatus attribute
	 */
	public String getLsCustomerStatus() {
		return lsCustomerStatus.getValue();
	}

	/**
	 * Setter for lsCustomerStatus attribute.
	 * @param lsCustomerStatus the new value of lsCustomerStatus
	 */
	public void setLsCustomerStatus(String lsCustomerStatus) {
		this.lsCustomerStatus.setValue(lsCustomerStatus);
	}
	/**
	 * Gets the reference for attribute customerNotFound.
	 * @return the customerNotFound attribute reference
	 */
	public ConditionReference getCustomerNotFoundReference() {
		return lsCustomerStatus.getCondition(customerNotFound);	
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
		return lsCustomerStatus.getCondition(customerActive);	
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
		return lsCustomerStatus.getCondition(customerInactive);	
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
		return lsCustomerStatus.getCondition(customerException);	
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
