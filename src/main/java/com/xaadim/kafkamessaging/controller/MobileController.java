package com.xaadim.kafkamessaging.controller;

import com.xaadim.kafkamessaging.configuration.KafkaConsumerConfig;
import com.xaadim.kafkamessaging.configuration.KafkaProducerConfig;
import com.xaadim.kafkamessaging.model.Message;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/mobile")
public class MobileController {
    private final KafkaProducerConfig producer;
    private final KafkaConsumerConfig consumer;
    public MobileController(KafkaProducerConfig producer, KafkaConsumerConfig consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

   @PostMapping("/sendMessage")
    public void sendMessage (@RequestBody Message message){
        this.producer.sendMessage(message.getSource(), message.getDest(), message.getTextMessage());
    }

    @GetMapping("/getMessage")
    public Map getMessage (){
        return this.consumer.getLastProcessedMessage();
    }




}
