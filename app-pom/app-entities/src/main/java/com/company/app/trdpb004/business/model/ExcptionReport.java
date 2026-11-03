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
 * Data simplifier file ExcptionReport.
 * 
 * <p>About 'excptionRecord' field, <br>uml entity: com.company.app.trdpb004.business.model.ExcptionRecord
 * <br></p>
 * 
 */
@Component("com.company.app.trdpb004.business.model.ExcptionReport")
@Lazy
@Scope("prototype")
public class ExcptionReport extends RecordEntity {

	private final Group root = new Group(getData());
	private final Elementary excptionRecord = new Elementary(root,new AlphanumericType(1100));
	 
	/**
	 * Instantiate a new ExcptionReport.
	 * @param configuration the configuration
	 */
	public ExcptionReport(@Qualifier("sharedConfiguration") Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}
 
	/**
	 * Gets the reference for attribute excptionRecord.
	 * @return the excptionRecord attribute reference
	 */
	public ElementaryRangeReference getExcptionRecordReference() {
		return excptionRecord.getReference();
	}

	/**
	 * Getter for excptionRecord attribute.
	 * @return excptionRecord attribute
	 */
	public String getExcptionRecord() {
		return excptionRecord.getValue();
	}

	/**
	 * Setter for excptionRecord attribute.
	 * @param excptionRecord the new value of excptionRecord
	 */
	public void setExcptionRecord(String excptionRecord) {
		this.excptionRecord.setValue(excptionRecord);
	}
}
