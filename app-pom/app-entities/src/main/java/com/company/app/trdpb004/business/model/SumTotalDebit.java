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
 * Data simplifier entity SumTotalDebit.
 * 
 * <p>About 'sumTotalDebit' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SumTotalDebit extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary sumTotalDebit = new Elementary(root,new PackedType(10, 2, false, false, true));
	
	/**
	 * Instantiate a new SumTotalDebit with a default record.
	 * @param configuration the configuration
	 */
	public SumTotalDebit(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SumTotalDebit bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SumTotalDebit(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute sumTotalDebit.
	 * @return the sumTotalDebit attribute reference
	 */
	public ElementaryRangeReference getSumTotalDebitReference() {
		return sumTotalDebit.getReference();
	}

	/**
	 * Getter for sumTotalDebit attribute.
	 * @return sumTotalDebit attribute
	 */
	public BigDecimal getSumTotalDebit() {
		return sumTotalDebit.getValue();
	}

	/**
	 * Setter for sumTotalDebit attribute.
	 * @param sumTotalDebit the new value of sumTotalDebit
	 */
	public void setSumTotalDebit(BigDecimal sumTotalDebit) {
		this.sumTotalDebit.setValue(sumTotalDebit);
	}
}
