package com.pandora.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Service class for consuming messages from a Kafka topic.
 */
@Service
public class KafkaConsumerService {

    /**
     * Listens for messages on the specified Kafka topic and processes them.
     *
     * @param message The message received from the Kafka topic.
     */
    @KafkaListener(topics = "<your-topic>")
    public void receiveMessage(final String message) {
        // Handle the received message
        System.out.println("Received message: " + message);
    }
}
