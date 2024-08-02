package com.example.systemeGestionTickets.controller;

import com.example.systemeGestionTickets.controller.api.TicketApi;
import com.example.systemeGestionTickets.dto.TicketDto;
import com.example.systemeGestionTickets.dto.UserDto;
import com.example.systemeGestionTickets.service.interfaces.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController implements TicketApi {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public List<TicketDto> findAll() {
        return ticketService.findAll();
    }

    @Override
    public TicketDto getTicketById(Long id) {
        return ticketService.findById(id);
    }

    @Override
    public TicketDto createTicket(TicketDto dto) {
        return ticketService.create(dto);
    }

    @Override
    public TicketDto updateTicket(Long id, TicketDto ticketDto) {
        return ticketService.updateTicket(id,ticketDto);
    }

    @Override
    public TicketDto assignTicketToUser(Long id, Long userId) {
        return ticketService.assignTicketToUser(id,userId);
    }

    @Override
    public void delete(Long id) {
        ticketService.delete(id);
    }
}
