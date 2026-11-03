package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Filler;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity PrtExcptionRec.
 * 
 * <p>About 'prtExcptionType' field, <br>
 * </p>
 * 
 * <p>About 'prtExcptionDesc' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class PrtExcptionRec extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(2),"| ");
	private final Elementary prtExcptionType = new Elementary(root,new AlphanumericType(20));
	@SuppressWarnings("unused")
	private final Filler filler1 = new Filler(root,new AlphanumericType(3)," | ");
	private final Elementary prtExcptionDesc = new Elementary(root,new AlphanumericType(1000));
	@SuppressWarnings("unused")
	private final Filler filler2 = new Filler(root,new AlphanumericType(3)," | ");
	
	/**
	 * Instantiate a new PrtExcptionRec with a default record.
	 * @param configuration the configuration
	 */
	public PrtExcptionRec(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new PrtExcptionRec bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public PrtExcptionRec(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute prtExcptionType.
	 * @return the prtExcptionType attribute reference
	 */
	public ElementaryRangeReference getPrtExcptionTypeReference() {
		return prtExcptionType.getReference();
	}

	/**
	 * Getter for prtExcptionType attribute.
	 * @return prtExcptionType attribute
	 */
	public String getPrtExcptionType() {
		return prtExcptionType.getValue();
	}

	/**
	 * Setter for prtExcptionType attribute.
	 * @param prtExcptionType the new value of prtExcptionType
	 */
	public void setPrtExcptionType(String prtExcptionType) {
		this.prtExcptionType.setValue(prtExcptionType);
	}
	/**
	 * Gets the reference for attribute prtExcptionDesc.
	 * @return the prtExcptionDesc attribute reference
	 */
	public ElementaryRangeReference getPrtExcptionDescReference() {
		return prtExcptionDesc.getReference();
	}

	/**
	 * Getter for prtExcptionDesc attribute.
	 * @return prtExcptionDesc attribute
	 */
	public String getPrtExcptionDesc() {
		return prtExcptionDesc.getValue();
	}

	/**
	 * Setter for prtExcptionDesc attribute.
	 * @param prtExcptionDesc the new value of prtExcptionDesc
	 */
	public void setPrtExcptionDesc(String prtExcptionDesc) {
		this.prtExcptionDesc.setValue(prtExcptionDesc);
	}
}
