package com.moment.web.service;

import com.moment.web.AedDTO;
import com.moment.web.config.KafkaProperties;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Slf4j
@Service
public class ProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public String sendMsg(AedDTO aedDTO) {
        CompletableFuture<SendResult<String, Object>> completableFuture = kafkaTemplate.send(KafkaProperties.TOPIC, aedDTO);
        completableFuture.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Send mesage : {}", aedDTO.getId());
            } else {
                log.info("Error Occured");
            }
        });
        return "SUCCESS";
    }
}
