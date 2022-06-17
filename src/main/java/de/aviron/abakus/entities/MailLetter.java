package de.aviron.abakus.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
public class MailLetter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Postfach
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="box_id")
    private MailBox box;

    // Beschreibung/Anzeigename
    private String description;

    // Zustellungs Zeitpunkt
    private LocalDateTime receiveDateTime;

    // Betreff
    private String subject;

    // Inhalt
    private String content;

    // archiviert
    private Boolean isArchived;

    // zerstört
    private Boolean isDestroyed;

    // Unterschriften
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "lettersWithSigning")
    private Collection<Signing> signings = new ArrayList<>();
    
    // Siegel
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "lettersWithUnbrokenSeals")
    private Collection<Seal> unbrokenSeals = new ArrayList<>();

    // gebrochene Siegel
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "lettersWithBrokenSeals")
    private Collection<Seal> brokenSeals = new ArrayList<>();

}
