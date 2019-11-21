package io.stackroute.nquirit.ticket.controller;

import io.stackroute.nquirit.ticket.model.Ticket;

import io.stackroute.nquirit.ticket.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody Ticket message) {
        System.out.println(message);
        this.producer.sendMessage(message);
    }
}

