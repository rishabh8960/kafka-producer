package com.example.kafka.controller;

import com.example.kafka.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class PostMsgsOnKafka {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/send")
    public String sendMessageToKafka(
            @RequestParam int start,
            @RequestParam int end,
            @RequestHeader("id") String id) {
        for (int i = start; i <= end; i++) {
            String message =  String.valueOf(i);
            kafkaProducer.sendMessage("Uniper_Topic", message, id);
        }
        return "Messages sent to Kafka for range: " + start + " to " + end;
    }
}