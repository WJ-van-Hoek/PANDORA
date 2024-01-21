package com.pandora;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {

    /**
     * Configures a {@code MessageSource} bean for message localization.
     *
     * @return The configured {@code MessageSource} bean.
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    /**
     * Configures a {@code WebMvcConfigurer} bean for CORS (Cross-Origin Resource Sharing) support.
     *
     * @return The configured {@code WebMvcConfigurer} bean.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(final CorsRegistry registry) {
                // Allow requests from the frontend server (e.g., localhost:8080)
                registry.addMapping("**").allowedOrigins("http://localhost:8080")
                        .allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*");
            }
        };
    }
}
