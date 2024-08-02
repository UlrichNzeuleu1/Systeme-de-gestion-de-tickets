package com.example.systemeGestionTickets.service.interfaces;

import com.example.systemeGestionTickets.dto.UserDto;
import com.example.systemeGestionTickets.model.User;

import java.util.List;

public interface UserService {

    UserDto create(UserDto dto);

    UserDto findById(Long id);

    List<UserDto> findAll();

    UserDto updateUser(Long id, UserDto updatedUser);

    void delete(Long id);

}
