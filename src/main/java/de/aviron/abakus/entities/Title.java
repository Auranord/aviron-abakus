package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Title {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Name
    private String name;

    // Kurzbeschreibung
    private String description;

    // Fraktion
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="faction_id")
    private Faction faction;

    // Mitgliedschaften
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "titles") @JsonIgnore
    private Collection<Membership> membershipsWithTitle = new ArrayList<>();

    // Rang
    private Integer rank;

    // Gewichtung
    private Integer weighting;

    // Geheim
    private Boolean isSecret;


    // Possessions

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "owningTitles") @JsonIgnore
    private Collection<Authorities> ownedPossessions = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "trustedTitles") @JsonIgnore
    private Collection<Authorities> trustedPossessions = new ArrayList<>();

}
