package com.xaadim.kafkamessaging.configuration;

import com.xaadim.kafkamessaging.constants.AppConstants;
import com.xaadim.kafkamessaging.model.Message;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaProducerConfig {

   /* public NewTopic createTopic(){
        return new NewTopic("my_topic", 3, (short) 1);
    }


    @Bean
    public ProducerFactory<String, Message> producerFactory() {
        Map<String , Object> configProps= new HashMap<>();
        configProps. put (ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.HOST) ;
        configProps. put (ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps. put (ProducerConfig. VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps) ;
    }

    @Bean
    public KafkaTemplate<String, Message> kafkaTemplate() { return new KafkaTemplate<>(producerFactory()); }


    /*

    */
    private static final String TOPIC= "my_topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void writeMessage(String msg){
        this.kafkaTemplate.send(TOPIC, msg);
    }

    public void sendMessage(String key, String senderNumber, String recipientNumber, String bodyMessage) {

        String msg = key + " " + senderNumber + " " + recipientNumber + " " + bodyMessage;

            this.kafkaTemplate.send(TOPIC, msg);

    }

}
