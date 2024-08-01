package com.example.systemeGestionTickets.dto;

import com.example.systemeGestionTickets.model.Ticket;
import com.example.systemeGestionTickets.model.Utilisateur;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data

public class UtilisateurDto {

    private Long id;

    private String nomUtilisateur;

    private String email;

    private List<Ticket> ticketsAssignes;

    //Ici nous allons faire un mapping du Dto vers l'Entite

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){

        if (utilisateur == null){
            return null;
        }
        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nomUtilisateur(utilisateur.getNomUtilisateur())
                .email(utilisateur.getEmail())
                .build();
    }

    //Maintenant faisons un mapping de l'Entite vers le Dto

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if (utilisateurDto == null){
            return  null;
        }

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setNomUtilisateur(utilisateurDto.getNomUtilisateur());
        utilisateur.setEmail(utilisateurDto.getEmail());
        return utilisateur;
    }
}
