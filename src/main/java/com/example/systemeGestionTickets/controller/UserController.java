package com.example.systemeGestionTickets.controller;


import com.example.systemeGestionTickets.controller.api.UserApi;
import com.example.systemeGestionTickets.dto.TicketDto;
import com.example.systemeGestionTickets.dto.UserDto;
import com.example.systemeGestionTickets.model.Ticket;
import com.example.systemeGestionTickets.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController implements UserApi {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Override
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @Override
    public List<TicketDto> getTicketsByUser(Long id) {
        return (List<TicketDto>) userService.findById(id);
    }

    @Override
    public UserDto createUser(UserDto dto) {
        return userService.create(dto);
    }

    public UserDto updateUser(Long id, UserDto updatedUser) {
        return userService.updateUser(id,updatedUser);
    }

    @Override
    public void delete(Long id) {
        userService.delete(id);
    }
}
