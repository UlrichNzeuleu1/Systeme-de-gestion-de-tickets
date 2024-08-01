package com.example.systemeGestionTickets.dto;

import com.example.systemeGestionTickets.model.StatusTicket;
import com.example.systemeGestionTickets.model.Ticket;
import com.example.systemeGestionTickets.model.Utilisateur;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class TicketDto {

    private Long id;

    private String title;

    private String description;

    private Utilisateur utilisateurAssigne;

    private StatusTicket statut;


    //Ici nous allons faire un mapping du Dto vers l'Entite

    public static TicketDto fromEntity (Ticket ticket){

        if (ticket == null) {
            return null;
        }
        return TicketDto.builder()
                .id(ticket.getId())
                .title(ticket.getTitle())
                .description(ticket.getDescription())
                .build();
    }

    //Maintenant faisons un mapping de l'Entite vers le Dto

    public static Ticket toEntity(TicketDto ticketDto){

        if (ticketDto == null){
            return null;
        }

        Ticket ticket = new Ticket();

        ticket.setTitle(ticketDto.getTitle());
        ticket.setDescription(ticketDto.getDescription());
        return ticket;
    }

}
