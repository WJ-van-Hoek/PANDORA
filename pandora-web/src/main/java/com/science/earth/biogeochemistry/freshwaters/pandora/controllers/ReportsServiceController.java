package com.science.earth.biogeochemistry.freshwaters.pandora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportsServiceController {
    @GetMapping("reports-index.html")
    public String reportService() {
      return "/reports/reports-index"; // this returns the template name to be rendered from resources/templates. You don't need to provide the extension.
    }
}
