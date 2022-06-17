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
public class Membership {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Mitglied
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="member_id")
    private Figure member;

    // Fraktion
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="faction_id")
    private Faction faction;

    // Titel
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "membership_titles", joinColumns = @JoinColumn(name = "membership_id"), inverseJoinColumns = @JoinColumn(name = "title_id"))
    private Collection<Title> titles = new ArrayList<>();

    // Geheim
    private Boolean isSecret;

}
