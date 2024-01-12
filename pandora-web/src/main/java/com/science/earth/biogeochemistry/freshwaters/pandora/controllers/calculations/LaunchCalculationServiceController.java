package com.science.earth.biogeochemistry.freshwaters.pandora.controllers.calculations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LaunchCalculationServiceController {
    /**
     * Handles GET requests for launching the calculation service.
     *
     * @return The path to the Thymeleaf template for launching the calculation service.
     */
    @GetMapping("launch-calculation-service.html")
    public String launchCalculationService() {
        return "/calculations/launch-calculation-service.html";
    }
}
