package com.company.app.trdpb006.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Data simplifier file Reporder.
<pre>
 * 
 * Legacy Documentation:<br>
 *                                                                 *<br>
</pre>
 * 
 * <p>About 'reporderRecord' field, <br>uml entity: com.company.app.trdpb006.business.model.ReporderRecord
 * <br></p>
 * 
 */
@Component("com.company.app.trdpb006.business.model.Reporder")
@Lazy
@Scope("prototype")
public class Reporder extends RecordEntity {

	private final Group root = new Group(getData());
	private final Elementary reporderRecord = new Elementary(root,new AlphanumericType(160));
	 
	/**
	 * Instantiate a new Reporder.
	 * @param configuration the configuration
	 */
	public Reporder(@Qualifier("sharedConfiguration") Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}
 
	/**
	 * Gets the reference for attribute reporderRecord.
	 * @return the reporderRecord attribute reference
	 */
	public ElementaryRangeReference getReporderRecordReference() {
		return reporderRecord.getReference();
	}

	/**
	 * Getter for reporderRecord attribute.
	 * @return reporderRecord attribute
	 */
	public String getReporderRecord() {
		return reporderRecord.getValue();
	}

	/**
	 * Setter for reporderRecord attribute.
	 * @param reporderRecord the new value of reporderRecord
	 */
	public void setReporderRecord(String reporderRecord) {
		this.reporderRecord.setValue(reporderRecord);
	}
}
