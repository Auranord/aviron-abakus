package de.aviron.abakus.entities;

import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Authorities {
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private _Possession possession;

    // Figures
  
    @ManyToMany(cascade = CascadeType.ALL) @JsonIgnore
    @JoinTable(name = "owner_figures", joinColumns = @JoinColumn(name = "authorities_id"), inverseJoinColumns = @JoinColumn(name = "figure_id"))
    private Collection<Figure> owningFigures;

    @ManyToMany(cascade = CascadeType.ALL) @JsonIgnore
    @JoinTable(name = "trustee_figures", joinColumns = @JoinColumn(name = "authorities_id"), inverseJoinColumns = @JoinColumn(name = "figure_id"))
    private Collection<Figure> authorizedFigures;

    // Fractions

    @ManyToMany(cascade = CascadeType.ALL) @JsonIgnore
    @JoinTable(name = "owner_fractions", joinColumns = @JoinColumn(name = "authorities_id"), inverseJoinColumns = @JoinColumn(name = "fractions_id"))
    private Collection<Faction> owningFractions;

    @ManyToMany(cascade = CascadeType.ALL) @JsonIgnore
    @JoinTable(name = "trustee_fractions", joinColumns = @JoinColumn(name = "authorities_id"), inverseJoinColumns = @JoinColumn(name = "fractions_id"))
    private Collection<Faction> authorizedFractions;
                
            
}

