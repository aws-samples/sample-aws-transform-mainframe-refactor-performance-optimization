package com.company.app.trdpb002.business.context;
import com.company.app.trdpb002.business.model.ExceptionRecord;
import com.company.app.trdpb002.business.model.ExceptionRecordLen;
import com.company.app.trdpb002.business.model.Sqlca;
import com.company.app.trdpb002.business.model.TrdOrderPair;
import com.company.app.trdpb002.business.model.WsCrDbSwtich;
import com.company.app.trdpb002.business.model.WsException;
import com.company.app.trdpb002.business.model.WsExcpType;
import com.company.app.trdpb002.business.model.WsSqlcode;
import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.rt.context.RuntimeContext;
import com.netfective.bluage.gapwalk.rt.utils.EntityUtils;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Data simplifier context Trdpb002Context.
 * 
 * <p>About 'onCode' field, <br>
 * </p>
 * 
 * <p>About 'onChar' field, <br>
 * </p>
 * 
 * <p>About 'wsSqlcode' field, <br>uml entity: com.company.app.trdpb002.business.model.WsSqlcode
 * <br></p>
 * 
 * <p>About 'wsCrDbSwtich' field, <br>uml entity: com.company.app.trdpb002.business.model.WsCrDbSwtich
 * <br></p>
 * 
 * <p>About 'wsException' field, <br>uml entity: com.company.app.trdpb002.business.model.WsException
 * <br></p>
 * 
 * <p>About 'wsExcpType' field, <br>uml entity: com.company.app.trdpb002.business.model.WsExcpType
 * <br></p>
 * 
 * <p>About 'exceptionRecordLen' field, <br>uml entity: com.company.app.trdpb002.business.model.ExceptionRecordLen
 * <br></p>
 * 
 * <p>About 'exceptionRecord' field, <br>uml entity: com.company.app.trdpb002.business.model.ExceptionRecord
 * <br></p>
 * 
 * <p>About 'sqlca' field, <br>uml entity: com.company.app.trdpb002.business.model.Sqlca
 * <br></p>
 * 
 * <p>About 'trdOrderPair' field, <br>uml entity: com.company.app.trdpb002.business.model.TrdOrderPair
 * <br></p>
 * 
 */
@Component("com.company.app.trdpb002.business.context.Trdpb002Context")
@Lazy
@Scope("prototype")
public class Trdpb002Context extends RuntimeContext {
	
	
	private WsSqlcode wsSqlcode;
	private WsCrDbSwtich wsCrDbSwtich;
	private WsException wsException;
	private WsExcpType wsExcpType;
	private ExceptionRecordLen exceptionRecordLen;
	private ExceptionRecord exceptionRecord;
	private Sqlca sqlca;
	private TrdOrderPair trdOrderPair;

	private List<RecordEntity> recordEntities;

   /**
	 * Public constructor with injected fields.
	 * @param configuration the datasimplifier configuration to use.
	 */	   
   	
   	public Trdpb002Context (@Qualifier("sharedConfiguration") Configuration configuration){		
	    super(configuration);
		initWorking(configuration);
		initLinkage(configuration);
		initRecordEntities();
	}
 	
	

	/**
	 * Getter for wsSqlcode.
	 * @return the wsSqlcode
	 */
	public WsSqlcode getWsSqlcode() {
		return this.wsSqlcode;
	}

