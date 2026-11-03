package com.company.app.trdpb004.business.context;
import com.company.app.trdpb004.business.model.ExcDescription;
import com.company.app.trdpb004.business.model.ExcType;
import com.company.app.trdpb004.business.model.ExcptionFileStatus;
import com.company.app.trdpb004.business.model.ExcptionReport;
import com.company.app.trdpb004.business.model.HdrExcptionRec;
import com.company.app.trdpb004.business.model.HdrExcptionRecDash;
import com.company.app.trdpb004.business.model.HdrRunlogRec;
import com.company.app.trdpb004.business.model.HdrRunlogRecDash;
import com.company.app.trdpb004.business.model.HdrSummaryRec;
import com.company.app.trdpb004.business.model.HdrSummaryRecDash;
import com.company.app.trdpb004.business.model.Itbtrdexc;
import com.company.app.trdpb004.business.model.Itbtrdlog;
import com.company.app.trdpb004.business.model.Itbtrdsum;
import com.company.app.trdpb004.business.model.LogCurrency;
import com.company.app.trdpb004.business.model.LogEndTs;
import com.company.app.trdpb004.business.model.LogStartTs;
import com.company.app.trdpb004.business.model.LogTransaction;
import com.company.app.trdpb004.business.model.PrtExcptionRec;
import com.company.app.trdpb004.business.model.PrtRunlogRec;
import com.company.app.trdpb004.business.model.PrtSummaryRec;
import com.company.app.trdpb004.business.model.RunlogFileStatus;
import com.company.app.trdpb004.business.model.RunlogReport;
import com.company.app.trdpb004.business.model.Sqlca;
import com.company.app.trdpb004.business.model.SumCloseBalance;
import com.company.app.trdpb004.business.model.SumCurrency;
import com.company.app.trdpb004.business.model.SumCustomerId;
import com.company.app.trdpb004.business.model.SumOpenBalance;
import com.company.app.trdpb004.business.model.SumOverdue;
import com.company.app.trdpb004.business.model.SumRejected;
import com.company.app.trdpb004.business.model.SumSettled;
import com.company.app.trdpb004.business.model.SumTotalCredit;
import com.company.app.trdpb004.business.model.SumTotalDebit;
import com.company.app.trdpb004.business.model.SummaryFileStatus;
import com.company.app.trdpb004.business.model.SummaryReport;
import com.company.app.trdpb004.business.model.WsException;
import com.company.app.trdpb004.business.model.WsNoMoreExcpRecsSw;
import com.company.app.trdpb004.business.model.WsNoMoreRunlogRecsSw;
import com.company.app.trdpb004.business.model.WsNoMoreSummaryRecsSw;
import com.company.app.trdpb004.business.model.WsSqlcode;
import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.io.metadata.builder.SequentialFileDescriptionBuilder;
import com.netfective.bluage.gapwalk.rt.context.RuntimeContext;
import com.netfective.bluage.gapwalk.rt.io.SequentialFile;
import com.netfective.bluage.gapwalk.rt.shared.ExecutionContext;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Data simplifier context Trdpb004Context.
 * 
 * <p>About 'onCode' field, <br>
 * </p>
 * 
 * <p>About 'onChar' field, <br>
 * </p>
 * 
 * <p>About 'runlogReport' file, <br>uml entity: com.company.app.trdpb004.business.model.RunlogReport
 * <br></p>
 * 
 * <p>About 'summaryReport' file, <br>uml entity: com.company.app.trdpb004.business.model.SummaryReport
 * <br></p>
 * 
 * <p>About 'excptionReport' file, <br>uml entity: com.company.app.trdpb004.business.model.ExcptionReport
 * <br></p>
 * 
 * <p>About 'wsSqlcode' field, <br>uml entity: com.company.app.trdpb004.business.model.WsSqlcode
 * <br></p>
 * 
 * <p>About 'runlogFileStatus' field, <br>uml entity: com.company.app.trdpb004.business.model.RunlogFileStatus
 * <br></p>
 * 
 * <p>About 'summaryFileStatus' field, <br>uml entity: com.company.app.trdpb004.business.model.SummaryFileStatus
 * <br></p>
 * 
 * <p>About 'excptionFileStatus' field, <br>uml entity: com.company.app.trdpb004.business.model.ExcptionFileStatus
 * <br></p>
 * 
 * <p>About 'wsException' field, <br>uml entity: com.company.app.trdpb004.business.model.WsException
 * <br></p>
 * 
 * <p>About 'wsNoMoreExcpRecsSw' field, <br>uml entity: com.company.app.trdpb004.business.model.WsNoMoreExcpRecsSw
 * <br></p>
 * 
 * <p>About 'wsNoMoreRunlogRecsSw' field, <br>uml entity: com.company.app.trdpb004.business.model.WsNoMoreRunlogRecsSw
 * <br></p>
 * 
 * <p>About 'wsNoMoreSummaryRecsSw' field, <br>uml entity: com.company.app.trdpb004.business.model.WsNoMoreSummaryRecsSw
 * <br></p>
 * 
 * <p>About 'hdrRunlogRecDash' field, <br>uml entity: com.company.app.trdpb004.business.model.HdrRunlogRecDash
 * <br></p>
 * 
 * <p>About 'hdrRunlogRec' field, <br>uml entity: com.company.app.trdpb004.business.model.HdrRunlogRec
 * <br></p>
 * 
 * <p>About 'prtRunlogRec' field, <br>uml entity: com.company.app.trdpb004.business.model.PrtRunlogRec
 * <br></p>
 * 
 * <p>About 'hdrExcptionRecDash' field, <br>uml entity: com.company.app.trdpb004.business.model.HdrExcptionRecDash
 * <br></p>
 * 
 * <p>About 'hdrExcptionRec' field, <br>uml entity: com.company.app.trdpb004.business.model.HdrExcptionRec
 * <br></p>
 * 
 * <p>About 'prtExcptionRec' field, <br>uml entity: com.company.app.trdpb004.business.model.PrtExcptionRec
 * <br></p>
 * 
 * <p>About 'hdrSummaryRecDash' field, <br>uml entity: com.company.app.trdpb004.business.model.HdrSummaryRecDash
 * <br></p>
 * 
 * <p>About 'hdrSummaryRec' field, <br>uml entity: com.company.app.trdpb004.business.model.HdrSummaryRec
 * <br></p>
 * 
 * <p>About 'prtSummaryRec' field, <br>uml entity: com.company.app.trdpb004.business.model.PrtSummaryRec
 * <br></p>
 * 
 * <p>About 'sqlca' field, <br>uml entity: com.company.app.trdpb004.business.model.Sqlca
 * <br></p>
 * 
 * <p>About 'excType' field, <br>uml entity: com.company.app.trdpb004.business.model.ExcType
 * <br></p>
 * 
 * <p>About 'excDescription' field, <br>uml entity: com.company.app.trdpb004.business.model.ExcDescription
 * <br></p>
 * 
 * <p>About 'itbtrdexc' field, <br>uml entity: com.company.app.trdpb004.business.model.Itbtrdexc
 * <br></p>
 * 
 * <p>About 'sumCustomerId' field, <br>uml entity: com.company.app.trdpb004.business.model.SumCustomerId
 * <br></p>
 * 
 * <p>About 'sumOverdue' field, <br>uml entity: com.company.app.trdpb004.business.model.SumOverdue
 * <br></p>
 * 
 * <p>About 'sumRejected' field, <br>uml entity: com.company.app.trdpb004.business.model.SumRejected
 * <br></p>
 * 
 * <p>About 'sumSettled' field, <br>uml entity: com.company.app.trdpb004.business.model.SumSettled
 * <br></p>
 * 
 * <p>About 'sumCurrency' field, <br>uml entity: com.company.app.trdpb004.business.model.SumCurrency
 * <br></p>
 * 
 * <p>About 'sumOpenBalance' field, <br>uml entity: com.company.app.trdpb004.business.model.SumOpenBalance
 * <br></p>
 * 
 * <p>About 'sumTotalDebit' field, <br>uml entity: com.company.app.trdpb004.business.model.SumTotalDebit
 * <br></p>
 * 
 * <p>About 'sumTotalCredit' field, <br>uml entity: com.company.app.trdpb004.business.model.SumTotalCredit
 * <br></p>
 * 
 * <p>About 'sumCloseBalance' field, <br>uml entity: com.company.app.trdpb004.business.model.SumCloseBalance
 * <br></p>
 * 
 * <p>About 'itbtrdsum' field, <br>uml entity: com.company.app.trdpb004.business.model.Itbtrdsum
 * <br></p>
 * 
 * <p>About 'logTransaction' field, <br>uml entity: com.company.app.trdpb004.business.model.LogTransaction
 * <br></p>
 * 
 * <p>About 'logCurrency' field, <br>uml entity: com.company.app.trdpb004.business.model.LogCurrency
 * <br></p>
 * 
 * <p>About 'logStartTs' field, <br>uml entity: com.company.app.trdpb004.business.model.LogStartTs
 * <br></p>
 * 
 * <p>About 'logEndTs' field, <br>uml entity: com.company.app.trdpb004.business.model.LogEndTs
 * <br></p>
 * 
 * <p>About 'itbtrdlog' field, <br>uml entity: com.company.app.trdpb004.business.model.Itbtrdlog
 * <br></p>
 * 
 */
