package com.example.systemeGestionTickets.service.interfaces;

import com.example.systemeGestionTickets.dto.TicketDto;

import java.util.List;

public interface TicketService {

        TicketDto create(TicketDto dto);

        TicketDto findById(Long id);

        List<TicketDto> findAll();

        TicketDto updateTicket(Long id, TicketDto updatedTicket);

        void delete(Long id);

        TicketDto assignTicketToUser(Long ticketId, Long userId);
}
