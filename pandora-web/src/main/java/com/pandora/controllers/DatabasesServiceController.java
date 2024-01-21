package com.pandora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DatabasesServiceController {
    /**
     * Handles GET requests for the databases index page.
     *
     * @return The view name for the databases index page ("/databases/databases-index").
     */
    @GetMapping("databases-index.html")
    public String databaseService() {
        return "/databases/databases-index";
    }
}
