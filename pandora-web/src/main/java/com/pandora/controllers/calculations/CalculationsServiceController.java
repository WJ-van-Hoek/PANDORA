package com.pandora.controllers.calculations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculationsServiceController {
    /**
     * Handles GET requests for the calculations service index page.
     *
     * @return The path to the Thymeleaf template for the calculations service index page.
     */
    @GetMapping("calculations-index.html")
    public String calculationService() {
        return "/calculations/calculations-index.html";
    }
}
