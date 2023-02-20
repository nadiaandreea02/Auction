package com.example.proiectbackend.controller;


import com.example.proiectbackend.exception.ProductNotFoundException;
import com.example.proiectbackend.exception.UserNotFoundException;
import com.example.proiectbackend.model.Product;
import com.example.proiectbackend.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins="http://localhost:3000")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/product")
    Product newProduct(@RequestBody Product newProduct){
        return productRepository.save(newProduct);
    }

    @GetMapping("/products")

        List<Product> getAllProducts(){
            return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    Product getUserById(@PathVariable Long id){
        return productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException(id));
    }
    @DeleteMapping("/product/{id}")
    String deleteUser(@PathVariable Long id){
        if(!productRepository.existsById(id)){
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
        return "Product with id"+id+"has been deleted.";
    }

    @PutMapping("/product/{id}")
    Product updateProduct(@RequestBody Product newProduct, @PathVariable Long id){
        return productRepository.findById(id)
                .map(product -> {
                    product.setCurrentBid(newProduct.getCurrentBid());
                    return productRepository.save(product);
                }).orElseThrow(()->new ProductNotFoundException(id));
    }


}
