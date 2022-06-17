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
public class Seal extends _Possession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Name
    private String name;

    // Spruch
    private String content;

    // TODO: Enum for styles

    // 
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "unbroken_seals", joinColumns = @JoinColumn(name = "seal_id"), inverseJoinColumns = @JoinColumn(name = "letter_id"))
    private Collection<MailLetter> lettersWithUnbrokenSeals = new ArrayList<>();

    // 
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "broken_seals", joinColumns = @JoinColumn(name = "seal_id"), inverseJoinColumns = @JoinColumn(name = "letter_id"))
    private Collection<MailLetter> lettersWithBrokenSeals = new ArrayList<>();
    
    // 
    @OneToMany(cascade = CascadeType.ALL, mappedBy="seal")
    private Collection<JournalArticle> articlesWithSeals = new ArrayList<>();

}
