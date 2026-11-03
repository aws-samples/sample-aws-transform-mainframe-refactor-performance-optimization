package com.company.app.trdpb001.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.PackedType;
import java.math.BigDecimal;
/**
 * Data simplifier entity MacBalance.
 * 
 * <p>About 'macBalance' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class MacBalance extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary macBalance = new Elementary(root,new PackedType(10, 2, false, false, true));
	
	/**
	 * Instantiate a new MacBalance with a default record.
	 * @param configuration the configuration
	 */
	public MacBalance(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new MacBalance bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public MacBalance(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute macBalance.
	 * @return the macBalance attribute reference
	 */
	public ElementaryRangeReference getMacBalanceReference() {
		return macBalance.getReference();
	}

	/**
	 * Getter for macBalance attribute.
	 * @return macBalance attribute
	 */
	public BigDecimal getMacBalance() {
		return macBalance.getValue();
	}

	/**
	 * Setter for macBalance attribute.
	 * @param macBalance the new value of macBalance
	 */
	public void setMacBalance(BigDecimal macBalance) {
		this.macBalance.setValue(macBalance);
	}
}
