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
public class Signing extends _Possession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Name
    private String name;

    // Inhalt
    private String content;

    // TODO: Enum for styles

    // 
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "letter_signings", joinColumns = @JoinColumn(name = "signing_id"), inverseJoinColumns = @JoinColumn(name = "letter_id"))
    private Collection<MailLetter> lettersWithSigning = new ArrayList<>();

    // 
    @OneToMany(cascade = CascadeType.ALL, mappedBy="signing")
    private Collection<JournalArticle> articlesWithSigning = new ArrayList<>();

}
