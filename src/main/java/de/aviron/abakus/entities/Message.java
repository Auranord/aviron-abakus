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
    private Integer id;

    // Absender
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="sender_id")
    private User sender;

    // Empfänger
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
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

    
    // Answers

    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="answering_id")
    private Message answering;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="answering") @JsonIgnore
    private Collection<Message> answers;

}
