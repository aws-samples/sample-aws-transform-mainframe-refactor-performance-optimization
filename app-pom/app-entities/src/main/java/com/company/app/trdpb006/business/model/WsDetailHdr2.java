package com.company.app.trdpb006.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Filler;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsDetailHdr2.
 * @see RecordEntity
 */
public class WsDetailHdr2 extends RecordEntity {

	private final Group root = new Group(getData()); 
	@SuppressWarnings("unused")
	private final Filler filler = new Filler(root,new AlphanumericType(1),"+");
	@SuppressWarnings("unused")
	private final Filler filler1 = new Filler(root,new AlphanumericType(10),"----------");
	@SuppressWarnings("unused")
	private final Filler filler2 = new Filler(root,new AlphanumericType(1),"+");
	@SuppressWarnings("unused")
	private final Filler filler3 = new Filler(root,new AlphanumericType(12),"------------");
	@SuppressWarnings("unused")
	private final Filler filler4 = new Filler(root,new AlphanumericType(1),"+");
	@SuppressWarnings("unused")
	private final Filler filler5 = new Filler(root,new AlphanumericType(12),"------------");
	@SuppressWarnings("unused")
	private final Filler filler6 = new Filler(root,new AlphanumericType(1),"+");
	@SuppressWarnings("unused")
	private final Filler filler7 = new Filler(root,new AlphanumericType(12),"------------");
	@SuppressWarnings("unused")
	private final Filler filler8 = new Filler(root,new AlphanumericType(1),"+");
	@SuppressWarnings("unused")
	private final Filler filler9 = new Filler(root,new AlphanumericType(20),"--------------------");
	@SuppressWarnings("unused")
	private final Filler filler10 = new Filler(root,new AlphanumericType(1),"+");
	@SuppressWarnings("unused")
	private final Filler filler11 = new Filler(root,new AlphanumericType(40),"----------------------------------------");
	@SuppressWarnings("unused")
	private final Filler filler12 = new Filler(root,new AlphanumericType(1),"+");
	@SuppressWarnings("unused")
	private final Filler filler13 = new Filler(root,new AlphanumericType(15),"---------------");
	@SuppressWarnings("unused")
	private final Filler filler14 = new Filler(root,new AlphanumericType(1),"+");
	@SuppressWarnings("unused")
	private final Filler filler15 = new Filler(root,new AlphanumericType(12),"------------");
	@SuppressWarnings("unused")
	private final Filler filler16 = new Filler(root,new AlphanumericType(1),"+");
	@SuppressWarnings("unused")
	private final Filler filler17 = new Filler(root,new AlphanumericType(3),"---");
	@SuppressWarnings("unused")
	private final Filler filler18 = new Filler(root,new AlphanumericType(1),"+");
	@SuppressWarnings("unused")
	private final Filler filler19 = new Filler(root,new AlphanumericType(12),"------------");
	@SuppressWarnings("unused")
	private final Filler filler20 = new Filler(root,new AlphanumericType(1),"+");
	
	/**
	 * Instantiate a new WsDetailHdr2 with a default record.
	 * @param configuration the configuration
	 */
	public WsDetailHdr2(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsDetailHdr2 bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsDetailHdr2(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

}
