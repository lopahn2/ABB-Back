package com.moment.web.service;

import com.moment.web.AedDTO;
import com.moment.web.config.KafkaProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ConsumerService {
    private final SimpMessagingTemplate simpMessagingTemplate;

    @KafkaListener(topics = KafkaProperties.TOPIC, groupId = KafkaProperties.CONSUMER_GROUP)
    public void listen(ConsumerRecord<String, AedDTO> record) {
        log.info("Received message : {}", record.value());
        simpMessagingTemplate.convertAndSend("/topic/aed", record.value());
    }

}
