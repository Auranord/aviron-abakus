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
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private _Possession possession;

    // Figures

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "owner_figures", joinColumns = @JoinColumn(name = "authorities_id"), inverseJoinColumns = @JoinColumn(name = "figure_id"))
    private Collection<Figure> owningFigures = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "trustee_figures", joinColumns = @JoinColumn(name = "authorities_id"), inverseJoinColumns = @JoinColumn(name = "figure_id"))
    private Collection<Figure> trustedFigures = new ArrayList<>();

    // Factions

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "owner_factions", joinColumns = @JoinColumn(name = "authorities_id"), inverseJoinColumns = @JoinColumn(name = "factions_id"))
    private Collection<Faction> owningFactions = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "trustee_factions", joinColumns = @JoinColumn(name = "authorities_id"), inverseJoinColumns = @JoinColumn(name = "factions_id"))
    private Collection<Faction> trustedFactions = new ArrayList<>();
                
    // Titles

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "owner_titles", joinColumns = @JoinColumn(name = "authorities_id"), inverseJoinColumns = @JoinColumn(name = "titles_id"))
    private Collection<Title> owningTitles = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "trustee_titles", joinColumns = @JoinColumn(name = "authorities_id"), inverseJoinColumns = @JoinColumn(name = "titles_id"))
    private Collection<Title> trustedTitles = new ArrayList<>();

}
