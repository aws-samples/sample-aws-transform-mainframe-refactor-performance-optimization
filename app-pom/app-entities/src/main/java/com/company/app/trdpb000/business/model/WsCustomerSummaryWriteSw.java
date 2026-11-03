package com.company.app.trdpb000.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ConditionReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.ConditionName;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
import java.util.Arrays;
/**
 * Data simplifier entity WsCustomerSummaryWriteSw.
<pre>
 * 
 * Legacy Documentation:<br>
 *  ****************************************************************<br>
 *   THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 9       *<br>
 *  <br>
</pre>
 * 
 * <p>About 'wsCustomerSummaryWriteSw' field, <br>
 *  ****************************************************************<br>
 *   THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 9       *<br>
 *  <br></p>
 * 
 * <p>About 'customerSummaryWrite' field, <br>
 * </p>
 * 
 * <p>About 'customerSummaryRewrite' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsCustomerSummaryWriteSw extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * ****************************************************************
	 * THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 9       *
	 * 
	 */
	private final Elementary wsCustomerSummaryWriteSw = new Elementary(root,new AlphanumericType(1));
	private final ConditionName customerSummaryWrite = new ConditionName(wsCustomerSummaryWriteSw,
		Arrays.asList("W"));
	private final ConditionName customerSummaryRewrite = new ConditionName(wsCustomerSummaryWriteSw,
		Arrays.asList("R"));
	
	/**
	 * Instantiate a new WsCustomerSummaryWriteSw with a default record.
	 * @param configuration the configuration
	 */
	public WsCustomerSummaryWriteSw(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsCustomerSummaryWriteSw bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsCustomerSummaryWriteSw(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsCustomerSummaryWriteSw.
	 * @return the wsCustomerSummaryWriteSw attribute reference
	 */
	public ElementaryRangeReference getWsCustomerSummaryWriteSwReference() {
		return wsCustomerSummaryWriteSw.getReference();
	}

	/**
	 * Getter for wsCustomerSummaryWriteSw attribute.
	 * @return wsCustomerSummaryWriteSw attribute
	 */
	public String getWsCustomerSummaryWriteSw() {
		return wsCustomerSummaryWriteSw.getValue();
	}

	/**
	 * Setter for wsCustomerSummaryWriteSw attribute.
	 * @param wsCustomerSummaryWriteSw the new value of wsCustomerSummaryWriteSw
	 */
	public void setWsCustomerSummaryWriteSw(String wsCustomerSummaryWriteSw) {
		this.wsCustomerSummaryWriteSw.setValue(wsCustomerSummaryWriteSw);
	}
	/**
	 * Gets the reference for attribute customerSummaryWrite.
	 * @return the customerSummaryWrite attribute reference
	 */
	public ConditionReference getCustomerSummaryWriteReference() {
		return wsCustomerSummaryWriteSw.getCondition(customerSummaryWrite);	
	}

	/**
	 * Getter for customerSummaryWrite attribute.
	 * @return customerSummaryWrite attribute
	 */
	public boolean isCustomerSummaryWrite() {
		return getCustomerSummaryWriteReference().getValue();	
	}

	/**
	 * Setter for customerSummaryWrite attribute.
	 * @param customerSummaryWrite the new value of customerSummaryWrite
	 */
	public void setCustomerSummaryWrite(boolean customerSummaryWrite) {
		getCustomerSummaryWriteReference().setValue(customerSummaryWrite);	
	}
	/**
	 * Gets the reference for attribute customerSummaryRewrite.
	 * @return the customerSummaryRewrite attribute reference
	 */
	public ConditionReference getCustomerSummaryRewriteReference() {
		return wsCustomerSummaryWriteSw.getCondition(customerSummaryRewrite);	
	}

	/**
	 * Getter for customerSummaryRewrite attribute.
	 * @return customerSummaryRewrite attribute
	 */
	public boolean isCustomerSummaryRewrite() {
		return getCustomerSummaryRewriteReference().getValue();	
	}

	/**
	 * Setter for customerSummaryRewrite attribute.
	 * @param customerSummaryRewrite the new value of customerSummaryRewrite
	 */
	public void setCustomerSummaryRewrite(boolean customerSummaryRewrite) {
		getCustomerSummaryRewriteReference().setValue(customerSummaryRewrite);	
	}
}
