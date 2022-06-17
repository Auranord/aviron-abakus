package de.aviron.abakus.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@EqualsAndHashCode(callSuper=true)
public class JournalEvent extends _Possession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Name
    private String title;

    // Datum und Zeit
    private LocalDateTime dateTime;

    // Beschreibung
    private String about;

    // TODO: list of attendance

    // Relevante Artikel
    @OneToMany(cascade = CascadeType.ALL, mappedBy="event")
    private Collection<JournalArticle> relatedArticles = new ArrayList<>();
    
}
