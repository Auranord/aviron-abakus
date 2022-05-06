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
public class Seal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    // Name
    private String name;

    // Inhalt
    private String content;


    // ################## Relations ##################

    // Besitzer
    @ManyToMany(cascade = CascadeType.ALL) @JsonIgnore
    @JoinTable(name = "seal_possessors", joinColumns = @JoinColumn(name = "seal_id"), inverseJoinColumns = @JoinColumn(name = "figure_id"))
    private Collection<Figure> possessors = new ArrayList<>();

    // Benutzer
    @ManyToMany(cascade = CascadeType.ALL) @JsonIgnore
    @JoinTable(name = "seal_authorized", joinColumns = @JoinColumn(name = "seal_id"), inverseJoinColumns = @JoinColumn(name = "figure_id"))
    private Collection<Figure> authorized = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL) @JsonIgnore
    @JoinTable(name = "unbroken_seals", joinColumns = @JoinColumn(name = "seal_id"), inverseJoinColumns = @JoinColumn(name = "letter_id"))
    private Collection<MailLetter> unbrokenSealLetters = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL) @JsonIgnore
    @JoinTable(name = "broken_seals", joinColumns = @JoinColumn(name = "seal_id"), inverseJoinColumns = @JoinColumn(name = "letter_id"))
    private Collection<MailLetter> brokenSealLetters = new ArrayList<>();
    
}
