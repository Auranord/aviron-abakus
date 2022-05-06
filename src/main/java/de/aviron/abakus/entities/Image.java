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
    Integer id;

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
    private LocalDateTime date;

    
    // ################## Relations ##################
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="picture") @JsonIgnore
    private Collection<User> userPictures = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="picture") @JsonIgnore
    private Collection<JournalArticle> articlePictures = new ArrayList<>();

}
