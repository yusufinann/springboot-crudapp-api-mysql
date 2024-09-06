package com.example.Spring_Crud_Api.service;


import com.example.Spring_Crud_Api.dto.UserDTO;
import com.example.Spring_Crud_Api.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsers() ;
    User getUser(Integer id) ;
    void updateUser(Integer id, User user);

    void deleteUser(Integer id);

    void updateName(Integer id, UserDTO userDTO);
}
