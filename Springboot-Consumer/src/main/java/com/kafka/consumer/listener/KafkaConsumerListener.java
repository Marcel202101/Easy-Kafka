package com.kafka.consumer.listener;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerListener {

    private Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = {"CreatingNew-Topic"},groupId = "my-group-id")
    public void listener(String message){
        LOGGER.info("Mensaje Recibido: "+ message);
    }
}
