package com.example.systemeGestionTickets.service.implementations;

import com.example.systemeGestionTickets.dto.TicketDto;
import com.example.systemeGestionTickets.dto.UserDto;
import com.example.systemeGestionTickets.exception.ErrorCodes;
import com.example.systemeGestionTickets.exception.InvalidEntityException;
import com.example.systemeGestionTickets.model.TicketStatus;
import com.example.systemeGestionTickets.model.User;
import com.example.systemeGestionTickets.service.interfaces.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public  void shouldCreateUserWithSuccess(){
        UserDto expectedUser = UserDto.builder()
                .email("email test")
                .username("username test")
                .build();
        UserDto createdUser = userService.create(expectedUser);

        assertNotNull(createdUser);
        assertNotNull(createdUser.getId());
        assertEquals(expectedUser.getEmail(), createdUser.getEmail());
        assertEquals(expectedUser.getUsername(), createdUser.getUsername());
    }

    @Test
    public  void shouldUpdateUserWithSuccess(){
        UserDto expectedUser = UserDto.builder()
                .email("email test")
                .username("username test")
                .build();
        UserDto createdUser = userService.create(expectedUser);
        UserDto userToUpdate = createdUser;
        userToUpdate.setUsername("username mise a jour");

        createdUser = userService.create(userToUpdate);


        assertNotNull(userToUpdate);
        assertNotNull(userToUpdate.getId());
        assertEquals(userToUpdate.getUsername(), createdUser.getUsername());
        assertEquals(userToUpdate.getEmail(), createdUser.getEmail());
    }

    @Test
    public  void shouldThrowInvalidEntityException(){
        UserDto expectedUser = UserDto.builder().build();

        InvalidEntityException  expectedException =  assertThrows(InvalidEntityException.class, () -> userService.create(expectedUser) );

        assertEquals(ErrorCodes.USER_NOT_VALID,expectedException.getErrorCode());
        assertEquals(1,expectedException.getErrors().size());
        assertEquals("Veuillez renseigner l'email de l'utilisateur", expectedException.getErrors().get(0));
    }
}