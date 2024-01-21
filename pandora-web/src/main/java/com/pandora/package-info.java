/**
 * This package contains the configuration classes for the Pandora Web application. The {@link AppConfig} class provides
 * configurations for message localization using {@code MessageSource} and enables Cross-Origin Resource Sharing (CORS)
 * support with {@code WebMvcConfigurer}.
 *
 * The main entry point for the Pandora Web application is the {@link PandoraWeb} class, which is annotated with
 * {@code @SpringBootApplication} and imports the configuration from {@link AppConfig}. The {@code main} method in
 * {@link PandoraWeb} starts the Spring Boot application.
 */
package com.pandora;
