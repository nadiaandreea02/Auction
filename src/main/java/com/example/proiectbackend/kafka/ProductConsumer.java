package com.example.proiectbackend.kafka;

import com.example.proiectbackend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ProductConsumer {

    @Payload(required = false)
    @KafkaListener(topics = KafkaConstants.KAFKA_TOPIC, groupId = KafkaConstants.GROUP_ID)
    public void listenToTopic(ProductService productService) {
        System.out.println("Message received is " + productService.toString());
    }




//    private final ProductService productService;
//
//    @Autowired
//    public ProductConsumer(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @KafkaListener(topics = "productTopic", groupId = "group-id")
//    public void consume(Product product) {
//        productService.saveProduct(product);
//    }
}

