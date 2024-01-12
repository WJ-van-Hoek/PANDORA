package com.science.earth.biogeochemistry.freshwaters.pandora.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.general.utils.docker.services.AbstractDockerService;

@Service
public class DockerServiceImpl extends AbstractDockerService {
    /**
     * Constructs a {@code DockerServiceImpl} with the specified Docker host.
     *
     * @param dockerHost The Docker host, injected from the application properties using {@code @Value}.
     */
    @Autowired
    public DockerServiceImpl(final @Value("${docker.host}") String dockerHost) {
        super(dockerHost);
    }
}
