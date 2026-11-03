package com.company.app.trdpb001.business.context;
import com.company.app.trdpb001.business.model.Dcltbtrdlog;
import com.company.app.trdpb001.business.model.Dcltbtrdsum;
import com.company.app.trdpb001.business.model.ExceptionRecord;
import com.company.app.trdpb001.business.model.ExceptionRecordLen;
import com.company.app.trdpb001.business.model.Itbtrdlog;
import com.company.app.trdpb001.business.model.Itbtrdmac;
import com.company.app.trdpb001.business.model.Itbtrdord;
import com.company.app.trdpb001.business.model.Itbtrdstq;
import com.company.app.trdpb001.business.model.Itbtrdsum;
import com.company.app.trdpb001.business.model.LkParm;
import com.company.app.trdpb001.business.model.MacBalance;
import com.company.app.trdpb001.business.model.MacCurrency;
import com.company.app.trdpb001.business.model.MacNumber;
import com.company.app.trdpb001.business.model.OrdBuySellInd;
import com.company.app.trdpb001.business.model.OrdCurrency;
import com.company.app.trdpb001.business.model.OrdFigi;
import com.company.app.trdpb001.business.model.OrdStatus;
import com.company.app.trdpb001.business.model.OrdTradeid;
import com.company.app.trdpb001.business.model.OrdTradingXchng;
import com.company.app.trdpb001.business.model.Sqlca;
import com.company.app.trdpb001.business.model.StqCurrency;
import com.company.app.trdpb001.business.model.StqId;
import com.company.app.trdpb001.business.model.StqTradeData;
import com.company.app.trdpb001.business.model.TrdOrderPair;
import com.company.app.trdpb001.business.model.WsAcceptanceTranid;
import com.company.app.trdpb001.business.model.WsCustomerSummaryRec;
import com.company.app.trdpb001.business.model.WsCustomerSummaryWriteSw;
import com.company.app.trdpb001.business.model.WsException;
import com.company.app.trdpb001.business.model.WsExcpType;
import com.company.app.trdpb001.business.model.WsMacBooking;
import com.company.app.trdpb001.business.model.WsOrderAccpRunning;
import com.company.app.trdpb001.business.model.WsOrderStatus;
import com.company.app.trdpb001.business.model.WsRetrySwitch;
import com.company.app.trdpb001.business.model.WsSacBooking;
import com.company.app.trdpb001.business.model.WsSettlementSwitch;
import com.company.app.trdpb001.business.model.WsSqlcode;
import com.company.app.trdpb001.business.model.WsSummaryDebitCreditSw;
import com.company.app.trdpb001.business.model.WsTradeCount;
import com.company.app.trdpb001.business.model.WsTradeid;
import com.company.app.trdpb001.business.model.WsTriggerSwitch;
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
 * Data simplifier context Trdpb001Context.
 * 
 * <p>About 'onCode' field, <br>
 * </p>
 * 
 * <p>About 'onChar' field, <br>
 * </p>
 * 
 * <p>About 'wsTradeCount' field, <br>uml entity: com.company.app.trdpb001.business.model.WsTradeCount
 * <br></p>
 * 
 * <p>About 'wsSqlcode' field, <br>uml entity: com.company.app.trdpb001.business.model.WsSqlcode
 * <br></p>
 * 
 * <p>About 'wsTradeid' field, <br>uml entity: com.company.app.trdpb001.business.model.WsTradeid
 * <br></p>
 * 
 * <p>About 'wsAcceptanceTranid' field, <br>uml entity: com.company.app.trdpb001.business.model.WsAcceptanceTranid
 * <br></p>
 * 
 * <p>About 'wsSacBooking' field, <br>uml entity: com.company.app.trdpb001.business.model.WsSacBooking
 * <br></p>
 * 
 * <p>About 'wsMacBooking' field, <br>uml entity: com.company.app.trdpb001.business.model.WsMacBooking
 * <br></p>
 * 
 * <p>About 'dcltbtrdsum' field, <br>uml entity: com.company.app.trdpb001.business.model.Dcltbtrdsum
 * <br></p>
 * 
 * <p>About 'itbtrdsum' field, <br>uml entity: com.company.app.trdpb001.business.model.Itbtrdsum
 * <br></p>
 * 
 * <p>About 'wsCustomerSummaryWriteSw' field, <br>uml entity: com.company.app.trdpb001.business.model.WsCustomerSummaryWriteSw
 * <br></p>
 * 
 * <p>About 'wsSummaryDebitCreditSw' field, <br>uml entity: com.company.app.trdpb001.business.model.WsSummaryDebitCreditSw
 * <br></p>
 * 
 * <p>About 'wsCustomerSummaryRec' field, <br>uml entity: com.company.app.trdpb001.business.model.WsCustomerSummaryRec
 * <br></p>
 * 
 * <p>About 'wsOrderAccpRunning' field, <br>uml entity: com.company.app.trdpb001.business.model.WsOrderAccpRunning
 * <br></p>
 * 
 * <p>About 'wsSettlementSwitch' field, <br>uml entity: com.company.app.trdpb001.business.model.WsSettlementSwitch
 * <br></p>
 * 
 * <p>About 'wsTriggerSwitch' field, <br>uml entity: com.company.app.trdpb001.business.model.WsTriggerSwitch
 * <br></p>
 * 
 * <p>About 'wsRetrySwitch' field, <br>uml entity: com.company.app.trdpb001.business.model.WsRetrySwitch
 * <br></p>
 * 
 * <p>About 'wsOrderStatus' field, <br>uml entity: com.company.app.trdpb001.business.model.WsOrderStatus
 * <br></p>
 * 
 * <p>About 'wsException' field, <br>uml entity: com.company.app.trdpb001.business.model.WsException
 * <br></p>
 * 
 * <p>About 'trdOrderPair' field, <br>uml entity: com.company.app.trdpb001.business.model.TrdOrderPair
 * <br></p>
 * 
 * <p>About 'wsCurrdate' field, <br>
 * </p>
 * 
 * <p>About 'wsCurrtime' field, <br>
 * </p>
 * 
 * <p>About 'wsExcpType' field, <br>uml entity: com.company.app.trdpb001.business.model.WsExcpType
 * <br></p>
 * 
 * <p>About 'exceptionRecordLen' field, <br>uml entity: com.company.app.trdpb001.business.model.ExceptionRecordLen
 * <br></p>
 * 
 * <p>About 'exceptionRecord' field, <br>uml entity: com.company.app.trdpb001.business.model.ExceptionRecord
 * <br></p>
 * 
 * <p>About 'sqlca' field, <br>uml entity: com.company.app.trdpb001.business.model.Sqlca
 * <br></p>
 * 
 * <p>About 'ordTradingXchng' field, <br>uml entity: com.company.app.trdpb001.business.model.OrdTradingXchng
 * <br></p>
 * 
 * <p>About 'ordTradeid' field, <br>uml entity: com.company.app.trdpb001.business.model.OrdTradeid
 * <br></p>
 * 
 * <p>About 'ordBuySellInd' field, <br>uml entity: com.company.app.trdpb001.business.model.OrdBuySellInd
 * <br></p>
 * 
 * <p>About 'ordFigi' field, <br>uml entity: com.company.app.trdpb001.business.model.OrdFigi
 * <br></p>
 * 
 * <p>About 'ordCurrency' field, <br>uml entity: com.company.app.trdpb001.business.model.OrdCurrency
 * <br></p>
 * 
 * <p>About 'ordStatus' field, <br>uml entity: com.company.app.trdpb001.business.model.OrdStatus
 * <br></p>
 * 
 * <p>About 'itbtrdord' field, <br>uml entity: com.company.app.trdpb001.business.model.Itbtrdord
 * <br></p>
 * 
 * <p>About 'macCurrency' field, <br>uml entity: com.company.app.trdpb001.business.model.MacCurrency
 * <br></p>
 * 
 * <p>About 'macNumber' field, <br>uml entity: com.company.app.trdpb001.business.model.MacNumber
 * <br></p>
 * 
 * <p>About 'macBalance' field, <br>uml entity: com.company.app.trdpb001.business.model.MacBalance
 * <br></p>
 * 
 * <p>About 'itbtrdmac' field, <br>uml entity: com.company.app.trdpb001.business.model.Itbtrdmac
 * <br></p>
 * 
 * <p>About 'stqCurrency' field, <br>uml entity: com.company.app.trdpb001.business.model.StqCurrency
 * <br></p>
 * 
 * <p>About 'stqId' field, <br>uml entity: com.company.app.trdpb001.business.model.StqId
 * <br></p>
 * 
 * <p>About 'stqTradeData' field, <br>uml entity: com.company.app.trdpb001.business.model.StqTradeData
 * <br></p>
 * 
 * <p>About 'itbtrdstq' field, <br>uml entity: com.company.app.trdpb001.business.model.Itbtrdstq
 * <br></p>
 * 
 * <p>About 'dcltbtrdlog' field, <br>uml entity: com.company.app.trdpb001.business.model.Dcltbtrdlog
 * <br></p>
 * 
 * <p>About 'itbtrdlog' field, <br>uml entity: com.company.app.trdpb001.business.model.Itbtrdlog
 * <br></p>
 * 
 * <p>About 'lkParm' field, <br>uml entity: com.company.app.trdpb001.business.model.LkParm
 * <br></p>
 * 
 */
