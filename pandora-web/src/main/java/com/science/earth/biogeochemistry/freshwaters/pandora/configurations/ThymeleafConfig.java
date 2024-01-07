package com.science.earth.biogeochemistry.freshwaters.pandora.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Configuration
public final class ThymeleafConfig {
    /**
     * Configures the Thymeleaf layout dialect as a Spring bean.
     *
     * @return The {@link LayoutDialect} bean.
     */
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
