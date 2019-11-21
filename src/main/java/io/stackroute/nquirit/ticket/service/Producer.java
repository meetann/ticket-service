package io.stackroute.nquirit.ticket.service;

import io.stackroute.nquirit.ticket.model.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "unresolvedticket";

    @Autowired
    private KafkaTemplate<String, Ticket> kafkaTemplate;

    public void sendMessage(Ticket message) {
//        logger.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }
}