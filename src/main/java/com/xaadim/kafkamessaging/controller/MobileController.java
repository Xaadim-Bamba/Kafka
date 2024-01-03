package com.xaadim.kafkamessaging.controller;

import com.xaadim.kafkamessaging.configuration.KafkaProducerConfig;
import com.xaadim.kafkamessaging.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path = "/mobile")
public class MobileController {

    /*@Autowired
    private KafkaService kafkaService;
    @PostMapping("/sendMessage")
    public void sendMessage (@RequestParam String key, @RequestParam String senderNumber,
                             @RequestParam String recipientNumber, @RequestParam String bodyMessage){
        kafkaService.sendMessage(key, senderNumber, recipientNumber, bodyMessage);
    }

     */


    private final com.xaadim.kafkamessaging.configuration.KafkaProducerConfig producer;
    public MobileController(KafkaProducerConfig producer) {
        this.producer = producer;
    }

    /*@PostMapping("/publish")
    public void writeMessageToTopic(@RequestParam("message") String message){
        this.producer.writeMessage(message);

    }

     */

   @PostMapping("/sendMessage")
    public void sendMessage (@RequestParam String key, @RequestParam String senderNumber,
                             @RequestParam String recipientNumber, @RequestParam String bodyMessage){
        this.producer.sendMessage(key, senderNumber, recipientNumber, bodyMessage);
    }




}
