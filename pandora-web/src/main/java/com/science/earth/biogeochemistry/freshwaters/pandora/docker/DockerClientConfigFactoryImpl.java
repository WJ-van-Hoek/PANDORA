package com.science.earth.biogeochemistry.freshwaters.pandora.docker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;

@Component
public class DockerClientConfigFactoryImpl implements DockerClientConfigFactory {
    @Value("${docker.host}")
    private String dockerHost;

    @Override
    public DockerClientConfig createDockerClientConfig() {
	return DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerHost(dockerHost).build();
    }
}
