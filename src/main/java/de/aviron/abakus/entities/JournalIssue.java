package de.aviron.abakus.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class JournalIssue {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    // Datum der Ausgabe
    private LocalDate date;


    // ################## Relations ##################

    @OneToMany(cascade = CascadeType.ALL, mappedBy="issue")
    private Collection<JournalArticle> articles = new ArrayList<>();
    
}
