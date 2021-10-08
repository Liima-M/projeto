package com.example.curso.repositories;

import com.example.curso.entite.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}