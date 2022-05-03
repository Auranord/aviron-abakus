package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class JournalCollection {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    // Name
    private String name;

    // Verfasser
    private Integer editor;


    // ################## Relations ##################

    @OneToMany(mappedBy="collection")
    private Collection<JournalArticle> collectionArticles = new ArrayList<>();
    
}
