package com.company.app.trdpb000.business.context;
import com.company.app.trdpb000.business.model.Dcltbtrdlog;
import com.company.app.trdpb000.business.model.Dcltbtrdsum;
import com.company.app.trdpb000.business.model.ExceptionRecord;
import com.company.app.trdpb000.business.model.ExceptionRecordLen;
import com.company.app.trdpb000.business.model.Itbtrdlog;
import com.company.app.trdpb000.business.model.Itbtrdmac;
import com.company.app.trdpb000.business.model.Itbtrdord;
import com.company.app.trdpb000.business.model.Itbtrdsac;
import com.company.app.trdpb000.business.model.Itbtrdstq;
import com.company.app.trdpb000.business.model.Itbtrdsum;
import com.company.app.trdpb000.business.model.LkParm;
import com.company.app.trdpb000.business.model.MacBalance;
import com.company.app.trdpb000.business.model.MacCurrency;
import com.company.app.trdpb000.business.model.MacCustomerId;
import com.company.app.trdpb000.business.model.MacNumber;
import com.company.app.trdpb000.business.model.MacStatus;
import com.company.app.trdpb000.business.model.OrdAmount;
import com.company.app.trdpb000.business.model.OrdBuySellInd;
import com.company.app.trdpb000.business.model.OrdCurrency;
import com.company.app.trdpb000.business.model.OrdCustomerId;
import com.company.app.trdpb000.business.model.OrdFigi;
import com.company.app.trdpb000.business.model.OrdQuantity;
import com.company.app.trdpb000.business.model.OrdStatus;
import com.company.app.trdpb000.business.model.OrdTradeid;
import com.company.app.trdpb000.business.model.OrdTradingXchng;
import com.company.app.trdpb000.business.model.SacCurrency;
import com.company.app.trdpb000.business.model.SacCustomerId;
import com.company.app.trdpb000.business.model.SacNumber;
import com.company.app.trdpb000.business.model.SacStatus;
import com.company.app.trdpb000.business.model.Sqlca;
import com.company.app.trdpb000.business.model.TrdOrderPair;
import com.company.app.trdpb000.business.model.WsAccDisp;
import com.company.app.trdpb000.business.model.WsCustomerCheck;
import com.company.app.trdpb000.business.model.WsCustomerIo;
import com.company.app.trdpb000.business.model.WsCustomerSummaryRec;
import com.company.app.trdpb000.business.model.WsCustomerSummaryWriteSw;
import com.company.app.trdpb000.business.model.WsException;
import com.company.app.trdpb000.business.model.WsExcpType;
import com.company.app.trdpb000.business.model.WsOrderCount;
import com.company.app.trdpb000.business.model.WsOrderStatus;
import com.company.app.trdpb000.business.model.WsOrdersSwitch;
import com.company.app.trdpb000.business.model.WsProgramStartParms;
import com.company.app.trdpb000.business.model.WsRetrySwitch;
import com.company.app.trdpb000.business.model.WsSdProgramStartParms;
import com.company.app.trdpb000.business.model.WsSecurityCheck;
import com.company.app.trdpb000.business.model.WsSecurityIo;
import com.company.app.trdpb000.business.model.WsSettlmentQueueTable;
import com.company.app.trdpb000.business.model.WsSqlcode;
import com.company.app.trdpb000.business.model.WsStqRowCcy;
import com.company.app.trdpb000.business.model.WsStqRowData;
import com.company.app.trdpb000.business.model.WsStqSqlcode;
import com.company.app.trdpb000.business.model.WsStqSub;
import com.company.app.trdpb000.business.model.WsSummaryDebitCreditSw;
import com.company.app.trdpb000.business.model.WsTradeid;
import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.utils.StringUtils;
import com.netfective.bluage.gapwalk.rt.context.RuntimeContext;
import com.netfective.bluage.gapwalk.rt.utils.EntityUtils;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Data simplifier context Trdpb000Context.
 * 
 * <p>About 'onCode' field, <br>
 * </p>
 * 
 * <p>About 'onChar' field, <br>
 * </p>
 * 
 * <p>About 'wsOrderCount' field, <br>uml entity: com.company.app.trdpb000.business.model.WsOrderCount
 * <br></p>
 * 
 * <p>About 'wsSqlcode' field, <br>uml entity: com.company.app.trdpb000.business.model.WsSqlcode
 * <br></p>
 * 
 * <p>About 'wsAccDisp' field, <br>uml entity: com.company.app.trdpb000.business.model.WsAccDisp
 * <br></p>
 * 
 * <p>About 'wsTradeid' field, <br>uml entity: com.company.app.trdpb000.business.model.WsTradeid
 * <br></p>
 * 
 * <p>About 'wsCustomerCheck' field, <br>uml entity: com.company.app.trdpb000.business.model.WsCustomerCheck
 * <br></p>
 * 
 * <p>About 'wsSecurityCheck' field, <br>uml entity: com.company.app.trdpb000.business.model.WsSecurityCheck
 * <br></p>
 * 
 * <p>About 'dcltbtrdsum' field, <br>uml entity: com.company.app.trdpb000.business.model.Dcltbtrdsum
 * <br></p>
 * 
 * <p>About 'itbtrdsum' field, <br>uml entity: com.company.app.trdpb000.business.model.Itbtrdsum
 * <br></p>
 * 
 * <p>About 'wsCustomerSummaryWriteSw' field, <br>uml entity: com.company.app.trdpb000.business.model.WsCustomerSummaryWriteSw
 * <br></p>
 * 
 * <p>About 'wsSummaryDebitCreditSw' field, <br>uml entity: com.company.app.trdpb000.business.model.WsSummaryDebitCreditSw
 * <br></p>
 * 
 * <p>About 'wsCustomerSummaryRec' field, <br>uml entity: com.company.app.trdpb000.business.model.WsCustomerSummaryRec
 * <br></p>
 * 
 * <p>About 'wsOrdersSwitch' field, <br>uml entity: com.company.app.trdpb000.business.model.WsOrdersSwitch
 * <br></p>
 * 
 * <p>About 'wsRetrySwitch' field, <br>uml entity: com.company.app.trdpb000.business.model.WsRetrySwitch
 * <br></p>
 * 
 * <p>About 'wsOrderStatus' field, <br>uml entity: com.company.app.trdpb000.business.model.WsOrderStatus
 * <br></p>
 * 
 * <p>About 'wsProgramStartParms' field, <br>uml entity: com.company.app.trdpb000.business.model.WsProgramStartParms
 * <br></p>
 * 
 * <p>About 'wsSdProgramStartParms' field, <br>uml entity: com.company.app.trdpb000.business.model.WsSdProgramStartParms
 * <br></p>
 * 
 * <p>About 'wsException' field, <br>uml entity: com.company.app.trdpb000.business.model.WsException
 * <br></p>
 * 
 * <p>About 'wsSettlmentQueueTable' field, <br>uml entity: com.company.app.trdpb000.business.model.WsSettlmentQueueTable
 * <br></p>
 * 
 * <p>About 'wsStqSub' field, <br>uml entity: com.company.app.trdpb000.business.model.WsStqSub
 * <br></p>
 * 
 * <p>About 'wsStqSqlcode' field, <br>uml entity: com.company.app.trdpb000.business.model.WsStqSqlcode
 * <br></p>
 * 
 * <p>About 'wsStqRowCcy' field, <br>uml entity: com.company.app.trdpb000.business.model.WsStqRowCcy
 * <br></p>
 * 
 * <p>About 'wsStqRowData' field, <br>uml entity: com.company.app.trdpb000.business.model.WsStqRowData
 * <br></p>
 * 
 * <p>About 'wsCustomerIo' field, <br>uml entity: com.company.app.trdpb000.business.model.WsCustomerIo
 * <br></p>
 * 
 * <p>About 'wsSecurityIo' field, <br>uml entity: com.company.app.trdpb000.business.model.WsSecurityIo
 * <br></p>
 * 
 * <p>About 'wsCurrdate' field, <br>
 * </p>
 * 
 * <p>About 'wsCurrtime' field, <br>
 * </p>
 * 
 * <p>About 'wsExcpType' field, <br>uml entity: com.company.app.trdpb000.business.model.WsExcpType
 * <br></p>
 * 
 * <p>About 'exceptionRecordLen' field, <br>uml entity: com.company.app.trdpb000.business.model.ExceptionRecordLen
 * <br></p>
 * 
 * <p>About 'exceptionRecord' field, <br>uml entity: com.company.app.trdpb000.business.model.ExceptionRecord
 * <br></p>
 * 
 * <p>About 'sqlca' field, <br>uml entity: com.company.app.trdpb000.business.model.Sqlca
 * <br></p>
 * 
 * <p>About 'ordTradingXchng' field, <br>uml entity: com.company.app.trdpb000.business.model.OrdTradingXchng
 * <br></p>
 * 
 * <p>About 'ordTradeid' field, <br>uml entity: com.company.app.trdpb000.business.model.OrdTradeid
 * <br></p>
 * 
 * <p>About 'ordBuySellInd' field, <br>uml entity: com.company.app.trdpb000.business.model.OrdBuySellInd
 * <br></p>
 * 
 * <p>About 'ordCustomerId' field, <br>uml entity: com.company.app.trdpb000.business.model.OrdCustomerId
 * <br></p>
 * 
 * <p>About 'ordFigi' field, <br>uml entity: com.company.app.trdpb000.business.model.OrdFigi
 * <br></p>
 * 
 * <p>About 'ordQuantity' field, <br>uml entity: com.company.app.trdpb000.business.model.OrdQuantity
 * <br></p>
 * 
 * <p>About 'ordCurrency' field, <br>uml entity: com.company.app.trdpb000.business.model.OrdCurrency
 * <br></p>
 * 
 * <p>About 'ordAmount' field, <br>uml entity: com.company.app.trdpb000.business.model.OrdAmount
 * <br></p>
 * 
 * <p>About 'ordStatus' field, <br>uml entity: com.company.app.trdpb000.business.model.OrdStatus
 * <br></p>
 * 
 * <p>About 'itbtrdord' field, <br>uml entity: com.company.app.trdpb000.business.model.Itbtrdord
 * <br></p>
 * 
 * <p>About 'sacCurrency' field, <br>uml entity: com.company.app.trdpb000.business.model.SacCurrency
 * <br></p>
 * 
 * <p>About 'sacNumber' field, <br>uml entity: com.company.app.trdpb000.business.model.SacNumber
 * <br></p>
 * 
 * <p>About 'sacCustomerId' field, <br>uml entity: com.company.app.trdpb000.business.model.SacCustomerId
 * <br></p>
 * 
 * <p>About 'sacStatus' field, <br>uml entity: com.company.app.trdpb000.business.model.SacStatus
 * <br></p>
 * 
 * <p>About 'itbtrdsac' field, <br>uml entity: com.company.app.trdpb000.business.model.Itbtrdsac
 * <br></p>
 * 
 * <p>About 'macCurrency' field, <br>uml entity: com.company.app.trdpb000.business.model.MacCurrency
 * <br></p>
 * 
 * <p>About 'macNumber' field, <br>uml entity: com.company.app.trdpb000.business.model.MacNumber
 * <br></p>
 * 
 * <p>About 'macCustomerId' field, <br>uml entity: com.company.app.trdpb000.business.model.MacCustomerId
 * <br></p>
 * 
 * <p>About 'macBalance' field, <br>uml entity: com.company.app.trdpb000.business.model.MacBalance
 * <br></p>
 * 
 * <p>About 'macStatus' field, <br>uml entity: com.company.app.trdpb000.business.model.MacStatus
 * <br></p>
 * 
 * <p>About 'itbtrdmac' field, <br>uml entity: com.company.app.trdpb000.business.model.Itbtrdmac
 * <br></p>
 * 
 * <p>About 'itbtrdstq' field, <br>uml entity: com.company.app.trdpb000.business.model.Itbtrdstq
 * <br></p>
 * 
 * <p>About 'dcltbtrdlog' field, <br>uml entity: com.company.app.trdpb000.business.model.Dcltbtrdlog
 * <br></p>
 * 
 * <p>About 'itbtrdlog' field, <br>uml entity: com.company.app.trdpb000.business.model.Itbtrdlog
 * <br></p>
 * 
 * <p>About 'trdOrderPair' field, <br>uml entity: com.company.app.trdpb000.business.model.TrdOrderPair
 * <br></p>
 * 
 * <p>About 'lkParm' field, <br>uml entity: com.company.app.trdpb000.business.model.LkParm
 * <br></p>
 * 
 */
