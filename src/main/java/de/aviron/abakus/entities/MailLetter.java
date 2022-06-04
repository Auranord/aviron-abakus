package de.aviron.abakus.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MailLetter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Postfach
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="box_id")
    private MailBox box;

    // Beschreibung/Anzeigename
    private String description;

    // Versende Zeitpunkt
    private LocalDateTime receiveDateTime;

    // Inhalt
    private String content;

    // zerstört
    private Boolean destroyed;

    // Unterschriften
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "lettersWithSigning") @JsonIgnore
    private Collection<Signing> signings = new ArrayList<>();
    
    // Siegel
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "lettersWithUnbrokenSeals") @JsonIgnore
    private Collection<Seal> unbrokenSeals = new ArrayList<>();

    // gebrochene Siegel
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "lettersWithBrokenSeals") @JsonIgnore
    private Collection<Seal> brokenSeals = new ArrayList<>();

}

