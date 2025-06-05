package com.jpmc.midascore;
import org.springframework.kafka.annotation.KafkaListener;

import com.jpmc.midascore.foundation.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MidasCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MidasCoreApplication.class, args);
    }
    @KafkaListener(
            topics = "${general.kafka-topic}",
            groupId = "midas-core",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(Transaction transaction) {
        System.out.println("Received Transaction: " + transaction);
    }
}

