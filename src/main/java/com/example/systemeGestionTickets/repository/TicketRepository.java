package com.example.systemeGestionTickets.repository;

import com.example.systemeGestionTickets.model.Ticket;
import com.example.systemeGestionTickets.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByAssignedUser(User user);
}
