package com.example.systemeGestionTickets.service.implementations;

import com.example.systemeGestionTickets.dto.UserDto;
import com.example.systemeGestionTickets.exception.EntityNotFoundException;
import com.example.systemeGestionTickets.exception.ErrorCodes;
import com.example.systemeGestionTickets.exception.InvalidEntityException;
import com.example.systemeGestionTickets.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

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
        userToUpdate.setEmail("email mise a jour");

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

    @Test
    public  void shouldThrowEntityNotFoundException1(){

        EntityNotFoundException expectedException =  assertThrows(EntityNotFoundException.class, () -> userService.findById(0L) );

        assertEquals(ErrorCodes.USER_NOT_FOUND,expectedException.getErrorCode());
        assertEquals("Aucun utilisateur avec l'ID 0 n'a ete trouve dans la BDD", expectedException.getMessage());
    }

    @Test(expected = EntityNotFoundException.class)
    public  void shouldThrowEntityNotFoundException2(){
        userService.findById(0L);
    }

    @Test
    public void shouldDeleteUserWithSuccess(){

            // Arrange
            Long userId = 1L;
            UserDto userDto = UserDto.builder()
                    .id(1L)
                    .build();

            // Act
            when(userRepository.findById(userId)).thenReturn(java.util.Optional.of(userDto));
            doNothing().when(userRepository).deleteById(userId);
            userService.delete(userId);

            // Assert
            verify(userRepository, times(1)).findById(userId);
            verify(userRepository, times(1)).deleteById(userId);
            assertNull(userDto.getId());

    }

    @Test(expected = EntityNotFoundException.class)
    public  void shouldFindAllWithSuccess(){
        userService.findAll();
    }

}