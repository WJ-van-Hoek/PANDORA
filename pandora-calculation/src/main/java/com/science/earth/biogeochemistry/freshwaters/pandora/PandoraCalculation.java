package com.science.earth.biogeochemistry.freshwaters.pandora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PandoraCalculation {
    /**
     * The main method to launch the Pandora Calculation Spring Boot application. It uses {@code SpringApplication.run}
     * to start the application, initializing the necessary components and triggering the Spring Boot lifecycle.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(final String[] args) {
        SpringApplication.run(PandoraCalculation.class, args);
    }
}
