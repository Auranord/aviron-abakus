package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

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
    @ManyToMany
    @JoinTable(name = "seal_possessors", joinColumns = @JoinColumn(name = "seal_id"), inverseJoinColumns = @JoinColumn(name = "figure_id"))
    private Collection<Figure> possessors = new ArrayList<>();

    // Benutzer
    @ManyToMany
    @JoinTable(name = "seal_authorized", joinColumns = @JoinColumn(name = "seal_id"), inverseJoinColumns = @JoinColumn(name = "figure_id"))
    private Collection<Figure> authorized = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "unbroken_seals", joinColumns = @JoinColumn(name = "seal_id"), inverseJoinColumns = @JoinColumn(name = "letter_id"))
    private Collection<MailLetter> unbrokenSealLetters = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "broken_seals", joinColumns = @JoinColumn(name = "seal_id"), inverseJoinColumns = @JoinColumn(name = "letter_id"))
    private Collection<MailLetter> brokenSealLetters = new ArrayList<>();
    
}
