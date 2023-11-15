package com.moment.web.domain.kafka_service;

import com.moment.web.domain.Aed;
import com.moment.web.domain.dto.AedMsgDTO;
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

    public String sendMsg(Aed aed) {
        CompletableFuture<SendResult<String, Object>> completableFuture = kafkaTemplate.send(KafkaProperties.TOPIC,
                aed);
        completableFuture.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Send mesage : {}", aed);
                log.info("aed isWorked: {}, isExist:{}", aed.isWorked(), aed.isExist());
            } else {
                log.info("Error Occured");
            }
        });
        return "SUCCESS";
    }
}
