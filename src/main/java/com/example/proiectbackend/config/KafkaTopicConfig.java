package com.example.proiectbackend.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
   // @Value("${kafka.topic.product_current_bid_updated}")
  //  private String productCurrentBidUpdatedTopic;

    @Bean
    public NewTopic productCurrentBidUpdated() {
       // return new NewTopic(productCurrentBidUpdatedTopic, 1, (short) 1);
    return TopicBuilder.name("productTopic")
            .build();

    }
}
