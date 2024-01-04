package com.xaadim.kafkamessaging.configuration;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.xaadim.kafkamessaging.constants.AppConstants;
import lombok.Getter;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

@EnableKafka
@Configuration
@Getter
public class KafkaConsumerConfig {
    Map<String, String> lastProcessedMessage;

    @KafkaListener(topics="my_topic", groupId="my_group_id")
    public void getMessage(String message){
       System.out.println(message);
       Map<String, String> map = new HashMap<>();
       StringTokenizer tokenizer = new StringTokenizer(message, " ");

       while (tokenizer.hasMoreTokens()) {
           String token = tokenizer.nextToken();
           String[] keyValue = token.split("=");
           map.put(keyValue[0], keyValue[1]);
       }
       lastProcessedMessage = map;
   }


}
