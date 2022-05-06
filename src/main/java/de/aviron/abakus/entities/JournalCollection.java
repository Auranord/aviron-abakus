package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class JournalCollection {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    // Name
    private String name;

    // Verfasser
    private Integer editor;


    // ################## Relations ##################

    @OneToMany(cascade = CascadeType.ALL, mappedBy="collection")
    private Collection<JournalArticle> collectionArticles = new ArrayList<>();
    
}
