package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Figure {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Besitzer
    @ManyToOne
    @JoinColumn(name="owner_id")
    private User owner;

    // Name
    private String name;

    // Barvermögen
    private Integer money;

    // Botenpunkte
    private Integer activity;


    // ################## Relations ##################

    @OneToMany(mappedBy="author")
    private Collection<JournalArticle> figureArticles = new ArrayList<>();

    @OneToMany(mappedBy="author")
    private Collection<JournalLetter> figureLetters = new ArrayList<>();

}
