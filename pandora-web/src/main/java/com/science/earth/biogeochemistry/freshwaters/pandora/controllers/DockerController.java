package com.science.earth.biogeochemistry.freshwaters.pandora.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.transport.DockerHttpClient;
import com.science.earth.biogeochemistry.freshwaters.pandora.docker.DockerClientConfigFactory;
import com.science.earth.biogeochemistry.freshwaters.pandora.docker.DockerHttpClientFactory;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DockerController {
    private final DockerClient dockerClient;

    public DockerController(DockerClientConfigFactory dockerClientConfigFactory,
	DockerHttpClientFactory dockerHttpClientFactory) {
	DockerClientConfig config = dockerClientConfigFactory.createDockerClientConfig();
	DockerHttpClient client = dockerHttpClientFactory.createDockerHttpClient(config);
	dockerClient = DockerClientBuilder.getInstance(config).withDockerHttpClient(client).build();
    }

    @PostMapping("/api/docker/launch")
    public ResponseEntity<Boolean> launchDockerContainer(@RequestBody Map<String, String> requestBody) {
	String imageName = requestBody.get("imageName");
	String containerName = requestBody.get("containerName"); 
	try {
	    CreateContainerResponse container = dockerClient.createContainerCmd(imageName.concat(":ALPHA_0.1"))
		    .withName(containerName).exec();

	    dockerClient.startContainerCmd(container.getId()).exec();

	    log.info("Docker container started successfully");
	    return ResponseEntity.ok(true);
	} catch (Exception e) {
	    log.error("Error starting Docker container: ", e);
	    return ResponseEntity.ok(false);
	}
    }
}
