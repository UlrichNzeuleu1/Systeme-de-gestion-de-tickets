package com.example.systemeGestionTickets.exception;



// cette classe va nous permettre de lever une  exception lorsque l'on effectue
// par exemple une recherche sans trouver dans la base de donnees

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException{

    @Getter
    private ErrorCodes errorCode;

    public  EntityNotFoundException(String message){
        super(message);
    }
    public  EntityNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public  EntityNotFoundException(String message, Throwable cause, ErrorCodes errorCode){
        super(message, cause);
        this.errorCode = errorCode;
    }
    public  EntityNotFoundException(String message, ErrorCodes errorCode){
        super(message);
        this.errorCode = errorCode;
    }

}