@Component("com.company.app.trdpb004.business.context.Trdpb004Context")
@Import({
	com.company.app.trdpb004.business.model.RunlogReport.class
,	com.company.app.trdpb004.business.model.SummaryReport.class
,	com.company.app.trdpb004.business.model.ExcptionReport.class
})
@Lazy
@Scope("prototype")
public class Trdpb004Context extends RuntimeContext {
	
	@Autowired
	private RunlogReport runlogReport;
	@Autowired
	private SummaryReport summaryReport;
	@Autowired
	private ExcptionReport excptionReport;

	private SequentialFile runlogReportFile;	

	private SequentialFile summaryReportFile;	

	private SequentialFile excptionReportFile;	
	
	private WsSqlcode wsSqlcode;
	private RunlogFileStatus runlogFileStatus;
	private SummaryFileStatus summaryFileStatus;
	private ExcptionFileStatus excptionFileStatus;
	private WsException wsException;
	private WsNoMoreExcpRecsSw wsNoMoreExcpRecsSw;
	private WsNoMoreRunlogRecsSw wsNoMoreRunlogRecsSw;
	private WsNoMoreSummaryRecsSw wsNoMoreSummaryRecsSw;
	private HdrRunlogRecDash hdrRunlogRecDash;
	private HdrRunlogRec hdrRunlogRec;
	private PrtRunlogRec prtRunlogRec;
	private HdrExcptionRecDash hdrExcptionRecDash;
	private HdrExcptionRec hdrExcptionRec;
	private PrtExcptionRec prtExcptionRec;
	private HdrSummaryRecDash hdrSummaryRecDash;
	private HdrSummaryRec hdrSummaryRec;
	private PrtSummaryRec prtSummaryRec;
	private Sqlca sqlca;
	private ExcType excType;
	private ExcDescription excDescription;
	private Itbtrdexc itbtrdexc;
	private SumCustomerId sumCustomerId;
	private SumOverdue sumOverdue;
	private SumRejected sumRejected;
	private SumSettled sumSettled;
	private SumCurrency sumCurrency;
	private SumOpenBalance sumOpenBalance;
	private SumTotalDebit sumTotalDebit;
	private SumTotalCredit sumTotalCredit;
	private SumCloseBalance sumCloseBalance;
	private Itbtrdsum itbtrdsum;
	private LogTransaction logTransaction;
	private LogCurrency logCurrency;
	private LogStartTs logStartTs;
	private LogEndTs logEndTs;
	private Itbtrdlog itbtrdlog;

