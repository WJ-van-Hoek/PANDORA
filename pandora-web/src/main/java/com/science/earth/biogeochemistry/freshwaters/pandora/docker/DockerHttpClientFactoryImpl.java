package com.science.earth.biogeochemistry.freshwaters.pandora.docker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;

@Component
public class DockerHttpClientFactoryImpl implements DockerHttpClientFactory {
    @Value("${docker.http.client.connections.max}")
    private int maxConnections;


    @Override
    public DockerHttpClient createDockerHttpClient(DockerClientConfig config) {
	return new ApacheDockerHttpClient.Builder().dockerHost(config.getDockerHost()).sslConfig(config.getSSLConfig())
		.maxConnections(maxConnections).build();
    }
}
