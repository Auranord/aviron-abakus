package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class Signing extends _Possession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Name
    private String name;

    // Inhalt
    private String content;

    // TODO: Enum for styles

    // 
    @ManyToMany(cascade = CascadeType.ALL) @JsonIgnore
    @JoinTable(name = "letter_signings", joinColumns = @JoinColumn(name = "signing_id"), inverseJoinColumns = @JoinColumn(name = "letter_id"))
    private Collection<MailLetter> lettersWithSigning = new ArrayList<>();

    // 
    @OneToMany(cascade = CascadeType.ALL, mappedBy="signing") @JsonIgnore
    private Collection<JournalArticle> articlesWithSigning = new ArrayList<>();

}
