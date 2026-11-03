package com.company.app.trdpb004.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Filler;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity HdrSummaryRec.
 * @see RecordEntity
 */
public class HdrSummaryRec extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(2),"| ");
	@SuppressWarnings("unused")
	private final Filler filler1 = new Filler(root,new AlphanumericType(12),"CUSTOMER");
	@SuppressWarnings("unused")
	private final Filler filler2 = new Filler(root,new AlphanumericType(3)," | ");
	@SuppressWarnings("unused")
	private final Filler filler3 = new Filler(root,new AlphanumericType(11, true),"OVERDUE");
	@SuppressWarnings("unused")
	private final Filler filler4 = new Filler(root,new AlphanumericType(3)," | ");
	@SuppressWarnings("unused")
	private final Filler filler5 = new Filler(root,new AlphanumericType(11, true),"REJECTED");
	@SuppressWarnings("unused")
	private final Filler filler6 = new Filler(root,new AlphanumericType(3)," | ");
	@SuppressWarnings("unused")
	private final Filler filler7 = new Filler(root,new AlphanumericType(11, true),"SETTLED");
	@SuppressWarnings("unused")
	private final Filler filler8 = new Filler(root,new AlphanumericType(3)," | ");
	@SuppressWarnings("unused")
	private final Filler filler9 = new Filler(root,new AlphanumericType(8),"CURRENCY");
	@SuppressWarnings("unused")
	private final Filler filler10 = new Filler(root,new AlphanumericType(3)," | ");
	@SuppressWarnings("unused")
	private final Filler filler11 = new Filler(root,new AlphanumericType(14, true),"OPEN BALANCE");
	@SuppressWarnings("unused")
	private final Filler filler12 = new Filler(root,new AlphanumericType(4)," |  ");
	@SuppressWarnings("unused")
	private final Filler filler13 = new Filler(root,new AlphanumericType(14, true),"DEBITS ");
	@SuppressWarnings("unused")
	private final Filler filler14 = new Filler(root,new AlphanumericType(4)," |  ");
	@SuppressWarnings("unused")
	private final Filler filler15 = new Filler(root,new AlphanumericType(14, true),"CREDITS");
	@SuppressWarnings("unused")
	private final Filler filler16 = new Filler(root,new AlphanumericType(3)," | ");
	@SuppressWarnings("unused")
	private final Filler filler17 = new Filler(root,new AlphanumericType(14, true),"CLOSE BALANCE");
	@SuppressWarnings("unused")
	private final Filler filler18 = new Filler(root,new AlphanumericType(3)," | ");
	
	/**
	 * Instantiate a new HdrSummaryRec with a default record.
	 * @param configuration the configuration
	 */
	public HdrSummaryRec(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new HdrSummaryRec bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public HdrSummaryRec(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

}
