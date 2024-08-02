package com.example.systemeGestionTickets.controller.api;

import com.example.systemeGestionTickets.dto.TicketDto;
import com.example.systemeGestionTickets.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/users")
public interface UserApi {

    @GetMapping(value = "/users",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recuperer tous les utilisateurs", notes = "Cette methode permet de chercher et renvoyer la liste des utilisateurs qui existent dans la BDD", responseContainer = "List<UserDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des utilisateurs / Une liste vide "),
    })
    List<UserDto> findAll();


    @GetMapping(value = "/users/{id}/ticket",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recuperer tous les tickets assignes a l'utilisateur", notes = "Cette methode permet de chercher et recuperer tous les tickets assignes a un utilisateur qui existe dans la BDD", responseContainer = "List<TicketDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des utilisateurs / Une liste vide "),
    })
    public List<TicketDto> getTicketsByUser(@PathVariable Long id);


    @PostMapping(value = "/users",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Creer un utilisateur", notes = "Cette methode permet de creer ou modifier un utilisateur", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet utilisateur cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet utilisateur n'est pas valide")
    })
    UserDto createUser(@RequestBody UserDto dto);               //@RequestBody: c'est pour la deserialisation c-a-d la transformation d'un text du format json vers cette objet de type UserDto


    @PutMapping(value = "/users/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Mettre a jour un utilisateur", notes = "Cette methode permet de mettre a jour un utilisateur existant en BDD", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet utilisateur cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet utilisateur n'est pas valide")
    })
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto );


    @DeleteMapping(value = "/users/delete/{id}")
    @ApiOperation(value = "Suppprimer un utilisateur par son ID", notes = "Cette methode permet de supprimer un utilisateur par son ID", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'utilisateur a ete supprime "),
    })
    void delete(@PathVariable("id") Long id);

}
