package com.science.earth.biogeochemistry.freshwaters.pandora.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.general.utils.docker.services.AbstractDockerService;

@Service
public class DockerServiceImpl extends AbstractDockerService {

    @Autowired
    public DockerServiceImpl(@Value("${docker.host}") String dockerHost) {
        super(dockerHost);
    }
}
