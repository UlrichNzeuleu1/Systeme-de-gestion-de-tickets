package com.example.systemeGestionTickets.validateur;

import com.example.systemeGestionTickets.dto.UtilisateurDto;
import com.example.systemeGestionTickets.model.Utilisateur;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidateur {

    public static List<String> validate (UtilisateurDto utilisateurDto){

        List<String> errors = new ArrayList<>();

        if (utilisateurDto == null){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
            errors.add("veuillez renseigner l'email de l'utilisateur");
            return errors;
        }

        if (!StringUtils.hasLength(utilisateurDto.getNomUtilisateur())){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
        }

        if (!StringUtils.hasLength(utilisateurDto.getEmail())){
            errors.add("Veuillez renseigner l'email de l'utilisateur");
        }

        return errors;
    }
}
