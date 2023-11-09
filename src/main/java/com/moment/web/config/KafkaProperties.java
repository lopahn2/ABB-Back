package com.moment.web.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("kafka")
@Data
public class KafkaProperties {
    public static final String CONSUMER_GROUP = "aed-consumer-group";
    public static final String TOPIC = "AED";

    @Value("${kafka.bootstrap.servers}")
    private String bootstrapServers;
}