@Component("com.company.app.trdpb000.business.context.Trdpb000Context")
@Lazy
@Scope("prototype")
public class Trdpb000Context extends RuntimeContext {
	
	
	private WsOrderCount wsOrderCount;
	private WsSqlcode wsSqlcode;
	private WsAccDisp wsAccDisp;
	private WsTradeid wsTradeid;
	private WsCustomerCheck wsCustomerCheck;
	private WsSecurityCheck wsSecurityCheck;
	private Dcltbtrdsum dcltbtrdsum;
	private Itbtrdsum itbtrdsum;
	private WsCustomerSummaryWriteSw wsCustomerSummaryWriteSw;
	private WsSummaryDebitCreditSw wsSummaryDebitCreditSw;
	private WsCustomerSummaryRec wsCustomerSummaryRec;
	private WsOrdersSwitch wsOrdersSwitch;
	private WsRetrySwitch wsRetrySwitch;
	private WsOrderStatus wsOrderStatus;
	private WsProgramStartParms wsProgramStartParms;
	private WsSdProgramStartParms wsSdProgramStartParms;
	private WsException wsException;
	private WsSettlmentQueueTable wsSettlmentQueueTable;
	private WsStqSub wsStqSub;
	private WsStqSqlcode wsStqSqlcode;
	private WsStqRowCcy wsStqRowCcy;
	private WsStqRowData wsStqRowData;
	private WsCustomerIo wsCustomerIo;
	private WsSecurityIo wsSecurityIo;
	private WsExcpType wsExcpType;
	private ExceptionRecordLen exceptionRecordLen;
	private ExceptionRecord exceptionRecord;
	private Sqlca sqlca;
	private OrdTradingXchng ordTradingXchng;
	private OrdTradeid ordTradeid;
	private OrdBuySellInd ordBuySellInd;
	private OrdCustomerId ordCustomerId;
	private OrdFigi ordFigi;
	private OrdQuantity ordQuantity;
	private OrdCurrency ordCurrency;
	private OrdAmount ordAmount;
	private OrdStatus ordStatus;
	private Itbtrdord itbtrdord;
	private SacCurrency sacCurrency;
	private SacNumber sacNumber;
	private SacCustomerId sacCustomerId;
	private SacStatus sacStatus;
	private Itbtrdsac itbtrdsac;
	private MacCurrency macCurrency;
	private MacNumber macNumber;
	private MacCustomerId macCustomerId;
	private MacBalance macBalance;
	private MacStatus macStatus;
	private Itbtrdmac itbtrdmac;
	private Itbtrdstq itbtrdstq;
	private Dcltbtrdlog dcltbtrdlog;
	private Itbtrdlog itbtrdlog;
	private TrdOrderPair trdOrderPair;
	private LkParm lkParm;

