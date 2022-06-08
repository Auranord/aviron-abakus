package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Membership {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Mitglied
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="member_id")
    private Figure member;

    // Fraktion
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="faction_id")
    private Faction faction;

    // Titel
    @ManyToMany(cascade = CascadeType.ALL) @JsonIgnore
    @JoinTable(name = "membership_titles", joinColumns = @JoinColumn(name = "membership_id"), inverseJoinColumns = @JoinColumn(name = "title_id"))
    private Collection<Title> titles = new ArrayList<>();

    // Geheim
    private Boolean isSecret;

}
