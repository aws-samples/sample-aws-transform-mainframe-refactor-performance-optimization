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
 * Data simplifier entity WsOrderStatus.
 * 
 * <p>About 'wsOrderStatus' field, <br>
 * </p>
 * 
 * <p>About 'accepted' field, <br>
 * </p>
 * 
 * <p>About 'matched' field, <br>
 * </p>
 * 
 * <p>About 'overdue' field, <br>
 * </p>
 * 
 * <p>About 'overdueBuyerIdInvld' field, <br>
 * </p>
 * 
 * <p>About 'overdueSellerIdInvld' field, <br>
 * </p>
 * 
 * <p>About 'overdueSecurityInvld' field, <br>
 * </p>
 * 
 * <p>About 'overdueBuyerAcInvld' field, <br>
 * </p>
 * 
 * <p>About 'overdueSellerAcInvld' field, <br>
 * </p>
 * 
 * <p>About 'overdueBuyerOrdstaInvld' field, <br>
 * </p>
 * 
 * <p>About 'overdueSellerOrdstaInvld' field, <br>
 * </p>
 * 
 * <p>About 'overdueSellerOrdMissing' field, <br>
 * </p>
 * 
 * <p>About 'rejected' field, <br>
 * </p>
 * 
 * <p>About 'settled' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsOrderStatus extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsOrderStatus = new Elementary(root,new AlphanumericType(3));
	private final ConditionName accepted = new ConditionName(wsOrderStatus,
		Arrays.asList("101"));
	private final ConditionName matched = new ConditionName(wsOrderStatus,
		Arrays.asList("201"));
	private final ConditionName overdue = new ConditionName(wsOrderStatus,
		Arrays.asList("301", "302", "303", "304", "305", "306", "307", "308"));
	private final ConditionName overdueBuyerIdInvld = new ConditionName(wsOrderStatus,
		Arrays.asList("301"));
	private final ConditionName overdueSellerIdInvld = new ConditionName(wsOrderStatus,
		Arrays.asList("302"));
	private final ConditionName overdueSecurityInvld = new ConditionName(wsOrderStatus,
		Arrays.asList("303"));
	private final ConditionName overdueBuyerAcInvld = new ConditionName(wsOrderStatus,
		Arrays.asList("304"));
	private final ConditionName overdueSellerAcInvld = new ConditionName(wsOrderStatus,
		Arrays.asList("305"));
	private final ConditionName overdueBuyerOrdstaInvld = new ConditionName(wsOrderStatus,
		Arrays.asList("306"));
	private final ConditionName overdueSellerOrdstaInvld = new ConditionName(wsOrderStatus,
		Arrays.asList("307"));
	private final ConditionName overdueSellerOrdMissing = new ConditionName(wsOrderStatus,
		Arrays.asList("308"));
	private final ConditionName rejected = new ConditionName(wsOrderStatus,
		Arrays.asList("401"));
	private final ConditionName settled = new ConditionName(wsOrderStatus,
		Arrays.asList("601"));
	
	/**
	 * Instantiate a new WsOrderStatus with a default record.
	 * @param configuration the configuration
	 */
	public WsOrderStatus(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsOrderStatus bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsOrderStatus(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsOrderStatus.
	 * @return the wsOrderStatus attribute reference
	 */
	public ElementaryRangeReference getWsOrderStatusReference() {
		return wsOrderStatus.getReference();
	}

	/**
	 * Getter for wsOrderStatus attribute.
	 * @return wsOrderStatus attribute
	 */
	public String getWsOrderStatus() {
		return wsOrderStatus.getValue();
	}

	/**
	 * Setter for wsOrderStatus attribute.
	 * @param wsOrderStatus the new value of wsOrderStatus
	 */
	public void setWsOrderStatus(String wsOrderStatus) {
		this.wsOrderStatus.setValue(wsOrderStatus);
	}
	/**
	 * Gets the reference for attribute accepted.
	 * @return the accepted attribute reference
	 */
	public ConditionReference getAcceptedReference() {
		return wsOrderStatus.getCondition(accepted);	
	}

	/**
	 * Getter for accepted attribute.
	 * @return accepted attribute
	 */
	public boolean isAccepted() {
		return getAcceptedReference().getValue();	
	}

	/**
	 * Setter for accepted attribute.
	 * @param accepted the new value of accepted
	 */
	public void setAccepted(boolean accepted) {
		getAcceptedReference().setValue(accepted);	
	}
	/**
	 * Gets the reference for attribute matched.
	 * @return the matched attribute reference
	 */
	public ConditionReference getMatchedReference() {
		return wsOrderStatus.getCondition(matched);	
	}

	/**
	 * Getter for matched attribute.
	 * @return matched attribute
	 */
	public boolean isMatched() {
		return getMatchedReference().getValue();	
	}

	/**
	 * Setter for matched attribute.
	 * @param matched the new value of matched
	 */
	public void setMatched(boolean matched) {
		getMatchedReference().setValue(matched);	
	}
	/**
	 * Gets the reference for attribute overdue.
	 * @return the overdue attribute reference
	 */
	public ConditionReference getOverdueReference() {
		return wsOrderStatus.getCondition(overdue);	
	}

	/**
	 * Getter for overdue attribute.
	 * @return overdue attribute
	 */
	public boolean isOverdue() {
		return getOverdueReference().getValue();	
	}

	/**
	 * Setter for overdue attribute.
	 * @param overdue the new value of overdue
	 */
	public void setOverdue(boolean overdue) {
		getOverdueReference().setValue(overdue);	
	}
	/**
	 * Gets the reference for attribute overdueBuyerIdInvld.
	 * @return the overdueBuyerIdInvld attribute reference
	 */
	public ConditionReference getOverdueBuyerIdInvldReference() {
		return wsOrderStatus.getCondition(overdueBuyerIdInvld);	
	}

	/**
	 * Getter for overdueBuyerIdInvld attribute.
	 * @return overdueBuyerIdInvld attribute
	 */
	public boolean isOverdueBuyerIdInvld() {
		return getOverdueBuyerIdInvldReference().getValue();	
	}

	/**
	 * Setter for overdueBuyerIdInvld attribute.
	 * @param overdueBuyerIdInvld the new value of overdueBuyerIdInvld
	 */
	public void setOverdueBuyerIdInvld(boolean overdueBuyerIdInvld) {
		getOverdueBuyerIdInvldReference().setValue(overdueBuyerIdInvld);	
	}
	/**
	 * Gets the reference for attribute overdueSellerIdInvld.
	 * @return the overdueSellerIdInvld attribute reference
	 */
	public ConditionReference getOverdueSellerIdInvldReference() {
		return wsOrderStatus.getCondition(overdueSellerIdInvld);	
	}

	/**
	 * Getter for overdueSellerIdInvld attribute.
	 * @return overdueSellerIdInvld attribute
	 */
	public boolean isOverdueSellerIdInvld() {
		return getOverdueSellerIdInvldReference().getValue();	
	}

	/**
	 * Setter for overdueSellerIdInvld attribute.
	 * @param overdueSellerIdInvld the new value of overdueSellerIdInvld
	 */
	public void setOverdueSellerIdInvld(boolean overdueSellerIdInvld) {
		getOverdueSellerIdInvldReference().setValue(overdueSellerIdInvld);	
	}
	/**
	 * Gets the reference for attribute overdueSecurityInvld.
	 * @return the overdueSecurityInvld attribute reference
	 */
	public ConditionReference getOverdueSecurityInvldReference() {
		return wsOrderStatus.getCondition(overdueSecurityInvld);	
	}

	/**
	 * Getter for overdueSecurityInvld attribute.
	 * @return overdueSecurityInvld attribute
	 */
	public boolean isOverdueSecurityInvld() {
		return getOverdueSecurityInvldReference().getValue();	
	}

	/**
	 * Setter for overdueSecurityInvld attribute.
	 * @param overdueSecurityInvld the new value of overdueSecurityInvld
	 */
	public void setOverdueSecurityInvld(boolean overdueSecurityInvld) {
		getOverdueSecurityInvldReference().setValue(overdueSecurityInvld);	
	}
	/**
	 * Gets the reference for attribute overdueBuyerAcInvld.
	 * @return the overdueBuyerAcInvld attribute reference
	 */
	public ConditionReference getOverdueBuyerAcInvldReference() {
		return wsOrderStatus.getCondition(overdueBuyerAcInvld);	
	}

	/**
	 * Getter for overdueBuyerAcInvld attribute.
	 * @return overdueBuyerAcInvld attribute
	 */
	public boolean isOverdueBuyerAcInvld() {
		return getOverdueBuyerAcInvldReference().getValue();	
	}

	/**
	 * Setter for overdueBuyerAcInvld attribute.
	 * @param overdueBuyerAcInvld the new value of overdueBuyerAcInvld
	 */
	public void setOverdueBuyerAcInvld(boolean overdueBuyerAcInvld) {
		getOverdueBuyerAcInvldReference().setValue(overdueBuyerAcInvld);	
	}
	/**
	 * Gets the reference for attribute overdueSellerAcInvld.
	 * @return the overdueSellerAcInvld attribute reference
	 */
	public ConditionReference getOverdueSellerAcInvldReference() {
		return wsOrderStatus.getCondition(overdueSellerAcInvld);	
	}

	/**
	 * Getter for overdueSellerAcInvld attribute.
	 * @return overdueSellerAcInvld attribute
	 */
	public boolean isOverdueSellerAcInvld() {
		return getOverdueSellerAcInvldReference().getValue();	
	}

	/**
	 * Setter for overdueSellerAcInvld attribute.
	 * @param overdueSellerAcInvld the new value of overdueSellerAcInvld
	 */
	public void setOverdueSellerAcInvld(boolean overdueSellerAcInvld) {
		getOverdueSellerAcInvldReference().setValue(overdueSellerAcInvld);	
	}
	/**
	 * Gets the reference for attribute overdueBuyerOrdstaInvld.
	 * @return the overdueBuyerOrdstaInvld attribute reference
	 */
	public ConditionReference getOverdueBuyerOrdstaInvldReference() {
		return wsOrderStatus.getCondition(overdueBuyerOrdstaInvld);	
	}

	/**
	 * Getter for overdueBuyerOrdstaInvld attribute.
	 * @return overdueBuyerOrdstaInvld attribute
	 */
	public boolean isOverdueBuyerOrdstaInvld() {
		return getOverdueBuyerOrdstaInvldReference().getValue();	
	}

	/**
	 * Setter for overdueBuyerOrdstaInvld attribute.
	 * @param overdueBuyerOrdstaInvld the new value of overdueBuyerOrdstaInvld
	 */
	public void setOverdueBuyerOrdstaInvld(boolean overdueBuyerOrdstaInvld) {
		getOverdueBuyerOrdstaInvldReference().setValue(overdueBuyerOrdstaInvld);	
	}
	/**
	 * Gets the reference for attribute overdueSellerOrdstaInvld.
	 * @return the overdueSellerOrdstaInvld attribute reference
	 */
	public ConditionReference getOverdueSellerOrdstaInvldReference() {
		return wsOrderStatus.getCondition(overdueSellerOrdstaInvld);	
	}

	/**
	 * Getter for overdueSellerOrdstaInvld attribute.
	 * @return overdueSellerOrdstaInvld attribute
	 */
	public boolean isOverdueSellerOrdstaInvld() {
		return getOverdueSellerOrdstaInvldReference().getValue();	
	}

	/**
	 * Setter for overdueSellerOrdstaInvld attribute.
	 * @param overdueSellerOrdstaInvld the new value of overdueSellerOrdstaInvld
	 */
	public void setOverdueSellerOrdstaInvld(boolean overdueSellerOrdstaInvld) {
		getOverdueSellerOrdstaInvldReference().setValue(overdueSellerOrdstaInvld);	
	}
	/**
	 * Gets the reference for attribute overdueSellerOrdMissing.
	 * @return the overdueSellerOrdMissing attribute reference
	 */
	public ConditionReference getOverdueSellerOrdMissingReference() {
		return wsOrderStatus.getCondition(overdueSellerOrdMissing);	
	}

	/**
	 * Getter for overdueSellerOrdMissing attribute.
	 * @return overdueSellerOrdMissing attribute
	 */
	public boolean isOverdueSellerOrdMissing() {
		return getOverdueSellerOrdMissingReference().getValue();	
	}

	/**
	 * Setter for overdueSellerOrdMissing attribute.
	 * @param overdueSellerOrdMissing the new value of overdueSellerOrdMissing
	 */
	public void setOverdueSellerOrdMissing(boolean overdueSellerOrdMissing) {
		getOverdueSellerOrdMissingReference().setValue(overdueSellerOrdMissing);	
	}
	/**
	 * Gets the reference for attribute rejected.
	 * @return the rejected attribute reference
	 */
	public ConditionReference getRejectedReference() {
		return wsOrderStatus.getCondition(rejected);	
	}

	/**
	 * Getter for rejected attribute.
	 * @return rejected attribute
	 */
	public boolean isRejected() {
		return getRejectedReference().getValue();	
	}

	/**
	 * Setter for rejected attribute.
	 * @param rejected the new value of rejected
	 */
	public void setRejected(boolean rejected) {
		getRejectedReference().setValue(rejected);	
	}
	/**
	 * Gets the reference for attribute settled.
	 * @return the settled attribute reference
	 */
	public ConditionReference getSettledReference() {
		return wsOrderStatus.getCondition(settled);	
	}

	/**
	 * Getter for settled attribute.
	 * @return settled attribute
	 */
	public boolean isSettled() {
		return getSettledReference().getValue();	
	}

	/**
	 * Setter for settled attribute.
	 * @param settled the new value of settled
	 */
	public void setSettled(boolean settled) {
		getSettledReference().setValue(settled);	
	}
}
