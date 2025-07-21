package com.example.kafka.service;

import com.example.kafka.pojo.User;
import com.example.kafka.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUsersById(String userId){
        return userRepository.findByUserId(userId);
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }

}
