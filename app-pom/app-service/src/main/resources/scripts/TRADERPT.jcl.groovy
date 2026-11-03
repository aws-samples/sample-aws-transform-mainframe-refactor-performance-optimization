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
	def jobName = "TRADERPT"
	mpr.setJobContext(jobContext)
	displayStartJob(jobName)
	Map programResults = jobContext.getProgramResults().clone()
	def lastProgramResult
	//-------> TO DO ID : PROCLIB [Line : 6] *****************************************
	if (programResults.get("GroovyExecutionResult") != null && !(programResults.get("GroovyExecutionResult").getExitCode() <= 8)) {
		return programResults.get("GroovyExecutionResult")
	}
	//
	//This job generates customer-wise Detailed Trade Report
	//
	lastProgramResult = stepDELETE(shell, params, programResults)
	if (programResults.get("GroovyExecutionResult") != null && !(programResults.get("GroovyExecutionResult").getExitCode() <= 8)) {
		return programResults.get("GroovyExecutionResult")
	}
	//
	stepTRADERPT(shell, jobName, params, programResults)
	displayEndJob(jobName)
	return programResults.get("GroovyExecutionResult")
}
//*********************************************************************
//*                            STEPS                                  *
//*********************************************************************
// STEP DELETE - PGM - IEFBR14****************************************************
def stepDELETE(Object shell, Map params, Map programResults){
	shell.with {
		if (checkValidProgramResults(programResults)) {
			return execStep("DELETE", "IEFBR14", programResults, {
				mpr
					.withFileConfigurations(new FileConfigurationUtils()
						.withJobContext(jobContext)
						.bluesam("REPORDER")
						.dataset("CLOUDFRM.TRADING.BATCHDB2.REPORDER.REPORT.MF")
						.disposition("MOD")
						.normalTermination("DELETE")
						.abnormalTermination("DELETE")
						.build()
						.getFileConfigurations())
					.withParameters(params)
					.runProgram("IEFBR14")
				})
		}
	}
}
// STEP TRADERPT - PROC - TRDPROC*************************************************
def stepTRADERPT(Object shell, String jobName, Map params, Map programResults) {
	shell.with{
		if (checkValidProgramResults(programResults)) {
			def stepName = 'TRADERPT'
			execStepSimple(stepName, programResults, {
				def procName = 'TRDPROC'
				TreeMap mapTransfo = new TreeMap(params["MapTransfo"])
				mapTransfo['RUNPARM'] = 'TRADERPT'
				Map<String,FileConfiguration> fcmap = new FileConfigurationUtils()
				.withJobContext(jobContext)
				.bluesam("REPORDER")
				.dataset("CLOUDFRM.TRADING.BATCHDB2.REPORDER.REPORT.MF")
				.disposition("MOD")
				.normalTermination("CATLG")
				.abnormalTermination("DELETE")
				.build()
				.fileSystem("SYSTSIN")
				.path("CLOUDFRM.TRADING.BATCHDB2.CARD(TRADERPT)")
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
