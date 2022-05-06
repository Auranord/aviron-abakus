package de.aviron.abakus.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class JournalLetter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    // Artikel
     @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="article_id")
    private JournalArticle article;

    // Verfasser
     @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="author_id")
    private Figure author;
    
    // Zeitpunkt
    private LocalDateTime time;
    
    // Inhalt
    private String content;
    
    // Sichtbar
    private Boolean isVisible;
    
    // Zensurgrund
    private String reason;

}
