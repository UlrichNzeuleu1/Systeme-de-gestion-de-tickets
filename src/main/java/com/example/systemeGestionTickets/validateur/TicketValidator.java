package com.example.systemeGestionTickets.validateur;

import com.example.systemeGestionTickets.dto.TicketDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TicketValidator {

    public static List<String> validate (TicketDto ticketDto) {

        List<String> errors = new ArrayList<>();

        if (ticketDto == null) {
            errors.add("Veuillez renseigner le titre du ticket");
            errors.add("Veuillez renseigner la description du ticket");
            return errors;
        }

        if (!StringUtils.hasLength(ticketDto.getTitle())) {
            errors.add("Veuillez renseigner le titre du ticket");
        }
        if (!StringUtils.hasLength(ticketDto.getDescription())) {
            errors.add("Veuillez renseigner la description du ticket");
        }
        return errors;
    }
}
