package io.stackroute.nquirit.ticket.exception;

public class TicketNotFoundException extends Exception{
    private String message;

    public TicketNotFoundException() {}

    public TicketNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
