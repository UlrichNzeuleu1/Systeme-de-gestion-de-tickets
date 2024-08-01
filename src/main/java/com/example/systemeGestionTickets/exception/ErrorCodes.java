package com.example.systemeGestionTickets.exception;

import java.util.Enumeration;

public enum ErrorCodes {

        TICKET_NOT_FOUND(1000),
        TICKET_NOT_VALIDE(1001),

        UTILISATEUR_NOT_FOUND(2000),
        UTILISATEUR_NOT_VALID(2001);

        private int code;
        ErrorCodes(int code){ this.code = code; }

        public int getCode() { return code; }
}
