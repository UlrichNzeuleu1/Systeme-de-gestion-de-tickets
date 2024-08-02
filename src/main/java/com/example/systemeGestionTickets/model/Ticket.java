package com.example.systemeGestionTickets.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Ticket")

public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    private User AssignedUser;

    private  TicketStatus statut;
}
