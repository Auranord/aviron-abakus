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
public class JournalCollection {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Name
    private String name;

    // Verfasser TODO: make extend Possesion? (B) 
    private Integer editor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="collection") @JsonIgnore
    private Collection<JournalArticle> includedArticles = new ArrayList<>();
    
}
