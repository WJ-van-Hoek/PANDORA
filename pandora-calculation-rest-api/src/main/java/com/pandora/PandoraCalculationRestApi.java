package com.pandora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for starting the PANDORA Calculation Rest API application. This class contains the main method to
 * launch the Spring Boot application.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@SpringBootApplication
public class PandoraCalculationRestApi {

    /**
     * The main method to start the Pandora Calculation Rest API application.
     *
     * @param args Command line arguments passed to the application.
     */
    public static void main(final String[] args) {
        SpringApplication.run(PandoraCalculationRestApi.class, args);
    }
}
