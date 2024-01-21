package com.pandora.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.general.utils.docker.container.Container;
import com.general.utils.docker.services.DockerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@AllArgsConstructor
@Slf4j
public class DockerController {
    /**
     * Service responsible for Docker-related operations.
     */
    private final DockerService dockerService;

    /**
     * Handles POST requests to launch a Docker container.
     *
     * @param requestBody A {@link Map} containing parameters for launching the Docker container. It should include
     * "imageName", "containerName", and "version".
     * @return The launched {@link Container} object.
     */
    @PostMapping("/api/docker/launch")
    public Container launchDockerContainer(final @RequestBody Map<String, String> requestBody) {
        String imageName = requestBody.get("imageName");
        String containerName = requestBody.get("containerName");
        String version = requestBody.get("version");

        return dockerService.launchContainer(imageName, containerName, version);
    }
}
