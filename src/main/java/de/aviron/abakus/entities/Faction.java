package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy="faction")
    private Collection<Membership> memberships = new ArrayList<>();

    // Titel
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faction")
    private Collection<Title> titles = new ArrayList<>();

    // Possessions

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "owningFactions")
    private Collection<Authorities> ownedPossessions = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "trustedFactions")
    private Collection<Authorities> trustedPossessions = new ArrayList<>();

}
