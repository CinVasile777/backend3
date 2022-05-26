package com.example.myapplication.service;

import com.example.myapplication.model.Product;
import com.example.myapplication.model.User;
import com.example.myapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public void addUser(User user){
        Optional<User> userOptional = userRepository.findById(user.getId());
        if (userOptional.isPresent()){
            throw new IllegalArgumentException("user already exist");
        }

        userRepository.save(user);
    }

    public List<User> findByEmailAndPassword(String email, String password){
        return userRepository.findByEmailAndPassword(email,password);
    }
}
