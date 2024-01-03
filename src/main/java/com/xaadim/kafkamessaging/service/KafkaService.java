package com.xaadim.kafkamessaging.service;

import com.xaadim.kafkamessaging.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;
    private final String topicName = "my_topic";
    public void sendMessage(String key, String senderNumber, String recipientNumber, String bodyMessage) {
        kafkaTemplate.send(topicName, key, Message.builder()
                .source(senderNumber)
                .dest(recipientNumber)
                .textMessage(bodyMessage)
                .build()
        );
    }

   /*@KafkaListener(topics = "my_topic", containerFactory = "kafkaListenerContainerFactory")
    public void listenerMobile(Message message) {
        System.out.println (message.getSenderNumber () + " : " + message.getBody());
    }

    */


}

