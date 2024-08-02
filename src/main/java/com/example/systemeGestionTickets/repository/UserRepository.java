package com.example.systemeGestionTickets.repository;


import com.example.systemeGestionTickets.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
