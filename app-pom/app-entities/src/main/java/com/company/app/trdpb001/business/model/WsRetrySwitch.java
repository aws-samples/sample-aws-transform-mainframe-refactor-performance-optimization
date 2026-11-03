package com.company.app.trdpb001.business.model;

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
 * Data simplifier entity WsRetrySwitch.
 * 
 * <p>About 'wsRetrySwitch' field, <br>
 * </p>
 * 
 * <p>About 'doSql' field, <br>
 * </p>
 * 
 * <p>About 'retrySql' field, <br>
 * </p>
 * 
 * <p>About 'sqlDone' field, <br>
 * </p>
 * 
 * @see RecordEntity
 */
public class WsRetrySwitch extends RecordEntity {

	private final Group root = new Group(getData()); 
	private final Elementary wsRetrySwitch = new Elementary(root,new AlphanumericType(1));
	private final ConditionName doSql = new ConditionName(wsRetrySwitch,
		Arrays.asList("D"));
	private final ConditionName retrySql = new ConditionName(wsRetrySwitch,
		Arrays.asList("R"));
	private final ConditionName sqlDone = new ConditionName(wsRetrySwitch,
		Arrays.asList("S"));
	
	/**
	 * Instantiate a new WsRetrySwitch with a default record.
	 * @param configuration the configuration
	 */
	public WsRetrySwitch(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsRetrySwitch bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsRetrySwitch(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsRetrySwitch.
	 * @return the wsRetrySwitch attribute reference
	 */
	public ElementaryRangeReference getWsRetrySwitchReference() {
		return wsRetrySwitch.getReference();
	}

	/**
	 * Getter for wsRetrySwitch attribute.
	 * @return wsRetrySwitch attribute
	 */
	public String getWsRetrySwitch() {
		return wsRetrySwitch.getValue();
	}

	/**
	 * Setter for wsRetrySwitch attribute.
	 * @param wsRetrySwitch the new value of wsRetrySwitch
	 */
	public void setWsRetrySwitch(String wsRetrySwitch) {
		this.wsRetrySwitch.setValue(wsRetrySwitch);
	}
	/**
	 * Gets the reference for attribute doSql.
	 * @return the doSql attribute reference
	 */
	public ConditionReference getDoSqlReference() {
		return wsRetrySwitch.getCondition(doSql);	
	}

	/**
	 * Getter for doSql attribute.
	 * @return doSql attribute
	 */
	public boolean isDoSql() {
		return getDoSqlReference().getValue();	
	}

	/**
	 * Setter for doSql attribute.
	 * @param doSql the new value of doSql
	 */
	public void setDoSql(boolean doSql) {
		getDoSqlReference().setValue(doSql);	
	}
	/**
	 * Gets the reference for attribute retrySql.
	 * @return the retrySql attribute reference
	 */
	public ConditionReference getRetrySqlReference() {
		return wsRetrySwitch.getCondition(retrySql);	
	}

	/**
	 * Getter for retrySql attribute.
	 * @return retrySql attribute
	 */
	public boolean isRetrySql() {
		return getRetrySqlReference().getValue();	
	}

	/**
	 * Setter for retrySql attribute.
	 * @param retrySql the new value of retrySql
	 */
	public void setRetrySql(boolean retrySql) {
		getRetrySqlReference().setValue(retrySql);	
	}
	/**
	 * Gets the reference for attribute sqlDone.
	 * @return the sqlDone attribute reference
	 */
	public ConditionReference getSqlDoneReference() {
		return wsRetrySwitch.getCondition(sqlDone);	
	}

	/**
	 * Getter for sqlDone attribute.
	 * @return sqlDone attribute
	 */
	public boolean isSqlDone() {
		return getSqlDoneReference().getValue();	
	}

	/**
	 * Setter for sqlDone attribute.
	 * @param sqlDone the new value of sqlDone
	 */
	public void setSqlDone(boolean sqlDone) {
		getSqlDoneReference().setValue(sqlDone);	
	}
}
