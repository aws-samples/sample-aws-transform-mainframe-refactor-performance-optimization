package com.company.app.mstpb002.business.context;
import com.company.app.mstpb002.business.model.ExceptionType;
import com.company.app.mstpb002.business.model.Itbtrdsec;
import com.company.app.mstpb002.business.model.LsSecurityIo;
import com.company.app.mstpb002.business.model.SecCurrency;
import com.company.app.mstpb002.business.model.SecDescription;
import com.company.app.mstpb002.business.model.SecFigi;
import com.company.app.mstpb002.business.model.SecShareClassFigi;
import com.company.app.mstpb002.business.model.SecSymbol;
import com.company.app.mstpb002.business.model.SecType;
import com.company.app.mstpb002.business.model.Sqlca;
import com.company.app.mstpb002.business.model.WsExcpType;
import com.company.app.mstpb002.business.model.WsGetmainFailed;
import com.company.app.mstpb002.business.model.WsSqlcode;
import com.company.app.mstpb002.business.model.WsSystemException;
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
 * Data simplifier context Mstpb002Context.
 * 
 * <p>About 'onCode' field, <br>
 * </p>
 * 
 * <p>About 'onChar' field, <br>
 * </p>
 * 
 * <p>About 'wsSqlcode' field, <br>uml entity: com.company.app.mstpb002.business.model.WsSqlcode
 * <br></p>
 * 
 * <p>About 'wsSystemException' field, <br>uml entity: com.company.app.mstpb002.business.model.WsSystemException
 * <br></p>
 * 
 * <p>About 'wsGetmainFailed' field, <br>uml entity: com.company.app.mstpb002.business.model.WsGetmainFailed
 * <br></p>
 * 
 * <p>About 'wsExcpType' field, <br>uml entity: com.company.app.mstpb002.business.model.WsExcpType
 * <br></p>
 * 
 * <p>About 'exceptionType' field, <br>uml entity: com.company.app.mstpb002.business.model.ExceptionType
 * <br></p>
 * 
 * <p>About 'sqlca' field, <br>uml entity: com.company.app.mstpb002.business.model.Sqlca
 * <br></p>
 * 
 * <p>About 'secFigi' field, <br>uml entity: com.company.app.mstpb002.business.model.SecFigi
 * <br></p>
 * 
 * <p>About 'secCurrency' field, <br>uml entity: com.company.app.mstpb002.business.model.SecCurrency
 * <br></p>
 * 
 * <p>About 'secDescription' field, <br>uml entity: com.company.app.mstpb002.business.model.SecDescription
 * <br></p>
 * 
 * <p>About 'secSymbol' field, <br>uml entity: com.company.app.mstpb002.business.model.SecSymbol
 * <br></p>
 * 
 * <p>About 'secShareClassFigi' field, <br>uml entity: com.company.app.mstpb002.business.model.SecShareClassFigi
 * <br></p>
 * 
 * <p>About 'secType' field, <br>uml entity: com.company.app.mstpb002.business.model.SecType
 * <br></p>
 * 
 * <p>About 'itbtrdsec' field, <br>uml entity: com.company.app.mstpb002.business.model.Itbtrdsec
 * <br></p>
 * 
 * <p>About 'lsSecurityIo' field, <br>uml entity: com.company.app.mstpb002.business.model.LsSecurityIo
 * <br></p>
 * 
 */
@Component("com.company.app.mstpb002.business.context.Mstpb002Context")
@Lazy
@Scope("prototype")
public class Mstpb002Context extends RuntimeContext {
	
	
	private WsSqlcode wsSqlcode;
	private WsSystemException wsSystemException;
	private WsGetmainFailed wsGetmainFailed;
	private WsExcpType wsExcpType;
	private ExceptionType exceptionType;
	private Sqlca sqlca;
	private SecFigi secFigi;
	private SecCurrency secCurrency;
	private SecDescription secDescription;
	private SecSymbol secSymbol;
	private SecShareClassFigi secShareClassFigi;
	private SecType secType;
	private Itbtrdsec itbtrdsec;
	private LsSecurityIo lsSecurityIo;

	private List<RecordEntity> recordEntities;

   /**
	 * Public constructor with injected fields.
	 * @param configuration the datasimplifier configuration to use.
	 */	   
   	
