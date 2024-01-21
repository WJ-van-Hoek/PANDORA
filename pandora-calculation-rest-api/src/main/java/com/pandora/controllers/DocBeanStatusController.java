package com.pandora.controllers;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pandora.config.species.services.DocBeanStatusService;

/**
 * The {@code DocBeanStatusController} class serves as a Spring MVC controller handling HTTP requests related to the
 * status of the DOC bean. It is annotated with {@link RestController} and is conditionally enabled based on the
 * "doc.enabled" property.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @see DocBeanStatusService
 */
@ConditionalOnProperty(name = "doc.enabled", havingValue = "true")
@RestController
@RequestMapping("/api")
public class DocBeanStatusController {
    /**
     * The {@code docBeanStatusService} attribute in the {@link DocBeanStatusController} class represents the service
     * responsible for managing the status of the DOC bean. It is injected during the instantiation of the controller.
     *
     * @see DocBeanStatusService
     * @see DocBeanStatusController
     */
    private final DocBeanStatusService docBeanStatusService;

    /**
     * Constructs a new {@code DocBeanStatusController} with the specified {@link DocBeanStatusService}.
     *
     * @param docBeanStatusServiceParam The service responsible for managing the DOC bean status.
     * @see DocBeanStatusService
     * @see DocBeanStatusController
     */
    public DocBeanStatusController(final DocBeanStatusService docBeanStatusServiceParam) {
        this.docBeanStatusService = docBeanStatusServiceParam;
    }

    /**
     * Handles the HTTP POST request to toggle the status of the DOC bean. It delegates the task to
     * {@link DocBeanStatusService#toggleBeanStatus(boolean)}.
     *
     * @param enable A boolean value indicating whether to enable or disable the DOC bean.
     * @return {@code true} if the toggle operation is successful, {@code false} otherwise.
     * @see DocBeanStatusService
     * @see DocBeanStatusController
     */
    @PostMapping("/toggleDoc")
    public Boolean toggleDoc(final @RequestParam boolean enable) {
        return docBeanStatusService.toggleBeanStatus(enable);
    }

    /**
     * Handles the HTTP GET request to retrieve the current status of the DOC bean. It delegates the task to
     * {@link DocBeanStatusService#isBeanEnabled()}.
     *
     * @return {@code true} if the DOC bean is enabled, {@code false} otherwise.
     * @see DocBeanStatusService
     * @see DocBeanStatusController
     */
    @GetMapping("/docStatus")
    public Boolean getDocStatus() {
        return docBeanStatusService.isBeanEnabled();
    }
}
