package de.aviron.abakus.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class MailLetter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    // Postfach
    @ManyToOne
    @JoinColumn(name="box_id")
    private MailBox box;

    // Beschreibung/Anzeigename
    private String description;

    // Versende Zeitpunkt
    private LocalDateTime received;

    // Inhalt
    private String content;

    // zerstört
    private Boolean destroyed;


    // ################## Relations ##################

    // Unterschriften
    @ManyToMany(mappedBy = "signingLetters")
    private Collection<Signing> signings = new ArrayList<>();
    
    // Siegel
    @ManyToMany(mappedBy = "unbrokenSealLetters")
    private Collection<Seal> unbrokenSeals = new ArrayList<>();

    // gebrochene Siegel
    @ManyToMany(mappedBy = "brokenSealLetters")
    private Collection<Seal> brokenSeals = new ArrayList<>();

}

