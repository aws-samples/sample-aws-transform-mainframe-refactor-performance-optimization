package com.company.app.trdpbexc.business.model;

import com.netfective.bluage.gapwalk.datasimplifier.configuration.Configuration;
import com.netfective.bluage.gapwalk.datasimplifier.data.RecordAdaptable;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Elementary;
import com.netfective.bluage.gapwalk.datasimplifier.data.structure.Group;
import com.netfective.bluage.gapwalk.datasimplifier.entity.ElementaryRangeReference;
import com.netfective.bluage.gapwalk.datasimplifier.entity.RecordEntity;
import com.netfective.bluage.gapwalk.datasimplifier.metadata.type.AlphanumericType;
/**
 * Data simplifier entity WsExceptionHandler.
<pre>
 * 
 * Legacy Documentation:<br>
 *  ****************************************************************<br>
 *   THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 3       *<br>
 *  <br>
</pre>
 * 
 * <p>About 'wsExceptionHandler' field, <br>
 *  ****************************************************************<br>
 *   THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 3       *<br>
 *  <br></p>
 * 
 * @see RecordEntity
 */
public class WsExceptionHandler extends RecordEntity {

	private final Group root = new Group(getData()); 
	
	/**
	 * ****************************************************************
	 * THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 3       *
	 * 
	 */
	private final Elementary wsExceptionHandler = new Elementary(root,new AlphanumericType(16),"TRDPBEXC");
	
	/**
	 * Instantiate a new WsExceptionHandler with a default record.
	 * @param configuration the configuration
	 */
	public WsExceptionHandler(Configuration configuration) {
		super(configuration);
		setupRoot(root);
	}

	/**
	 * Instantiate a new WsExceptionHandler bound to the provided record.
	 * @param configuration the configuration
	 * @param existingRecord the existing record to bind
	 */
	public WsExceptionHandler(Configuration configuration, RecordAdaptable existingRecord) {
		super(configuration);
		setupRoot(root, existingRecord);
	}

	/**
	 * Gets the reference for attribute wsExceptionHandler.
	 * @return the wsExceptionHandler attribute reference
	 */
	public ElementaryRangeReference getWsExceptionHandlerReference() {
		return wsExceptionHandler.getReference();
	}

	/**
	 * Getter for wsExceptionHandler attribute.
	 * @return wsExceptionHandler attribute
	 */
	public String getWsExceptionHandler() {
		return wsExceptionHandler.getValue();
	}

	/**
	 * Setter for wsExceptionHandler attribute.
	 * @param wsExceptionHandler the new value of wsExceptionHandler
	 */
	public void setWsExceptionHandler(String wsExceptionHandler) {
		this.wsExceptionHandler.setValue(wsExceptionHandler);
	}
}
