package de.aviron.abakus.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class JournalLetter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Artikel
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="article_id")
    private JournalArticle article;

    // Verfasser
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="author_id")
    private Figure author;
    
    // Zeitpunkt
    private LocalDateTime dateTime;
    
    // Inhalt
    private String content;
    
    // Sichtbar
    private Boolean isVisible;
    
    // Zensurgrund
    private String reason;

}
