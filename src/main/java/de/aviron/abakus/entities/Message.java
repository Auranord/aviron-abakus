package de.aviron.abakus.entities;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    // Absender
    @ManyToOne
    @JoinColumn(name="sender_id")
    User sender;

    // Empfänger
    @ManyToOne
    @JoinColumn(name="receiver_id")
    User receiver;

    // Betreff
    String subject;

    // Inhalt
    String content;

    // Sende Datum/Zeit
    LocalDateTime date;

    // gelesen
    Boolean isRead;

    // archiviert
    Boolean isArchived;

    
    // ################## Relations ##################

    @ManyToOne
    @JoinColumn(name="reference_id")
    Message reference;

    @OneToMany(mappedBy="reference")
    Collection<Message> answers;

}
