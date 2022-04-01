package com.kafka.message.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogListener {

    @KafkaListener(topics = "logs", groupId = "log-group")
    public void listenMessage(String message) {
        log.info("Thread: {}", Thread.currentThread().getId());
        log.info("Received message: {}", message);
    }
}
