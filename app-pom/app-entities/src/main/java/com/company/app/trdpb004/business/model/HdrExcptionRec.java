package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Filler;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity HdrExcptionRec.
 * @see RecordEntity
 */
public class HdrExcptionRec extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(2),"| ");
	@SuppressWarnings("unused")
	private final Filler filler1 = new Filler(root,new AlphanumericType(20),"EXCEPTION TYPE");
	@SuppressWarnings("unused")
	private final Filler filler2 = new Filler(root,new AlphanumericType(3)," | ");
	@SuppressWarnings("unused")
	private final Filler filler3 = new Filler(root,new AlphanumericType(1000),"DESCRIPTION");
	@SuppressWarnings("unused")
	private final Filler filler4 = new Filler(root,new AlphanumericType(3)," | ");
	
	/**
	 * Instantiate a new HdrExcptionRec with a default record.
	 * @param configuration the configuration
	 */
	public HdrExcptionRec(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new HdrExcptionRec bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public HdrExcptionRec(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

}
