package com.example.systemeGestionTickets.service.interfaces;

import com.example.systemeGestionTickets.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto create(UserDto dto);
    UserDto findById(Long id);
    List<UserDto> findAll();
    UserDto update(UserDto dto);
    void delete(Long id);

}
