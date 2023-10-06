package com.science.earth.biogeochemistry.freshwaters.pandora.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.science.earth.biogeochemistry.freshwaters.pandora.objects.FileUploadForm;

import jakarta.validation.Valid;

@Controller
public class ConfigurationUploadController {
    
    @GetMapping("/upload")
    public String uploadForm(Model model) {
        model.addAttribute("fileUploadForm", new FileUploadForm());
        return "upload-form";
    }

    @PostMapping("/upload")
    public String uploadFile(@Valid FileUploadForm fileUploadForm, BindingResult result){
	if (result.hasErrors()) {
	    // errors processing
	}
        MultipartFile file = fileUploadForm.getFileToUpload();
        if (!file.isEmpty()) {
            // Process the uploaded file
            // ...
        } else {
            // Handle the case when no file is uploaded.
        }
        return "redirect:/";
    }
}
