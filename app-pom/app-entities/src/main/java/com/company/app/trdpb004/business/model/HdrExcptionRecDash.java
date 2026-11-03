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
 * Data simplifier entity HdrExcptionRecDash.
 * 
 * <p>About 'filler1' field, <br>
 * </p>
 * 
 * <p>About 'filler2' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class HdrExcptionRecDash extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(2),"+-");
	private final Elementary filler1 = new Elementary(root,new AlphanumericType(20));
	@SuppressWarnings("unused")
	private final Filler filler3 = new Filler(root,new AlphanumericType(3),"-+-");
	private final Elementary filler2 = new Elementary(root,new AlphanumericType(1000));
	@SuppressWarnings("unused")
	private final Filler filler4 = new Filler(root,new AlphanumericType(3),"-+ ");
	
	/**
	 * Instantiate a new HdrExcptionRecDash with a default record.
	 * @param configuration the configuration
	 */
	public HdrExcptionRecDash(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new HdrExcptionRecDash bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public HdrExcptionRecDash(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute filler1.
	 * @return the filler1 attribute reference
	 */
	public ElementaryRangeReference getFiller1Reference() {
		return filler1.getReference();
	}

	/**
	 * Getter for filler1 attribute.
	 * @return filler1 attribute
	 */
	public String getFiller1() {
		return filler1.getValue();
	}

	/**
	 * Setter for filler1 attribute.
	 * @param filler1 the new value of filler1
	 */
	public void setFiller1(String filler1) {
		this.filler1.setValue(filler1);
	}
	/**
	 * Gets the reference for attribute filler2.
	 * @return the filler2 attribute reference
	 */
	public ElementaryRangeReference getFiller2Reference() {
		return filler2.getReference();
	}

	/**
	 * Getter for filler2 attribute.
	 * @return filler2 attribute
	 */
	public String getFiller2() {
		return filler2.getValue();
	}

	/**
	 * Setter for filler2 attribute.
	 * @param filler2 the new value of filler2
	 */
	public void setFiller2(String filler2) {
		this.filler2.setValue(filler2);
	}
}
