package de.aviron.abakus.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class JournalIssue {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    // Datum der Ausgabe
    private LocalDate date;

    @OneToMany(mappedBy="issue")
    private Collection<JournalArticle> articles = new ArrayList<>();
    
}
