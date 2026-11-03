package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.PackedType;
import java.math.BigDecimal;
/**
 * Data simplifier entity SumTotalCredit.
 * 
 * <p>About 'sumTotalCredit' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SumTotalCredit extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary sumTotalCredit = new Elementary(root,new PackedType(10, 2, false, false, true));
	
	/**
	 * Instantiate a new SumTotalCredit with a default record.
	 * @param configuration the configuration
	 */
	public SumTotalCredit(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SumTotalCredit bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SumTotalCredit(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute sumTotalCredit.
	 * @return the sumTotalCredit attribute reference
	 */
	public ElementaryRangeReference getSumTotalCreditReference() {
		return sumTotalCredit.getReference();
	}

	/**
	 * Getter for sumTotalCredit attribute.
	 * @return sumTotalCredit attribute
	 */
	public BigDecimal getSumTotalCredit() {
		return sumTotalCredit.getValue();
	}

	/**
	 * Setter for sumTotalCredit attribute.
	 * @param sumTotalCredit the new value of sumTotalCredit
	 */
	public void setSumTotalCredit(BigDecimal sumTotalCredit) {
		this.sumTotalCredit.setValue(sumTotalCredit);
	}
}