   	public Mstpb002Context (@Qualifier("sharedConfiguration") Configuration configuration){		
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
	 * Getter for secFigi.
	 * @return the secFigi
	 */
	public SecFigi getSecFigi() {
		return this.secFigi;
	}

	/**
	 * Setter for secFigi.
	 * @param reference the new value for secFigi
	 */
	public void setSecFigi(RangeReference reference) {
		this.secFigi.setBytes(reference.getBytes());
	}

	/**
	 * Getter for secCurrency.
	 * @return the secCurrency
	 */
	public SecCurrency getSecCurrency() {
		return this.secCurrency;
	}

	/**
	 * Setter for secCurrency.
	 * @param reference the new value for secCurrency
	 */
	public void setSecCurrency(RangeReference reference) {
		this.secCurrency.setBytes(reference.getBytes());
	}

	/**
	 * Getter for secDescription.
	 * @return the secDescription
	 */
	public SecDescription getSecDescription() {
		return this.secDescription;
	}

	/**
	 * Setter for secDescription.
	 * @param reference the new value for secDescription
	 */
	public void setSecDescription(RangeReference reference) {
		this.secDescription.setBytes(reference.getBytes());
	}

	/**
	 * Getter for secSymbol.
	 * @return the secSymbol
	 */
	public SecSymbol getSecSymbol() {
		return this.secSymbol;
	}

	/**
	 * Setter for secSymbol.
	 * @param reference the new value for secSymbol
	 */
	public void setSecSymbol(RangeReference reference) {
		this.secSymbol.setBytes(reference.getBytes());
	}

	/**
	 * Getter for secShareClassFigi.
	 * @return the secShareClassFigi
	 */
	public SecShareClassFigi getSecShareClassFigi() {
		return this.secShareClassFigi;
	}

	/**
	 * Setter for secShareClassFigi.
	 * @param reference the new value for secShareClassFigi
	 */
	public void setSecShareClassFigi(RangeReference reference) {
		this.secShareClassFigi.setBytes(reference.getBytes());
	}

	/**
	 * Getter for secType.
	 * @return the secType
	 */
	public SecType getSecType() {
		return this.secType;
	}

	/**
	 * Setter for secType.
	 * @param reference the new value for secType
	 */
	public void setSecType(RangeReference reference) {
		this.secType.setBytes(reference.getBytes());
	}

	/**
	 * Getter for itbtrdsec.
	 * @return the itbtrdsec
	 */
	public Itbtrdsec getItbtrdsec() {
		return this.itbtrdsec;
	}

	/**
	 * Setter for itbtrdsec.
	 * @param reference the new value for itbtrdsec
	 */
	public void setItbtrdsec(RangeReference reference) {
		this.itbtrdsec.setBytes(reference.getBytes());
	}

	/**
	 * Getter for lsSecurityIo.
	 * @return the lsSecurityIo
	 */
	public LsSecurityIo getLsSecurityIo() {
		return this.lsSecurityIo;
	}

	/**
	 * Setter for lsSecurityIo.
	 * @param reference the new value for lsSecurityIo
	 */
	public void setLsSecurityIo(RangeReference reference) {
		this.lsSecurityIo.setBytes(reference.getBytes());
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
		secFigi = new SecFigi(configuration);
		secCurrency = new SecCurrency(configuration);
		secDescription = new SecDescription(configuration);
		secSymbol = new SecSymbol(configuration);
		secShareClassFigi = new SecShareClassFigi(configuration);
		secType = new SecType(configuration);
		itbtrdsec = new Itbtrdsec(configuration);
	}
	
	private void initLinkage(Configuration configuration) {
		lsSecurityIo = new LsSecurityIo(configuration, EntityUtils.getUnlinkedRecord());
	
	}

	private void initRecordEntities() {
		recordEntities = Arrays.asList(wsSqlcode, wsSystemException, wsGetmainFailed, wsExcpType, exceptionType, sqlca, secFigi, secCurrency, secDescription, secSymbol, secShareClassFigi, secType, itbtrdsec);
	}

	@Override
	public String toString(){
		StringBuilder toSB = new StringBuilder("\nMstpb002Context:\n");
		if(!this.recordEntities.isEmpty()){
			this.recordEntities.forEach(e -> toSB.append(e.getClass().getSimpleName()).append(" : [").append(e.toString()).append("]\n"));
		}
		toSB.append("LsSecurityIo : [").append(lsSecurityIo.toString()).append("]\n");
		return toSB.toString();
	}
}
