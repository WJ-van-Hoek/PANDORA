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
    /**
     * The {@code dicBeanStatusService} attribute in the {@link DicBeanStatusController} class represents the service
     * responsible for managing the status of the DIC bean. It is injected during the instantiation of the controller.
     *
     * @see DicBeanStatusService
     * @see DicBeanStatusController
     */
    private final DicBeanStatusService dicBeanStatusService;

    /**
     * Constructs a new {@code DicBeanStatusController} with the specified {@link DicBeanStatusService}.
     *
     * @param dicBeanStatusServiceParam The service responsible for managing the DIC bean status.
     * @see DicBeanStatusService
     * @see DicBeanStatusController
     */
    public DicBeanStatusController(final DicBeanStatusService dicBeanStatusServiceParam) {
        this.dicBeanStatusService = dicBeanStatusServiceParam;
    }

    /**
     * Handles the HTTP POST request to toggle the status of the DIC bean. It delegates the task to
     * {@link DicBeanStatusService#toggleBeanStatus(boolean)}.
     *
     * @param enable A boolean value indicating whether to enable or disable the DIC bean.
     * @return {@code true} if the toggle operation is successful, {@code false} otherwise.
     * @see DicBeanStatusService
     * @see DicBeanStatusController
     */
    @PostMapping("/toggleDic")
    public Boolean toggleDic(final @RequestParam boolean enable) {
        return dicBeanStatusService.toggleBeanStatus(enable);
    }

    /**
     * Handles the HTTP GET request to retrieve the current status of the DIC bean. It delegates the task to
     * {@link DicBeanStatusService#isBeanEnabled()}.
     *
     * @return {@code true} if the DIC bean is enabled, {@code false} otherwise.
     * @see DicBeanStatusService
     * @see DicBeanStatusController
     */
    @GetMapping("/dicStatus")
    public Boolean getDicStatus() {
        return dicBeanStatusService.isBeanEnabled();
    }
}
