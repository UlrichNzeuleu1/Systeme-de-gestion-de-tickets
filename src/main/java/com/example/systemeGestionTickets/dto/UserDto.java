package com.example.systemeGestionTickets.dto;

import com.example.systemeGestionTickets.model.Ticket;
import com.example.systemeGestionTickets.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data

public class UserDto extends User{

    private Long id;

    private String username;

    private String email;

    private List<Ticket> AssignedTickets;

    //Ici nous allons faire un mapping du Dto vers l'Entite

    public static UserDto fromEntity(User user){

        if (user == null){
            return null;
        }
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

    //Maintenant faisons un mapping de l'Entite vers le Dto

    public static User toEntity(UserDto userDto){
        if (userDto == null){
            return  null;
        }

        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        return user;
    }
}
