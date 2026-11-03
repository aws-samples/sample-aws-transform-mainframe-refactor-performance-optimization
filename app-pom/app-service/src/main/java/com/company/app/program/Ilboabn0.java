package com.company.app.program;
import com.company.app.SpringBootLauncher;
import com.company.app.ilboabn0.business.context.Ilboabn0Context;
import com.company.app.ilboabn0.service.Ilboabn0Process;
import com.netfective.bluage.gapwalk.rt.call.ExecutionController;
import com.netfective.bluage.gapwalk.rt.context.Context;
import com.netfective.bluage.gapwalk.rt.context.ProgramContextStore;
import com.netfective.bluage.gapwalk.rt.provider.Program;
import com.netfective.bluage.gapwalk.rt.shared.ExecutionContext;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.sql.DataSource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * References the spring application of program ILBOABN0.
 * Provides an access to the contained program for the run unit.
 */
@Component
@Import({
	com.company.app.shared.SharedConfiguration.class,
	com.company.app.ilboabn0.business.context.Ilboabn0Context.class,
	com.company.app.ilboabn0.service.impl.Ilboabn0ProcessImpl.class
})
@Lazy
public class Ilboabn0 implements Program {

	/**
	 * Main program identifier for the contained program.
	 */
	private static final String PROGRAM_IDENTIFIER = "ILBOABN0";

	/**
	 * Unique identifiers for the contained program.
	 */
	private static final Set<String> PROGRAM_IDENTIFIERS = Collections.unmodifiableSet(Stream.of(PROGRAM_IDENTIFIER).collect(Collectors.toSet()));

    @Autowired
	private PlatformTransactionManager transactionManager;
	
    @Autowired
	private Map<String, DataSource> datasources;

    @Autowired
    private BeanFactory beanFactory;
	
    @Autowired
    @Qualifier("com.company.app.ilboabn0.service.Ilboabn0Process")
	private Ilboabn0Process instanceIlboabn0Process;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConfigurableApplicationContext getSpringApplication() {
		return SpringBootLauncher.getCac();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateExecutionContext(ExecutionContext executionContext) {
		executionContext.setDatasources(datasources);
		executionContext.setDatabaseSupport(ExecutionContext.DatabaseSupport.POSTGRE);
		executionContext.setSqlcaVersion(ExecutionContext.SqlcaVersion.getEnum("ansi-comp5"));
		executionContext.setTransactionManager(transactionManager);
		executionContext.setUseSQLDateNewParadigm(true);
		executionContext.setUseSQLTrimStringType(false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<String> getProgramIdentifiers() {
		return PROGRAM_IDENTIFIERS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getProgramMainIdentifier() {
		return PROGRAM_IDENTIFIER;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Context getContext() {
		return ProgramContextStore.getOrCreate(
		getProgramMainIdentifier(),
		com.company.app.ilboabn0.business.context.Ilboabn0Context.class,
		beanFactory);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run(ExecutionController ctrl) {
		instanceIlboabn0Process.mainline((Ilboabn0Context) getContext(), ctrl);
	}

}
