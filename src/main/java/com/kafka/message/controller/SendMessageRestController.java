package com.kafka.message.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/producer")
public class SendMessageRestController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage() {
        log.info("Sending message to kafka topic...");
        for (int i = 0; i < 1000; i++) {
            kafkaTemplate.send("logs", "message log " + i);
        }
        return ResponseEntity.ok("Messages sent successfully");
    }
}
