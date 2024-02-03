package com.pandora.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Service class for producing messages to a Kafka topic.
 */
@Service
public class KafkaProducerService {
    /**
     * The KafkaTemplate used by the KafkaProducerService for producing messages.
     */
    private final KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Constructs a new KafkaProducerService with the specified KafkaTemplate.
     *
     * @param kafkaTemplateParam The KafkaTemplate used for producing messages.
     */
    public KafkaProducerService(final KafkaTemplate<String, String> kafkaTemplateParam) {
        this.kafkaTemplate = kafkaTemplateParam;
    }

    /**
     * Sends a message to the specified Kafka topic.
     *
     * @param topic   The name of the Kafka topic to which the message will be sent.
     * @param message The message to be sent to the Kafka topic.
     */
    public void sendMessage(final String topic, final String message) {
        kafkaTemplate.send(topic, message);
    }
}
