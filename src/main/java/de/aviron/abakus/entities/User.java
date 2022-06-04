package de.aviron.abakus.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.aviron.abakus.enums.UserRole;
import de.aviron.abakus.enums.UserSince;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String email; 

    @JsonIgnore
    private String password;

    // Mitgliedsstatus
    @Enumerated
    private UserRole role = UserRole.NONE;

    // Bild
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
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

    // Urlaubsmodus
    private Boolean vacation;

    // Inaktiv
    private Boolean inactive;

    // Statusnachricht
    private String status;

    // Spenden
    private Double donations;

    // Figuren
    @OneToMany(cascade = CascadeType.ALL, mappedBy="owner") @JsonIgnore
    private Collection<Figure> figures = new ArrayList<>();

    // Bilder
    @OneToMany(cascade = CascadeType.ALL, mappedBy="uploader") @JsonIgnore
    private Collection<Image> uploadedImages = new ArrayList<>();

    
    // Messages

    @OneToMany(cascade = CascadeType.ALL, mappedBy="sender") @JsonIgnore
    private Collection<Message> sendMessages = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="receiver") @JsonIgnore
    private Collection<Message> receivedMessages = new ArrayList<>();
    
}
