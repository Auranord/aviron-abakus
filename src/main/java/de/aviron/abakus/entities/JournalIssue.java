package de.aviron.abakus.entities;

import java.time.LocalDate;
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
public class JournalIssue {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Datum der Ausgabe
    private LocalDate date;

    // Artikel
    @OneToMany(cascade = CascadeType.ALL, mappedBy="issue")
    private Collection<JournalArticle> articles = new ArrayList<>();
    
}
