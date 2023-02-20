package com.example.proiectbackend.kafka;

import com.example.proiectbackend.model.Product;
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
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;



    @EnableKafka
    @Configuration
    public class ProductProducer {
        @Bean
        public ProducerFactory<String, ProductService> producerFactory() {
            return new DefaultKafkaProducerFactory<>(producerConfigurations());
        }

        @Bean
        public Map<String, Object> producerConfigurations() {
            Map<String, Object> configurations = new HashMap<>();
            configurations.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.KAFKA_BROKER);
            configurations.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            configurations.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
            return configurations;
        }

        @Bean
        public KafkaTemplate<String, ProductService> kafkaTemplate() {
            return new KafkaTemplate<>(producerFactory());
        }
//        public void sendMessage(Product product) {
//        kafkaTemplate.send(TOPIC, product);}
    }














//    private static final String TOPIC = "productTopic";
//
//    @Autowired
//    private KafkaTemplate<String, Product> kafkaTemplate;
//
//    public void sendMessage(Product product) {
//        kafkaTemplate.send(TOPIC, product);
//    }
//
//    @Bean
//    public KafkaTemplate<String, Product> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//    @Bean
//    public DefaultKafkaProducerFactory<String, Product> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        configProps.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
//        configProps.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//}

