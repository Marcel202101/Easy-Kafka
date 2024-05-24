package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generatetopic(){

        Map<String,String> configuration = new HashMap<>();

        configuration.put(TopicConfig.CLEANUP_POLICY_CONFIG,TopicConfig.CLEANUP_POLICY_DELETE); //delete borra msj // compact mantiene el mas actual
        configuration.put(TopicConfig.RETENTION_MS_CONFIG,"84000000");//tiempo de retencion de msj (-1 no borra)-> por defecto
        configuration.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");//Tamano max de segmento defecto 1gb
        configuration.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG,"1000012"); // Tamano max de msj defecto 1mb

        return TopicBuilder.name("CreatingNew-Topic")
                .partitions(2)
                .replicas(2)
                .configs(configuration)
                .build();
    }
}
