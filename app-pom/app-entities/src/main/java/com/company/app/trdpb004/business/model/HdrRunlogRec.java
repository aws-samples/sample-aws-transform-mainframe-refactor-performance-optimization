package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Filler;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity HdrRunlogRec.
 * @see RecordEntity
 */
public class HdrRunlogRec extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(2),"| ");
	@SuppressWarnings("unused")
	private final Filler filler1 = new Filler(root,new AlphanumericType(12),"TRANSACTION");
	@SuppressWarnings("unused")
	private final Filler filler2 = new Filler(root,new AlphanumericType(3)," | ");
	@SuppressWarnings("unused")
	private final Filler filler3 = new Filler(root,new AlphanumericType(8),"CURRENCY");
	@SuppressWarnings("unused")
	private final Filler filler4 = new Filler(root,new AlphanumericType(3)," | ");
	@SuppressWarnings("unused")
	private final Filler filler5 = new Filler(root,new AlphanumericType(26),"START TIMESTAMP");
	@SuppressWarnings("unused")
	private final Filler filler6 = new Filler(root,new AlphanumericType(3)," | ");
	@SuppressWarnings("unused")
	private final Filler filler7 = new Filler(root,new AlphanumericType(26),"END TIMESTAMP");
	@SuppressWarnings("unused")
	private final Filler filler8 = new Filler(root,new AlphanumericType(3)," | ");
	
	/**
	 * Instantiate a new HdrRunlogRec with a default record.
	 * @param configuration the configuration
	 */
	public HdrRunlogRec(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new HdrRunlogRec bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public HdrRunlogRec(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

}
