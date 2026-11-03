package com.company.app.trdpb006.business.context;
import com.company.app.trdpb006.business.model.CusDescription;
import com.company.app.trdpb006.business.model.Itbtrdcus;
import com.company.app.trdpb006.business.model.Itbtrdord;
import com.company.app.trdpb006.business.model.Itbtrdsec;
import com.company.app.trdpb006.business.model.OrdAmount;
import com.company.app.trdpb006.business.model.OrdBuySellInd;
import com.company.app.trdpb006.business.model.OrdCurrency;
import com.company.app.trdpb006.business.model.OrdCustomerId;
import com.company.app.trdpb006.business.model.OrdFigi;
import com.company.app.trdpb006.business.model.OrdQuantity;
import com.company.app.trdpb006.business.model.OrdStatus;
import com.company.app.trdpb006.business.model.OrdTradeid;
import com.company.app.trdpb006.business.model.OrdTradingXchng;
import com.company.app.trdpb006.business.model.Reporder;
import com.company.app.trdpb006.business.model.ReporderFileStatus;
import com.company.app.trdpb006.business.model.SecDescription;
import com.company.app.trdpb006.business.model.SecSymbol;
import com.company.app.trdpb006.business.model.SecType;
import com.company.app.trdpb006.business.model.Sqlca;
import com.company.app.trdpb006.business.model.WsBuyerSellerCustId;
import com.company.app.trdpb006.business.model.WsDetailHdr1;
import com.company.app.trdpb006.business.model.WsDetailHdr2;
import com.company.app.trdpb006.business.model.WsDetailRec;
import com.company.app.trdpb006.business.model.WsEndOfOrdersSw;
import com.company.app.trdpb006.business.model.WsHeader1;
import com.company.app.trdpb006.business.model.WsMaxOrdersPerPage;
import com.company.app.trdpb006.business.model.WsOrderCount;
import com.company.app.trdpb006.business.model.WsPageHeader;
import com.company.app.trdpb006.business.model.WsPagenum;
import com.company.app.trdpb006.business.model.WsPrintHeader;
import com.company.app.trdpb006.business.model.WsSqlcode;
import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.io.metadata.builder.SequentialFileDescriptionBuilder;
import com.netfective.bluage.gapwalk.rt.context.RuntimeContext;
import com.netfective.bluage.gapwalk.rt.io.AccessMode;
import com.netfective.bluage.gapwalk.rt.io.SequentialFile;
import com.netfective.bluage.gapwalk.rt.shared.ExecutionContext;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Data simplifier context Trdpb006Context.
 * 
 * <p>About 'onCode' field, <br>
 * </p>
 * 
 * <p>About 'onChar' field, <br>
 * </p>
 * 
 * <p>About 'reporder' file, <br>uml entity: com.company.app.trdpb006.business.model.Reporder
 * <br></p>
 * 
 * <p>About 'reporderFileStatus' field, <br>uml entity: com.company.app.trdpb006.business.model.ReporderFileStatus
 * <br></p>
 * 
 * <p>About 'wsPagenum' field, <br>uml entity: com.company.app.trdpb006.business.model.WsPagenum
 * <br></p>
 * 
 * <p>About 'wsPrintHeader' field, <br>uml entity: com.company.app.trdpb006.business.model.WsPrintHeader
 * <br></p>
 * 
 * <p>About 'wsEndOfOrdersSw' field, <br>uml entity: com.company.app.trdpb006.business.model.WsEndOfOrdersSw
 * <br></p>
 * 
 * <p>About 'wsPageHeader' field, <br>uml entity: com.company.app.trdpb006.business.model.WsPageHeader
 * <br></p>
 * 
 * <p>About 'wsHeader1' field, <br>uml entity: com.company.app.trdpb006.business.model.WsHeader1
 * <br></p>
 * 
 * <p>About 'wsEmptyHdr' field, <br>
 * </p>
 * 
 * <p>About 'wsDetailHdr1' field, <br>uml entity: com.company.app.trdpb006.business.model.WsDetailHdr1
 * <br></p>
 * 
 * <p>About 'wsDetailHdr2' field, <br>uml entity: com.company.app.trdpb006.business.model.WsDetailHdr2
 * <br></p>
 * 
 * <p>About 'wsDetailRec' field, <br>uml entity: com.company.app.trdpb006.business.model.WsDetailRec
 * <br></p>
 * 
 * <p>About 'wsPrevCustid' field, <br>
 * </p>
 * 
 * <p>About 'wsPrevBuySell' field, <br>
 * </p>
 * 
 * <p>About 'wsPrevOrderStatus' field, <br>
 * </p>
 * 
 * <p>About 'wsMaxOrdersPerPage' field, <br>uml entity: com.company.app.trdpb006.business.model.WsMaxOrdersPerPage
 * <br></p>
 * 
 * <p>About 'wsOrderCount' field, <br>uml entity: com.company.app.trdpb006.business.model.WsOrderCount
 * <br></p>
 * 
 * <p>About 'wsBuyerSellerCustId' field, <br>uml entity: com.company.app.trdpb006.business.model.WsBuyerSellerCustId
 * <br></p>
 * 
 * <p>About 'wsSqlcode' field, <br>uml entity: com.company.app.trdpb006.business.model.WsSqlcode
 * <br></p>
 * 
 * <p>About 'sqlca' field, <br>uml entity: com.company.app.trdpb006.business.model.Sqlca
 * <br></p>
 * 
 * <p>About 'ordTradingXchng' field, <br>uml entity: com.company.app.trdpb006.business.model.OrdTradingXchng
 * <br></p>
 * 
 * <p>About 'ordTradeid' field, <br>uml entity: com.company.app.trdpb006.business.model.OrdTradeid
 * <br></p>
 * 
 * <p>About 'ordBuySellInd' field, <br>uml entity: com.company.app.trdpb006.business.model.OrdBuySellInd
 * <br></p>
 * 
 * <p>About 'ordCustomerId' field, <br>uml entity: com.company.app.trdpb006.business.model.OrdCustomerId
 * <br></p>
 * 
 * <p>About 'ordFigi' field, <br>uml entity: com.company.app.trdpb006.business.model.OrdFigi
 * <br></p>
 * 
 * <p>About 'ordQuantity' field, <br>uml entity: com.company.app.trdpb006.business.model.OrdQuantity
 * <br></p>
 * 
 * <p>About 'ordCurrency' field, <br>uml entity: com.company.app.trdpb006.business.model.OrdCurrency
 * <br></p>
 * 
 * <p>About 'ordAmount' field, <br>uml entity: com.company.app.trdpb006.business.model.OrdAmount
 * <br></p>
 * 
 * <p>About 'ordStatus' field, <br>uml entity: com.company.app.trdpb006.business.model.OrdStatus
 * <br></p>
 * 
 * <p>About 'itbtrdord' field, <br>uml entity: com.company.app.trdpb006.business.model.Itbtrdord
 * <br></p>
 * 
 * <p>About 'secDescription' field, <br>uml entity: com.company.app.trdpb006.business.model.SecDescription
 * <br></p>
 * 
 * <p>About 'secSymbol' field, <br>uml entity: com.company.app.trdpb006.business.model.SecSymbol
 * <br></p>
 * 
 * <p>About 'secType' field, <br>uml entity: com.company.app.trdpb006.business.model.SecType
 * <br></p>
 * 
 * <p>About 'itbtrdsec' field, <br>uml entity: com.company.app.trdpb006.business.model.Itbtrdsec
 * <br></p>
 * 
 * <p>About 'cusDescription' field, <br>uml entity: com.company.app.trdpb006.business.model.CusDescription
 * <br></p>
 * 
 * <p>About 'itbtrdcus' field, <br>uml entity: com.company.app.trdpb006.business.model.Itbtrdcus
 * <br></p>
 * 
 */
