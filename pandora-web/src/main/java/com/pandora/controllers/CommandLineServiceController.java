package com.pandora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommandLineServiceController {
    /**
     * Handles GET requests for the command line service.
     *
     * @return The path to the Thymeleaf template for the command line service.
     */
    @GetMapping("commandline-index.html")
    public String commandlineService() {
        return "/commandline/commandline-index.html";
    }
}
