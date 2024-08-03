package com.example.systemeGestionTickets.service.implementations;

import com.example.systemeGestionTickets.dto.TicketDto;
import com.example.systemeGestionTickets.dto.UserDto;
import com.example.systemeGestionTickets.exception.EntityNotFoundException;
import com.example.systemeGestionTickets.exception.ErrorCodes;
import com.example.systemeGestionTickets.exception.InvalidEntityException;
import com.example.systemeGestionTickets.repository.TicketRepository;
import com.example.systemeGestionTickets.repository.UserRepository;
import com.example.systemeGestionTickets.service.interfaces.TicketService;
import com.example.systemeGestionTickets.validateur.TicketValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j              // simplifier l'utilisation des loggers

public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TicketDto create(TicketDto dto) {

        List<String> errors = TicketValidator.validate(dto);

        if (!errors.isEmpty()){
            log.error("Ticket is not valid ", dto);
            throw new InvalidEntityException("Le Ticket n'est pas valide", ErrorCodes.TICKET_NOT_VALIDE,errors);

        }
        return TicketDto.fromEntity(ticketRepository.save(TicketDto.toEntity(dto)));
    }

    @Override
    public TicketDto findById(Long id) {

        if (id == null){
            log.error("Ticket ID is null");
            return  null;
        }
        return ticketRepository.findById(id)
                .map(TicketDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                                "Aucun TICKET avec l'ID = "+id+ "n'a ete trouve dans la BDD",
                                ErrorCodes.TICKET_NOT_FOUND
                        )
                );
    }

    @Override
    public List<TicketDto> findAll() {

        return ticketRepository.findAll().stream()
                .map(TicketDto::fromEntity)                          //Expression lambda
                .collect(Collectors.toList());

    }

    @Override
    public TicketDto updateTicket(Long id, TicketDto updatedTicket) {

        TicketDto ticketDto = TicketDto.fromEntity(findById(id));
        ticketDto.setTitle(updatedTicket.getTitle());
        ticketDto.setDescription(updatedTicket.getDescription());
        ticketDto.setStatus(updatedTicket.getStatus());
        ticketDto.setAssignedUser(updatedTicket.getAssignedUser());
        return ticketRepository.save(ticketDto);
    }

    @Override
    public void delete(Long id) {

        if (id == null){
            log.error("Ticket ID is null");
        }
        ticketRepository.deleteById(id);
    }

    @Override
    public TicketDto assignTicketToUser(Long ticketId, Long userId) {
            TicketDto ticketDto = findById(ticketId);
            UserDto userDto = (UserDto) userRepository.findById(ticketId)
                    .orElseThrow(() -> new EntityNotFoundException("Aucun utilisateur ne correstpond a cette id fournit ",ErrorCodes.USER_NOT_FOUND));
            ticketDto.setAssignedUser(userDto);
            ticketRepository.save(ticketDto);

        return ticketDto;
    }


}
