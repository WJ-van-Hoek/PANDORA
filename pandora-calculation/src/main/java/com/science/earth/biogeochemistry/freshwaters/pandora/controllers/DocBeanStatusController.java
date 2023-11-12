package com.science.earth.biogeochemistry.freshwaters.pandora.controllers;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.services.DocBeanStatusService;

@ConditionalOnProperty(name = "doc.enabled", havingValue = "true")
@RestController
@RequestMapping("/api")
public class DocBeanStatusController {

    DocBeanStatusService docBeanStatusService;

    public DocBeanStatusController(DocBeanStatusService docBeanStatusService) {
        this.docBeanStatusService = docBeanStatusService;
    }

    @PostMapping("/toggleDoc")
    public Boolean toggleDoc(@RequestParam boolean enable) {
	return docBeanStatusService.toggleBeanStatus(enable);
    }

    @GetMapping("/docStatus")
    public Boolean getDocStatus() {
        return docBeanStatusService.isBeanEnabled();
    }
}
