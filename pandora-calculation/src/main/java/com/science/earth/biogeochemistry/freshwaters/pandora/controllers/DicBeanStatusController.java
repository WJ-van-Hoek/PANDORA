package com.science.earth.biogeochemistry.freshwaters.pandora.controllers;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.services.DicBeanStatusService;

@ConditionalOnProperty(name = "dic.enabled", havingValue = "true")
@RestController
@RequestMapping("/api")
public class DicBeanStatusController {

    DicBeanStatusService dicBeanStatusService;

    public DicBeanStatusController(DicBeanStatusService dicBeanStatusService) {
        this.dicBeanStatusService = dicBeanStatusService;
    }

    @PostMapping("/toggleDic")
    public Boolean toggleDic(@RequestParam boolean enable) {
	return dicBeanStatusService.toggleBeanStatus(enable);
    }

    @GetMapping("/dicStatus")
    public Boolean getDicStatus() {
        return dicBeanStatusService.isBeanEnabled();
    }
}