@Component("com.company.app.trdpb001.business.context.Trdpb001Context")
@Lazy
@Scope("prototype")
public class Trdpb001Context extends RuntimeContext {
	
	
	private WsTradeCount wsTradeCount;
	private WsSqlcode wsSqlcode;
	private WsTradeid wsTradeid;
	private WsAcceptanceTranid wsAcceptanceTranid;
	private WsSacBooking wsSacBooking;
	private WsMacBooking wsMacBooking;
	private Dcltbtrdsum dcltbtrdsum;
	private Itbtrdsum itbtrdsum;
	private WsCustomerSummaryWriteSw wsCustomerSummaryWriteSw;
	private WsSummaryDebitCreditSw wsSummaryDebitCreditSw;
	private WsCustomerSummaryRec wsCustomerSummaryRec;
	private WsOrderAccpRunning wsOrderAccpRunning;
	private WsSettlementSwitch wsSettlementSwitch;
	private WsTriggerSwitch wsTriggerSwitch;
	private WsRetrySwitch wsRetrySwitch;
	private WsOrderStatus wsOrderStatus;
	private WsException wsException;
	private TrdOrderPair trdOrderPair;
	private WsExcpType wsExcpType;
	private ExceptionRecordLen exceptionRecordLen;
	private ExceptionRecord exceptionRecord;
	private Sqlca sqlca;
	private OrdTradingXchng ordTradingXchng;
	private OrdTradeid ordTradeid;
	private OrdBuySellInd ordBuySellInd;
	private OrdFigi ordFigi;
	private OrdCurrency ordCurrency;
	private OrdStatus ordStatus;
	private Itbtrdord itbtrdord;
	private MacCurrency macCurrency;
	private MacNumber macNumber;
	private MacBalance macBalance;
	private Itbtrdmac itbtrdmac;
	private StqCurrency stqCurrency;
	private StqId stqId;
	private StqTradeData stqTradeData;
	private Itbtrdstq itbtrdstq;
	private Dcltbtrdlog dcltbtrdlog;
	private Itbtrdlog itbtrdlog;
	private LkParm lkParm;

