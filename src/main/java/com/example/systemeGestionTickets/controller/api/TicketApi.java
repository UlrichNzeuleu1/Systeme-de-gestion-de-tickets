package com.example.systemeGestionTickets.controller.api;

import com.example.systemeGestionTickets.dto.TicketDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api("/tickets")
public interface TicketApi {

        @GetMapping(value = "/tickets",produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Recuperer tous les tickets", notes = "Cette methode permet de chercher et renvoyer la liste des tickets qui existent dans la BDD", responseContainer = "List<TicketDto>")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "La liste des tickets / Une liste vide "),
        })
        List<TicketDto> findAll();


        @GetMapping(value = "/tickets/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Recuperer un ticket par son ID", notes = "Cette methode permet de chercher un ticket par son ID", response = TicketDto.class)
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Le ticket a ete trouve dans la BDD"),
                @ApiResponse(code = 404, message = "Aucun ticket n'a ete trouve avec l'ID fourni")

        })
        TicketDto getTicketById(@PathVariable Long id);



        @PostMapping(value = "/tickets",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Creer un nouveau ticket", notes = "Cette methode permet de creer ou modifier un ticket", response = TicketDto.class)
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "L'objet ticket cree / modifie"),
                @ApiResponse(code = 400, message = "L'objet ticket n'est pas valide")
        })
        TicketDto createTicket(@RequestBody TicketDto dto);               //@RequestBody: c'est pour la deserialisation c-a-d la transformation d'un text du format json vers cette objet de type TicketDto



        @PutMapping(value = "/tickets/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Mettre a jour un ticket", notes = "Cette methode permet de mettre a jour un ticket existant en BDD", response = TicketDto.class)
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "L'objet ticket cree / modifie"),
                @ApiResponse(code = 400, message = "L'objet ticket n'est pas valide")
        })
        public TicketDto updateTicket(@PathVariable Long id, @RequestBody TicketDto ticketDto);


        @PutMapping(value = "/tickets/{id}/assign/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
        @ApiOperation(value = "Assigner un ticket a un utilisateur", notes = "Cette methode permet d'asssigner un ticket a un utilisateur", response = TicketDto.class)
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "L'objet ticket a ete assigne avec succes"),
                @ApiResponse(code = 400, message = "L'objet ticket n'est pas valide")
        })
        public TicketDto assignTicketToUser(@PathVariable Long ticketId, @PathVariable Long userId );


        @DeleteMapping(value = "/tickets/{id}")
        @ApiOperation(value = "Suppprimer un ticket par son ID", notes = "Cette methode permet de supprimer un ticket par son ID", response = TicketDto.class)
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Le ticket a ete supprime "),
        })
        void delete(@PathVariable("id") Long id);
}
