package com.example.Spring_Crud_Api.repository;

import com.example.Spring_Crud_Api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
