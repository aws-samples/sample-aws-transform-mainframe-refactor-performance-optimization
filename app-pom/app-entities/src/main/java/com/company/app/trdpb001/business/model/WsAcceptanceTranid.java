package com.company.app.trdpb001.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Filler;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsAcceptanceTranid.
 * 
 * <p>About 'wsAcceptanceCurrency' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsAcceptanceTranid extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(1));
	private final Elementary wsAcceptanceCurrency = new Elementary(root,new AlphanumericType(3));
	
	/**
	 * Instantiate a new WsAcceptanceTranid with a default record.
	 * @param configuration the configuration
	 */
	public WsAcceptanceTranid(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsAcceptanceTranid bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsAcceptanceTranid(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsAcceptanceCurrency.
	 * @return the wsAcceptanceCurrency attribute reference
	 */
	public ElementaryRangeReference getWsAcceptanceCurrencyReference() {
		return wsAcceptanceCurrency.getReference();
	}

	/**
	 * Getter for wsAcceptanceCurrency attribute.
	 * @return wsAcceptanceCurrency attribute
	 */
	public String getWsAcceptanceCurrency() {
		return wsAcceptanceCurrency.getValue();
	}

	/**
	 * Setter for wsAcceptanceCurrency attribute.
	 * @param wsAcceptanceCurrency the new value of wsAcceptanceCurrency
	 */
	public void setWsAcceptanceCurrency(String wsAcceptanceCurrency) {
		this.wsAcceptanceCurrency.setValue(wsAcceptanceCurrency);
	}
}
