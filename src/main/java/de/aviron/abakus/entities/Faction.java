package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Faction extends _Possession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Name
    private String name;

    // Kurzbeschreibung
    private String description;

    // Trivia Artikel
    private String trivia;

    // Mitgliedschaften
    @OneToMany(cascade = CascadeType.ALL, mappedBy="faction") @JsonIgnore
    private Collection<Membership> memberships = new ArrayList<>();

    // Titel
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "faction") @JsonIgnore
    private Collection<Title> titles = new ArrayList<>();

    // Possessions

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "owningFactions") @JsonIgnore
    private Collection<Authorities> ownedPossessions = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "trustedFactions") @JsonIgnore
    private Collection<Authorities> trustedPossessions = new ArrayList<>();

}
