package com.example.systemeGestionTickets.service.implementations;


import com.example.systemeGestionTickets.dto.UserDto;
import com.example.systemeGestionTickets.exception.EntityNotFoundException;
import com.example.systemeGestionTickets.exception.ErrorCodes;
import com.example.systemeGestionTickets.exception.InvalidEntityException;
import com.example.systemeGestionTickets.repository.UserRepository;
import com.example.systemeGestionTickets.service.interfaces.UserService;
import com.example.systemeGestionTickets.validateur.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto create(UserDto dto) {

        List<String> errors = UserValidator.validate(dto);

        if (!errors.isEmpty()){
            log.error("User is not valid ", dto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.USER_NOT_VALID,errors);
        }
        return UserDto.fromEntity(userRepository.save(UserDto.toEntity(dto)));

    }

    @Override
    public UserDto findById(Long id) {

        if (id == null){
            log.error("User ID is null");
            return  null;
        }
        return userRepository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                                "Aucun utilisateur avec l'ID = "+id+ "n'a ete trouve dans la BDD",
                                ErrorCodes.USER_NOT_FOUND
                        )
                );
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto update(UserDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

        if (id == null){
            log.error("User ID is null");
        }
        userRepository.deleteById(id);
    }
}
