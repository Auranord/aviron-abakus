package de.aviron.abakus.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Image {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    // URL
    private String url;

    // Uploader
    @ManyToOne
    @JoinColumn(name="uploader_id")
    private User uploader;
    
    // Name
    private String name;
    
    // Kommentar
    private String comment;
    
    // Upload Datum
    private LocalDateTime date;

    
    // ################## Relations ##################
    
    @OneToMany(mappedBy="picture")
    private Collection<User> userPictures = new ArrayList<>();

    @OneToMany(mappedBy="picture")
    private Collection<JournalArticle> articlePictures = new ArrayList<>();

}
