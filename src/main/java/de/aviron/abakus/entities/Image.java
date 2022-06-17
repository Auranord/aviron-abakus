package de.aviron.abakus.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Image {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // URL
    private String url;

    // Uploader
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="uploader_id")
    private User uploader;
    
    // Name
    private String name;
    
    // Kommentar
    private String comment;
    
    // Upload Datum
    private LocalDateTime uploadDateTime;

    // Uses

    @OneToMany(cascade = CascadeType.ALL, mappedBy="avatar")
    private Collection<User> avatarOf = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="illustration")
    private Collection<JournalArticle> illustrationOf = new ArrayList<>();

}
