package com.example.systemeGestionTickets.repository;


import com.example.systemeGestionTickets.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
