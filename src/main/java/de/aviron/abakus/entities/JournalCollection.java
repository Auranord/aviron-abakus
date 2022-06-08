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
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class JournalCollection extends _Possession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Name
    private String name;

    // Kurzbeschreibung
    private String description;

    // Beinhaltete Artikel
    @OneToMany(cascade = CascadeType.ALL, mappedBy="collection") @JsonIgnore
    private Collection<JournalArticle> includedArticles = new ArrayList<>();
    
}