	private String wsCurrdate;

	private String wsCurrtime;

	private List<RecordEntity> recordEntities;

   /**
	 * Public constructor with injected fields.
	 * @param configuration the datasimplifier configuration to use.
	 */	   
   	
   	public Trdpb000Context (@Qualifier("sharedConfiguration") Configuration configuration){		
	    super(configuration);
		initWorking(configuration);
		initLinkage(configuration);
		initRecordEntities();
	}
 	
	

	/**
	 * Getter for wsOrderCount.
	 * @return the wsOrderCount
	 */
	public WsOrderCount getWsOrderCount() {
		return this.wsOrderCount;
	}

	/**
	 * Setter for wsOrderCount.
	 * @param reference the new value for wsOrderCount
	 */
	public void setWsOrderCount(RangeReference reference) {
		this.wsOrderCount.setBytes(reference.getBytes());
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
	 * Getter for wsAccDisp.
	 * @return the wsAccDisp
	 */
	public WsAccDisp getWsAccDisp() {
		return this.wsAccDisp;
	}

	/**
	 * Setter for wsAccDisp.
	 * @param reference the new value for wsAccDisp
	 */
	public void setWsAccDisp(RangeReference reference) {
		this.wsAccDisp.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsTradeid.
	 * @return the wsTradeid
	 */
	public WsTradeid getWsTradeid() {
		return this.wsTradeid;
	}

	/**
	 * Setter for wsTradeid.
	 * @param reference the new value for wsTradeid
	 */
	public void setWsTradeid(RangeReference reference) {
		this.wsTradeid.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsCustomerCheck.
	 * @return the wsCustomerCheck
	 */
	public WsCustomerCheck getWsCustomerCheck() {
		return this.wsCustomerCheck;
	}

	/**
	 * Setter for wsCustomerCheck.
	 * @param reference the new value for wsCustomerCheck
	 */
	public void setWsCustomerCheck(RangeReference reference) {
		this.wsCustomerCheck.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsSecurityCheck.
	 * @return the wsSecurityCheck
	 */
	public WsSecurityCheck getWsSecurityCheck() {
		return this.wsSecurityCheck;
	}

	/**
	 * Setter for wsSecurityCheck.
	 * @param reference the new value for wsSecurityCheck
	 */
	public void setWsSecurityCheck(RangeReference reference) {
		this.wsSecurityCheck.setBytes(reference.getBytes());
	}

	/**
	 * Getter for dcltbtrdsum.
	 * @return the dcltbtrdsum
	 */
	public Dcltbtrdsum getDcltbtrdsum() {
		return this.dcltbtrdsum;
	}

	/**
	 * Setter for dcltbtrdsum.
	 * @param reference the new value for dcltbtrdsum
	 */
	public void setDcltbtrdsum(RangeReference reference) {
		this.dcltbtrdsum.setBytes(reference.getBytes());
	}

	/**
	 * Getter for itbtrdsum.
	 * @return the itbtrdsum
	 */
	public Itbtrdsum getItbtrdsum() {
		return this.itbtrdsum;
	}

	/**
	 * Setter for itbtrdsum.
	 * @param reference the new value for itbtrdsum
	 */
	public void setItbtrdsum(RangeReference reference) {
		this.itbtrdsum.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsCustomerSummaryWriteSw.
	 * @return the wsCustomerSummaryWriteSw
	 */
	public WsCustomerSummaryWriteSw getWsCustomerSummaryWriteSw() {
		return this.wsCustomerSummaryWriteSw;
	}

	/**
	 * Setter for wsCustomerSummaryWriteSw.
	 * @param reference the new value for wsCustomerSummaryWriteSw
	 */
	public void setWsCustomerSummaryWriteSw(RangeReference reference) {
		this.wsCustomerSummaryWriteSw.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsSummaryDebitCreditSw.
	 * @return the wsSummaryDebitCreditSw
	 */
	public WsSummaryDebitCreditSw getWsSummaryDebitCreditSw() {
		return this.wsSummaryDebitCreditSw;
	}

	/**
	 * Setter for wsSummaryDebitCreditSw.
	 * @param reference the new value for wsSummaryDebitCreditSw
	 */
	public void setWsSummaryDebitCreditSw(RangeReference reference) {
		this.wsSummaryDebitCreditSw.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsCustomerSummaryRec.
	 * @return the wsCustomerSummaryRec
	 */
	public WsCustomerSummaryRec getWsCustomerSummaryRec() {
		return this.wsCustomerSummaryRec;
	}

	/**
	 * Setter for wsCustomerSummaryRec.
	 * @param reference the new value for wsCustomerSummaryRec
	 */
	public void setWsCustomerSummaryRec(RangeReference reference) {
		this.wsCustomerSummaryRec.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsOrdersSwitch.
	 * @return the wsOrdersSwitch
	 */
	public WsOrdersSwitch getWsOrdersSwitch() {
		return this.wsOrdersSwitch;
	}

	/**
	 * Setter for wsOrdersSwitch.
	 * @param reference the new value for wsOrdersSwitch
	 */
	public void setWsOrdersSwitch(RangeReference reference) {
		this.wsOrdersSwitch.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsRetrySwitch.
	 * @return the wsRetrySwitch
	 */
	public WsRetrySwitch getWsRetrySwitch() {
		return this.wsRetrySwitch;
	}

	/**
	 * Setter for wsRetrySwitch.
	 * @param reference the new value for wsRetrySwitch
	 */
	public void setWsRetrySwitch(RangeReference reference) {
		this.wsRetrySwitch.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsOrderStatus.
	 * @return the wsOrderStatus
	 */
	public WsOrderStatus getWsOrderStatus() {
		return this.wsOrderStatus;
	}

	/**
	 * Setter for wsOrderStatus.
	 * @param reference the new value for wsOrderStatus
	 */
	public void setWsOrderStatus(RangeReference reference) {
		this.wsOrderStatus.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsProgramStartParms.
	 * @return the wsProgramStartParms
	 */
	public WsProgramStartParms getWsProgramStartParms() {
		return this.wsProgramStartParms;
	}

	/**
	 * Setter for wsProgramStartParms.
	 * @param reference the new value for wsProgramStartParms
	 */
	public void setWsProgramStartParms(RangeReference reference) {
		this.wsProgramStartParms.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsSdProgramStartParms.
	 * @return the wsSdProgramStartParms
	 */
	public WsSdProgramStartParms getWsSdProgramStartParms() {
		return this.wsSdProgramStartParms;
	}

	/**
	 * Setter for wsSdProgramStartParms.
	 * @param reference the new value for wsSdProgramStartParms
	 */
	public void setWsSdProgramStartParms(RangeReference reference) {
		this.wsSdProgramStartParms.setBytes(reference.getBytes());
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
	 * Getter for wsSettlmentQueueTable.
	 * @return the wsSettlmentQueueTable
	 */
	public WsSettlmentQueueTable getWsSettlmentQueueTable() {
		return this.wsSettlmentQueueTable;
	}

	/**
	 * Setter for wsSettlmentQueueTable.
	 * @param reference the new value for wsSettlmentQueueTable
	 */
	public void setWsSettlmentQueueTable(RangeReference reference) {
		this.wsSettlmentQueueTable.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsStqSub.
	 * @return the wsStqSub
	 */
	public WsStqSub getWsStqSub() {
		return this.wsStqSub;
	}

	/**
	 * Setter for wsStqSub.
	 * @param reference the new value for wsStqSub
	 */
	public void setWsStqSub(RangeReference reference) {
		this.wsStqSub.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsStqSqlcode.
	 * @return the wsStqSqlcode
	 */
	public WsStqSqlcode getWsStqSqlcode() {
		return this.wsStqSqlcode;
	}

	/**
	 * Setter for wsStqSqlcode.
	 * @param reference the new value for wsStqSqlcode
	 */
	public void setWsStqSqlcode(RangeReference reference) {
		this.wsStqSqlcode.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsStqRowCcy.
	 * @return the wsStqRowCcy
	 */
	public WsStqRowCcy getWsStqRowCcy() {
		return this.wsStqRowCcy;
	}

	/**
	 * Setter for wsStqRowCcy.
	 * @param reference the new value for wsStqRowCcy
	 */
	public void setWsStqRowCcy(RangeReference reference) {
		this.wsStqRowCcy.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsStqRowData.
	 * @return the wsStqRowData
	 */
	public WsStqRowData getWsStqRowData() {
		return this.wsStqRowData;
	}

	/**
	 * Setter for wsStqRowData.
	 * @param reference the new value for wsStqRowData
	 */
	public void setWsStqRowData(RangeReference reference) {
		this.wsStqRowData.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsCustomerIo.
	 * @return the wsCustomerIo
	 */
	public WsCustomerIo getWsCustomerIo() {
		return this.wsCustomerIo;
	}

	/**
	 * Setter for wsCustomerIo.
	 * @param reference the new value for wsCustomerIo
	 */
	public void setWsCustomerIo(RangeReference reference) {
		this.wsCustomerIo.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsSecurityIo.
	 * @return the wsSecurityIo
	 */
	public WsSecurityIo getWsSecurityIo() {
		return this.wsSecurityIo;
	}

	/**
	 * Setter for wsSecurityIo.
	 * @param reference the new value for wsSecurityIo
	 */
	public void setWsSecurityIo(RangeReference reference) {
		this.wsSecurityIo.setBytes(reference.getBytes());
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
	 * Getter for ordTradingXchng.
	 * @return the ordTradingXchng
	 */
	public OrdTradingXchng getOrdTradingXchng() {
		return this.ordTradingXchng;
	}

	/**
	 * Setter for ordTradingXchng.
	 * @param reference the new value for ordTradingXchng
	 */
	public void setOrdTradingXchng(RangeReference reference) {
		this.ordTradingXchng.setBytes(reference.getBytes());
	}

	/**
	 * Getter for ordTradeid.
	 * @return the ordTradeid
	 */
	public OrdTradeid getOrdTradeid() {
		return this.ordTradeid;
	}

	/**
	 * Setter for ordTradeid.
	 * @param reference the new value for ordTradeid
	 */
	public void setOrdTradeid(RangeReference reference) {
		this.ordTradeid.setBytes(reference.getBytes());
	}

	/**
	 * Getter for ordBuySellInd.
	 * @return the ordBuySellInd
	 */
	public OrdBuySellInd getOrdBuySellInd() {
		return this.ordBuySellInd;
	}

	/**
	 * Setter for ordBuySellInd.
	 * @param reference the new value for ordBuySellInd
	 */
	public void setOrdBuySellInd(RangeReference reference) {
		this.ordBuySellInd.setBytes(reference.getBytes());
	}

	/**
	 * Getter for ordCustomerId.
	 * @return the ordCustomerId
	 */
	public OrdCustomerId getOrdCustomerId() {
		return this.ordCustomerId;
	}

	/**
	 * Setter for ordCustomerId.
	 * @param reference the new value for ordCustomerId
	 */
	public void setOrdCustomerId(RangeReference reference) {
		this.ordCustomerId.setBytes(reference.getBytes());
	}

	/**
	 * Getter for ordFigi.
	 * @return the ordFigi
	 */
	public OrdFigi getOrdFigi() {
		return this.ordFigi;
	}

	/**
	 * Setter for ordFigi.
	 * @param reference the new value for ordFigi
	 */
	public void setOrdFigi(RangeReference reference) {
		this.ordFigi.setBytes(reference.getBytes());
	}

	/**
	 * Getter for ordQuantity.
	 * @return the ordQuantity
	 */
	public OrdQuantity getOrdQuantity() {
		return this.ordQuantity;
	}

	/**
	 * Setter for ordQuantity.
	 * @param reference the new value for ordQuantity
	 */
	public void setOrdQuantity(RangeReference reference) {
		this.ordQuantity.setBytes(reference.getBytes());
	}

	/**
	 * Getter for ordCurrency.
	 * @return the ordCurrency
	 */
	public OrdCurrency getOrdCurrency() {
		return this.ordCurrency;
	}

	/**
	 * Setter for ordCurrency.
	 * @param reference the new value for ordCurrency
	 */
	public void setOrdCurrency(RangeReference reference) {
		this.ordCurrency.setBytes(reference.getBytes());
	}

	/**
	 * Getter for ordAmount.
	 * @return the ordAmount
	 */
	public OrdAmount getOrdAmount() {
		return this.ordAmount;
	}

	/**
	 * Setter for ordAmount.
	 * @param reference the new value for ordAmount
	 */
	public void setOrdAmount(RangeReference reference) {
		this.ordAmount.setBytes(reference.getBytes());
	}

	/**
	 * Getter for ordStatus.
	 * @return the ordStatus
	 */
	public OrdStatus getOrdStatus() {
		return this.ordStatus;
	}

	/**
	 * Setter for ordStatus.
	 * @param reference the new value for ordStatus
	 */
	public void setOrdStatus(RangeReference reference) {
		this.ordStatus.setBytes(reference.getBytes());
	}

	/**
	 * Getter for itbtrdord.
	 * @return the itbtrdord
	 */
	public Itbtrdord getItbtrdord() {
		return this.itbtrdord;
	}

	/**
	 * Setter for itbtrdord.
	 * @param reference the new value for itbtrdord
	 */
	public void setItbtrdord(RangeReference reference) {
		this.itbtrdord.setBytes(reference.getBytes());
	}

	/**
	 * Getter for sacCurrency.
	 * @return the sacCurrency
	 */
	public SacCurrency getSacCurrency() {
		return this.sacCurrency;
	}

	/**
	 * Setter for sacCurrency.
	 * @param reference the new value for sacCurrency
	 */
	public void setSacCurrency(RangeReference reference) {
		this.sacCurrency.setBytes(reference.getBytes());
	}

	/**
	 * Getter for sacNumber.
	 * @return the sacNumber
	 */
	public SacNumber getSacNumber() {
		return this.sacNumber;
	}

	/**
	 * Setter for sacNumber.
	 * @param reference the new value for sacNumber
	 */
	public void setSacNumber(RangeReference reference) {
		this.sacNumber.setBytes(reference.getBytes());
	}

	/**
	 * Getter for sacCustomerId.
	 * @return the sacCustomerId
	 */
	public SacCustomerId getSacCustomerId() {
		return this.sacCustomerId;
	}

	/**
	 * Setter for sacCustomerId.
	 * @param reference the new value for sacCustomerId
	 */
	public void setSacCustomerId(RangeReference reference) {
		this.sacCustomerId.setBytes(reference.getBytes());
	}

	/**
	 * Getter for sacStatus.
	 * @return the sacStatus
	 */
	public SacStatus getSacStatus() {
		return this.sacStatus;
	}

	/**
	 * Setter for sacStatus.
	 * @param reference the new value for sacStatus
	 */
	public void setSacStatus(RangeReference reference) {
		this.sacStatus.setBytes(reference.getBytes());
	}

	/**
	 * Getter for itbtrdsac.
	 * @return the itbtrdsac
	 */
	public Itbtrdsac getItbtrdsac() {
		return this.itbtrdsac;
	}

	/**
	 * Setter for itbtrdsac.
	 * @param reference the new value for itbtrdsac
	 */
	public void setItbtrdsac(RangeReference reference) {
		this.itbtrdsac.setBytes(reference.getBytes());
	}

	/**
	 * Getter for macCurrency.
	 * @return the macCurrency
	 */
	public MacCurrency getMacCurrency() {
		return this.macCurrency;
	}

	/**
	 * Setter for macCurrency.
	 * @param reference the new value for macCurrency
	 */
	public void setMacCurrency(RangeReference reference) {
		this.macCurrency.setBytes(reference.getBytes());
	}

	/**
	 * Getter for macNumber.
	 * @return the macNumber
	 */
	public MacNumber getMacNumber() {
		return this.macNumber;
	}

	/**
	 * Setter for macNumber.
	 * @param reference the new value for macNumber
	 */
	public void setMacNumber(RangeReference reference) {
		this.macNumber.setBytes(reference.getBytes());
	}

	/**
	 * Getter for macCustomerId.
	 * @return the macCustomerId
	 */
	public MacCustomerId getMacCustomerId() {
		return this.macCustomerId;
	}

	/**
	 * Setter for macCustomerId.
	 * @param reference the new value for macCustomerId
	 */
	public void setMacCustomerId(RangeReference reference) {
		this.macCustomerId.setBytes(reference.getBytes());
	}

	/**
	 * Getter for macBalance.
	 * @return the macBalance
	 */
	public MacBalance getMacBalance() {
		return this.macBalance;
	}

	/**
	 * Setter for macBalance.
	 * @param reference the new value for macBalance
	 */
	public void setMacBalance(RangeReference reference) {
		this.macBalance.setBytes(reference.getBytes());
	}

	/**
	 * Getter for macStatus.
	 * @return the macStatus
	 */
	public MacStatus getMacStatus() {
		return this.macStatus;
	}

	/**
	 * Setter for macStatus.
	 * @param reference the new value for macStatus
	 */
	public void setMacStatus(RangeReference reference) {
		this.macStatus.setBytes(reference.getBytes());
	}

	/**
	 * Getter for itbtrdmac.
	 * @return the itbtrdmac
	 */
	public Itbtrdmac getItbtrdmac() {
		return this.itbtrdmac;
	}

	/**
	 * Setter for itbtrdmac.
	 * @param reference the new value for itbtrdmac
	 */
	public void setItbtrdmac(RangeReference reference) {
		this.itbtrdmac.setBytes(reference.getBytes());
	}

	/**
	 * Getter for itbtrdstq.
	 * @return the itbtrdstq
	 */
	public Itbtrdstq getItbtrdstq() {
		return this.itbtrdstq;
	}

	/**
	 * Setter for itbtrdstq.
	 * @param reference the new value for itbtrdstq
	 */
	public void setItbtrdstq(RangeReference reference) {
		this.itbtrdstq.setBytes(reference.getBytes());
	}

	/**
	 * Getter for dcltbtrdlog.
	 * @return the dcltbtrdlog
	 */
	public Dcltbtrdlog getDcltbtrdlog() {
		return this.dcltbtrdlog;
	}

	/**
	 * Setter for dcltbtrdlog.
	 * @param reference the new value for dcltbtrdlog
	 */
	public void setDcltbtrdlog(RangeReference reference) {
		this.dcltbtrdlog.setBytes(reference.getBytes());
	}

	/**
	 * Getter for itbtrdlog.
	 * @return the itbtrdlog
	 */
	public Itbtrdlog getItbtrdlog() {
		return this.itbtrdlog;
	}

	/**
	 * Setter for itbtrdlog.
	 * @param reference the new value for itbtrdlog
	 */
	public void setItbtrdlog(RangeReference reference) {
		this.itbtrdlog.setBytes(reference.getBytes());
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

	/**
	 * Getter for lkParm.
	 * @return the lkParm
	 */
	public LkParm getLkParm() {
		return this.lkParm;
	}

	/**
	 * Setter for lkParm.
	 * @param reference the new value for lkParm
	 */
	public void setLkParm(RangeReference reference) {
		this.lkParm.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsCurrdate.
	 * @return the wsCurrdate
	 */
	public String getWsCurrdate() {
		return this.wsCurrdate;
	}

	/**
	 * Setter for wsCurrdate.
	 * @param value the new value for wsCurrdate
	 */
	public void setWsCurrdate(String value) {
		this.wsCurrdate = value;
	}

	

	/**
	 * Getter for wsCurrtime.
	 * @return the wsCurrtime
	 */
	public String getWsCurrtime() {
		return this.wsCurrtime;
	}

	/**
	 * Setter for wsCurrtime.
	 * @param value the new value for wsCurrtime
	 */
	public void setWsCurrtime(String value) {
		this.wsCurrtime = value;
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
		this.wsCurrdate = StringUtils.buildDefaultValue(10, getConfiguration());
		this.wsCurrtime = StringUtils.buildDefaultValue(8, getConfiguration());
	}

	
	private void initWorking(Configuration configuration) {
		wsOrderCount = new WsOrderCount(configuration);
		wsSqlcode = new WsSqlcode(configuration);
		wsAccDisp = new WsAccDisp(configuration);
		wsTradeid = new WsTradeid(configuration);
		wsCustomerCheck = new WsCustomerCheck(configuration);
		wsSecurityCheck = new WsSecurityCheck(configuration);
		dcltbtrdsum = new Dcltbtrdsum(configuration);
		itbtrdsum = new Itbtrdsum(configuration);
		wsCustomerSummaryWriteSw = new WsCustomerSummaryWriteSw(configuration);
		wsSummaryDebitCreditSw = new WsSummaryDebitCreditSw(configuration);
		wsCustomerSummaryRec = new WsCustomerSummaryRec(configuration);
		wsOrdersSwitch = new WsOrdersSwitch(configuration);
		wsRetrySwitch = new WsRetrySwitch(configuration);
		wsOrderStatus = new WsOrderStatus(configuration);
		wsProgramStartParms = new WsProgramStartParms(configuration);
		wsSdProgramStartParms = new WsSdProgramStartParms(configuration);
		wsException = new WsException(configuration);
		wsSettlmentQueueTable = new WsSettlmentQueueTable(configuration);
		wsStqSub = new WsStqSub(configuration);
		wsStqSqlcode = new WsStqSqlcode(configuration);
		wsStqRowCcy = new WsStqRowCcy(configuration);
		wsStqRowData = new WsStqRowData(configuration);
		wsCustomerIo = new WsCustomerIo(configuration);
		wsSecurityIo = new WsSecurityIo(configuration);
		wsExcpType = new WsExcpType(configuration);
		exceptionRecordLen = new ExceptionRecordLen(configuration);
		exceptionRecord = new ExceptionRecord(configuration);
		sqlca = new Sqlca(configuration);
		ordTradingXchng = new OrdTradingXchng(configuration);
		ordTradeid = new OrdTradeid(configuration);
		ordBuySellInd = new OrdBuySellInd(configuration);
		ordCustomerId = new OrdCustomerId(configuration);
		ordFigi = new OrdFigi(configuration);
		ordQuantity = new OrdQuantity(configuration);
		ordCurrency = new OrdCurrency(configuration);
		ordAmount = new OrdAmount(configuration);
		ordStatus = new OrdStatus(configuration);
		itbtrdord = new Itbtrdord(configuration);
		sacCurrency = new SacCurrency(configuration);
		sacNumber = new SacNumber(configuration);
		sacCustomerId = new SacCustomerId(configuration);
		sacStatus = new SacStatus(configuration);
		itbtrdsac = new Itbtrdsac(configuration);
		macCurrency = new MacCurrency(configuration);
		macNumber = new MacNumber(configuration);
		macCustomerId = new MacCustomerId(configuration);
		macBalance = new MacBalance(configuration);
		macStatus = new MacStatus(configuration);
		itbtrdmac = new Itbtrdmac(configuration);
		itbtrdstq = new Itbtrdstq(configuration);
		dcltbtrdlog = new Dcltbtrdlog(configuration);
		itbtrdlog = new Itbtrdlog(configuration);
		trdOrderPair = new TrdOrderPair(configuration);
	}
	
	private void initLinkage(Configuration configuration) {
		lkParm = new LkParm(configuration, EntityUtils.getUnlinkedRecord());
	
	}

	private void initRecordEntities() {
		recordEntities = Arrays.asList(wsOrderCount, wsSqlcode, wsAccDisp, wsTradeid, wsCustomerCheck, wsSecurityCheck, dcltbtrdsum, itbtrdsum, wsCustomerSummaryWriteSw, wsSummaryDebitCreditSw, wsCustomerSummaryRec, wsOrdersSwitch, wsRetrySwitch, wsOrderStatus, wsProgramStartParms, wsSdProgramStartParms, wsException, wsSettlmentQueueTable, wsStqSub, wsStqSqlcode, wsStqRowCcy, wsStqRowData, wsCustomerIo, wsSecurityIo, wsExcpType, exceptionRecordLen, exceptionRecord, sqlca, ordTradingXchng, ordTradeid, ordBuySellInd, ordCustomerId, ordFigi, ordQuantity, ordCurrency, ordAmount, ordStatus, itbtrdord, sacCurrency, sacNumber, sacCustomerId, sacStatus, itbtrdsac, macCurrency, macNumber, macCustomerId, macBalance, macStatus, itbtrdmac, itbtrdstq, dcltbtrdlog, itbtrdlog, trdOrderPair);
	}

	@Override
	public String toString(){
		StringBuilder toSB = new StringBuilder("\nTrdpb000Context:\n");
		if(!this.recordEntities.isEmpty()){
			this.recordEntities.forEach(e -> toSB.append(e.getClass().getSimpleName()).append(" : [").append(e.toString()).append("]\n"));
		}
		toSB.append("LkParm : [").append(lkParm.toString()).append("]\n");
		return toSB.toString();
	}
}
