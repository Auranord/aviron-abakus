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
public class JournalEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Name
    private String title;

    // Datum und Zeit
    private LocalDateTime dateTime;

    // Kommentar
    private String about;

    // Verfasser TODO: make extend Possesion? (B) 
    private Integer editor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="event") @JsonIgnore
    private Collection<JournalArticle> relatedArticles = new ArrayList<>();
    
}
