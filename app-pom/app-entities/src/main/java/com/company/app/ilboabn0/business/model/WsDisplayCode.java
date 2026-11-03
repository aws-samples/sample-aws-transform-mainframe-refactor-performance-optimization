package com.company.app.ilboabn0.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.ZonedType;
/**
 * Data simplifier entity WsDisplayCode.
<pre>
 * 
 * Legacy Documentation:<br>
 *  ****************************************************************<br>
 *                                                                 *<br>
 *   ILBOABN0 : Abend routine                                      *<br>
 *                                                                 *<br>
 *    - cobol/TRDPBEXC ends its 9999-ABEND-DUMP paragraph with     *<br>
 *      CALL 'ILBOABN0' USING WS-ABEND-CODE, which on z/OS invoked *<br>
 *      the IBM Language Environment assembler module of that      *<br>
 *      name to force a user abend (U0255).                        *<br>
 *                                                                 *<br>
 *    - No COBOL source for that module exists or ever did, so the *<br>
 *      static CALL cannot be resolved by a refactor.  This stub   *<br>
 *      stands in for it and preserves the behaviour the batch     *<br>
 *      job stream actually depends on:                            *<br>
 *                                                                 *<br>
 *        a) it does NOT return to the caller, so TRDPBEXC cannot  *<br>
 *           fall through to 9999-EXIT and carry on after a fatal  *<br>
 *           error, and                                            *<br>
 *        b) it terminates with the abend code as the return code, *<br>
 *           which is what COND=(8,LT) on the ACCP* and SETL* jobs *<br>
 *           tests in order to stop the downstream steps.          *<br>
 *                                                                 *<br>
 *    - Difference from the original: z/OS produced a U0255 abend  *<br>
 *      with a SYSUDUMP and let DB2 back out the in-flight unit of *<br>
 *      work.  Here the step ends with return code 255 and no      *<br>
 *      dump.  If the target runtime offers a native abend         *<br>
 *      primitive, call that instead.                              *<br>
 *                                                                 *<br>
 *    - Added during AWS Transform remediation; not a mainframe    *<br>
 *      export.  See docs/AWS_TRANSFORM_REMEDIATION.md.            *<br>
 *                                                                 *<br>
 *  ****************************************************************<br>
</pre>
 * 
 * <p>About 'wsDisplayCode' field, <br>
 *  ****************************************************************<br>
 *                                                                 *<br>
 *   ILBOABN0 : Abend routine                                      *<br>
 *                                                                 *<br>
 *    - cobol/TRDPBEXC ends its 9999-ABEND-DUMP paragraph with     *<br>
 *      CALL 'ILBOABN0' USING WS-ABEND-CODE, which on z/OS invoked *<br>
 *      the IBM Language Environment assembler module of that      *<br>
 *      name to force a user abend (U0255).                        *<br>
 *                                                                 *<br>
 *    - No COBOL source for that module exists or ever did, so the *<br>
 *      static CALL cannot be resolved by a refactor.  This stub   *<br>
 *      stands in for it and preserves the behaviour the batch     *<br>
 *      job stream actually depends on:                            *<br>
 *                                                                 *<br>
 *        a) it does NOT return to the caller, so TRDPBEXC cannot  *<br>
 *           fall through to 9999-EXIT and carry on after a fatal  *<br>
 *           error, and                                            *<br>
 *        b) it terminates with the abend code as the return code, *<br>
 *           which is what COND=(8,LT) on the ACCP* and SETL* jobs *<br>
 *           tests in order to stop the downstream steps.          *<br>
 *                                                                 *<br>
 *    - Difference from the original: z/OS produced a U0255 abend  *<br>
 *      with a SYSUDUMP and let DB2 back out the in-flight unit of *<br>
 *      work.  Here the step ends with return code 255 and no      *<br>
 *      dump.  If the target runtime offers a native abend         *<br>
 *      primitive, call that instead.                              *<br>
 *                                                                 *<br>
 *    - Added during AWS Transform remediation; not a mainframe    *<br>
 *      export.  See docs/AWS_TRANSFORM_REMEDIATION.md.            *<br>
 *                                                                 *<br>
 *  ****************************************************************<br></p>
 * 
 * @see RecordEntity
 */
public class WsDisplayCode extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * ****************************************************************
	 * *
	 * ILBOABN0 : Abend routine                                      *
	 * *
	 * - cobol/TRDPBEXC ends its 9999-ABEND-DUMP paragraph with     *
	 * CALL 'ILBOABN0' USING WS-ABEND-CODE, which on z/OS invoked *
	 * the IBM Language Environment assembler module of that      *
	 * name to force a user abend (U0255).                        *
	 * *
	 * - No COBOL source for that module exists or ever did, so the *
	 * static CALL cannot be resolved by a refactor.  This stub   *
	 * stands in for it and preserves the behaviour the batch     *
	 * job stream actually depends on:                            *
	 * *
	 * a) it does NOT return to the caller, so TRDPBEXC cannot  *
	 * fall through to 9999-EXIT and carry on after a fatal  *
	 * error, and                                            *
	 * b) it terminates with the abend code as the return code, *
	 * which is what COND=(8,LT) on the ACCP* and SETL* jobs *
	 * tests in order to stop the downstream steps.          *
	 * *
	 * - Difference from the original: z/OS produced a U0255 abend  *
	 * with a SYSUDUMP and let DB2 back out the in-flight unit of *
	 * work.  Here the step ends with return code 255 and no      *
	 * dump.  If the target runtime offers a native abend         *
	 * primitive, call that instead.                              *
	 * *
	 * - Added during AWS Transform remediation; not a mainframe    *
	 * export.  See docs/AWS_TRANSFORM_REMEDIATION.md.            *
	 * *
	 * ****************************************************************
	 */
	private final Elementary wsDisplayCode = new Elementary(root,new ZonedType(4, 0, false));
	
	/**
	 * Instantiate a new WsDisplayCode with a default record.
	 * @param configuration the configuration
	 */
	public WsDisplayCode(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsDisplayCode bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsDisplayCode(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsDisplayCode.
	 * @return the wsDisplayCode attribute reference
	 */
	public ElementaryRangeReference getWsDisplayCodeReference() {
		return wsDisplayCode.getReference();
	}

	/**
	 * Getter for wsDisplayCode attribute.
	 * @return wsDisplayCode attribute
	 */
	public int getWsDisplayCode() {
		return wsDisplayCode.getValue();
	}

	/**
	 * Setter for wsDisplayCode attribute.
	 * @param wsDisplayCode the new value of wsDisplayCode
	 */
	public void setWsDisplayCode(int wsDisplayCode) {
		this.wsDisplayCode.setValue(wsDisplayCode);
	}
}
