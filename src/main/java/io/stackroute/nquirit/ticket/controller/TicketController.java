package io.stackroute.nquirit.ticket.controller;

import io.stackroute.nquirit.ticket.exception.TicketNotFoundException;
import io.stackroute.nquirit.ticket.model.Ticket;
import io.stackroute.nquirit.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class TicketController {

    @Autowired
    TicketService ticketService;

    ResponseEntity responseEntity;

    // Get all tickets
    @GetMapping("/tickets/all")
    public ResponseEntity<?> getAllTickets() throws TicketNotFoundException {
        responseEntity = new ResponseEntity<List<Ticket>>(ticketService.getAllTickets(), HttpStatus.OK);
        return responseEntity;
    }

    // Get all unresolved tickets
    @GetMapping("/tickets/unresolved")
    public ResponseEntity<?> getUnresolvedTickets() throws TicketNotFoundException {
        responseEntity = new ResponseEntity<List<Ticket>>(ticketService.getUnresolved(), HttpStatus.OK);
        return responseEntity;
    }

    // Get all tickets resolved by bot
    @GetMapping("/tickets/byBot")
    public ResponseEntity<?> getResolvedByBot() throws TicketNotFoundException {
        responseEntity = new ResponseEntity<List<Ticket>>(ticketService.getResolvedByBot(), HttpStatus.OK);
        return responseEntity;
    }

    // Get all tickets resolved by CSR
    @GetMapping("/tickets/byCSR")
    public ResponseEntity<?> getResolvedByCSR() throws TicketNotFoundException {
        responseEntity = new ResponseEntity<List<Ticket>>(ticketService.getResolvedByCSR(), HttpStatus.OK);
        return responseEntity;
    }

    // Get tickets yet to be reviewed (by DEV or ADMIN)
    @GetMapping("tickets/review")
    public ResponseEntity<?> getToBeReviewed() throws TicketNotFoundException {
        responseEntity = new ResponseEntity<List<Ticket>>(ticketService.getToBeReviewed(), HttpStatus.OK);
        return responseEntity;
    }

    // Get a ticket by ticketId
    @GetMapping("/tickets/id/{ticketId}")
    public ResponseEntity<?> getTicketById(@PathVariable UUID ticketId) throws TicketNotFoundException {
        responseEntity = new ResponseEntity<Ticket>(ticketService.getTicketById(ticketId), HttpStatus.OK);
        return responseEntity;
    }

    // Add a new ticket
    @PostMapping("/tickets/add")
    public ResponseEntity<?> addTicket(@RequestBody Ticket ticket) {
        ticketService.addTicket(ticket);
        responseEntity = new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
        return responseEntity;
    }

    // Update an existing ticket
    @PutMapping("tickets/update")
    public ResponseEntity<?> updateTicket(@RequestBody Ticket ticket) throws TicketNotFoundException {
        ticketService.updateTicket(ticket);
        responseEntity = new ResponseEntity<Ticket>(ticketService.updateTicket(ticket), HttpStatus.OK);
        return responseEntity;
    }

    // Delete an existing ticket
    @DeleteMapping("/tickets/delete")
    public ResponseEntity<?> delTicket(@RequestBody Ticket ticket) throws TicketNotFoundException {
        responseEntity = new ResponseEntity<Ticket>(ticketService.deleteTicket(ticket), HttpStatus.OK);
        return responseEntity;
    }


}
