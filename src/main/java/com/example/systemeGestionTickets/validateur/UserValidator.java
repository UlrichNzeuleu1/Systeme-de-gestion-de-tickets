package com.example.systemeGestionTickets.validateur;

import com.example.systemeGestionTickets.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate (UserDto userDto){

        List<String> errors = new ArrayList<>();

        if (userDto == null){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
            errors.add("veuillez renseigner l'email de l'utilisateur");
            return errors;
        }

        if (!StringUtils.hasLength(userDto.getUsername())){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
        }

        if (!StringUtils.hasLength(userDto.getEmail())){
            errors.add("Veuillez renseigner l'email de l'utilisateur");
        }

        return errors;
    }
}