@Component("com.company.app.trdpb006.business.context.Trdpb006Context")
@Import({
	com.company.app.trdpb006.business.model.Reporder.class
})
@Lazy
@Scope("prototype")
public class Trdpb006Context extends RuntimeContext {
	
	@Autowired
	private Reporder reporder;

	private SequentialFile reporderFile;	
	
	private ReporderFileStatus reporderFileStatus;
	private WsPagenum wsPagenum;
	private WsPrintHeader wsPrintHeader;
	private WsEndOfOrdersSw wsEndOfOrdersSw;
	private WsPageHeader wsPageHeader;
	private WsHeader1 wsHeader1;
	private WsDetailHdr1 wsDetailHdr1;
	private WsDetailHdr2 wsDetailHdr2;
	private WsDetailRec wsDetailRec;
	private WsMaxOrdersPerPage wsMaxOrdersPerPage;
	private WsOrderCount wsOrderCount;
	private WsBuyerSellerCustId wsBuyerSellerCustId;
	private WsSqlcode wsSqlcode;
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
	private SecDescription secDescription;
	private SecSymbol secSymbol;
	private SecType secType;
	private Itbtrdsec itbtrdsec;
	private CusDescription cusDescription;
	private Itbtrdcus itbtrdcus;

	private String wsEmptyHdr;

