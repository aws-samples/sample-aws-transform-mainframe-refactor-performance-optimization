package com.company.app.trdpbexc.business.context;
import com.company.app.trdpbexc.business.model.ExcDescription;
import com.company.app.trdpbexc.business.model.ExcType;
import com.company.app.trdpbexc.business.model.ExceptionRecord;
import com.company.app.trdpbexc.business.model.ExceptionRecordLen;
import com.company.app.trdpbexc.business.model.Itbtrdexc;
import com.company.app.trdpbexc.business.model.Sqlca;
import com.company.app.trdpbexc.business.model.WsAbendCode;
import com.company.app.trdpbexc.business.model.WsDateTimeVars;
import com.company.app.trdpbexc.business.model.WsExceptionHandler;
import com.company.app.trdpbexc.business.model.WsExcpType;
import com.company.app.trdpbexc.business.model.WsSqlcode;
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
 * Data simplifier context TrdpbexcContext.
 * 
 * <p>About 'onCode' field, <br>
 * </p>
 * 
 * <p>About 'onChar' field, <br>
 * </p>
 * 
 * <p>About 'wsSqlcode' field, <br>uml entity: com.company.app.trdpbexc.business.model.WsSqlcode
 * <br></p>
 * 
 * <p>About 'wsAbendCode' field, <br>uml entity: com.company.app.trdpbexc.business.model.WsAbendCode
 * <br></p>
 * 
 * <p>About 'sqlca' field, <br>uml entity: com.company.app.trdpbexc.business.model.Sqlca
 * <br></p>
 * 
 * <p>About 'excType' field, <br>uml entity: com.company.app.trdpbexc.business.model.ExcType
 * <br></p>
 * 
 * <p>About 'excDescription' field, <br>uml entity: com.company.app.trdpbexc.business.model.ExcDescription
 * <br></p>
 * 
 * <p>About 'itbtrdexc' field, <br>uml entity: com.company.app.trdpbexc.business.model.Itbtrdexc
 * <br></p>
 * 
 * <p>About 'wsExceptionHandler' field, <br>uml entity: com.company.app.trdpbexc.business.model.WsExceptionHandler
 * <br></p>
 * 
 * <p>About 'wsDateTimeVars' field, <br>uml entity: com.company.app.trdpbexc.business.model.WsDateTimeVars
 * <br></p>
 * 
 * <p>About 'wsExcpType' field, <br>uml entity: com.company.app.trdpbexc.business.model.WsExcpType
 * <br></p>
 * 
 * <p>About 'exceptionRecordLen' field, <br>uml entity: com.company.app.trdpbexc.business.model.ExceptionRecordLen
 * <br></p>
 * 
 * <p>About 'exceptionRecord' field, <br>uml entity: com.company.app.trdpbexc.business.model.ExceptionRecord
 * <br></p>
 * 
 */
@Component("com.company.app.trdpbexc.business.context.TrdpbexcContext")
@Lazy
@Scope("prototype")
public class TrdpbexcContext extends RuntimeContext {
	
	
	private WsSqlcode wsSqlcode;
	private WsAbendCode wsAbendCode;
	private Sqlca sqlca;
	private ExcType excType;
	private ExcDescription excDescription;
	private Itbtrdexc itbtrdexc;
	private WsExceptionHandler wsExceptionHandler;
	private WsDateTimeVars wsDateTimeVars;
	private WsExcpType wsExcpType;
	private ExceptionRecordLen exceptionRecordLen;
	private ExceptionRecord exceptionRecord;

	private List<RecordEntity> recordEntities;

   /**
	 * Public constructor with injected fields.
	 * @param configuration the datasimplifier configuration to use.
	 */	   
   	