	/**
	 * Setter for wsSqlcode.
	 * @param reference the new value for wsSqlcode
	 */
	public void setWsSqlcode(RangeReference reference) {
		this.wsSqlcode.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsCrDbSwtich.
	 * @return the wsCrDbSwtich
	 */
	public WsCrDbSwtich getWsCrDbSwtich() {
		return this.wsCrDbSwtich;
	}

	/**
	 * Setter for wsCrDbSwtich.
	 * @param reference the new value for wsCrDbSwtich
	 */
	public void setWsCrDbSwtich(RangeReference reference) {
		this.wsCrDbSwtich.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsException.
	 * @return the wsException
	 */
	public WsException getWsException() {
		return this.wsException;
	}

	/**
	 * Setter for wsException.
	 * @param reference the new value for wsException
	 */
	public void setWsException(RangeReference reference) {
		this.wsException.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsExcpType.
	 * @return the wsExcpType
	 */
	public WsExcpType getWsExcpType() {
		return this.wsExcpType;
	}

	/**
	 * Setter for wsExcpType.
	 * @param reference the new value for wsExcpType
	 */
	public void setWsExcpType(RangeReference reference) {
		this.wsExcpType.setBytes(reference.getBytes());
	}

	/**
	 * Getter for exceptionRecordLen.
	 * @return the exceptionRecordLen
	 */
	public ExceptionRecordLen getExceptionRecordLen() {
		return this.exceptionRecordLen;
	}

	/**
	 * Setter for exceptionRecordLen.
	 * @param reference the new value for exceptionRecordLen
	 */
	public void setExceptionRecordLen(RangeReference reference) {
		this.exceptionRecordLen.setBytes(reference.getBytes());
	}

	/**
	 * Getter for exceptionRecord.
	 * @return the exceptionRecord
	 */
	public ExceptionRecord getExceptionRecord() {
		return this.exceptionRecord;
	}

	/**
	 * Setter for exceptionRecord.
	 * @param reference the new value for exceptionRecord
	 */
	public void setExceptionRecord(RangeReference reference) {
		this.exceptionRecord.setBytes(reference.getBytes());
	}

	/**
	 * Getter for sqlca.
	 * @return the sqlca
	 */
	public Sqlca getSqlca() {
		return this.sqlca;
	}

	/**
	 * Setter for sqlca.
	 * @param reference the new value for sqlca
	 */
	public void setSqlca(RangeReference reference) {
		this.sqlca.setBytes(reference.getBytes());
	}

	/**
	 * Getter for trdOrderPair.
	 * @return the trdOrderPair
	 */
	public TrdOrderPair getTrdOrderPair() {
		return this.trdOrderPair;
	}

	/**
	 * Setter for trdOrderPair.
	 * @param reference the new value for trdOrderPair
	 */
	public void setTrdOrderPair(RangeReference reference) {
		this.trdOrderPair.setBytes(reference.getBytes());
	}

	@Override 
	public void cleanUp(){
		// No resources to clean up
	}

	@Override
	protected void doReset() {
		cleanUp();
	    // reset the working
		recordEntities.stream().forEach(e -> e.reset());
	}

	
	private void initWorking(Configuration configuration) {
		wsSqlcode = new WsSqlcode(configuration);
		wsCrDbSwtich = new WsCrDbSwtich(configuration);
		wsException = new WsException(configuration);
		wsExcpType = new WsExcpType(configuration);
		exceptionRecordLen = new ExceptionRecordLen(configuration);
		exceptionRecord = new ExceptionRecord(configuration);
		sqlca = new Sqlca(configuration);
	}
	
	private void initLinkage(Configuration configuration) {
		trdOrderPair = new TrdOrderPair(configuration, EntityUtils.getUnlinkedRecord());
	
	}

	private void initRecordEntities() {
		recordEntities = Arrays.asList(wsSqlcode, wsCrDbSwtich, wsException, wsExcpType, exceptionRecordLen, exceptionRecord, sqlca);
	}

	@Override
	public String toString(){
		StringBuilder toSB = new StringBuilder("\nTrdpb002Context:\n");
		if(!this.recordEntities.isEmpty()){
			this.recordEntities.forEach(e -> toSB.append(e.getClass().getSimpleName()).append(" : [").append(e.toString()).append("]\n"));
		}
		toSB.append("TrdOrderPair : [").append(trdOrderPair.toString()).append("]\n");
		return toSB.toString();
	}
}
