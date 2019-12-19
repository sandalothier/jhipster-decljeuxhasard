package com.fisc.decljeuxhasard.web.rest;

import com.fisc.decljeuxhasard.service.DecljeuxhasardKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/decljeuxhasard-kafka")
public class DecljeuxhasardKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DecljeuxhasardKafkaResource.class);

    private DecljeuxhasardKafkaProducer kafkaProducer;

    public DecljeuxhasardKafkaResource(DecljeuxhasardKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
