package com.company.app.trdpb006.business.model;

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
 * Data simplifier entity WsPrintHeader.
 * 
 * <p>About 'wsPrintHeader' field, <br>
 * </p>
 * 
 * <p>About 'printPageHeader' field, <br>
 * </p>
 * 
 * <p>About 'printHeader1' field, <br>
 * </p>
 * 
 * <p>About 'printDetailHdr' field, <br>
 * </p>
 * 
 * <p>About 'printDetail' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsPrintHeader extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * 
	 */
	private final Elementary wsPrintHeader = new Elementary(root,new AlphanumericType(1)," ");
	private final ConditionName printPageHeader = new ConditionName(wsPrintHeader,
		Arrays.asList("P"));
	private final ConditionName printHeader1 = new ConditionName(wsPrintHeader,
		Arrays.asList("H"));
	private final ConditionName printDetailHdr = new ConditionName(wsPrintHeader,
		Arrays.asList("D"));
	private final ConditionName printDetail = new ConditionName(wsPrintHeader,
		Arrays.asList(" "));
	
	/**
	 * Instantiate a new WsPrintHeader with a default record.
	 * @param configuration the configuration
	 */
	public WsPrintHeader(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsPrintHeader bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsPrintHeader(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsPrintHeader.
	 * @return the wsPrintHeader attribute reference
	 */
	public ElementaryRangeReference getWsPrintHeaderReference() {
		return wsPrintHeader.getReference();
	}

	/**
	 * Getter for wsPrintHeader attribute.
	 * @return wsPrintHeader attribute
	 */
	public String getWsPrintHeader() {
		return wsPrintHeader.getValue();
	}

	/**
	 * Setter for wsPrintHeader attribute.
	 * @param wsPrintHeader the new value of wsPrintHeader
	 */
	public void setWsPrintHeader(String wsPrintHeader) {
		this.wsPrintHeader.setValue(wsPrintHeader);
	}
	/**
	 * Gets the reference for attribute printPageHeader.
	 * @return the printPageHeader attribute reference
	 */
	public ConditionReference getPrintPageHeaderReference() {
		return wsPrintHeader.getCondition(printPageHeader);	
	}

	/**
	 * Getter for printPageHeader attribute.
	 * @return printPageHeader attribute
	 */
	public boolean isPrintPageHeader() {
		return getPrintPageHeaderReference().getValue();	
	}

	/**
	 * Setter for printPageHeader attribute.
	 * @param printPageHeader the new value of printPageHeader
	 */
	public void setPrintPageHeader(boolean printPageHeader) {
		getPrintPageHeaderReference().setValue(printPageHeader);	
	}
	/**
	 * Gets the reference for attribute printHeader1.
	 * @return the printHeader1 attribute reference
	 */
	public ConditionReference getPrintHeader1Reference() {
		return wsPrintHeader.getCondition(printHeader1);	
	}

	/**
	 * Getter for printHeader1 attribute.
	 * @return printHeader1 attribute
	 */
	public boolean isPrintHeader1() {
		return getPrintHeader1Reference().getValue();	
	}

	/**
	 * Setter for printHeader1 attribute.
	 * @param printHeader1 the new value of printHeader1
	 */
	public void setPrintHeader1(boolean printHeader1) {
		getPrintHeader1Reference().setValue(printHeader1);	
	}
	/**
	 * Gets the reference for attribute printDetailHdr.
	 * @return the printDetailHdr attribute reference
	 */
	public ConditionReference getPrintDetailHdrReference() {
		return wsPrintHeader.getCondition(printDetailHdr);	
	}

	/**
	 * Getter for printDetailHdr attribute.
	 * @return printDetailHdr attribute
	 */
	public boolean isPrintDetailHdr() {
		return getPrintDetailHdrReference().getValue();	
	}

	/**
	 * Setter for printDetailHdr attribute.
	 * @param printDetailHdr the new value of printDetailHdr
	 */
	public void setPrintDetailHdr(boolean printDetailHdr) {
		getPrintDetailHdrReference().setValue(printDetailHdr);	
	}
	/**
	 * Gets the reference for attribute printDetail.
	 * @return the printDetail attribute reference
	 */
	public ConditionReference getPrintDetailReference() {
		return wsPrintHeader.getCondition(printDetail);	
	}

	/**
	 * Getter for printDetail attribute.
	 * @return printDetail attribute
	 */
	public boolean isPrintDetail() {
		return getPrintDetailReference().getValue();	
	}

	/**
	 * Setter for printDetail attribute.
	 * @param printDetail the new value of printDetail
	 */
	public void setPrintDetail(boolean printDetail) {
		getPrintDetailReference().setValue(printDetail);	
	}
}
