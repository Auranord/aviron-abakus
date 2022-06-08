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
    @ManyToMany(cascade = CascadeType.ALL) @JsonIgnore
    @JoinTable(name = "unbroken_seals", joinColumns = @JoinColumn(name = "seal_id"), inverseJoinColumns = @JoinColumn(name = "letter_id"))
    private Collection<MailLetter> lettersWithUnbrokenSeals = new ArrayList<>();

    // 
    @ManyToMany(cascade = CascadeType.ALL) @JsonIgnore
    @JoinTable(name = "broken_seals", joinColumns = @JoinColumn(name = "seal_id"), inverseJoinColumns = @JoinColumn(name = "letter_id"))
    private Collection<MailLetter> lettersWithBrokenSeals = new ArrayList<>();
    
    // 
    @OneToMany(cascade = CascadeType.ALL, mappedBy="seal") @JsonIgnore
    private Collection<JournalArticle> articlesWithSeals = new ArrayList<>();

}
