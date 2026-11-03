package com.company.app.trdpb006.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity SecSymbol.
 * 
 * <p>About 'secSymbol' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class SecSymbol extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary secSymbol = new Elementary(root,new AlphanumericType(20));
	
	/**
	 * Instantiate a new SecSymbol with a default record.
	 * @param configuration the configuration
	 */
	public SecSymbol(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new SecSymbol bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public SecSymbol(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute secSymbol.
	 * @return the secSymbol attribute reference
	 */
	public ElementaryRangeReference getSecSymbolReference() {
		return secSymbol.getReference();
	}

	/**
	 * Getter for secSymbol attribute.
	 * @return secSymbol attribute
	 */
	public String getSecSymbol() {
		return secSymbol.getValue();
	}

	/**
	 * Setter for secSymbol attribute.
	 * @param secSymbol the new value of secSymbol
	 */
	public void setSecSymbol(String secSymbol) {
		this.secSymbol.setValue(secSymbol);
	}
}