	private String wsPrevCustid;

	private String wsPrevBuySell;

	private String wsPrevOrderStatus;

	private List<RecordEntity> recordEntities;

   /**
	 * Public constructor with injected fields.
	 * @param configuration the datasimplifier configuration to use.
	 */	   
   	
   	public Trdpb006Context (@Qualifier("sharedConfiguration") Configuration configuration){		
	    super(configuration);
		initWorking(configuration);
		
		initRecordEntities();
	}
 	
	

	/**
	 * Getter for the file reporder.
	 * @return the reporder
	 */
	public Reporder getReporder() {
		return this.reporder;
	}
	
	/**
	 * Getter for the file handler reporderFile.
	 * @param executionContext the execution context
	 * @return the reporderFile
	 */
	public SequentialFile getReporderHandler(ExecutionContext executionContext) {
		
		if(this.reporderFile == null){
			this.reporderFile = executionContext.getFileProvider().getFile(
				"REPORDER",
				new SequentialFileDescriptionBuilder()
					.fileStatus(this.getReporderFileStatus())
					.accessMode(AccessMode.SEQUENTIAL)
					.printer(true)
					.build(),
				getConfiguration(), reporder);
		}
		return this.reporderFile;	
	}

	/**
	 * Getter for reporderFileStatus.
	 * @return the reporderFileStatus
	 */
	public ReporderFileStatus getReporderFileStatus() {
		return this.reporderFileStatus;
	}

