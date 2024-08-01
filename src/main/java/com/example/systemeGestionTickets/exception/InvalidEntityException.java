package com.example.systemeGestionTickets.exception;

import lombok.Getter;
import java.util.List;


// cette classe nous permettra de lever l'exception lorqu'on essaira d'enregistrer
// une entite qui n'est pas valide dans la BDD'

public class InvalidEntityException extends  RuntimeException{


    @Getter
    private  ErrorCodes errorCode;
    @Getter
    private List<String> errors;

    public  InvalidEntityException(String message){
        super(message);
    }
    public  InvalidEntityException(String message, Throwable cause){
        super(message, cause);
    }

    public  InvalidEntityException(String message, Throwable cause, ErrorCodes errorCode){
        super(message, cause);
        this.errorCode = errorCode;
    }
    public  InvalidEntityException(String message, ErrorCodes errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidEntityException(String message, ErrorCodes errorCode,List<String> errors){
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }
}