	private String wsCurrdate;

	private String wsCurrtime;

	private List<RecordEntity> recordEntities;

   /**
	 * Public constructor with injected fields.
	 * @param configuration the datasimplifier configuration to use.
	 */	   
   	
   	public Trdpb001Context (@Qualifier("sharedConfiguration") Configuration configuration){		
	    super(configuration);
		initWorking(configuration);
		initLinkage(configuration);
		initRecordEntities();
	}
 	
	

	/**
	 * Getter for wsTradeCount.
	 * @return the wsTradeCount
	 */
	public WsTradeCount getWsTradeCount() {
		return this.wsTradeCount;
	}

	/**
	 * Setter for wsTradeCount.
	 * @param reference the new value for wsTradeCount
	 */
	public void setWsTradeCount(RangeReference reference) {
		this.wsTradeCount.setBytes(reference.getBytes());
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
	 * Getter for wsAcceptanceTranid.
	 * @return the wsAcceptanceTranid
	 */
	public WsAcceptanceTranid getWsAcceptanceTranid() {
		return this.wsAcceptanceTranid;
	}

	/**
	 * Setter for wsAcceptanceTranid.
	 * @param reference the new value for wsAcceptanceTranid
	 */
	public void setWsAcceptanceTranid(RangeReference reference) {
		this.wsAcceptanceTranid.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsSacBooking.
	 * @return the wsSacBooking
	 */
	public WsSacBooking getWsSacBooking() {
		return this.wsSacBooking;
	}

	/**
	 * Setter for wsSacBooking.
	 * @param reference the new value for wsSacBooking
	 */
	public void setWsSacBooking(RangeReference reference) {
		this.wsSacBooking.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsMacBooking.
	 * @return the wsMacBooking
	 */
	public WsMacBooking getWsMacBooking() {
		return this.wsMacBooking;
	}

	/**
	 * Setter for wsMacBooking.
	 * @param reference the new value for wsMacBooking
	 */
	public void setWsMacBooking(RangeReference reference) {
		this.wsMacBooking.setBytes(reference.getBytes());
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
	 * Getter for wsOrderAccpRunning.
	 * @return the wsOrderAccpRunning
	 */
	public WsOrderAccpRunning getWsOrderAccpRunning() {
		return this.wsOrderAccpRunning;
	}

	/**
	 * Setter for wsOrderAccpRunning.
	 * @param reference the new value for wsOrderAccpRunning
	 */
	public void setWsOrderAccpRunning(RangeReference reference) {
		this.wsOrderAccpRunning.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsSettlementSwitch.
	 * @return the wsSettlementSwitch
	 */
	public WsSettlementSwitch getWsSettlementSwitch() {
		return this.wsSettlementSwitch;
	}

	/**
	 * Setter for wsSettlementSwitch.
	 * @param reference the new value for wsSettlementSwitch
	 */
	public void setWsSettlementSwitch(RangeReference reference) {
		this.wsSettlementSwitch.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsTriggerSwitch.
	 * @return the wsTriggerSwitch
	 */
	public WsTriggerSwitch getWsTriggerSwitch() {
		return this.wsTriggerSwitch;
	}

	/**
	 * Setter for wsTriggerSwitch.
	 * @param reference the new value for wsTriggerSwitch
	 */
	public void setWsTriggerSwitch(RangeReference reference) {
		this.wsTriggerSwitch.setBytes(reference.getBytes());
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
	 * Getter for stqCurrency.
	 * @return the stqCurrency
	 */
	public StqCurrency getStqCurrency() {
		return this.stqCurrency;
	}

	/**
	 * Setter for stqCurrency.
	 * @param reference the new value for stqCurrency
	 */
	public void setStqCurrency(RangeReference reference) {
		this.stqCurrency.setBytes(reference.getBytes());
	}

	/**
	 * Getter for stqId.
	 * @return the stqId
	 */
	public StqId getStqId() {
		return this.stqId;
	}

	/**
	 * Setter for stqId.
	 * @param reference the new value for stqId
	 */
	public void setStqId(RangeReference reference) {
		this.stqId.setBytes(reference.getBytes());
	}

	/**
	 * Getter for stqTradeData.
	 * @return the stqTradeData
	 */
	public StqTradeData getStqTradeData() {
		return this.stqTradeData;
	}

	/**
	 * Setter for stqTradeData.
	 * @param reference the new value for stqTradeData
	 */
	public void setStqTradeData(RangeReference reference) {
		this.stqTradeData.setBytes(reference.getBytes());
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
		wsTradeCount = new WsTradeCount(configuration);
		wsSqlcode = new WsSqlcode(configuration);
		wsTradeid = new WsTradeid(configuration);
		wsAcceptanceTranid = new WsAcceptanceTranid(configuration);
		wsSacBooking = new WsSacBooking(configuration);
		wsMacBooking = new WsMacBooking(configuration);
		dcltbtrdsum = new Dcltbtrdsum(configuration);
		itbtrdsum = new Itbtrdsum(configuration);
		wsCustomerSummaryWriteSw = new WsCustomerSummaryWriteSw(configuration);
		wsSummaryDebitCreditSw = new WsSummaryDebitCreditSw(configuration);
		wsCustomerSummaryRec = new WsCustomerSummaryRec(configuration);
		wsOrderAccpRunning = new WsOrderAccpRunning(configuration);
		wsSettlementSwitch = new WsSettlementSwitch(configuration);
		wsTriggerSwitch = new WsTriggerSwitch(configuration);
		wsRetrySwitch = new WsRetrySwitch(configuration);
		wsOrderStatus = new WsOrderStatus(configuration);
		wsException = new WsException(configuration);
		trdOrderPair = new TrdOrderPair(configuration);
		wsExcpType = new WsExcpType(configuration);
		exceptionRecordLen = new ExceptionRecordLen(configuration);
		exceptionRecord = new ExceptionRecord(configuration);
		sqlca = new Sqlca(configuration);
		ordTradingXchng = new OrdTradingXchng(configuration);
		ordTradeid = new OrdTradeid(configuration);
		ordBuySellInd = new OrdBuySellInd(configuration);
		ordFigi = new OrdFigi(configuration);
		ordCurrency = new OrdCurrency(configuration);
		ordStatus = new OrdStatus(configuration);
		itbtrdord = new Itbtrdord(configuration);
		macCurrency = new MacCurrency(configuration);
		macNumber = new MacNumber(configuration);
		macBalance = new MacBalance(configuration);
		itbtrdmac = new Itbtrdmac(configuration);
		stqCurrency = new StqCurrency(configuration);
		stqId = new StqId(configuration);
		stqTradeData = new StqTradeData(configuration);
		itbtrdstq = new Itbtrdstq(configuration);
		dcltbtrdlog = new Dcltbtrdlog(configuration);
		itbtrdlog = new Itbtrdlog(configuration);
	}
	
	private void initLinkage(Configuration configuration) {
		lkParm = new LkParm(configuration, EntityUtils.getUnlinkedRecord());
	
	}

	private void initRecordEntities() {
		recordEntities = Arrays.asList(wsTradeCount, wsSqlcode, wsTradeid, wsAcceptanceTranid, wsSacBooking, wsMacBooking, dcltbtrdsum, itbtrdsum, wsCustomerSummaryWriteSw, wsSummaryDebitCreditSw, wsCustomerSummaryRec, wsOrderAccpRunning, wsSettlementSwitch, wsTriggerSwitch, wsRetrySwitch, wsOrderStatus, wsException, trdOrderPair, wsExcpType, exceptionRecordLen, exceptionRecord, sqlca, ordTradingXchng, ordTradeid, ordBuySellInd, ordFigi, ordCurrency, ordStatus, itbtrdord, macCurrency, macNumber, macBalance, itbtrdmac, stqCurrency, stqId, stqTradeData, itbtrdstq, dcltbtrdlog, itbtrdlog);
	}

	@Override
	public String toString(){
		StringBuilder toSB = new StringBuilder("\nTrdpb001Context:\n");
		if(!this.recordEntities.isEmpty()){
			this.recordEntities.forEach(e -> toSB.append(e.getClass().getSimpleName()).append(" : [").append(e.toString()).append("]\n"));
		}
		toSB.append("LkParm : [").append(lkParm.toString()).append("]\n");
		return toSB.toString();
	}
}
