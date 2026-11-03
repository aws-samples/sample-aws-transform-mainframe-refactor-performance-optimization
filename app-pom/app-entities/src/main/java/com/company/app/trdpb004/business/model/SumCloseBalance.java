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
 * Data simplifier entity SumCloseBalance.
 * 
 * <p>About 'sumCloseBalance' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SumCloseBalance extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary sumCloseBalance = new Elementary(root,new PackedType(10, 2, false, false, true));
	
	/**
	 * Instantiate a new SumCloseBalance with a default record.
	 * @param configuration the configuration
	 */
	public SumCloseBalance(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SumCloseBalance bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SumCloseBalance(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute sumCloseBalance.
	 * @return the sumCloseBalance attribute reference
	 */
	public ElementaryRangeReference getSumCloseBalanceReference() {
		return sumCloseBalance.getReference();
	}

	/**
	 * Getter for sumCloseBalance attribute.
	 * @return sumCloseBalance attribute
	 */
	public BigDecimal getSumCloseBalance() {
		return sumCloseBalance.getValue();
	}

	/**
	 * Setter for sumCloseBalance attribute.
	 * @param sumCloseBalance the new value of sumCloseBalance
	 */
	public void setSumCloseBalance(BigDecimal sumCloseBalance) {
		this.sumCloseBalance.setValue(sumCloseBalance);
	}
}
