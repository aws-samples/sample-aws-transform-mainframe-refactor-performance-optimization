package com.company.app.mstpb001.business.context;
import com.company.app.mstpb001.business.model.CusCurrency;
import com.company.app.mstpb001.business.model.CusCustomerId;
import com.company.app.mstpb001.business.model.CusDescription;
import com.company.app.mstpb001.business.model.CusStatus;
import com.company.app.mstpb001.business.model.ExceptionType;
import com.company.app.mstpb001.business.model.Itbtrdcus;
import com.company.app.mstpb001.business.model.LsCustomerIo;
import com.company.app.mstpb001.business.model.Sqlca;
import com.company.app.mstpb001.business.model.WsExcpType;
import com.company.app.mstpb001.business.model.WsGetmainFailed;
import com.company.app.mstpb001.business.model.WsSqlcode;
import com.company.app.mstpb001.business.model.WsSystemException;
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
 * Data simplifier context Mstpb001Context.
 * 
 * <p>About 'onCode' field, <br>
 * </p>
 * 
 * <p>About 'onChar' field, <br>
 * </p>
 * 
 * <p>About 'wsSqlcode' field, <br>uml entity: com.company.app.mstpb001.business.model.WsSqlcode
 * <br></p>
 * 
 * <p>About 'wsSystemException' field, <br>uml entity: com.company.app.mstpb001.business.model.WsSystemException
 * <br></p>
 * 
 * <p>About 'wsGetmainFailed' field, <br>uml entity: com.company.app.mstpb001.business.model.WsGetmainFailed
 * <br></p>
 * 
 * <p>About 'wsExcpType' field, <br>uml entity: com.company.app.mstpb001.business.model.WsExcpType
 * <br></p>
 * 
 * <p>About 'exceptionType' field, <br>uml entity: com.company.app.mstpb001.business.model.ExceptionType
 * <br></p>
 * 
 * <p>About 'sqlca' field, <br>uml entity: com.company.app.mstpb001.business.model.Sqlca
 * <br></p>
 * 
 * <p>About 'cusCustomerId' field, <br>uml entity: com.company.app.mstpb001.business.model.CusCustomerId
 * <br></p>
 * 
 * <p>About 'cusCurrency' field, <br>uml entity: com.company.app.mstpb001.business.model.CusCurrency
 * <br></p>
 * 
 * <p>About 'cusDescription' field, <br>uml entity: com.company.app.mstpb001.business.model.CusDescription
 * <br></p>
 * 
 * <p>About 'cusStatus' field, <br>uml entity: com.company.app.mstpb001.business.model.CusStatus
 * <br></p>
 * 
 * <p>About 'itbtrdcus' field, <br>uml entity: com.company.app.mstpb001.business.model.Itbtrdcus
 * <br></p>
 * 
 * <p>About 'lsCustomerIo' field, <br>uml entity: com.company.app.mstpb001.business.model.LsCustomerIo
 * <br></p>
 * 
 */
@Component("com.company.app.mstpb001.business.context.Mstpb001Context")
@Lazy
@Scope("prototype")
public class Mstpb001Context extends RuntimeContext {
	
	
	private WsSqlcode wsSqlcode;
	private WsSystemException wsSystemException;
	private WsGetmainFailed wsGetmainFailed;
	private WsExcpType wsExcpType;
	private ExceptionType exceptionType;
	private Sqlca sqlca;
	private CusCustomerId cusCustomerId;
	private CusCurrency cusCurrency;
	private CusDescription cusDescription;
	private CusStatus cusStatus;
	private Itbtrdcus itbtrdcus;
	private LsCustomerIo lsCustomerIo;

	private List<RecordEntity> recordEntities;

   /**
	 * Public constructor with injected fields.
	 * @param configuration the datasimplifier configuration to use.
	 */	   
   	
