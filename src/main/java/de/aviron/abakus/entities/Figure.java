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

    // Botenpunkte
    private Integer activity;


    // Transactions

    @OneToMany(cascade = CascadeType.ALL, mappedBy="client") @JsonIgnore
    private Collection<BankTransaction> madeTransactions;


    // Fractions

    @ManyToMany(cascade = CascadeType.ALL) @JsonIgnore
    @JoinTable(name = "fraction_members", joinColumns = @JoinColumn(name = "figure_id"), inverseJoinColumns = @JoinColumn(name = "fraction_id"))
    private Collection<Fraction> memberOf = new ArrayList<>();


    // Journal

    @OneToMany(cascade = CascadeType.ALL, mappedBy="author") @JsonIgnore
    private Collection<JournalArticle> writenJournalAricles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="author") @JsonIgnore
    private Collection<JournalLetter> writenJournalLetters = new ArrayList<>();


    // Possesions

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "owningFigures") @JsonIgnore
    private Collection<Authorities> ownedPossessions = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "authorizedFigures") @JsonIgnore
    private Collection<Authorities> authorizedPossessions = new ArrayList<>();

}
