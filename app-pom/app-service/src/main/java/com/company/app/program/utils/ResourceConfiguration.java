package com.company.app.program.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Configuration file that fetches the configuration.* Yml properties into a Map.
 */
@Component
@EnableConfigurationProperties
@ConfigurationProperties
public class ResourceConfiguration {

	private Map<String, String> configuration = new HashMap<>();

	/**
	 * Returns the configuration.
	 * @return the configuration.
	 */
    public Map<String, String> getConfiguration() {
        return configuration;
    }
    
    /**
	 * Sets the configuration.
	 * @param configuration the configuration to use.
	 */
    public void setConfiguration(Map<String, String> configuration) {
		this.configuration = configuration;
	}
}
