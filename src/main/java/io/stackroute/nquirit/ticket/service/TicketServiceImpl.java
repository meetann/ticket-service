package io.stackroute.nquirit.ticket.service;

import io.stackroute.nquirit.ticket.exception.TicketNotFoundException;
import io.stackroute.nquirit.ticket.model.Ticket;
import io.stackroute.nquirit.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import  com.fasterxml.uuid.Generators;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    TicketRepository ticketRepository;

    // Get all tickets
    @Override
    public List<Ticket> getAllTickets() throws TicketNotFoundException {
        List<Ticket> allTickets = ticketRepository.findAll();
        if(allTickets.size() == 0){
            throw new TicketNotFoundException("No tickets available!");
        }
        return allTickets;
    }

    // Get all unresolved tickets
    @Override
    public List<Ticket> getUnresolved() throws TicketNotFoundException {
        List<Ticket> unresolvedTickets = ticketRepository.findByStatus(Ticket.status.UNRESOLVED);
        if(unresolvedTickets.size() == 0){
            throw new TicketNotFoundException("No unresolved tickets available!");
        }
        return unresolvedTickets;
    }

    // Get all tickets resolved by bot
    @Override
    public List<Ticket> getResolvedByBot() throws TicketNotFoundException {
        List<Ticket> resolvedByBot = ticketRepository.getResolvedByBot();
        if(resolvedByBot.size() == 0){
            throw new TicketNotFoundException("No tickets available!");
        }
        return resolvedByBot;
    }

    // Get all tickets resolved by CSR
    @Override
    public List<Ticket> getResolvedByCSR() throws TicketNotFoundException {
        List<Ticket> resolvedByCSR = ticketRepository.getResolvedByCSR();
        if(resolvedByCSR.size() == 0){
            throw new TicketNotFoundException("No tickets available!");
        }
        return resolvedByCSR;
    }

    // Get tickets yet to be reviewed (by DEV or ADMIN)
    @Override
    public List<Ticket> getToBeReviewed() throws TicketNotFoundException{
        List<Ticket> toBeReviewed = ticketRepository.findByReviewedBy(Ticket.reviewedBy.NONE);
        if(toBeReviewed.size() == 0){
            throw new TicketNotFoundException("No tickets available!");
        }
        return toBeReviewed;
    }

    // Get a ticket by ticketId
    @Override
    public Ticket getTicketById(UUID ticketId) throws TicketNotFoundException{
        Ticket ticket = ticketRepository.findByTicketId(ticketId);
        if(ticket == null){
            throw new TicketNotFoundException("Ticket not found!");
        }
        return ticket;
    }

    // Add a new ticket
    @Override
    public Ticket addTicket(Ticket ticket) {
//        Ticket will be generated by BotService
//        Populating for testing purpose
        ticket.setTicketId(Generators.timeBasedGenerator().generate());
        ticket.setCreatedOn(LocalDateTime.now() );
//        ticket.setCreatedOn(DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm:ss").format(LocalDateTime.now() ) );
        ticket.setStatus(Ticket.status.UNRESOLVED);
        return ticketRepository.save(ticket);
    }

    // Update an existing ticket
    @Override
    public Ticket updateTicket(Ticket ticket) throws TicketNotFoundException {
        if(ticketRepository.findByTicketId(ticket.getTicketId()) == null){
            throw new TicketNotFoundException("Ticket not found!");
        }
        ticketRepository.save(ticket);
        return ticket;
    }

    // Delete an existing ticket
    @Override
    public Ticket deleteTicket(Ticket ticket) throws TicketNotFoundException {
        Ticket ticket1 = ticketRepository.findByTicketId(ticket.getTicketId());
        if(ticket1 == null){
            throw new TicketNotFoundException("Ticket not found!");
        }
        ticketRepository.deleteById(ticket1.getTicketId());
        return ticket;
    }

}
