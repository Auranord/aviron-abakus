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
public class Title {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Name
    private String name;

    // Kurzbeschreibung
    private String description;

    // Fraktion
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="faction_id")
    private Faction faction;

    // Mitgliedschaften
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "titles")
    private Collection<Membership> membershipsWithTitle = new ArrayList<>();

    // Rang
    private Integer rank;

    // Gewichtung
    private Integer weighting;

    // Geheim
    private Boolean isSecret;


    // Possessions

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "owningTitles")
    private Collection<Authorities> ownedPossessions = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "trustedTitles")
    private Collection<Authorities> trustedPossessions = new ArrayList<>();

}
