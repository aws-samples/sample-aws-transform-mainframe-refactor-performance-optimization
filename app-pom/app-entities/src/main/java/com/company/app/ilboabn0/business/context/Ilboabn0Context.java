package com.company.app.ilboabn0.business.context;
import com.company.app.ilboabn0.business.model.LkAbendCode;
import com.company.app.ilboabn0.business.model.WsDisplayCode;
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
 * Data simplifier context Ilboabn0Context.
 * 
 * <p>About 'onCode' field, <br>
 * </p>
 * 
 * <p>About 'onChar' field, <br>
 * </p>
 * 
 * <p>About 'wsDisplayCode' field, <br>uml entity: com.company.app.ilboabn0.business.model.WsDisplayCode
 * <br></p>
 * 
 * <p>About 'lkAbendCode' field, <br>uml entity: com.company.app.ilboabn0.business.model.LkAbendCode
 * <br></p>
 * 
 */
@Component("com.company.app.ilboabn0.business.context.Ilboabn0Context")
@Lazy
@Scope("prototype")
public class Ilboabn0Context extends RuntimeContext {
	
	
	private WsDisplayCode wsDisplayCode;
	private LkAbendCode lkAbendCode;

	private List<RecordEntity> recordEntities;

   /**
	 * Public constructor with injected fields.
	 * @param configuration the datasimplifier configuration to use.
	 */	   
   	
   	public Ilboabn0Context (@Qualifier("sharedConfiguration") Configuration configuration){		
	    super(configuration);
		initWorking(configuration);
		initLinkage(configuration);
		initRecordEntities();
	}
 	
	

	/**
	 * Getter for wsDisplayCode.
	 * @return the wsDisplayCode
	 */
	public WsDisplayCode getWsDisplayCode() {
		return this.wsDisplayCode;
	}

	/**
	 * Setter for wsDisplayCode.
	 * @param reference the new value for wsDisplayCode
	 */
	public void setWsDisplayCode(RangeReference reference) {
		this.wsDisplayCode.setBytes(reference.getBytes());
	}

	/**
	 * Getter for lkAbendCode.
	 * @return the lkAbendCode
	 */
	public LkAbendCode getLkAbendCode() {
		return this.lkAbendCode;
	}

	/**
	 * Setter for lkAbendCode.
	 * @param reference the new value for lkAbendCode
	 */
	public void setLkAbendCode(RangeReference reference) {
		this.lkAbendCode.setBytes(reference.getBytes());
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
		wsDisplayCode = new WsDisplayCode(configuration);
	}
	
	private void initLinkage(Configuration configuration) {
		lkAbendCode = new LkAbendCode(configuration, EntityUtils.getUnlinkedRecord());
	
	}

	private void initRecordEntities() {
		recordEntities = Arrays.asList(wsDisplayCode);
	}

	@Override
	public String toString(){
		StringBuilder toSB = new StringBuilder("\nIlboabn0Context:\n");
		if(!this.recordEntities.isEmpty()){
			this.recordEntities.forEach(e -> toSB.append(e.getClass().getSimpleName()).append(" : [").append(e.toString()).append("]\n"));
		}
		toSB.append("LkAbendCode : [").append(lkAbendCode.toString()).append("]\n");
		return toSB.toString();
	}
}
