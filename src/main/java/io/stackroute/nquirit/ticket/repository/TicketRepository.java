package io.stackroute.nquirit.ticket.repository;

import io.stackroute.nquirit.ticket.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, UUID> {

    public Ticket findByTicketId(UUID ticketId);

    public List<Ticket> findByStatus(Ticket.status status);

    // resolvedBy == "BOT"
    @Query(" { resolvedBy: BOT } ")
    public List<Ticket> getResolvedByBot();

    // resolvedBy != "BOT"
    @Query(" { resolvedBy: { $ne: BOT } } ")
    public List<Ticket> getResolvedByCSR();

    public List<Ticket> findByReviewedBy(Ticket.reviewedBy reviewedBy);
}
