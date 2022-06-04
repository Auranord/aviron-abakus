package de.aviron.abakus.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Image {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // URL
    private String url;

    // Uploader
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="uploader_id")
    private User uploader;
    
    // Name
    private String name;
    
    // Kommentar
    private String comment;
    
    // Upload Datum
    private LocalDateTime uploadDateTime;

    // Uses

    @OneToMany(cascade = CascadeType.ALL, mappedBy="avatar") @JsonIgnore
    private Collection<User> avatarOf = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="illustration") @JsonIgnore
    private Collection<JournalArticle> illustrationOf = new ArrayList<>();

}
