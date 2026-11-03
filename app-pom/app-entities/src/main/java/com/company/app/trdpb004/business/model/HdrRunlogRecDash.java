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
 * Data simplifier entity HdrRunlogRecDash.
 * 
 * <p>About 'filler1' field, <br>
 * </p>
 * 
 * <p>About 'filler2' field, <br>
 * </p>
 * 
 * <p>About 'filler3' field, <br>
 * </p>
 * 
 * <p>About 'filler4' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class HdrRunlogRecDash extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(2),"+-");
	private final Elementary filler1 = new Elementary(root,new AlphanumericType(12));
	@SuppressWarnings("unused")
	private final Filler filler5 = new Filler(root,new AlphanumericType(3),"-+-");
	private final Elementary filler2 = new Elementary(root,new AlphanumericType(8));
	@SuppressWarnings("unused")
	private final Filler filler6 = new Filler(root,new AlphanumericType(3),"-+-");
	private final Elementary filler3 = new Elementary(root,new AlphanumericType(26));
	@SuppressWarnings("unused")
	private final Filler filler7 = new Filler(root,new AlphanumericType(3),"-+-");
	private final Elementary filler4 = new Elementary(root,new AlphanumericType(26));
	@SuppressWarnings("unused")
	private final Filler filler8 = new Filler(root,new AlphanumericType(3),"-+ ");
	
	/**
	 * Instantiate a new HdrRunlogRecDash with a default record.
	 * @param configuration the configuration
	 */
	public HdrRunlogRecDash(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new HdrRunlogRecDash bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public HdrRunlogRecDash(Configuration configuration, RecordAdaptable existingRecord) {
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
	/**
	 * Gets the reference for attribute filler3.
	 * @return the filler3 attribute reference
	 */
	public ElementaryRangeReference getFiller3Reference() {
		return filler3.getReference();
	}

	/**
	 * Getter for filler3 attribute.
	 * @return filler3 attribute
	 */
	public String getFiller3() {
		return filler3.getValue();
	}

	/**
	 * Setter for filler3 attribute.
	 * @param filler3 the new value of filler3
	 */
	public void setFiller3(String filler3) {
		this.filler3.setValue(filler3);
	}
	/**
	 * Gets the reference for attribute filler4.
	 * @return the filler4 attribute reference
	 */
	public ElementaryRangeReference getFiller4Reference() {
		return filler4.getReference();
	}

	/**
	 * Getter for filler4 attribute.
	 * @return filler4 attribute
	 */
	public String getFiller4() {
		return filler4.getValue();
	}

	/**
	 * Setter for filler4 attribute.
	 * @param filler4 the new value of filler4
	 */
	public void setFiller4(String filler4) {
		this.filler4.setValue(filler4);
	}
}
