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
 * Data simplifier entity LsSecurityIo.
<pre>
 * 
 * Legacy Documentation:<br>
 *  ****************************************************************<br>
 *   THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 6       *<br>
 *  <br>
 *  <br>
</pre>
 * 
 * <p>About 'lsFigi' field, <br>
 * </p>
 * 
 * <p>About 'lsCurrency' field, <br>
 * </p>
 * 
 * <p>About 'lsDescription' field, <br>
 * </p>
 * 
 * <p>About 'lsSymbol' field, <br>
 * </p>
 * 
 * <p>About 'lsShareClassFigi' field, <br>
 * </p>
 * 
 * <p>About 'lsType' field, <br>
 * </p>
 * 
 * <p>About 'lsSecurityErrorMsg' field, <br>
 * </p>
 * 
 * <p>About 'lsSecurityStatus' field, <br>
 * </p>
 * 
 * <p>About 'securityNotFound' field, <br>
 * </p>
 * 
 * <p>About 'securityActive' field, <br>
 * </p>
 * 
 * <p>About 'securityInactive' field, <br>
 * </p>
 * 
 * <p>About 'securityException' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class LsSecurityIo extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary lsFigi = new Elementary(root,new AlphanumericType(12));
	private final Elementary lsCurrency = new Elementary(root,new AlphanumericType(3));
	private final Elementary lsDescription = new Elementary(root,new AlphanumericType(40));
	private final Elementary lsSymbol = new Elementary(root,new AlphanumericType(20));
	private final Elementary lsShareClassFigi = new Elementary(root,new AlphanumericType(12));
	private final Elementary lsType = new Elementary(root,new AlphanumericType(20));
	private final Elementary lsSecurityErrorMsg = new Elementary(root,new AlphanumericType(200));
	private final Elementary lsSecurityStatus = new Elementary(root,new AlphanumericType(1));
	private final ConditionName securityNotFound = new ConditionName(lsSecurityStatus,
		Arrays.asList("N"));
	private final ConditionName securityActive = new ConditionName(lsSecurityStatus,
		Arrays.asList("A"));
	private final ConditionName securityInactive = new ConditionName(lsSecurityStatus,
		Arrays.asList("I"));
	private final ConditionName securityException = new ConditionName(lsSecurityStatus,
		Arrays.asList("S"));
	
	/**
	 * Instantiate a new LsSecurityIo with a default record.
	 * @param configuration the configuration
	 */
	public LsSecurityIo(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new LsSecurityIo bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public LsSecurityIo(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute lsFigi.
	 * @return the lsFigi attribute reference
	 */
	public ElementaryRangeReference getLsFigiReference() {
		return lsFigi.getReference();
	}

	/**
	 * Getter for lsFigi attribute.
	 * @return lsFigi attribute
	 */
	public String getLsFigi() {
		return lsFigi.getValue();
	}

	/**
	 * Setter for lsFigi attribute.
	 * @param lsFigi the new value of lsFigi
	 */
	public void setLsFigi(String lsFigi) {
		this.lsFigi.setValue(lsFigi);
	}
	/**
	 * Gets the reference for attribute lsCurrency.
	 * @return the lsCurrency attribute reference
	 */
	public ElementaryRangeReference getLsCurrencyReference() {
		return lsCurrency.getReference();
	}

	/**
	 * Getter for lsCurrency attribute.
	 * @return lsCurrency attribute
	 */
	public String getLsCurrency() {
		return lsCurrency.getValue();
	}

	/**
	 * Setter for lsCurrency attribute.
	 * @param lsCurrency the new value of lsCurrency
	 */
	public void setLsCurrency(String lsCurrency) {
		this.lsCurrency.setValue(lsCurrency);
	}
	/**
	 * Gets the reference for attribute lsDescription.
	 * @return the lsDescription attribute reference
	 */
	public ElementaryRangeReference getLsDescriptionReference() {
		return lsDescription.getReference();
	}

	/**
	 * Getter for lsDescription attribute.
	 * @return lsDescription attribute
	 */
	public String getLsDescription() {
		return lsDescription.getValue();
	}

	/**
	 * Setter for lsDescription attribute.
	 * @param lsDescription the new value of lsDescription
	 */
	public void setLsDescription(String lsDescription) {
		this.lsDescription.setValue(lsDescription);
	}
	/**
	 * Gets the reference for attribute lsSymbol.
	 * @return the lsSymbol attribute reference
	 */
	public ElementaryRangeReference getLsSymbolReference() {
		return lsSymbol.getReference();
	}

	/**
	 * Getter for lsSymbol attribute.
	 * @return lsSymbol attribute
	 */
	public String getLsSymbol() {
		return lsSymbol.getValue();
	}

	/**
	 * Setter for lsSymbol attribute.
	 * @param lsSymbol the new value of lsSymbol
	 */
	public void setLsSymbol(String lsSymbol) {
		this.lsSymbol.setValue(lsSymbol);
	}
	/**
	 * Gets the reference for attribute lsShareClassFigi.
	 * @return the lsShareClassFigi attribute reference
	 */
	public ElementaryRangeReference getLsShareClassFigiReference() {
		return lsShareClassFigi.getReference();
	}

	/**
	 * Getter for lsShareClassFigi attribute.
	 * @return lsShareClassFigi attribute
	 */
	public String getLsShareClassFigi() {
		return lsShareClassFigi.getValue();
	}

	/**
	 * Setter for lsShareClassFigi attribute.
	 * @param lsShareClassFigi the new value of lsShareClassFigi
	 */
	public void setLsShareClassFigi(String lsShareClassFigi) {
		this.lsShareClassFigi.setValue(lsShareClassFigi);
	}
	/**
	 * Gets the reference for attribute lsType.
	 * @return the lsType attribute reference
	 */
	public ElementaryRangeReference getLsTypeReference() {
		return lsType.getReference();
	}

	/**
	 * Getter for lsType attribute.
	 * @return lsType attribute
	 */
	public String getLsType() {
		return lsType.getValue();
	}

	/**
	 * Setter for lsType attribute.
	 * @param lsType the new value of lsType
	 */
	public void setLsType(String lsType) {
		this.lsType.setValue(lsType);
	}
	/**
	 * Gets the reference for attribute lsSecurityErrorMsg.
	 * @return the lsSecurityErrorMsg attribute reference
	 */
	public ElementaryRangeReference getLsSecurityErrorMsgReference() {
		return lsSecurityErrorMsg.getReference();
	}

	/**
	 * Getter for lsSecurityErrorMsg attribute.
	 * @return lsSecurityErrorMsg attribute
	 */
	public String getLsSecurityErrorMsg() {
		return lsSecurityErrorMsg.getValue();
	}

	/**
	 * Setter for lsSecurityErrorMsg attribute.
	 * @param lsSecurityErrorMsg the new value of lsSecurityErrorMsg
	 */
	public void setLsSecurityErrorMsg(String lsSecurityErrorMsg) {
		this.lsSecurityErrorMsg.setValue(lsSecurityErrorMsg);
	}
	/**
	 * Gets the reference for attribute lsSecurityStatus.
	 * @return the lsSecurityStatus attribute reference
	 */
	public ElementaryRangeReference getLsSecurityStatusReference() {
		return lsSecurityStatus.getReference();
	}

	/**
	 * Getter for lsSecurityStatus attribute.
	 * @return lsSecurityStatus attribute
	 */
	public String getLsSecurityStatus() {
		return lsSecurityStatus.getValue();
	}

	/**
	 * Setter for lsSecurityStatus attribute.
	 * @param lsSecurityStatus the new value of lsSecurityStatus
	 */
	public void setLsSecurityStatus(String lsSecurityStatus) {
		this.lsSecurityStatus.setValue(lsSecurityStatus);
	}
	/**
	 * Gets the reference for attribute securityNotFound.
	 * @return the securityNotFound attribute reference
	 */
	public ConditionReference getSecurityNotFoundReference() {
		return lsSecurityStatus.getCondition(securityNotFound);	
	}

	/**
	 * Getter for securityNotFound attribute.
	 * @return securityNotFound attribute
	 */
	public boolean isSecurityNotFound() {
		return getSecurityNotFoundReference().getValue();	
	}

	/**
	 * Setter for securityNotFound attribute.
	 * @param securityNotFound the new value of securityNotFound
	 */
	public void setSecurityNotFound(boolean securityNotFound) {
		getSecurityNotFoundReference().setValue(securityNotFound);	
	}
	/**
	 * Gets the reference for attribute securityActive.
	 * @return the securityActive attribute reference
	 */
	public ConditionReference getSecurityActiveReference() {
		return lsSecurityStatus.getCondition(securityActive);	
	}

	/**
	 * Getter for securityActive attribute.
	 * @return securityActive attribute
	 */
	public boolean isSecurityActive() {
		return getSecurityActiveReference().getValue();	
	}

	/**
	 * Setter for securityActive attribute.
	 * @param securityActive the new value of securityActive
	 */
	public void setSecurityActive(boolean securityActive) {
		getSecurityActiveReference().setValue(securityActive);	
	}
	/**
	 * Gets the reference for attribute securityInactive.
	 * @return the securityInactive attribute reference
	 */
	public ConditionReference getSecurityInactiveReference() {
		return lsSecurityStatus.getCondition(securityInactive);	
	}

	/**
	 * Getter for securityInactive attribute.
	 * @return securityInactive attribute
	 */
	public boolean isSecurityInactive() {
		return getSecurityInactiveReference().getValue();	
	}

	/**
	 * Setter for securityInactive attribute.
	 * @param securityInactive the new value of securityInactive
	 */
	public void setSecurityInactive(boolean securityInactive) {
		getSecurityInactiveReference().setValue(securityInactive);	
	}
	/**
	 * Gets the reference for attribute securityException.
	 * @return the securityException attribute reference
	 */
	public ConditionReference getSecurityExceptionReference() {
		return lsSecurityStatus.getCondition(securityException);	
	}

	/**
	 * Getter for securityException attribute.
	 * @return securityException attribute
	 */
	public boolean isSecurityException() {
		return getSecurityExceptionReference().getValue();	
	}

	/**
	 * Setter for securityException attribute.
	 * @param securityException the new value of securityException
	 */
	public void setSecurityException(boolean securityException) {
		getSecurityExceptionReference().setValue(securityException);	
	}
}
