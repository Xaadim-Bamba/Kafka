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
    private static final String TOPIC= "my_topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void writeMessage(String msg){
        this.kafkaTemplate.send(TOPIC, msg);
    }

    public void sendMessage(String source, String dest, String textMessage) {
        this.kafkaTemplate.send(TOPIC, "source="+source+" dest="+dest+" textMessage="+textMessage);
    }
}
