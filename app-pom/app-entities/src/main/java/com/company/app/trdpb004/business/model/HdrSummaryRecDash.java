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
 * Data simplifier entity HdrSummaryRecDash.
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
 * <p>About 'filler5' field, <br>
 * </p>
 * 
 * <p>About 'filler6' field, <br>
 * </p>
 * 
 * <p>About 'filler7' field, <br>
 * </p>
 * 
 * <p>About 'filler8' field, <br>
 * </p>
 * 
 * <p>About 'filler9' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class HdrSummaryRecDash extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(2),"+-");
	private final Elementary filler1 = new Elementary(root,new AlphanumericType(12));
	@SuppressWarnings("unused")
	private final Filler filler10 = new Filler(root,new AlphanumericType(3)," + ");
	private final Elementary filler2 = new Elementary(root,new AlphanumericType(11));
	@SuppressWarnings("unused")
	private final Filler filler11 = new Filler(root,new AlphanumericType(3)," + ");
	private final Elementary filler3 = new Elementary(root,new AlphanumericType(11));
	@SuppressWarnings("unused")
	private final Filler filler12 = new Filler(root,new AlphanumericType(3)," + ");
	private final Elementary filler4 = new Elementary(root,new AlphanumericType(11));
	@SuppressWarnings("unused")
	private final Filler filler13 = new Filler(root,new AlphanumericType(3)," + ");
	private final Elementary filler5 = new Elementary(root,new AlphanumericType(8));
	@SuppressWarnings("unused")
	private final Filler filler14 = new Filler(root,new AlphanumericType(3)," + ");
	private final Elementary filler6 = new Elementary(root,new AlphanumericType(14));
	@SuppressWarnings("unused")
	private final Filler filler15 = new Filler(root,new AlphanumericType(4)," +  ");
	private final Elementary filler7 = new Elementary(root,new AlphanumericType(14));
	@SuppressWarnings("unused")
	private final Filler filler16 = new Filler(root,new AlphanumericType(4)," +  ");
	private final Elementary filler8 = new Elementary(root,new AlphanumericType(14));
	@SuppressWarnings("unused")
	private final Filler filler17 = new Filler(root,new AlphanumericType(3)," + ");
	private final Elementary filler9 = new Elementary(root,new AlphanumericType(14));
	@SuppressWarnings("unused")
	private final Filler filler18 = new Filler(root,new AlphanumericType(3)," + ");
	
	/**
	 * Instantiate a new HdrSummaryRecDash with a default record.
	 * @param configuration the configuration
	 */
	public HdrSummaryRecDash(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new HdrSummaryRecDash bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public HdrSummaryRecDash(Configuration configuration, RecordAdaptable existingRecord) {
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
	/**
	 * Gets the reference for attribute filler5.
	 * @return the filler5 attribute reference
	 */
	public ElementaryRangeReference getFiller5Reference() {
		return filler5.getReference();
	}

	/**
	 * Getter for filler5 attribute.
	 * @return filler5 attribute
	 */
	public String getFiller5() {
		return filler5.getValue();
	}

	/**
	 * Setter for filler5 attribute.
	 * @param filler5 the new value of filler5
	 */
	public void setFiller5(String filler5) {
		this.filler5.setValue(filler5);
	}
	/**
	 * Gets the reference for attribute filler6.
	 * @return the filler6 attribute reference
	 */
	public ElementaryRangeReference getFiller6Reference() {
		return filler6.getReference();
	}

	/**
	 * Getter for filler6 attribute.
	 * @return filler6 attribute
	 */
	public String getFiller6() {
		return filler6.getValue();
	}

	/**
	 * Setter for filler6 attribute.
	 * @param filler6 the new value of filler6
	 */
	public void setFiller6(String filler6) {
		this.filler6.setValue(filler6);
	}
	/**
	 * Gets the reference for attribute filler7.
	 * @return the filler7 attribute reference
	 */
	public ElementaryRangeReference getFiller7Reference() {
		return filler7.getReference();
	}

	/**
	 * Getter for filler7 attribute.
	 * @return filler7 attribute
	 */
	public String getFiller7() {
		return filler7.getValue();
	}

	/**
	 * Setter for filler7 attribute.
	 * @param filler7 the new value of filler7
	 */
	public void setFiller7(String filler7) {
		this.filler7.setValue(filler7);
	}
	/**
	 * Gets the reference for attribute filler8.
	 * @return the filler8 attribute reference
	 */
	public ElementaryRangeReference getFiller8Reference() {
		return filler8.getReference();
	}

	/**
	 * Getter for filler8 attribute.
	 * @return filler8 attribute
	 */
	public String getFiller8() {
		return filler8.getValue();
	}

	/**
	 * Setter for filler8 attribute.
	 * @param filler8 the new value of filler8
	 */
	public void setFiller8(String filler8) {
		this.filler8.setValue(filler8);
	}
	/**
	 * Gets the reference for attribute filler9.
	 * @return the filler9 attribute reference
	 */
	public ElementaryRangeReference getFiller9Reference() {
		return filler9.getReference();
	}

	/**
	 * Getter for filler9 attribute.
	 * @return filler9 attribute
	 */
	public String getFiller9() {
		return filler9.getValue();
	}

	/**
	 * Setter for filler9 attribute.
	 * @param filler9 the new value of filler9
	 */
	public void setFiller9(String filler9) {
		this.filler9.setValue(filler9);
	}
}
