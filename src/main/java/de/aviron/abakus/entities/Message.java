package de.aviron.abakus.entities;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    // Absender
     @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="sender_id")
    User sender;

    // Empfänger
     @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
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

    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="reference_id")
    Message reference;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="reference") @JsonIgnore
    Collection<Message> answers;

}
