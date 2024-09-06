package com.example.Spring_Crud_Api.service.impl;

import com.example.Spring_Crud_Api.dto.UserDTO;
import com.example.Spring_Crud_Api.entity.User;
import com.example.Spring_Crud_Api.repository.UserRepository;
import com.example.Spring_Crud_Api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        User user=userRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid User id "+id));
        return user;
    }

    @Override
    public void updateUser(Integer id, User user) {
        // Check if the user exists, throw an exception if not found
        userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User id " + id));

        // Update the user's details
        user.setId(id); // Assuming 'name' is a field in User entity

        // Save the updated user
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        // Check if the user exists, throw an exception if not found
        User user=userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User id " + id));
        userRepository.delete(user);
    }

    @Override
    public void updateName(Integer id, UserDTO userDTO) {
        // Check if the user exists, throw an exception if not found
        User user=userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User id " + id));

        user.setName(userDTO.getName());
        userRepository.save(user);

    }

}
