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
 * Data simplifier file SummaryReport.
 * 
 * <p>About 'summaryRecord' field, <br>uml entity: com.company.app.trdpb004.business.model.SummaryRecord
 * <br></p>
 * 
 */
@Component("com.company.app.trdpb004.business.model.SummaryReport")
@Lazy
@Scope("prototype")
public class SummaryReport extends RecordEntity {

	private final Group root = new Group(getData());
	private final Elementary summaryRecord = new Elementary(root,new AlphanumericType(140));
	 
	/**
	 * Instantiate a new SummaryReport.
	 * @param configuration the configuration
	 */
	public SummaryReport(@Qualifier("sharedConfiguration") Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}
 
	/**
	 * Gets the reference for attribute summaryRecord.
	 * @return the summaryRecord attribute reference
	 */
	public ElementaryRangeReference getSummaryRecordReference() {
		return summaryRecord.getReference();
	}

	/**
	 * Getter for summaryRecord attribute.
	 * @return summaryRecord attribute
	 */
	public String getSummaryRecord() {
		return summaryRecord.getValue();
	}

	/**
	 * Setter for summaryRecord attribute.
	 * @param summaryRecord the new value of summaryRecord
	 */
	public void setSummaryRecord(String summaryRecord) {
		this.summaryRecord.setValue(summaryRecord);
	}
}
