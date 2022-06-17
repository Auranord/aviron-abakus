package de.aviron.abakus.entities;

import de.aviron.abakus.enums.UserRole;
import de.aviron.abakus.enums.UserSince;
import de.aviron.abakus.enums.UserStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Email
    @Column(unique = true)
    private String email; 

    // Passwort
    @JsonIgnore
    private String password;

    // Mitgliedsstatus
    @Enumerated
    private UserRole role = UserRole.NONE;

    // Bild
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="avatar_id")
    private Image avatar;

    // MC UUID
    @Column(unique = true)
    private UUID uuid;

    // Registrationsdatum
    private LocalDateTime registrationDate;

    // Letzte Aktivität
    private LocalDateTime lastActivity;

    // Über mich
    private String about;

    // Geburtstag
    private LocalDate birthday ;

    // Dabei seit
    @Enumerated
    private UserSince since;

    // Banngrund
    private String banReason;

    // Urlaubsmodus Inaktiv
    @Enumerated
    private UserStatus status;

    // Statusnachricht
    private String statusComment;

    // Spenden
    private Double donations;

    // Figuren
    @OneToMany(cascade = CascadeType.ALL, mappedBy="owner") //@JsonIgnore
    private Collection<Figure> figures = new ArrayList<>();

    // Bilder
    @OneToMany(cascade = CascadeType.ALL, mappedBy="uploader") //@JsonIgnore
    private Collection<Image> uploadedImages = new ArrayList<>();

    
    // Messages

    @OneToMany(cascade = CascadeType.ALL, mappedBy="sender") //@JsonIgnore
    private Collection<Message> sentMessages = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="receiver") //@JsonIgnore
    private Collection<Message> receivedMessages = new ArrayList<>();
    
}
