package com.xaadim.kafkamessaging.configuration;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.xaadim.kafkamessaging.constants.AppConstants;
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

@EnableKafka
@Configuration
public class KafkaConsumerConfig {


   /* @KafkaListener(topics="my_topic", groupId="my_group_id")
    @Bean
    public ConsumerFactory<String, String> consumerFactory( ) {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.HOST);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new org.springframework.kafka.support.serializer.JsonDeserializer<>());
    }


    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListnerFactory(String groupId) {

        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());

        return factory;
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory( ) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
                factory.setConsumerFactory(consumerFactory ());
        return factory;
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> mobileContainerFactory() {
        return kafkaListenerContainerFactory();
    }

    */



   @KafkaListener(topics="my_topic", groupId="my_group_id")
    public void getMessage(String message){

        System.out.println(message);

    }



}
