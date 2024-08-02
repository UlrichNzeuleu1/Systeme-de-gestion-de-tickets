package com.example.systemeGestionTickets.service.implementations;

import com.example.systemeGestionTickets.dto.TicketDto;
import com.example.systemeGestionTickets.dto.UserDto;
import com.example.systemeGestionTickets.exception.ErrorCodes;
import com.example.systemeGestionTickets.exception.InvalidEntityException;
import com.example.systemeGestionTickets.model.TicketStatus;
import com.example.systemeGestionTickets.service.interfaces.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)                  //executer les test unitaires
@SpringBootTest                               //preparer le contex pour le test, apres injection du composant (bean necessaire)

public class TicketServiceImplTest {

    @Autowired
    private TicketService ticketService;

    @Test
    public  void shouldCreateTicketWithSuccess(){
        TicketDto expectedTicket = TicketDto.builder()
                .title("titre test")
                .description("description test")
                .status(TicketStatus.EN_COURS)
                .build();
        TicketDto createdTicket = ticketService.create(expectedTicket);

        assertNotNull(createdTicket);
        assertNotNull(createdTicket.getId());
        assertEquals(expectedTicket.getTitle(), createdTicket.getTitle());
        assertEquals(expectedTicket.getDescription(), createdTicket.getDescription());
        assertEquals(expectedTicket.getStatus(), createdTicket.getStatus());
    }

    @Test
    public  void shouldUpdateTicketWithSuccess(){
        TicketDto expectedTicket = TicketDto.builder()
                .title("titre test")
                .description("description test")
                .status(TicketStatus.EN_COURS)
                .build();
        TicketDto createdTicket = ticketService.create(expectedTicket);

        TicketDto ticketToUpdate =  createdTicket;
        ticketToUpdate.setTitle("titre mise a jour");

        createdTicket = ticketService.create(ticketToUpdate);

        assertNotNull(ticketToUpdate);
        assertNotNull(ticketToUpdate.getId());
        assertEquals(ticketToUpdate.getTitle(), createdTicket.getTitle());
        assertEquals(ticketToUpdate.getDescription(), createdTicket.getDescription());
        assertEquals(ticketToUpdate.getStatus(), createdTicket.getStatus());
    }

    @Test
    public  void shouldThrowInvalidEntityException(){
        TicketDto expectedTicket = TicketDto.builder().build();

        InvalidEntityException  expectedException = assertThrows(InvalidEntityException.class, () -> ticketService.create(expectedTicket) );

        TicketDto createdTicket = ticketService.create(expectedTicket);

        assertEquals(ErrorCodes.TICKET_NOT_VALIDE,expectedException.getErrorCode());
        assertEquals(1,expectedException.getErrors().size());
        assertEquals("Veuillez renseigner le titre du ticket", expectedException.getErrors().get(0));

    }
}

