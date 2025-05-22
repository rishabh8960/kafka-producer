package com.example.kafka.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String message, String id) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
        record.headers().add("id", id.getBytes());
        kafkaTemplate.send(record);
    }
}