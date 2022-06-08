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

    // Name
    private String name;

    // Kurzbeschreibung
    private String description;

    // Trivia Artikel
    private String trivia;

    // Besitzer
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="owner_id")
    private User owner;

    // Botenpunkte
    private Integer activity;

    // Mitgliedschaften
    @OneToMany(cascade = CascadeType.ALL, mappedBy="member") @JsonIgnore
    private Collection<Membership> memberships = new ArrayList<>();


    // Transactions

    @OneToMany(cascade = CascadeType.ALL, mappedBy="client") @JsonIgnore
    private Collection<BankTransaction> madeTransactions;


    // Journal

    @OneToMany(cascade = CascadeType.ALL, mappedBy="author") @JsonIgnore
    private Collection<JournalArticle> writtenJournalArticles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="author") @JsonIgnore
    private Collection<JournalLetter> writtenJournalLetters = new ArrayList<>();


    // Possessions

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "owningFigures") @JsonIgnore
    private Collection<Authorities> ownedPossessions = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "trustedFigures") @JsonIgnore
    private Collection<Authorities> trustedPossessions = new ArrayList<>();

}
