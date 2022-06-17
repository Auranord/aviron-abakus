package de.aviron.abakus.entities;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Absender
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sender_id")
    private User sender;

    // Empfänger
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="receiver_id")
    private User receiver;

    // Betreff
    private String subject;

    // Inhalt
    private String content;

    // Sende Datum/Zeit
    private LocalDateTime sendDateTime;

    // gelesen
    private Boolean isRead;

    // archiviert
    private Boolean isArchived;

    // löschen
    private Boolean isDeleted;
    
    // Answers

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="answering_id")
    private Message answering;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="answering")
    private Collection<Message> answers;

}
