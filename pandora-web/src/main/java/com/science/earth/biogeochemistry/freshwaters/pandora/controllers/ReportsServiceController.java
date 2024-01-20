package com.pandora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportsServiceController {
    /**
     * Handles GET requests to display the reports index page.
     *
     * @return The name of the Thymeleaf template to be rendered as the reports index page.
     */
    @GetMapping("reports-index.html")
    public String reportService() {
        return "/reports/reports-index";
    }
}
