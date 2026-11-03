package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.FixedArray;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.BinaryType;
/**
 * Data simplifier entity Itbtrdmac.
<pre>
 * 
 * Legacy Documentation:<br>
 *  ****************************************************************<br>
 *   INDICATOR VARIABLE STRUCTURE                                   *<br>
 *  ****************************************************************<br>
</pre>
 * 
 * <p>About 'indstruc' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class Itbtrdmac extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary indstruc = new Elementary(root,new FixedArray(5),new BinaryType(4, 0, "STD", false, false, true));
	
	/**
	 * Instantiate a new Itbtrdmac with a default record.
	 * @param configuration the configuration
	 */
	public Itbtrdmac(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new Itbtrdmac bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public Itbtrdmac(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Indexed getter for indstruc attribute.
	 * @param indexes the indexes
	 * @return indstruc attribute
	 */
	public ElementaryRangeReference getItemFromIndstrucReference(Integer... indexes) {
		return indstruc.getIndexedReference(indexes);
	}
	
	/**
	 * Indexed getter for indstruc attribute.
	 * @param indexes the indexes
	 * @return indstruc attribute
	 */
	public Integer getItemFromIndstruc(Integer... indexes) {
		return indstruc.getIndexedValue(indexes);
	}
	
	/**
	 * Indexed setter for indstruc attribute.
	 * @param indstruc the new value of indstruc for given indexes
	 * @param indexes the indexes
	 */
	public void setItemFromIndstruc(Integer indstruc,Integer... indexes) {
		this.indstruc.setIndexedValue(indstruc,indexes);
	}
	
	/**
	 * Collection size getter for indstruc attribute.
	 * @return  the collection size for attributeindstruc
	 */
	public int getIndstrucSize(){
		return indstruc.getRepetition().getCount();
	}
	
	/**
	 * Indexed getter for indstruc attribute.
	 * @param indexes the indexes
	 * @return indstruc attribute
	 */
	public ElementaryRangeReference getIndstrucReference() {
		return indstruc.getReference();
	}
	
	/**
	 * Indexed getter for indstruc attribute.
	 * @param indexes the indexes
	 * @return indstruc attribute
	 */
	public Integer getIndstruc() {
		return indstruc.getValue();
	}
	
	/**
	 * Indexed setter for indstruc attribute.
	 * @param indstruc the new value of indstruc for given indexes
	 * @param indexes the indexes
	 */
	public void setIndstruc(Integer indstruc) {
		this.indstruc.setValue(indstruc);
	}
	
}
