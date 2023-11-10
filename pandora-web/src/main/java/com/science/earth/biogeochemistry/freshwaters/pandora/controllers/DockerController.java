package com.science.earth.biogeochemistry.freshwaters.pandora.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.general.utils.docker.container.ContainerResponse;
import com.general.utils.docker.services.DockerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@AllArgsConstructor
@Slf4j
public class DockerController {
    
    DockerService dockerService;

    @PostMapping("/api/docker/launch")
    public ContainerResponse launchDockerContainer(@RequestBody Map<String, String> requestBody) {
	String imageName = requestBody.get("imageName");
	String containerName = requestBody.get("containerName"); 
	String version = requestBody.get("version");
	
	return dockerService.launchContainer(imageName, containerName, version);
    }


}
