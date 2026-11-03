package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity LogCurrency.
 * 
 * <p>About 'logCurrency' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class LogCurrency extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary logCurrency = new Elementary(root,new AlphanumericType(3));
	
	/**
	 * Instantiate a new LogCurrency with a default record.
	 * @param configuration the configuration
	 */
	public LogCurrency(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new LogCurrency bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public LogCurrency(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute logCurrency.
	 * @return the logCurrency attribute reference
	 */
	public ElementaryRangeReference getLogCurrencyReference() {
		return logCurrency.getReference();
	}

	/**
	 * Getter for logCurrency attribute.
	 * @return logCurrency attribute
	 */
	public String getLogCurrency() {
		return logCurrency.getValue();
	}

	/**
	 * Setter for logCurrency attribute.
	 * @param logCurrency the new value of logCurrency
	 */
	public void setLogCurrency(String logCurrency) {
		this.logCurrency.setValue(logCurrency);
	}
}
