package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Signing {
    
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
    @JoinTable(name = "signing_possessors", joinColumns = @JoinColumn(name = "box_id"), inverseJoinColumns = @JoinColumn(name = "figure_id"))
    private Collection<Figure> possessors = new ArrayList<>();

    // Benutzer
    @ManyToMany
    @JoinTable(name = "signing_authorized", joinColumns = @JoinColumn(name = "box_id"), inverseJoinColumns = @JoinColumn(name = "figure_id"))
    private Collection<Figure> authorized = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "letter_signings", joinColumns = @JoinColumn(name = "signing_id"), inverseJoinColumns = @JoinColumn(name = "letter_id"))
    private Collection<MailLetter> signingLetters = new ArrayList<>();

}
