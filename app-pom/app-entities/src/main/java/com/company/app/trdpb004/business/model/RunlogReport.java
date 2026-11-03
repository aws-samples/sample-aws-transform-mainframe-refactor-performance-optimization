package com.company.app.trdpb004.business.model;

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
 * Data simplifier file RunlogReport.
<pre>
 * 
 * Legacy Documentation:<br>
 *                                                                 *<br>
 *  <br>
</pre>
 * 
 * <p>About 'runlogRecord' field, <br>uml entity: com.company.app.trdpb004.business.model.RunlogRecord
 * <br></p>
 * 
 */
@Component("com.company.app.trdpb004.business.model.RunlogReport")
@Lazy
@Scope("prototype")
public class RunlogReport extends RecordEntity {

	private final Group root = new Group(getData());
	private final Elementary runlogRecord = new Elementary(root,new AlphanumericType(90));
	 
	/**
	 * Instantiate a new RunlogReport.
	 * @param configuration the configuration
	 */
	public RunlogReport(@Qualifier("sharedConfiguration") Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}
 
	/**
	 * Gets the reference for attribute runlogRecord.
	 * @return the runlogRecord attribute reference
	 */
	public ElementaryRangeReference getRunlogRecordReference() {
		return runlogRecord.getReference();
	}

	/**
	 * Getter for runlogRecord attribute.
	 * @return runlogRecord attribute
	 */
	public String getRunlogRecord() {
		return runlogRecord.getValue();
	}

	/**
	 * Setter for runlogRecord attribute.
	 * @param runlogRecord the new value of runlogRecord
	 */
	public void setRunlogRecord(String runlogRecord) {
		this.runlogRecord.setValue(runlogRecord);
	}
}
