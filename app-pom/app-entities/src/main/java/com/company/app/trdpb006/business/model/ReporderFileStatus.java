package com.company.app.trdpb006.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity ReporderFileStatus.
<pre>
 * 
 * Legacy Documentation:<br>
 *                                                                 *<br>
 *  <br>
</pre>
 * 
 * <p>About 'reporderFileStatus' field, <br>
 *                                                                 *<br>
 *  <br></p>
 * 
 * @see RecordEntity
 */
public class ReporderFileStatus extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * *
	 * 
	 */
	private final Elementary reporderFileStatus = new Elementary(root,new AlphanumericType(2));
	
	/**
	 * Instantiate a new ReporderFileStatus with a default record.
	 * @param configuration the configuration
	 */
	public ReporderFileStatus(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new ReporderFileStatus bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public ReporderFileStatus(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute reporderFileStatus.
	 * @return the reporderFileStatus attribute reference
	 */
	public ElementaryRangeReference getReporderFileStatusReference() {
		return reporderFileStatus.getReference();
	}

	/**
	 * Getter for reporderFileStatus attribute.
	 * @return reporderFileStatus attribute
	 */
	public String getReporderFileStatus() {
		return reporderFileStatus.getValue();
	}

	/**
	 * Setter for reporderFileStatus attribute.
	 * @param reporderFileStatus the new value of reporderFileStatus
	 */
	public void setReporderFileStatus(String reporderFileStatus) {
		this.reporderFileStatus.setValue(reporderFileStatus);
	}
}
