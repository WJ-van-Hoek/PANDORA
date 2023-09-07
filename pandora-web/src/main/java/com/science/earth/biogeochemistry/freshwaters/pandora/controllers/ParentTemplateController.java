package com.science.earth.biogeochemistry.freshwaters.pandora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParentTemplateController {

    @GetMapping("upload-form")
    public String showParentTemplate(Model model) {
        // Add model attributes if needed
        
        return "parent-template"; // Render the parent-template.html
    }
}
