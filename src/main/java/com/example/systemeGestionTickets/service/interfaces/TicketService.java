package com.example.systemeGestionTickets.service.interfaces;

import com.example.systemeGestionTickets.dto.TicketDto;

import java.util.List;

public interface TicketService {

        TicketDto create(TicketDto dto);
        TicketDto findById(Long id);
        List<TicketDto> findAll();
        TicketDto update(TicketDto dto);
        void delete(Long id);


}
