// 'RUNPARM'='DUMMY'
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
Map params = ["MapTransfo":mapTransfo]
// Execute job with utility functions
Binding binding = new Binding()
binding.setVariable("jobContext", jobContext)
binding.setVariable("fcmap", fcmap)
def shell = new GroovyShell(binding).parse(ScriptRegistry.getScript("functions"))
//*********************************************************************
//*                             PROC                                  *
//*********************************************************************
shell.with {
	def procName = "TRDPROC"
	mpr.setJobContext(jobContext)
	def jobName = "" + jobContext.getJobName() + "-" + procName
	displayStartProc(procName)
	mpr.withSchenv(jobContext.getSchenv())
	def lastProgramResult
	//                                                                     
	lastProgramResult = stepSTEP01(shell, params, programResults)
	displayEndProc(procName)
	return programResults
}
//*********************************************************************
//*                            STEPS                                  *
//*********************************************************************
// STEP STEP01 - PGM - IKJEFT01***************************************************
def stepSTEP01(Object shell, Map params, Map programResults){
	shell.with {
		if (checkValidProgramResults(programResults)) {
			return execStep("STEP01", "IKJEFT01", programResults, {
				mpr
					.withFileConfigurations(new FileConfigurationUtils()
						.withJobContext(jobContext)
						.concatenation("STEPLIB")
						.path("DSNC10.DBCG.SDSNEXIT")
						.disposition("SHR")
						.path("DSNC10.SDSNLOAD")
						.disposition("SHR")
						.path("CLOUDFRM.TRADING.BATCHDB2.LOADLIB")
						.disposition("SHR")
						.build()
						.systemOut("SYSUDUMP")
						.output("*")
						.build()
						.systemOut("SYSPRINT")
						.output("*")
						.build()
						.systemOut("SYSTSPRT")
						.output("*")
						.build()
						.systemOut("SYSOUT")
						.output("*")
						.build()
						.fileSystem("SYSTSIN")
						.path("CLOUDFRM.TRADING.BATCHDB2.CARD(&RUNPARM)")
						.disposition("SHR")
						.build()
						.getFileConfigurations(fcmap))
					.withParameters(params)
					.runProgram("IKJEFT01")
				})
		}
	}
}
