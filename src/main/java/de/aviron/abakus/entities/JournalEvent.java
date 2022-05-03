package de.aviron.abakus.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class JournalEvent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    // Name
    private String title;

    // Datum und Zeit
    private LocalDateTime date;

    // Kommentar
    private String about;


    // ################## Relations ##################

    @OneToMany(mappedBy="event")
    private Collection<JournalArticle> eventArticles = new ArrayList<>();
    
}
