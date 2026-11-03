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
 * Data simplifier entity WsSecurityIo.
 * 
 * <p>About 'wsFigi' field, <br>
 * </p>
 * 
 * <p>About 'wsCurrency' field, <br>
 * </p>
 * 
 * <p>About 'wsDescription' field, <br>
 * </p>
 * 
 * <p>About 'wsSymbol' field, <br>
 * </p>
 * 
 * <p>About 'wsShareClassFigi' field, <br>
 * </p>
 * 
 * <p>About 'wsType' field, <br>
 * </p>
 * 
 * <p>About 'wsSecurityErrorMsg' field, <br>
 * </p>
 * 
 * <p>About 'wsSecurityStatus' field, <br>
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
public class WsSecurityIo extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsFigi = new Elementary(root,new AlphanumericType(12));
	private final Elementary wsCurrency = new Elementary(root,new AlphanumericType(3));
	private final Elementary wsDescription = new Elementary(root,new AlphanumericType(40));
	private final Elementary wsSymbol = new Elementary(root,new AlphanumericType(20));
	private final Elementary wsShareClassFigi = new Elementary(root,new AlphanumericType(12));
	private final Elementary wsType = new Elementary(root,new AlphanumericType(20));
	private final Elementary wsSecurityErrorMsg = new Elementary(root,new AlphanumericType(200));
	private final Elementary wsSecurityStatus = new Elementary(root,new AlphanumericType(1));
	private final ConditionName securityNotFound = new ConditionName(wsSecurityStatus,
		Arrays.asList("N"));
	private final ConditionName securityActive = new ConditionName(wsSecurityStatus,
		Arrays.asList("A"));
	private final ConditionName securityInactive = new ConditionName(wsSecurityStatus,
		Arrays.asList("I"));
	private final ConditionName securityException = new ConditionName(wsSecurityStatus,
		Arrays.asList("S"));
	
	/**
	 * Instantiate a new WsSecurityIo with a default record.
	 * @param configuration the configuration
	 */
	public WsSecurityIo(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsSecurityIo bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsSecurityIo(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsFigi.
	 * @return the wsFigi attribute reference
	 */
	public ElementaryRangeReference getWsFigiReference() {
		return wsFigi.getReference();
	}

	/**
	 * Getter for wsFigi attribute.
	 * @return wsFigi attribute
	 */
	public String getWsFigi() {
		return wsFigi.getValue();
	}

	/**
	 * Setter for wsFigi attribute.
	 * @param wsFigi the new value of wsFigi
	 */
	public void setWsFigi(String wsFigi) {
		this.wsFigi.setValue(wsFigi);
	}
	/**
	 * Gets the reference for attribute wsCurrency.
	 * @return the wsCurrency attribute reference
	 */
	public ElementaryRangeReference getWsCurrencyReference() {
		return wsCurrency.getReference();
	}

	/**
	 * Getter for wsCurrency attribute.
	 * @return wsCurrency attribute
	 */
	public String getWsCurrency() {
		return wsCurrency.getValue();
	}

	/**
	 * Setter for wsCurrency attribute.
	 * @param wsCurrency the new value of wsCurrency
	 */
	public void setWsCurrency(String wsCurrency) {
		this.wsCurrency.setValue(wsCurrency);
	}
	/**
	 * Gets the reference for attribute wsDescription.
	 * @return the wsDescription attribute reference
	 */
	public ElementaryRangeReference getWsDescriptionReference() {
		return wsDescription.getReference();
	}

	/**
	 * Getter for wsDescription attribute.
	 * @return wsDescription attribute
	 */
	public String getWsDescription() {
		return wsDescription.getValue();
	}

	/**
	 * Setter for wsDescription attribute.
	 * @param wsDescription the new value of wsDescription
	 */
	public void setWsDescription(String wsDescription) {
		this.wsDescription.setValue(wsDescription);
	}
	/**
	 * Gets the reference for attribute wsSymbol.
	 * @return the wsSymbol attribute reference
	 */
	public ElementaryRangeReference getWsSymbolReference() {
		return wsSymbol.getReference();
	}

	/**
	 * Getter for wsSymbol attribute.
	 * @return wsSymbol attribute
	 */
	public String getWsSymbol() {
		return wsSymbol.getValue();
	}

	/**
	 * Setter for wsSymbol attribute.
	 * @param wsSymbol the new value of wsSymbol
	 */
	public void setWsSymbol(String wsSymbol) {
		this.wsSymbol.setValue(wsSymbol);
	}
	/**
	 * Gets the reference for attribute wsShareClassFigi.
	 * @return the wsShareClassFigi attribute reference
	 */
	public ElementaryRangeReference getWsShareClassFigiReference() {
		return wsShareClassFigi.getReference();
	}

	/**
	 * Getter for wsShareClassFigi attribute.
	 * @return wsShareClassFigi attribute
	 */
	public String getWsShareClassFigi() {
		return wsShareClassFigi.getValue();
	}

	/**
	 * Setter for wsShareClassFigi attribute.
	 * @param wsShareClassFigi the new value of wsShareClassFigi
	 */
	public void setWsShareClassFigi(String wsShareClassFigi) {
		this.wsShareClassFigi.setValue(wsShareClassFigi);
	}
	/**
	 * Gets the reference for attribute wsType.
	 * @return the wsType attribute reference
	 */
	public ElementaryRangeReference getWsTypeReference() {
		return wsType.getReference();
	}

	/**
	 * Getter for wsType attribute.
	 * @return wsType attribute
	 */
	public String getWsType() {
		return wsType.getValue();
	}

	/**
	 * Setter for wsType attribute.
	 * @param wsType the new value of wsType
	 */
	public void setWsType(String wsType) {
		this.wsType.setValue(wsType);
	}
	/**
	 * Gets the reference for attribute wsSecurityErrorMsg.
	 * @return the wsSecurityErrorMsg attribute reference
	 */
	public ElementaryRangeReference getWsSecurityErrorMsgReference() {
		return wsSecurityErrorMsg.getReference();
	}

	/**
	 * Getter for wsSecurityErrorMsg attribute.
	 * @return wsSecurityErrorMsg attribute
	 */
	public String getWsSecurityErrorMsg() {
		return wsSecurityErrorMsg.getValue();
	}

	/**
	 * Setter for wsSecurityErrorMsg attribute.
	 * @param wsSecurityErrorMsg the new value of wsSecurityErrorMsg
	 */
	public void setWsSecurityErrorMsg(String wsSecurityErrorMsg) {
		this.wsSecurityErrorMsg.setValue(wsSecurityErrorMsg);
	}
	/**
	 * Gets the reference for attribute wsSecurityStatus.
	 * @return the wsSecurityStatus attribute reference
	 */
	public ElementaryRangeReference getWsSecurityStatusReference() {
		return wsSecurityStatus.getReference();
	}

	/**
	 * Getter for wsSecurityStatus attribute.
	 * @return wsSecurityStatus attribute
	 */
	public String getWsSecurityStatus() {
		return wsSecurityStatus.getValue();
	}

	/**
	 * Setter for wsSecurityStatus attribute.
	 * @param wsSecurityStatus the new value of wsSecurityStatus
	 */
	public void setWsSecurityStatus(String wsSecurityStatus) {
		this.wsSecurityStatus.setValue(wsSecurityStatus);
	}
	/**
	 * Gets the reference for attribute securityNotFound.
	 * @return the securityNotFound attribute reference
	 */
	public ConditionReference getSecurityNotFoundReference() {
		return wsSecurityStatus.getCondition(securityNotFound);	
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
		return wsSecurityStatus.getCondition(securityActive);	
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
		return wsSecurityStatus.getCondition(securityInactive);	
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
		return wsSecurityStatus.getCondition(securityException);	
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