	/**
	 * Setter for reporderFileStatus.
	 * @param reference the new value for reporderFileStatus
	 */
	public void setReporderFileStatus(RangeReference reference) {
		this.reporderFileStatus.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsPagenum.
	 * @return the wsPagenum
	 */
	public WsPagenum getWsPagenum() {
		return this.wsPagenum;
	}

	/**
	 * Setter for wsPagenum.
	 * @param reference the new value for wsPagenum
	 */
	public void setWsPagenum(RangeReference reference) {
		this.wsPagenum.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsPrintHeader.
	 * @return the wsPrintHeader
	 */
	public WsPrintHeader getWsPrintHeader() {
		return this.wsPrintHeader;
	}

	/**
	 * Setter for wsPrintHeader.
	 * @param reference the new value for wsPrintHeader
	 */
	public void setWsPrintHeader(RangeReference reference) {
		this.wsPrintHeader.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsEndOfOrdersSw.
	 * @return the wsEndOfOrdersSw
	 */
	public WsEndOfOrdersSw getWsEndOfOrdersSw() {
		return this.wsEndOfOrdersSw;
	}

	/**
	 * Setter for wsEndOfOrdersSw.
	 * @param reference the new value for wsEndOfOrdersSw
	 */
	public void setWsEndOfOrdersSw(RangeReference reference) {
		this.wsEndOfOrdersSw.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsPageHeader.
	 * @return the wsPageHeader
	 */
	public WsPageHeader getWsPageHeader() {
		return this.wsPageHeader;
	}

	/**
	 * Setter for wsPageHeader.
	 * @param reference the new value for wsPageHeader
	 */
	public void setWsPageHeader(RangeReference reference) {
		this.wsPageHeader.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsHeader1.
	 * @return the wsHeader1
	 */
	public WsHeader1 getWsHeader1() {
		return this.wsHeader1;
	}

	/**
	 * Setter for wsHeader1.
	 * @param reference the new value for wsHeader1
	 */
	public void setWsHeader1(RangeReference reference) {
		this.wsHeader1.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsDetailHdr1.
	 * @return the wsDetailHdr1
	 */
	public WsDetailHdr1 getWsDetailHdr1() {
		return this.wsDetailHdr1;
	}

	/**
	 * Setter for wsDetailHdr1.
	 * @param reference the new value for wsDetailHdr1
	 */
	public void setWsDetailHdr1(RangeReference reference) {
		this.wsDetailHdr1.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsDetailHdr2.
	 * @return the wsDetailHdr2
	 */
	public WsDetailHdr2 getWsDetailHdr2() {
		return this.wsDetailHdr2;
	}

	/**
	 * Setter for wsDetailHdr2.
	 * @param reference the new value for wsDetailHdr2
	 */
	public void setWsDetailHdr2(RangeReference reference) {
		this.wsDetailHdr2.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsDetailRec.
	 * @return the wsDetailRec
	 */
	public WsDetailRec getWsDetailRec() {
		return this.wsDetailRec;
	}

	/**
	 * Setter for wsDetailRec.
	 * @param reference the new value for wsDetailRec
	 */
	public void setWsDetailRec(RangeReference reference) {
		this.wsDetailRec.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsMaxOrdersPerPage.
	 * @return the wsMaxOrdersPerPage
	 */
	public WsMaxOrdersPerPage getWsMaxOrdersPerPage() {
		return this.wsMaxOrdersPerPage;
	}

	/**
	 * Setter for wsMaxOrdersPerPage.
	 * @param reference the new value for wsMaxOrdersPerPage
	 */
	public void setWsMaxOrdersPerPage(RangeReference reference) {
		this.wsMaxOrdersPerPage.setBytes(reference.getBytes());
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
	 * Getter for wsBuyerSellerCustId.
	 * @return the wsBuyerSellerCustId
	 */
	public WsBuyerSellerCustId getWsBuyerSellerCustId() {
		return this.wsBuyerSellerCustId;
	}

	/**
	 * Setter for wsBuyerSellerCustId.
	 * @param reference the new value for wsBuyerSellerCustId
	 */
	public void setWsBuyerSellerCustId(RangeReference reference) {
		this.wsBuyerSellerCustId.setBytes(reference.getBytes());
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
	 * Getter for wsEmptyHdr.
	 * @return the wsEmptyHdr
	 */
	public String getWsEmptyHdr() {
		return this.wsEmptyHdr;
	}

	/**
	 * Setter for wsEmptyHdr.
	 * @param value the new value for wsEmptyHdr
	 */
	public void setWsEmptyHdr(String value) {
		this.wsEmptyHdr = value;
	}

	

	/**
	 * Getter for wsPrevCustid.
	 * @return the wsPrevCustid
	 */
	public String getWsPrevCustid() {
		return this.wsPrevCustid;
	}

	/**
	 * Setter for wsPrevCustid.
	 * @param value the new value for wsPrevCustid
	 */
	public void setWsPrevCustid(String value) {
		this.wsPrevCustid = value;
	}

	

	/**
	 * Getter for wsPrevBuySell.
	 * @return the wsPrevBuySell
	 */
	public String getWsPrevBuySell() {
		return this.wsPrevBuySell;
	}

	/**
	 * Setter for wsPrevBuySell.
	 * @param value the new value for wsPrevBuySell
	 */
	public void setWsPrevBuySell(String value) {
		this.wsPrevBuySell = value;
	}

	

	/**
	 * Getter for wsPrevOrderStatus.
	 * @return the wsPrevOrderStatus
	 */
	public String getWsPrevOrderStatus() {
		return this.wsPrevOrderStatus;
	}

	/**
	 * Setter for wsPrevOrderStatus.
	 * @param value the new value for wsPrevOrderStatus
	 */
	public void setWsPrevOrderStatus(String value) {
		this.wsPrevOrderStatus = value;
	}

	

	@Override 
	public void cleanUp(){
		if(this.reporderFile !=null && this.reporderFile.isOpen() && !this.reporderFile.isShared()) {
			this.reporderFile.close();
		}
		if(this.reporderFile !=null && !this.reporderFile.isShared()){
			this.reporderFile = null;
		}
		// No resources to clean up
	}

	@Override
	protected void doReset() {
		cleanUp();
		this.reporder.reset();
	    // reset the working
		recordEntities.stream().forEach(e -> e.reset());
		this.wsEmptyHdr = StringUtils.rightPad(" ", 160);
		this.wsPrevCustid = StringUtils.rightPad(" ", 12);
		this.wsPrevBuySell = " ";
		this.wsPrevOrderStatus = com.netfective.bluage.gapwalk.datasimplifier.utils.StringUtils.buildDefaultValue(3, getConfiguration());
	}

	
	private void initWorking(Configuration configuration) {
		reporderFileStatus = new ReporderFileStatus(configuration);
		wsPagenum = new WsPagenum(configuration);
		wsPrintHeader = new WsPrintHeader(configuration);
		wsEndOfOrdersSw = new WsEndOfOrdersSw(configuration);
		wsPageHeader = new WsPageHeader(configuration);
		wsHeader1 = new WsHeader1(configuration);
		wsDetailHdr1 = new WsDetailHdr1(configuration);
		wsDetailHdr2 = new WsDetailHdr2(configuration);
		wsDetailRec = new WsDetailRec(configuration);
		wsMaxOrdersPerPage = new WsMaxOrdersPerPage(configuration);
		wsOrderCount = new WsOrderCount(configuration);
		wsBuyerSellerCustId = new WsBuyerSellerCustId(configuration);
		wsSqlcode = new WsSqlcode(configuration);
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
		secDescription = new SecDescription(configuration);
		secSymbol = new SecSymbol(configuration);
		secType = new SecType(configuration);
		itbtrdsec = new Itbtrdsec(configuration);
		cusDescription = new CusDescription(configuration);
		itbtrdcus = new Itbtrdcus(configuration);
	}

	private void initRecordEntities() {
		recordEntities = Arrays.asList(reporderFileStatus, wsPagenum, wsPrintHeader, wsEndOfOrdersSw, wsPageHeader, wsHeader1, wsDetailHdr1, wsDetailHdr2, wsDetailRec, wsMaxOrdersPerPage, wsOrderCount, wsBuyerSellerCustId, wsSqlcode, sqlca, ordTradingXchng, ordTradeid, ordBuySellInd, ordCustomerId, ordFigi, ordQuantity, ordCurrency, ordAmount, ordStatus, itbtrdord, secDescription, secSymbol, secType, itbtrdsec, cusDescription, itbtrdcus);
	}

	@Override
	public String toString(){
		StringBuilder toSB = new StringBuilder("\nTrdpb006Context:\n");
		if(!this.recordEntities.isEmpty()){
			this.recordEntities.forEach(e -> toSB.append(e.getClass().getSimpleName()).append(" : [").append(e.toString()).append("]\n"));
		}
		return toSB.toString();
	}
}
