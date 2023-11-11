package com.science.earth.biogeochemistry.freshwaters.pandora.config.parameters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:parameters.properties")
public class ParametersConfiguration {
    @Value("${timestep.length}")
    private int timestepLength;

    @Value("${timestep.unit}")
    private String unit;
    
    @Bean
    public Parameters parametersBean() {
        return new Parameters(timestepLength, unit);
    }
}
