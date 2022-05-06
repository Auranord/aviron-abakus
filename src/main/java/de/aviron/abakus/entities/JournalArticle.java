package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.aviron.abakus.enums.JournalCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class JournalArticle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    // Ausgabe
     @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="issue_id")
    private JournalIssue issue;

    // Titel
    private String title;

    // Untertitel
    private String subtitle;

    // Verfasser
     @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="author_id")
    private Figure author;

    // Anonym
    private Boolean isAnonymous;

    // Bild
     @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="picture_id")
    private Image picture;

    // Sparte
    @Enumerated
    private JournalCategory category;

    // Antwort
     @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="answer_id")
    private JournalArticle answer;

    // Reihe
     @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="collection_id")
    private JournalCollection collection;

    // Event
     @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="event_id")
    private JournalEvent event;

    // Eingereicht
    private Boolean isDone;

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
