package com.pandora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    /**
     * Handles GET requests for the application's index or home page.
     *
     * @return The name of the Thymeleaf template to be rendered as the index page.
     */
    @GetMapping({ "", "/", "index", "index.html" })
    public String homeService() {
        return "index";
    }
}
