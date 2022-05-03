package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import de.aviron.abakus.enums.JournalCategory;
import lombok.Data;

@Entity
@Data
public class JournalArticle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    // Ausgabe
    @ManyToOne
    @JoinColumn(name="issue_id")
    private JournalIssue issue;

    // Titel
    private String title;

    // Untertitel
    private String subtitle;

    // Verfasser
    @ManyToOne
    @JoinColumn(name="author_id")
    private Figure author;

    // Anonym
    private Boolean anonymous;

    // Bild
    @ManyToOne
    @JoinColumn(name="picture_id")
    private Image picture;

    // Sparte
    @Enumerated
    private JournalCategory category;

    // Antwort
    @ManyToOne
    @JoinColumn(name="answer_id")
    private JournalArticle answer;

    // Reihe x
    @ManyToOne
    @JoinColumn(name="collection_id")
    private JournalCollection collection;

    // Event x
    @ManyToOne
    @JoinColumn(name="event_id")
    private JournalEvent event;

    // Eingereicht
    private Boolean done;

    // Artikel Wert
    private Integer value;

    // Sichtbar
    private Boolean visible;

    // Zensurgrund
    private String reason;


    // ################## Relations ##################

    @OneToMany(mappedBy="answer")
    private Collection<JournalArticle> articleAnswers = new ArrayList<>();

    @OneToMany(mappedBy="article")
    private Collection<JournalLetter> articleLetters = new ArrayList<>();
    
}
