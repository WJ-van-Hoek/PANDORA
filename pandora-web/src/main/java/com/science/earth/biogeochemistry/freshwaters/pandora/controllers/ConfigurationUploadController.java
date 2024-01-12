package com.science.earth.biogeochemistry.freshwaters.pandora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.science.earth.biogeochemistry.freshwaters.pandora.objects.FileUploadForm;

import jakarta.validation.Valid;

@Controller
public class ConfigurationUploadController {

    /**
     * Handles GET requests to display the configuration file upload form.
     *
     * @param model The model to be populated with attributes for the view.
     * @return The Thymeleaf template for the upload form.
     */
    @GetMapping("/upload")
    public String uploadForm(final Model model) {
        model.addAttribute("fileUploadForm", new FileUploadForm());
        return "upload-form";
    }

    /**
     * Handles POST requests to process uploaded configuration files.
     *
     * @param fileUploadForm The form containing the uploaded file.
     * @param result The result of the validation.
     * @return A redirect to the home page after processing the file.
     * @throws Exception
     */
    @PostMapping("/upload")
    public String uploadFile(final @Valid FileUploadForm fileUploadForm, final BindingResult result) throws Exception {
        return "redirect:/";
    }
}
