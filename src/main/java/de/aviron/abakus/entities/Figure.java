package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Figure {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Besitzer
     @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="owner_id")
    private User owner;

    // Name
    private String name;

    // Barvermögen
    private Integer money;

    // Botenpunkte
    private Integer activity;


    // ################## Relations ##################

    @OneToMany(cascade = CascadeType.ALL, mappedBy="author") @JsonIgnore
    private Collection<JournalArticle> figureArticles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="author") @JsonIgnore
    private Collection<JournalLetter> figureLetters = new ArrayList<>();

}
