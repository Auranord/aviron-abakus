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
public class Fraction extends _Possession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "memberOf") @JsonIgnore
    private Collection<Figure> members = new ArrayList<>();

    
    // Possesions

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "owningFractions") @JsonIgnore
    private Collection<Authorities> ownedPossessions = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "authorizedFractions") @JsonIgnore
    private Collection<Authorities> authorizedPossessions = new ArrayList<>();

}
