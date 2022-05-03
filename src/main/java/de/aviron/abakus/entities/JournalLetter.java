package de.aviron.abakus.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class JournalLetter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    // Artikel
    @ManyToOne
    @JoinColumn(name="article_id")
    private JournalArticle article;

    // Verfasser
    @ManyToOne
    @JoinColumn(name="author_id")
    private Figure author;
    
    // Zeitpunkt
    private LocalDateTime time;
    
    // Inhalt
    private String content;
    
    // Sichtbar
    private Boolean visible;
    
    // Zensurgrund
    private String reason;

    // ################## Relations ##################


    
    
}
