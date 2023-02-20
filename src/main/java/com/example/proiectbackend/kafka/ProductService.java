package com.example.proiectbackend.kafka;

import com.example.proiectbackend.model.Product;
import com.example.proiectbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductProducer productProducer;

    public void saveProduct(Product product) {
        // Check if the product already exists in the database
        Optional<Product> existingProduct = productRepository.findById(product.getId());
        if (existingProduct.isPresent()) {
            // Product already exists, update it
            Product updatedProduct = existingProduct.get();
            updatedProduct.setName(product.getName());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setStartDate(product.getStartDate());
            updatedProduct.setEndDate(product.getEndDate());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setCurrentBid(product.getCurrentBid());
            updatedProduct.setUserId(product.getUserId());
            productRepository.save(updatedProduct);
            //productProducer.sendMessage(updatedProduct);
        } else {
            // Product doesn't exist, save it
            productRepository.save(product);
        }

       // productProducer.sendMessage(product);
    }
}

