package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.UserRepository;
import com.example.demo.models.UserModel;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public ArrayList<UserModel>  getUsersWithPriority(Integer priority) {
        return userRepository.findByPriority(priority);
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getUser(Long id){
        return userRepository.findById(id);
    }

    public boolean removeUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch(Exception err) {
            return false;
        }
    }
}
