package com.example.proiectbackend.controller;

import com.example.proiectbackend.exception.UserNotFoundException;
import com.example.proiectbackend.model.User;
import com.example.proiectbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser (@RequestBody User newUser){
        return  userRepository.save(newUser);
    }

  @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
  }

  @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
      .orElseThrow(()->new UserNotFoundException(id));
  }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id"+id+"has been deleted.";
    }
}
