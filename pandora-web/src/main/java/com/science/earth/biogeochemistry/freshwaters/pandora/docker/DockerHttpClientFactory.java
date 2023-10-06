package com.science.earth.biogeochemistry.freshwaters.pandora.docker;

import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.transport.DockerHttpClient;

public interface DockerHttpClientFactory {
    DockerHttpClient createDockerHttpClient(DockerClientConfig config);
}
