package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import de.aviron.abakus.enums.JournalCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class JournalArticle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    // Ausgabe
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="issue_id")
    private JournalIssue issue;

    // Titel
    private String title;

    // Untertitel
    private String subtitle;

    // Verfasser
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="author_id")
    private Figure author;

    // Unterschriften
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="signing_id")
    private Signing signing;
    
    // Siegel
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="seal_id")
    private Seal seal;

    // gebrochene Siegel
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "lettersWithBrokenSeals")
    private Collection<Seal> brokenSeals = new ArrayList<>();

    // Bild
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="illustration_id")
    private Image illustration;

    // Sparte
    @Enumerated
    private JournalCategory category;

    // Antwort
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="answer_id")
    private JournalArticle answer;

    // Reihe
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="collection_id")
    private JournalCollection collection;

    // Event
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="event_id")
    private JournalEvent event;

    // TODO: Enum for formating

    // Eingereicht
    private Boolean isReady;

    // Artikel Wert
    private Integer value;

    // Sichtbar
    private Boolean isVisible;

    // Zensurgrund
    private String reason;


    // ################## Relations ##################

    @OneToMany(cascade = CascadeType.ALL, mappedBy="answer")
    private Collection<JournalArticle> articleAnswers = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="article")
    private Collection<JournalLetter> articleLetters = new ArrayList<>();
    
}
