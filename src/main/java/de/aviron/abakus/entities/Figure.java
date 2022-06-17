package de.aviron.abakus.entities;

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
public class Figure {

    public Figure(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Name
    private String name;

    // Kurzbeschreibung
    private String description = "Beschreibung";

    // Trivia Artikel
    private String trivia;

    // Besitzer
    @ManyToOne(cascade = CascadeType.ALL) //@JsonIgnore
    @JoinColumn(name="owner_id")
    private User owner;

    // Botenpunkte
    private Integer activity = 0;

    // Mitgliedschaften
    @OneToMany(cascade = CascadeType.ALL, mappedBy="member")
    private Collection<Membership> memberships = new ArrayList<>();


    // Transactions

    @OneToMany(cascade = CascadeType.ALL, mappedBy="client")
    private Collection<BankTransaction> madeTransactions;


    // Journal

    @OneToMany(cascade = CascadeType.ALL, mappedBy="author")
    private Collection<JournalArticle> writtenJournalArticles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="author")
    private Collection<JournalLetter> writtenJournalLetters = new ArrayList<>();


    // Possessions

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "owningFigures")
    private Collection<Authorities> ownedPossessions = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "trustedFigures")
    private Collection<Authorities> trustedPossessions = new ArrayList<>();

}
