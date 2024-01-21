package com.pandora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParentTemplateController {
    /**
     * Handles GET requests to display the parent template.
     *
     * @param model The Spring MVC model, which can be used to add attributes if needed.
     * @return The name of the Thymeleaf template to be rendered as the parent template.
     */
    @GetMapping("upload-form")
    public String showParentTemplate(final Model model) {
        // Add model attributes if needed
        return "parent-template";
    }
}
