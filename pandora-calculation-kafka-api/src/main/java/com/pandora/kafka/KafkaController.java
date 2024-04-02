package com.pandora.kafka;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling HTTP requests related to Kafka messaging.
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    /**
     * The KafkaProducerService responsible for producing messages in the KafkaController.
     */
    private final KafkaProducerService producerService;

    /**
     * Constructs a new KafkaController with the specified KafkaProducerService.
     *
     * @param producerServiceParam The KafkaProducerService responsible for producing messages.
     */
    public KafkaController(final KafkaProducerService producerServiceParam) {
        this.producerService = producerServiceParam;
    }

    /**
     * Handles a POST request to publish a message to a Kafka topic.
     *
     * @param message The message to be sent to the Kafka topic.
     */
    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(final @RequestParam("message") String message) {
        producerService.sendMessage("<your-topic>", message);
    }
}