	private List<RecordEntity> recordEntities;

   /**
	 * Public constructor with injected fields.
	 * @param configuration the datasimplifier configuration to use.
	 */	   
   	
   	public Trdpb004Context (@Qualifier("sharedConfiguration") Configuration configuration){		
	    super(configuration);
		initWorking(configuration);
		
		initRecordEntities();
	}
 	
	

	/**
	 * Getter for the file runlogReport.
	 * @return the runlogReport
	 */
	public RunlogReport getRunlogReport() {
		return this.runlogReport;
	}
	
	/**
	 * Getter for the file handler runlogReportFile.
	 * @param executionContext the execution context
	 * @return the runlogReportFile
	 */
	public SequentialFile getRunlogReportHandler(ExecutionContext executionContext) {
		
		if(this.runlogReportFile == null){
			this.runlogReportFile = executionContext.getFileProvider().getFile(
				"RUNLOG",
				new SequentialFileDescriptionBuilder()
					.fileStatus(this.getRunlogFileStatus())
					.build(),
				getConfiguration(), runlogReport);
		}
		return this.runlogReportFile;	
	}

	/**
	 * Getter for the file summaryReport.
	 * @return the summaryReport
	 */
	public SummaryReport getSummaryReport() {
		return this.summaryReport;
	}
	
