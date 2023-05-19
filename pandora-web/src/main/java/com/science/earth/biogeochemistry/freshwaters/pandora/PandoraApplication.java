package com.science.earth.biogeochemistry.freshwaters.pandora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
public class PandoraApplication {

    public static void main(String[] args) {
	SpringApplication.run(PandoraApplication.class, args);
    }

}
