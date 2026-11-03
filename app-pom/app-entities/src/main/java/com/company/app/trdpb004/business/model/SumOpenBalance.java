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
 * Data simplifier entity SumOpenBalance.
 * 
 * <p>About 'sumOpenBalance' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SumOpenBalance extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary sumOpenBalance = new Elementary(root,new PackedType(10, 2, false, false, true));
	
	/**
	 * Instantiate a new SumOpenBalance with a default record.
	 * @param configuration the configuration
	 */
	public SumOpenBalance(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SumOpenBalance bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SumOpenBalance(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute sumOpenBalance.
	 * @return the sumOpenBalance attribute reference
	 */
	public ElementaryRangeReference getSumOpenBalanceReference() {
		return sumOpenBalance.getReference();
	}

	/**
	 * Getter for sumOpenBalance attribute.
	 * @return sumOpenBalance attribute
	 */
	public BigDecimal getSumOpenBalance() {
		return sumOpenBalance.getValue();
	}

	/**
	 * Setter for sumOpenBalance attribute.
	 * @param sumOpenBalance the new value of sumOpenBalance
	 */
	public void setSumOpenBalance(BigDecimal sumOpenBalance) {
		this.sumOpenBalance.setValue(sumOpenBalance);
	}
}
