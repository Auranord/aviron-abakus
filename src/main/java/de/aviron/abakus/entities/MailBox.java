package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MailBox {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    private String name;

    private Boolean isPublic;

    private Boolean hasIncome;

    // Ort
    //private Location location;


    // ################## Relations ##################

    // Besitzer
    @ManyToMany
    @JoinTable(name = "mailbox_possessors", joinColumns = @JoinColumn(name = "box_id"), inverseJoinColumns = @JoinColumn(name = "figure_id"))
    private Collection<Figure> possessors = new ArrayList<>();

    // Benutzer
    @ManyToMany
    @JoinTable(name = "mailbox_authorized", joinColumns = @JoinColumn(name = "box_id"), inverseJoinColumns = @JoinColumn(name = "figure_id"))
    private Collection<Figure> authorized = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="box")
    private Collection<MailLetter> boxLetters = new ArrayList<>();

}
