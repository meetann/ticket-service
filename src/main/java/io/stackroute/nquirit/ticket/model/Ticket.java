package io.stackroute.nquirit.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

//    {
//        id: { type: UUID, unique: true, index: true },
//        query: { type: String, Index: true }
//        intent: { type: Array } // Collection of intents
//        raisedBy: { type: String, index: true }
//        createdOn: { type: Date, index: true }
//        updatedBy: { type: String }
//        resolvedBy: { type: String }
//        updatedOn: { type: Date }
//        type: { type: ENUM, index: true }
//        status: { type: ENUM, index: true }
    // ---- new
//          reviewedBy :{ type: ENUM, index: true }
//    }

    @Id
    private UUID ticketId;


    private String query;

    private String[] intent;


    private String raisedBy;


    private LocalDateTime createdOn;


    private String updatedBy;

    private String resolvedBy;

    private String updatedOn;

    private type type;
    public enum type{
        QUERY,
        CONTACT,
        SUGGESTION
    }

    private status status;
    public enum status{
        RESOLVED,
        UNRESOLVED
    }

    private reviewedBy reviewedBy;
    public enum reviewedBy{
        NONE,
        DEV,
        ADMIN
    }

}
