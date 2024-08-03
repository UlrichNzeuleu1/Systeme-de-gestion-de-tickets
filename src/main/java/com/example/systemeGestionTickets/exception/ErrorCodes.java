package com.example.systemeGestionTickets.exception;

public enum ErrorCodes {

        TICKET_NOT_FOUND(1000),
        TICKET_NOT_VALIDE(1001),

        USER_NOT_FOUND(2000),
        USER_NOT_VALID(2001);

        private int code;
        ErrorCodes(int code){ this.code = code; }

        public int getCode() { return code; }
}
