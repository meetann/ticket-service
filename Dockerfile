FROM maven:3.6.2-jdk-11

WORKDIR /ticketservice

COPY ./target/ticket-0.0.1-SNAPSHOT.jar ticket-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "ticket-0.0.1-SNAPSHOT.jar"]