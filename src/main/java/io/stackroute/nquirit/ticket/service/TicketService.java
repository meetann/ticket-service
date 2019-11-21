package io.stackroute.nquirit.ticket.service;

import io.stackroute.nquirit.ticket.exception.TicketNotFoundException;
import io.stackroute.nquirit.ticket.model.Ticket;

import java.util.List;
import java.util.UUID;

public interface TicketService {

    public List<Ticket> getAllTickets() throws TicketNotFoundException;

    public Ticket getTicketById(UUID ticketId) throws TicketNotFoundException;

    public Ticket addTicket(Ticket ticket);

    public Ticket updateTicket(Ticket ticket) throws TicketNotFoundException;

    public List<Ticket> getUnresolved() throws TicketNotFoundException;

    public List<Ticket> getResolvedByBot() throws TicketNotFoundException;

    public List<Ticket> getResolvedByCSR() throws TicketNotFoundException;

    public Ticket deleteTicket(Ticket ticket) throws TicketNotFoundException;

    public List<Ticket> getToBeReviewed() throws TicketNotFoundException;
}