   	public TrdpbexcContext (@Qualifier("sharedConfiguration") Configuration configuration){		
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
	 * Getter for wsAbendCode.
	 * @return the wsAbendCode
	 */
	public WsAbendCode getWsAbendCode() {
		return this.wsAbendCode;
	}

	/**
	 * Setter for wsAbendCode.
	 * @param reference the new value for wsAbendCode
	 */
	public void setWsAbendCode(RangeReference reference) {
		this.wsAbendCode.setBytes(reference.getBytes());
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
	 * Getter for excType.
	 * @return the excType
	 */
	public ExcType getExcType() {
		return this.excType;
	}

	/**
	 * Setter for excType.
	 * @param reference the new value for excType
	 */
	public void setExcType(RangeReference reference) {
		this.excType.setBytes(reference.getBytes());
	}

	/**
	 * Getter for excDescription.
	 * @return the excDescription
	 */
	public ExcDescription getExcDescription() {
		return this.excDescription;
	}

	/**
	 * Setter for excDescription.
	 * @param reference the new value for excDescription
	 */
	public void setExcDescription(RangeReference reference) {
		this.excDescription.setBytes(reference.getBytes());
	}

	/**
	 * Getter for itbtrdexc.
	 * @return the itbtrdexc
	 */
	public Itbtrdexc getItbtrdexc() {
		return this.itbtrdexc;
	}

	/**
	 * Setter for itbtrdexc.
	 * @param reference the new value for itbtrdexc
	 */
	public void setItbtrdexc(RangeReference reference) {
		this.itbtrdexc.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsExceptionHandler.
	 * @return the wsExceptionHandler
	 */
	public WsExceptionHandler getWsExceptionHandler() {
		return this.wsExceptionHandler;
	}

	/**
	 * Setter for wsExceptionHandler.
	 * @param reference the new value for wsExceptionHandler
	 */
	public void setWsExceptionHandler(RangeReference reference) {
		this.wsExceptionHandler.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsDateTimeVars.
	 * @return the wsDateTimeVars
	 */
	public WsDateTimeVars getWsDateTimeVars() {
		return this.wsDateTimeVars;
	}

	/**
	 * Setter for wsDateTimeVars.
	 * @param reference the new value for wsDateTimeVars
	 */
	public void setWsDateTimeVars(RangeReference reference) {
		this.wsDateTimeVars.setBytes(reference.getBytes());
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
		wsAbendCode = new WsAbendCode(configuration);
		sqlca = new Sqlca(configuration);
		excType = new ExcType(configuration);
		excDescription = new ExcDescription(configuration);
		itbtrdexc = new Itbtrdexc(configuration);
	}
	
	private void initLinkage(Configuration configuration) {
		wsExceptionHandler = new WsExceptionHandler(configuration, EntityUtils.getUnlinkedRecord());
		wsDateTimeVars = new WsDateTimeVars(configuration, EntityUtils.getUnlinkedRecord());
		wsExcpType = new WsExcpType(configuration, EntityUtils.getUnlinkedRecord());
		exceptionRecordLen = new ExceptionRecordLen(configuration, EntityUtils.getUnlinkedRecord());
		exceptionRecord = new ExceptionRecord(configuration, EntityUtils.getUnlinkedRecord());
	
	}

	private void initRecordEntities() {
		recordEntities = Arrays.asList(wsSqlcode, wsAbendCode, sqlca, excType, excDescription, itbtrdexc);
	}

	@Override
	public String toString(){
		StringBuilder toSB = new StringBuilder("\nTrdpbexcContext:\n");
		if(!this.recordEntities.isEmpty()){
			this.recordEntities.forEach(e -> toSB.append(e.getClass().getSimpleName()).append(" : [").append(e.toString()).append("]\n"));
		}
		toSB.append("WsExceptionHandler : [").append(wsExceptionHandler.toString()).append("]\n");
		toSB.append("WsDateTimeVars : [").append(wsDateTimeVars.toString()).append("]\n");
		toSB.append("WsExcpType : [").append(wsExcpType.toString()).append("]\n");
		toSB.append("ExceptionRecordLen : [").append(exceptionRecordLen.toString()).append("]\n");
		toSB.append("ExceptionRecord : [").append(exceptionRecord.toString()).append("]\n");
		return toSB.toString();
	}
}