   	public Mstpb001Context (@Qualifier("sharedConfiguration") Configuration configuration){		
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
	 * Getter for wsSystemException.
	 * @return the wsSystemException
	 */
	public WsSystemException getWsSystemException() {
		return this.wsSystemException;
	}

	/**
	 * Setter for wsSystemException.
	 * @param reference the new value for wsSystemException
	 */
	public void setWsSystemException(RangeReference reference) {
		this.wsSystemException.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsGetmainFailed.
	 * @return the wsGetmainFailed
	 */
	public WsGetmainFailed getWsGetmainFailed() {
		return this.wsGetmainFailed;
	}

	/**
	 * Setter for wsGetmainFailed.
	 * @param reference the new value for wsGetmainFailed
	 */
	public void setWsGetmainFailed(RangeReference reference) {
		this.wsGetmainFailed.setBytes(reference.getBytes());
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
	 * Getter for exceptionType.
	 * @return the exceptionType
	 */
	public ExceptionType getExceptionType() {
		return this.exceptionType;
	}

	/**
	 * Setter for exceptionType.
	 * @param reference the new value for exceptionType
	 */
	public void setExceptionType(RangeReference reference) {
		this.exceptionType.setBytes(reference.getBytes());
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
	 * Getter for cusCustomerId.
	 * @return the cusCustomerId
	 */
	public CusCustomerId getCusCustomerId() {
		return this.cusCustomerId;
	}

	/**
	 * Setter for cusCustomerId.
	 * @param reference the new value for cusCustomerId
	 */
	public void setCusCustomerId(RangeReference reference) {
		this.cusCustomerId.setBytes(reference.getBytes());
	}

	/**
	 * Getter for cusCurrency.
	 * @return the cusCurrency
	 */
	public CusCurrency getCusCurrency() {
		return this.cusCurrency;
	}

	/**
	 * Setter for cusCurrency.
	 * @param reference the new value for cusCurrency
	 */
	public void setCusCurrency(RangeReference reference) {
		this.cusCurrency.setBytes(reference.getBytes());
	}

	/**
	 * Getter for cusDescription.
	 * @return the cusDescription
	 */
	public CusDescription getCusDescription() {
		return this.cusDescription;
	}

	/**
	 * Setter for cusDescription.
	 * @param reference the new value for cusDescription
	 */
	public void setCusDescription(RangeReference reference) {
		this.cusDescription.setBytes(reference.getBytes());
	}

	/**
	 * Getter for cusStatus.
	 * @return the cusStatus
	 */
	public CusStatus getCusStatus() {
		return this.cusStatus;
	}

	/**
	 * Setter for cusStatus.
	 * @param reference the new value for cusStatus
	 */
	public void setCusStatus(RangeReference reference) {
		this.cusStatus.setBytes(reference.getBytes());
	}

	/**
	 * Getter for itbtrdcus.
	 * @return the itbtrdcus
	 */
	public Itbtrdcus getItbtrdcus() {
		return this.itbtrdcus;
	}

	/**
	 * Setter for itbtrdcus.
	 * @param reference the new value for itbtrdcus
	 */
	public void setItbtrdcus(RangeReference reference) {
		this.itbtrdcus.setBytes(reference.getBytes());
	}

	/**
	 * Getter for lsCustomerIo.
	 * @return the lsCustomerIo
	 */
	public LsCustomerIo getLsCustomerIo() {
		return this.lsCustomerIo;
	}

	/**
	 * Setter for lsCustomerIo.
	 * @param reference the new value for lsCustomerIo
	 */
	public void setLsCustomerIo(RangeReference reference) {
		this.lsCustomerIo.setBytes(reference.getBytes());
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
		wsSystemException = new WsSystemException(configuration);
		wsGetmainFailed = new WsGetmainFailed(configuration);
		wsExcpType = new WsExcpType(configuration);
		exceptionType = new ExceptionType(configuration);
		sqlca = new Sqlca(configuration);
		cusCustomerId = new CusCustomerId(configuration);
		cusCurrency = new CusCurrency(configuration);
		cusDescription = new CusDescription(configuration);
		cusStatus = new CusStatus(configuration);
		itbtrdcus = new Itbtrdcus(configuration);
	}
	
	private void initLinkage(Configuration configuration) {
		lsCustomerIo = new LsCustomerIo(configuration, EntityUtils.getUnlinkedRecord());
	
	}

	private void initRecordEntities() {
		recordEntities = Arrays.asList(wsSqlcode, wsSystemException, wsGetmainFailed, wsExcpType, exceptionType, sqlca, cusCustomerId, cusCurrency, cusDescription, cusStatus, itbtrdcus);
	}

	@Override
	public String toString(){
		StringBuilder toSB = new StringBuilder("\nMstpb001Context:\n");
		if(!this.recordEntities.isEmpty()){
			this.recordEntities.forEach(e -> toSB.append(e.getClass().getSimpleName()).append(" : [").append(e.toString()).append("]\n"));
		}
		toSB.append("LsCustomerIo : [").append(lsCustomerIo.toString()).append("]\n");
		return toSB.toString();
	}
}
