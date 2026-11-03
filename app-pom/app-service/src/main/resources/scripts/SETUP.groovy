// Import
import com.netfective.bluage.gapwalk.rt.provider.ScriptRegistry
import com.netfective.bluage.gapwalk.rt.call.MainProgramRunner
import com.netfective.bluage.gapwalk.io.support.FileConfigurationUtils
import com.netfective.bluage.gapwalk.rt.job.support.DefaultJobContext
import com.netfective.bluage.gapwalk.rt.utils.GroovyUtils
import com.netfective.bluage.gapwalk.rt.io.support.FileConfiguration
import com.netfective.bluage.gapwalk.rt.shared.AbendException
import com.netfective.bluage.gapwalk.rt.call.exception.GroovyExecutionException
// Variables
mpr = applicationContext.getBean("com.netfective.bluage.gapwalk.rt.call.ExecutionController", MainProgramRunner.class)
TreeMap mapTransfo = [:]
Map params = ["MapTransfo":mapTransfo]
// Execute job with utility functions
Binding binding = new Binding()
binding.setVariable("jobContext", jobContext)
def shell = new GroovyShell(binding).parse(ScriptRegistry.getScript("functions"))
//*********************************************************************
//*                             JOB                                   *
//*********************************************************************
shell.with {
	def jobName = "SETUP"
	mpr.setJobContext(jobContext)
	displayStartJob(jobName)
	Map programResults = jobContext.getProgramResults().clone()
	def lastProgramResult
	//
	//--------------------------------------------------------
	//  LOAD DATA (REPLACE)
	//--------------------------------------------------------
	//
	stepCUS(shell, jobName, params, programResults)
	//
	stepSEC(shell, jobName, params, programResults)
	//
	stepORD(shell, jobName, params, programResults)
	//
	stepMAC(shell, jobName, params, programResults)
	//
	stepSAC(shell, jobName, params, programResults)
	//
	stepPOS(shell, jobName, params, programResults)
	//
	//--------------------------------------------------------
	// START DB ACCESS(FORCE) TO OVERRIDE RECOVERY PENDING
	//--------------------------------------------------------
	//
	lastProgramResult = stepSTARTDB(shell, params, programResults)
	//
	//--------------------------------------------------------
	// START DB ACCESS(FORCE) TO OVERRIDE RECOVERY PENDING
	//--------------------------------------------------------
	//
	stepRUNSTATS(shell, jobName, params, programResults)
	lastProgramResult = stepDELETE(shell, params, programResults)
	displayEndJob(jobName)
	return programResults.get("GroovyExecutionResult")
}
//*********************************************************************
//*                            STEPS                                  *
//*********************************************************************
// STEP CUS - PROC - DSNUPROC*****************************************************
def stepCUS(Object shell, String jobName, Map params, Map programResults) {
	shell.with{
		if (checkValidProgramResults(programResults)) {
			def stepName = 'CUS'
			execStepSimple(stepName, programResults, {
				def procName = 'DSNUPROC'
				TreeMap mapTransfo = new TreeMap(params["MapTransfo"])
				mapTransfo['SYSTEM'] = 'DBCG'
				mapTransfo['UID'] = 'CLOUDFRM'
				mapTransfo['LIB'] = 'DSNC10.SDSNLOAD'
				mapTransfo['REGION'] = '0M'
				Map<String,FileConfiguration> fcmap = new FileConfigurationUtils()
				.withJobContext(jobContext)
				.bluesam("STEPLIB")
				.dataset("DSNC10.SDSNLOAD")
				.disposition("SHR")
				.build()
				.systemOut("SYSPRINT")
				.output("*")
				.build()
				.bluesam("SYSREC00")
				.dataset("CLOUDFRM.TRADING.TBTRDCUS.SMALL")
				.disposition("SHR")
				.build()
				.fileSystem("SYSMAP")
				.path("&&SYSMAP").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.bluesam("SYSERR")
				.dataset("&SYSUID..TBXMLLOG.SYSERR")
				.disposition("MOD")
				.normalTermination("CATLG")
				.abnormalTermination("CATLG")
				.build()
				.bluesam("SYSDISC")
				.dataset("&SYSUID..TBXMLLOG.SYSDISC")
				.disposition("MOD")
				.normalTermination("CATLG")
				.abnormalTermination("CATLG")
				.build()
				.fileSystem("SYSUT1")
				.path("&&SYSUT1").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK01")
				.path("&&SORWK01").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK02")
				.path("&&SORWK02").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK03")
				.path("&&SORWK03").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK04")
				.path("&&SORWK04").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK05")
				.path("&&SORWK05").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK06")
				.path("&&SORWK06").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK07")
				.path("&&SORWK07").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORTOUT")
				.path("&&SORTOUT").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SYSIN")
				.path("CLOUDFRM.TRADING.BATCHDB2.LDCNTL(TBTRDCUS)")
				.disposition("SHR")
				.build()
				.getFileConfigurations();
				File procFile = ScriptRegistry.getScript(procName);
				File resolvedProcFile = buildResolvedFile(jobName,stepName,procName)
				GroovyUtils.processGroovyParams(procFile, resolvedProcFile, mapTransfo, programResults)
				return execGroovy(applicationContext, mapTransfo, resolvedProcFile, jobContext, fcmap)
			})
		}
	}
}
// STEP SEC - PROC - DSNUPROC*****************************************************
def stepSEC(Object shell, String jobName, Map params, Map programResults) {
	shell.with{
		if (checkValidProgramResults(programResults)) {
			def stepName = 'SEC'
			execStepSimple(stepName, programResults, {
				def procName = 'DSNUPROC'
				TreeMap mapTransfo = new TreeMap(params["MapTransfo"])
				mapTransfo['SYSTEM'] = 'DBCG'
				mapTransfo['UID'] = 'CLOUDFRM'
				mapTransfo['LIB'] = 'DSNC10.SDSNLOAD'
				mapTransfo['REGION'] = '0M'
				Map<String,FileConfiguration> fcmap = new FileConfigurationUtils()
				.withJobContext(jobContext)
				.bluesam("STEPLIB")
				.dataset("DSNC10.SDSNLOAD")
				.disposition("SHR")
				.build()
				.systemOut("SYSPRINT")
				.output("*")
				.build()
				.bluesam("SYSREC00")
				.dataset("CLOUDFRM.TRADING.TBTRDSEC.SMALL")
				.disposition("SHR")
				.build()
				.fileSystem("SYSMAP")
				.path("&&SYSMAP").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.bluesam("SYSERR")
				.dataset("&SYSUID..TBXMLLOG.SYSERR")
				.disposition("MOD")
				.normalTermination("CATLG")
				.abnormalTermination("CATLG")
				.build()
				.bluesam("SYSDISC")
				.dataset("&SYSUID..TBXMLLOG.SYSDISC")
				.disposition("MOD")
				.normalTermination("CATLG")
				.abnormalTermination("CATLG")
				.build()
				.fileSystem("SYSUT1")
				.path("&&SYSUT1").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK01")
				.path("&&SORWK01").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK02")
				.path("&&SORWK02").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK03")
				.path("&&SORWK03").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK04")
				.path("&&SORWK04").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK05")
				.path("&&SORWK05").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK06")
				.path("&&SORWK06").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK07")
				.path("&&SORWK07").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORTOUT")
				.path("&&SORTOUT").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SYSIN")
				.path("CLOUDFRM.TRADING.BATCHDB2.LDCNTL(TBTRDSEC)")
				.disposition("SHR")
				.build()
				.getFileConfigurations();
				File procFile = ScriptRegistry.getScript(procName);
				File resolvedProcFile = buildResolvedFile(jobName,stepName,procName)
				GroovyUtils.processGroovyParams(procFile, resolvedProcFile, mapTransfo, programResults)
				return execGroovy(applicationContext, mapTransfo, resolvedProcFile, jobContext, fcmap)
			})
		}
	}
}
// STEP ORD - PROC - DSNUPROC*****************************************************
def stepORD(Object shell, String jobName, Map params, Map programResults) {
	shell.with{
		if (checkValidProgramResults(programResults)) {
			def stepName = 'ORD'
			execStepSimple(stepName, programResults, {
				def procName = 'DSNUPROC'
				TreeMap mapTransfo = new TreeMap(params["MapTransfo"])
				mapTransfo['SYSTEM'] = 'DBCG'
				mapTransfo['UID'] = 'CLOUDFRM'
				mapTransfo['LIB'] = 'DSNC10.SDSNLOAD'
				mapTransfo['REGION'] = '0M'
				Map<String,FileConfiguration> fcmap = new FileConfigurationUtils()
				.withJobContext(jobContext)
				.bluesam("STEPLIB")
				.dataset("DSNC10.SDSNLOAD")
				.disposition("SHR")
				.build()
				.systemOut("SYSPRINT")
				.output("*")
				.build()
				.bluesam("SYSREC00")
				.dataset("CLOUDFRM.TRADING.TBTRDORD.SMALL")
				.disposition("SHR")
				.build()
				.fileSystem("SYSMAP")
				.path("&&SYSMAP").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.bluesam("SYSERR")
				.dataset("&SYSUID..TBXMLLOG.SYSERR")
				.disposition("MOD")
				.normalTermination("CATLG")
				.abnormalTermination("CATLG")
				.build()
				.bluesam("SYSDISC")
				.dataset("&SYSUID..TBXMLLOG.SYSDISC")
				.disposition("MOD")
				.normalTermination("CATLG")
				.abnormalTermination("CATLG")
				.build()
				.fileSystem("SYSUT1")
				.path("&&SYSUT1").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK01")
				.path("&&SORWK01").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK02")
				.path("&&SORWK02").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK03")
				.path("&&SORWK03").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK04")
				.path("&&SORWK04").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK05")
				.path("&&SORWK05").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK06")
				.path("&&SORWK06").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK07")
				.path("&&SORWK07").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORTOUT")
				.path("&&SORTOUT").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SYSIN")
				.path("CLOUDFRM.TRADING.BATCHDB2.LDCNTL(TBTRDORD)")
				.disposition("SHR")
				.build()
				.getFileConfigurations();
				File procFile = ScriptRegistry.getScript(procName);
				File resolvedProcFile = buildResolvedFile(jobName,stepName,procName)
				GroovyUtils.processGroovyParams(procFile, resolvedProcFile, mapTransfo, programResults)
				return execGroovy(applicationContext, mapTransfo, resolvedProcFile, jobContext, fcmap)
			})
		}
	}
}
// STEP MAC - PROC - DSNUPROC*****************************************************
def stepMAC(Object shell, String jobName, Map params, Map programResults) {
	shell.with{
		if (checkValidProgramResults(programResults)) {
			def stepName = 'MAC'
			execStepSimple(stepName, programResults, {
				def procName = 'DSNUPROC'
				TreeMap mapTransfo = new TreeMap(params["MapTransfo"])
				mapTransfo['SYSTEM'] = 'DBCG'
				mapTransfo['UID'] = 'CLOUDFRM'
				mapTransfo['LIB'] = 'DSNC10.SDSNLOAD'
				mapTransfo['REGION'] = '0M'
				Map<String,FileConfiguration> fcmap = new FileConfigurationUtils()
				.withJobContext(jobContext)
				.bluesam("STEPLIB")
				.dataset("DSNC10.SDSNLOAD")
				.disposition("SHR")
				.build()
				.systemOut("SYSPRINT")
				.output("*")
				.build()
				.bluesam("SYSREC00")
				.dataset("CLOUDFRM.TRADING.TBTRDMAC.SMALL")
				.disposition("SHR")
				.build()
				.fileSystem("SYSMAP")
				.path("&&SYSMAP").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.bluesam("SYSERR")
				.dataset("&SYSUID..TBXMLLOG.SYSERR")
				.disposition("MOD")
				.normalTermination("CATLG")
				.abnormalTermination("CATLG")
				.build()
				.bluesam("SYSDISC")
				.dataset("&SYSUID..TBXMLLOG.SYSDISC")
				.disposition("MOD")
				.normalTermination("CATLG")
				.abnormalTermination("CATLG")
				.build()
				.fileSystem("SYSUT1")
				.path("&&SYSUT1").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK01")
				.path("&&SORWK01").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK02")
				.path("&&SORWK02").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK03")
				.path("&&SORWK03").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK04")
				.path("&&SORWK04").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK05")
				.path("&&SORWK05").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK06")
				.path("&&SORWK06").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK07")
				.path("&&SORWK07").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORTOUT")
				.path("&&SORTOUT").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SYSIN")
				.path("CLOUDFRM.TRADING.BATCHDB2.LDCNTL(TBTRDMAC)")
				.disposition("SHR")
				.build()
				.getFileConfigurations();
				File procFile = ScriptRegistry.getScript(procName);
				File resolvedProcFile = buildResolvedFile(jobName,stepName,procName)
				GroovyUtils.processGroovyParams(procFile, resolvedProcFile, mapTransfo, programResults)
				return execGroovy(applicationContext, mapTransfo, resolvedProcFile, jobContext, fcmap)
			})
		}
	}
}
// STEP SAC - PROC - DSNUPROC*****************************************************
def stepSAC(Object shell, String jobName, Map params, Map programResults) {
	shell.with{
		if (checkValidProgramResults(programResults)) {
			def stepName = 'SAC'
			execStepSimple(stepName, programResults, {
				def procName = 'DSNUPROC'
				TreeMap mapTransfo = new TreeMap(params["MapTransfo"])
				mapTransfo['SYSTEM'] = 'DBCG'
				mapTransfo['UID'] = 'CLOUDFRM'
				mapTransfo['LIB'] = 'DSNC10.SDSNLOAD'
				mapTransfo['REGION'] = '0M'
				Map<String,FileConfiguration> fcmap = new FileConfigurationUtils()
				.withJobContext(jobContext)
				.bluesam("STEPLIB")
				.dataset("DSNC10.SDSNLOAD")
				.disposition("SHR")
				.build()
				.systemOut("SYSPRINT")
				.output("*")
				.build()
				.bluesam("SYSREC00")
				.dataset("CLOUDFRM.TRADING.TBTRDSAC.SMALL")
				.disposition("SHR")
				.build()
				.fileSystem("SYSMAP")
				.path("&&SYSMAP").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.bluesam("SYSERR")
				.dataset("&SYSUID..TBXMLLOG.SYSERR")
				.disposition("MOD")
				.normalTermination("CATLG")
				.abnormalTermination("CATLG")
				.build()
				.bluesam("SYSDISC")
				.dataset("&SYSUID..TBXMLLOG.SYSDISC")
				.disposition("MOD")
				.normalTermination("CATLG")
				.abnormalTermination("CATLG")
				.build()
				.fileSystem("SYSUT1")
				.path("&&SYSUT1").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK01")
				.path("&&SORWK01").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK02")
				.path("&&SORWK02").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK03")
				.path("&&SORWK03").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK04")
				.path("&&SORWK04").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK05")
				.path("&&SORWK05").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK06")
				.path("&&SORWK06").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK07")
				.path("&&SORWK07").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORTOUT")
				.path("&&SORTOUT").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SYSIN")
				.path("CLOUDFRM.TRADING.BATCHDB2.LDCNTL(TBTRDSAC)")
				.disposition("SHR")
				.build()
				.getFileConfigurations();
				File procFile = ScriptRegistry.getScript(procName);
				File resolvedProcFile = buildResolvedFile(jobName,stepName,procName)
				GroovyUtils.processGroovyParams(procFile, resolvedProcFile, mapTransfo, programResults)
				return execGroovy(applicationContext, mapTransfo, resolvedProcFile, jobContext, fcmap)
			})
		}
	}
}
// STEP POS - PROC - DSNUPROC*****************************************************
def stepPOS(Object shell, String jobName, Map params, Map programResults) {
	shell.with{
		if (checkValidProgramResults(programResults)) {
			def stepName = 'POS'
			execStepSimple(stepName, programResults, {
				def procName = 'DSNUPROC'
				TreeMap mapTransfo = new TreeMap(params["MapTransfo"])
				mapTransfo['SYSTEM'] = 'DBCG'
				mapTransfo['UID'] = 'CLOUDFRM'
				mapTransfo['LIB'] = 'DSNC10.SDSNLOAD'
				mapTransfo['REGION'] = '0M'
				Map<String,FileConfiguration> fcmap = new FileConfigurationUtils()
				.withJobContext(jobContext)
				.bluesam("STEPLIB")
				.dataset("DSNC10.SDSNLOAD")
				.disposition("SHR")
				.build()
				.systemOut("SYSPRINT")
				.output("*")
				.build()
				.bluesam("SYSREC00")
				.dataset("CLOUDFRM.TRADING.TBTRDPOS.SMALL")
				.disposition("SHR")
				.build()
				.fileSystem("SYSMAP")
				.path("&&SYSMAP").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.bluesam("SYSERR")
				.dataset("&SYSUID..TBXMLLOG.SYSERR")
				.disposition("MOD")
				.normalTermination("CATLG")
				.abnormalTermination("CATLG")
				.build()
				.bluesam("SYSDISC")
				.dataset("&SYSUID..TBXMLLOG.SYSDISC")
				.disposition("MOD")
				.normalTermination("CATLG")
				.abnormalTermination("CATLG")
				.build()
				.fileSystem("SYSUT1")
				.path("&&SYSUT1").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK01")
				.path("&&SORWK01").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK02")
				.path("&&SORWK02").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK03")
				.path("&&SORWK03").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK04")
				.path("&&SORWK04").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK05")
				.path("&&SORWK05").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK06")
				.path("&&SORWK06").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORWK07")
				.path("&&SORWK07").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SORTOUT")
				.path("&&SORTOUT").temporary()
				.disposition("NEW")
				.normalTermination("DELETE")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SYSIN")
				.path("CLOUDFRM.TRADING.BATCHDB2.LDCNTL(TBTRDPOS)")
				.disposition("SHR")
				.build()
				.getFileConfigurations();
				File procFile = ScriptRegistry.getScript(procName);
				File resolvedProcFile = buildResolvedFile(jobName,stepName,procName)
				GroovyUtils.processGroovyParams(procFile, resolvedProcFile, mapTransfo, programResults)
				return execGroovy(applicationContext, mapTransfo, resolvedProcFile, jobContext, fcmap)
			})
		}
	}
}
// STEP STARTDB - PGM - IKJEFT01**************************************************
def stepSTARTDB(Object shell, Map params, Map programResults){
	shell.with {
		if (checkValidProgramResults(programResults)) {
			return execStep("STARTDB", "IKJEFT01", programResults, {
				mpr
					.withFileConfigurations(new FileConfigurationUtils()
						.withJobContext(jobContext)
						.concatenation("STEPLIB")
						.path("DSNC10.DBCG.SDSNEXIT")
						.disposition("SHR")
						.path("DSNC10.SDSNLOAD")
						.disposition("SHR")
						.build()
						.systemOut("SYSTSPRT")
						.output("*")
						.build()
						.systemOut("SYSPRINT")
						.output("*")
						.build()
						.fileSystem("SYSTSIN")
						.stream(
"""  DSN SYSTEM (DBCG)
  -STA DB(DBTRADEB) SPACE(TSTRDORD) ACCESS(FORCE)
  -STA DB(DBTRADEB) SPACE(TSTRDMAC) ACCESS(FORCE)
  -STA DB(DBTRADEB) SPACE(TSTRDSAC) ACCESS(FORCE)
  -STA DB(DBTRADEB) SPACE(TSTRDPOS) ACCESS(FORCE)
  -STA DB(DBTRADEB) SPACE(TSTRDSEC) ACCESS(FORCE)
  -STA DB(DBTRADEB) SPACE(TSTRDCUS) ACCESS(FORCE)
  -DIS DB(DBTRADEB) SPACE(*) LIMIT(300)
  END""", getEncoding())
						.build()
						.getFileConfigurations())
					.withParameters(params)
					.runProgram("IKJEFT01")
				})
		}
	}
}
// STEP RUNSTATS - PROC - DSNUPROC************************************************
def stepRUNSTATS(Object shell, String jobName, Map params, Map programResults) {
	shell.with{
		if (checkValidProgramResults(programResults)) {
			def stepName = 'RUNSTATS'
			execStepSimple(stepName, programResults, {
				def procName = 'DSNUPROC'
				TreeMap mapTransfo = new TreeMap(params["MapTransfo"])
				mapTransfo['SYSTEM'] = 'DBCG'
				mapTransfo['UID'] = ''
				Map<String,FileConfiguration> fcmap = new FileConfigurationUtils()
				.withJobContext(jobContext)
				.fileSystem("DSNUPROC.SYSIN")
				.stream(
"""RUNSTATS TABLESPACE DBTRADEB.TSTRDSEC
  INDEX(ALL) SHRLEVEL(CHANGE)
RUNSTATS TABLESPACE DBTRADEB.TSTRDORD
  INDEX(ALL) SHRLEVEL(CHANGE)
RUNSTATS TABLESPACE DBTRADEB.TSTRDCUS
  INDEX(ALL) SHRLEVEL(CHANGE)
RUNSTATS TABLESPACE DBTRADEB.TSTRDMAC
  INDEX(ALL) SHRLEVEL(CHANGE)
RUNSTATS TABLESPACE DBTRADEB.TSTRDSAC
  INDEX(ALL) SHRLEVEL(CHANGE)
RUNSTATS TABLESPACE DBTRADEB.TSTRDPOS
  INDEX(ALL) SHRLEVEL(CHANGE)""", getEncoding())
				.build()
				.getFileConfigurations();
				File procFile = ScriptRegistry.getScript(procName);
				File resolvedProcFile = buildResolvedFile(jobName,stepName,procName)
				GroovyUtils.processGroovyParams(procFile, resolvedProcFile, mapTransfo, programResults)
				return execGroovy(applicationContext, mapTransfo, resolvedProcFile, jobContext, fcmap)
			})
		}
	}
}
// STEP DELETE - PGM - IKJEFT01***************************************************
def stepDELETE(Object shell, Map params, Map programResults){
	shell.with {
		if (checkValidProgramResults(programResults)) {
			return execStep("DELETE", "IKJEFT01", programResults, {
				mpr
					.withFileConfigurations(new FileConfigurationUtils()
						.withJobContext(jobContext)
						.concatenation("STEPLIB")
						.path("DSNC10.SDSNLOAD")
						.disposition("SHR")
						.path("DSNC10.DBCG.RUNLIB.LOAD")
						.disposition("SHR")
						.build()
						.systemOut("SYSTSPRT")
						.output("*")
						.build()
						.fileSystem("SYSTSIN")
						.stream(
""" DSN SYSTEM(DBCG)
 RUN PROGRAM(DSNTEP2) PLAN(DSNTEP12) -
 LIBRARY ('DSNC10.DBCG.RUNLIB.LOAD')
 END""", getEncoding())
						.build()
						.systemOut("SYSPRINT")
						.output("*")
						.build()
						.systemOut("SYSUDUMP")
						.output("X")
						.build()
						.fileSystem("SYSIN")
						.stream(
"""  DELETE FROM TRADE.TBTRDSTQ;
  DELETE FROM TRADE.TBTRDSUM;
  DELETE FROM TRADE.TBTRDLOG;
  DELETE FROM TRADE.TBTRDEXC;""", getEncoding())
						.build()
						.getFileConfigurations())
					.withParameters(params)
					.runProgram("IKJEFT01")
				})
		}
	}
}
