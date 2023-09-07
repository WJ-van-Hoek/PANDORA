package com.science.earth.biogeochemistry.freshwaters.pandora.docker;

import com.github.dockerjava.core.DockerClientConfig;

public interface DockerClientConfigFactory {
    DockerClientConfig createDockerClientConfig();
}
