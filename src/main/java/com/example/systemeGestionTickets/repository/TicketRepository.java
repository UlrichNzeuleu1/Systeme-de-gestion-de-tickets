package com.example.systemeGestionTickets.repository;

import com.example.systemeGestionTickets.model.Ticket;
import com.example.systemeGestionTickets.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> utilisateurAssigne(Utilisateur utilisateur);
}