	/**
	 * Getter for the file handler summaryReportFile.
	 * @param executionContext the execution context
	 * @return the summaryReportFile
	 */
	public SequentialFile getSummaryReportHandler(ExecutionContext executionContext) {
		
		if(this.summaryReportFile == null){
			this.summaryReportFile = executionContext.getFileProvider().getFile(
				"SUMMARY",
				new SequentialFileDescriptionBuilder()
					.fileStatus(this.getSummaryFileStatus())
					.build(),
				getConfiguration(), summaryReport);
		}
		return this.summaryReportFile;	
	}

	/**
	 * Getter for the file excptionReport.
	 * @return the excptionReport
	 */
	public ExcptionReport getExcptionReport() {
		return this.excptionReport;
	}
	
	/**
	 * Getter for the file handler excptionReportFile.
	 * @param executionContext the execution context
	 * @return the excptionReportFile
	 */
	public SequentialFile getExcptionReportHandler(ExecutionContext executionContext) {
		
		if(this.excptionReportFile == null){
			this.excptionReportFile = executionContext.getFileProvider().getFile(
				"EXCPTION",
				new SequentialFileDescriptionBuilder()
					.fileStatus(this.getExcptionFileStatus())
					.build(),
				getConfiguration(), excptionReport);
		}
		return this.excptionReportFile;	
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
	 * Getter for runlogFileStatus.
	 * @return the runlogFileStatus
	 */
	public RunlogFileStatus getRunlogFileStatus() {
		return this.runlogFileStatus;
	}

	/**
	 * Setter for runlogFileStatus.
	 * @param reference the new value for runlogFileStatus
	 */
	public void setRunlogFileStatus(RangeReference reference) {
		this.runlogFileStatus.setBytes(reference.getBytes());
	}

	/**
	 * Getter for summaryFileStatus.
	 * @return the summaryFileStatus
	 */
	public SummaryFileStatus getSummaryFileStatus() {
		return this.summaryFileStatus;
	}

	/**
	 * Setter for summaryFileStatus.
	 * @param reference the new value for summaryFileStatus
	 */
	public void setSummaryFileStatus(RangeReference reference) {
		this.summaryFileStatus.setBytes(reference.getBytes());
	}

	/**
	 * Getter for excptionFileStatus.
	 * @return the excptionFileStatus
	 */
	public ExcptionFileStatus getExcptionFileStatus() {
		return this.excptionFileStatus;
	}

	/**
	 * Setter for excptionFileStatus.
	 * @param reference the new value for excptionFileStatus
	 */
	public void setExcptionFileStatus(RangeReference reference) {
		this.excptionFileStatus.setBytes(reference.getBytes());
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
	 * Getter for wsNoMoreExcpRecsSw.
	 * @return the wsNoMoreExcpRecsSw
	 */
	public WsNoMoreExcpRecsSw getWsNoMoreExcpRecsSw() {
		return this.wsNoMoreExcpRecsSw;
	}

	/**
	 * Setter for wsNoMoreExcpRecsSw.
	 * @param reference the new value for wsNoMoreExcpRecsSw
	 */
	public void setWsNoMoreExcpRecsSw(RangeReference reference) {
		this.wsNoMoreExcpRecsSw.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsNoMoreRunlogRecsSw.
	 * @return the wsNoMoreRunlogRecsSw
	 */
	public WsNoMoreRunlogRecsSw getWsNoMoreRunlogRecsSw() {
		return this.wsNoMoreRunlogRecsSw;
	}

	/**
	 * Setter for wsNoMoreRunlogRecsSw.
	 * @param reference the new value for wsNoMoreRunlogRecsSw
	 */
	public void setWsNoMoreRunlogRecsSw(RangeReference reference) {
		this.wsNoMoreRunlogRecsSw.setBytes(reference.getBytes());
	}

	/**
	 * Getter for wsNoMoreSummaryRecsSw.
	 * @return the wsNoMoreSummaryRecsSw
	 */
	public WsNoMoreSummaryRecsSw getWsNoMoreSummaryRecsSw() {
		return this.wsNoMoreSummaryRecsSw;
	}

	/**
	 * Setter for wsNoMoreSummaryRecsSw.
	 * @param reference the new value for wsNoMoreSummaryRecsSw
	 */
	public void setWsNoMoreSummaryRecsSw(RangeReference reference) {
		this.wsNoMoreSummaryRecsSw.setBytes(reference.getBytes());
	}

	/**
	 * Getter for hdrRunlogRecDash.
	 * @return the hdrRunlogRecDash
	 */
	public HdrRunlogRecDash getHdrRunlogRecDash() {
		return this.hdrRunlogRecDash;
	}

	/**
	 * Setter for hdrRunlogRecDash.
	 * @param reference the new value for hdrRunlogRecDash
	 */
	public void setHdrRunlogRecDash(RangeReference reference) {
		this.hdrRunlogRecDash.setBytes(reference.getBytes());
	}

	/**
	 * Getter for hdrRunlogRec.
	 * @return the hdrRunlogRec
	 */
	public HdrRunlogRec getHdrRunlogRec() {
		return this.hdrRunlogRec;
	}

	/**
	 * Setter for hdrRunlogRec.
	 * @param reference the new value for hdrRunlogRec
	 */
	public void setHdrRunlogRec(RangeReference reference) {
		this.hdrRunlogRec.setBytes(reference.getBytes());
	}

	/**
	 * Getter for prtRunlogRec.
	 * @return the prtRunlogRec
	 */
	public PrtRunlogRec getPrtRunlogRec() {
		return this.prtRunlogRec;
	}

	/**
	 * Setter for prtRunlogRec.
	 * @param reference the new value for prtRunlogRec
	 */
	public void setPrtRunlogRec(RangeReference reference) {
		this.prtRunlogRec.setBytes(reference.getBytes());
	}

	/**
	 * Getter for hdrExcptionRecDash.
	 * @return the hdrExcptionRecDash
	 */
	public HdrExcptionRecDash getHdrExcptionRecDash() {
		return this.hdrExcptionRecDash;
	}

	/**
	 * Setter for hdrExcptionRecDash.
	 * @param reference the new value for hdrExcptionRecDash
	 */
	public void setHdrExcptionRecDash(RangeReference reference) {
		this.hdrExcptionRecDash.setBytes(reference.getBytes());
	}

	/**
	 * Getter for hdrExcptionRec.
	 * @return the hdrExcptionRec
	 */
	public HdrExcptionRec getHdrExcptionRec() {
		return this.hdrExcptionRec;
	}

	/**
	 * Setter for hdrExcptionRec.
	 * @param reference the new value for hdrExcptionRec
	 */
	public void setHdrExcptionRec(RangeReference reference) {
		this.hdrExcptionRec.setBytes(reference.getBytes());
	}

	/**
	 * Getter for prtExcptionRec.
	 * @return the prtExcptionRec
	 */
	public PrtExcptionRec getPrtExcptionRec() {
		return this.prtExcptionRec;
	}

	/**
	 * Setter for prtExcptionRec.
	 * @param reference the new value for prtExcptionRec
	 */
	public void setPrtExcptionRec(RangeReference reference) {
		this.prtExcptionRec.setBytes(reference.getBytes());
	}

	/**
	 * Getter for hdrSummaryRecDash.
	 * @return the hdrSummaryRecDash
	 */
	public HdrSummaryRecDash getHdrSummaryRecDash() {
		return this.hdrSummaryRecDash;
	}

	/**
	 * Setter for hdrSummaryRecDash.
	 * @param reference the new value for hdrSummaryRecDash
	 */
	public void setHdrSummaryRecDash(RangeReference reference) {
		this.hdrSummaryRecDash.setBytes(reference.getBytes());
	}

	/**
	 * Getter for hdrSummaryRec.
	 * @return the hdrSummaryRec
	 */
	public HdrSummaryRec getHdrSummaryRec() {
		return this.hdrSummaryRec;
	}

	/**
	 * Setter for hdrSummaryRec.
	 * @param reference the new value for hdrSummaryRec
	 */
	public void setHdrSummaryRec(RangeReference reference) {
		this.hdrSummaryRec.setBytes(reference.getBytes());
	}

	/**
	 * Getter for prtSummaryRec.
	 * @return the prtSummaryRec
	 */
	public PrtSummaryRec getPrtSummaryRec() {
		return this.prtSummaryRec;
	}

	/**
	 * Setter for prtSummaryRec.
	 * @param reference the new value for prtSummaryRec
	 */
	public void setPrtSummaryRec(RangeReference reference) {
		this.prtSummaryRec.setBytes(reference.getBytes());
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
	 * Getter for sumCustomerId.
	 * @return the sumCustomerId
	 */
	public SumCustomerId getSumCustomerId() {
		return this.sumCustomerId;
	}

	/**
	 * Setter for sumCustomerId.
	 * @param reference the new value for sumCustomerId
	 */
	public void setSumCustomerId(RangeReference reference) {
		this.sumCustomerId.setBytes(reference.getBytes());
	}

	/**
	 * Getter for sumOverdue.
	 * @return the sumOverdue
	 */
	public SumOverdue getSumOverdue() {
		return this.sumOverdue;
	}

	/**
	 * Setter for sumOverdue.
	 * @param reference the new value for sumOverdue
	 */
	public void setSumOverdue(RangeReference reference) {
		this.sumOverdue.setBytes(reference.getBytes());
	}

	/**
	 * Getter for sumRejected.
	 * @return the sumRejected
	 */
	public SumRejected getSumRejected() {
		return this.sumRejected;
	}

	/**
	 * Setter for sumRejected.
	 * @param reference the new value for sumRejected
	 */
	public void setSumRejected(RangeReference reference) {
		this.sumRejected.setBytes(reference.getBytes());
	}

	/**
	 * Getter for sumSettled.
	 * @return the sumSettled
	 */
	public SumSettled getSumSettled() {
		return this.sumSettled;
	}

	/**
	 * Setter for sumSettled.
	 * @param reference the new value for sumSettled
	 */
	public void setSumSettled(RangeReference reference) {
		this.sumSettled.setBytes(reference.getBytes());
	}

	/**
	 * Getter for sumCurrency.
	 * @return the sumCurrency
	 */
	public SumCurrency getSumCurrency() {
		return this.sumCurrency;
	}

	/**
	 * Setter for sumCurrency.
	 * @param reference the new value for sumCurrency
	 */
	public void setSumCurrency(RangeReference reference) {
		this.sumCurrency.setBytes(reference.getBytes());
	}

	/**
	 * Getter for sumOpenBalance.
	 * @return the sumOpenBalance
	 */
	public SumOpenBalance getSumOpenBalance() {
		return this.sumOpenBalance;
	}

	/**
	 * Setter for sumOpenBalance.
	 * @param reference the new value for sumOpenBalance
	 */
	public void setSumOpenBalance(RangeReference reference) {
		this.sumOpenBalance.setBytes(reference.getBytes());
	}

	/**
	 * Getter for sumTotalDebit.
	 * @return the sumTotalDebit
	 */
	public SumTotalDebit getSumTotalDebit() {
		return this.sumTotalDebit;
	}

	/**
	 * Setter for sumTotalDebit.
	 * @param reference the new value for sumTotalDebit
	 */
	public void setSumTotalDebit(RangeReference reference) {
		this.sumTotalDebit.setBytes(reference.getBytes());
	}

	/**
	 * Getter for sumTotalCredit.
	 * @return the sumTotalCredit
	 */
	public SumTotalCredit getSumTotalCredit() {
		return this.sumTotalCredit;
	}

	/**
	 * Setter for sumTotalCredit.
	 * @param reference the new value for sumTotalCredit
	 */
	public void setSumTotalCredit(RangeReference reference) {
		this.sumTotalCredit.setBytes(reference.getBytes());
	}

	/**
	 * Getter for sumCloseBalance.
	 * @return the sumCloseBalance
	 */
	public SumCloseBalance getSumCloseBalance() {
		return this.sumCloseBalance;
	}

	/**
	 * Setter for sumCloseBalance.
	 * @param reference the new value for sumCloseBalance
	 */
	public void setSumCloseBalance(RangeReference reference) {
		this.sumCloseBalance.setBytes(reference.getBytes());
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
	 * Getter for logTransaction.
	 * @return the logTransaction
	 */
	public LogTransaction getLogTransaction() {
		return this.logTransaction;
	}

	/**
	 * Setter for logTransaction.
	 * @param reference the new value for logTransaction
	 */
	public void setLogTransaction(RangeReference reference) {
		this.logTransaction.setBytes(reference.getBytes());
	}

	/**
	 * Getter for logCurrency.
	 * @return the logCurrency
	 */
	public LogCurrency getLogCurrency() {
		return this.logCurrency;
	}

	/**
	 * Setter for logCurrency.
	 * @param reference the new value for logCurrency
	 */
	public void setLogCurrency(RangeReference reference) {
		this.logCurrency.setBytes(reference.getBytes());
	}

	/**
	 * Getter for logStartTs.
	 * @return the logStartTs
	 */
	public LogStartTs getLogStartTs() {
		return this.logStartTs;
	}

	/**
	 * Setter for logStartTs.
	 * @param reference the new value for logStartTs
	 */
	public void setLogStartTs(RangeReference reference) {
		this.logStartTs.setBytes(reference.getBytes());
	}

	/**
	 * Getter for logEndTs.
	 * @return the logEndTs
	 */
	public LogEndTs getLogEndTs() {
		return this.logEndTs;
	}

	/**
	 * Setter for logEndTs.
	 * @param reference the new value for logEndTs
	 */
	public void setLogEndTs(RangeReference reference) {
		this.logEndTs.setBytes(reference.getBytes());
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

	@Override 
	public void cleanUp(){
		if(this.runlogReportFile !=null && this.runlogReportFile.isOpen() && !this.runlogReportFile.isShared()) {
			this.runlogReportFile.close();
		}
		if(this.runlogReportFile !=null && !this.runlogReportFile.isShared()){
			this.runlogReportFile = null;
		}
		if(this.summaryReportFile !=null && this.summaryReportFile.isOpen() && !this.summaryReportFile.isShared()) {
			this.summaryReportFile.close();
		}
		if(this.summaryReportFile !=null && !this.summaryReportFile.isShared()){
			this.summaryReportFile = null;
		}
		if(this.excptionReportFile !=null && this.excptionReportFile.isOpen() && !this.excptionReportFile.isShared()) {
			this.excptionReportFile.close();
		}
		if(this.excptionReportFile !=null && !this.excptionReportFile.isShared()){
			this.excptionReportFile = null;
		}
		// No resources to clean up
	}

	@Override
	protected void doReset() {
		cleanUp();
		this.runlogReport.reset();
		this.summaryReport.reset();
		this.excptionReport.reset();
	    // reset the working
		recordEntities.stream().forEach(e -> e.reset());
	}

	
	private void initWorking(Configuration configuration) {
		wsSqlcode = new WsSqlcode(configuration);
		runlogFileStatus = new RunlogFileStatus(configuration);
		summaryFileStatus = new SummaryFileStatus(configuration);
		excptionFileStatus = new ExcptionFileStatus(configuration);
		wsException = new WsException(configuration);
		wsNoMoreExcpRecsSw = new WsNoMoreExcpRecsSw(configuration);
		wsNoMoreRunlogRecsSw = new WsNoMoreRunlogRecsSw(configuration);
		wsNoMoreSummaryRecsSw = new WsNoMoreSummaryRecsSw(configuration);
		hdrRunlogRecDash = new HdrRunlogRecDash(configuration);
		hdrRunlogRec = new HdrRunlogRec(configuration);
		prtRunlogRec = new PrtRunlogRec(configuration);
		hdrExcptionRecDash = new HdrExcptionRecDash(configuration);
		hdrExcptionRec = new HdrExcptionRec(configuration);
		prtExcptionRec = new PrtExcptionRec(configuration);
		hdrSummaryRecDash = new HdrSummaryRecDash(configuration);
		hdrSummaryRec = new HdrSummaryRec(configuration);
		prtSummaryRec = new PrtSummaryRec(configuration);
		sqlca = new Sqlca(configuration);
		excType = new ExcType(configuration);
		excDescription = new ExcDescription(configuration);
		itbtrdexc = new Itbtrdexc(configuration);
		sumCustomerId = new SumCustomerId(configuration);
		sumOverdue = new SumOverdue(configuration);
		sumRejected = new SumRejected(configuration);
		sumSettled = new SumSettled(configuration);
		sumCurrency = new SumCurrency(configuration);
		sumOpenBalance = new SumOpenBalance(configuration);
		sumTotalDebit = new SumTotalDebit(configuration);
		sumTotalCredit = new SumTotalCredit(configuration);
		sumCloseBalance = new SumCloseBalance(configuration);
		itbtrdsum = new Itbtrdsum(configuration);
		logTransaction = new LogTransaction(configuration);
		logCurrency = new LogCurrency(configuration);
		logStartTs = new LogStartTs(configuration);
		logEndTs = new LogEndTs(configuration);
		itbtrdlog = new Itbtrdlog(configuration);
	}

	private void initRecordEntities() {
		recordEntities = Arrays.asList(wsSqlcode, runlogFileStatus, summaryFileStatus, excptionFileStatus, wsException, wsNoMoreExcpRecsSw, wsNoMoreRunlogRecsSw, wsNoMoreSummaryRecsSw, hdrRunlogRecDash, hdrRunlogRec, prtRunlogRec, hdrExcptionRecDash, hdrExcptionRec, prtExcptionRec, hdrSummaryRecDash, hdrSummaryRec, prtSummaryRec, sqlca, excType, excDescription, itbtrdexc, sumCustomerId, sumOverdue, sumRejected, sumSettled, sumCurrency, sumOpenBalance, sumTotalDebit, sumTotalCredit, sumCloseBalance, itbtrdsum, logTransaction, logCurrency, logStartTs, logEndTs, itbtrdlog);
	}

	@Override
	public String toString(){
		StringBuilder toSB = new StringBuilder("\nTrdpb004Context:\n");
		if(!this.recordEntities.isEmpty()){
			this.recordEntities.forEach(e -> toSB.append(e.getClass().getSimpleName()).append(" : [").append(e.toString()).append("]\n"));
		}
		return toSB.toString();
	}
}
