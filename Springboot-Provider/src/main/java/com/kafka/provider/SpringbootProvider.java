package com.kafka.provider;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringbootProvider {

    public static void main(String[] args) { SpringApplication.run(SpringbootProvider.class, args);}

    @Bean
    CommandLineRunner init(KafkaTemplate<String,String> kafkaTemplate){
        return args ->{
                kafkaTemplate.send("CreatingNew-Topic", "Final Test Springboot with Kafka");
            };
    }
}