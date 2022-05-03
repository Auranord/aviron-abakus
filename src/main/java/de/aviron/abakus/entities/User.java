package de.aviron.abakus.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.aviron.abakus.enums.UserRole;
import de.aviron.abakus.enums.UserSince;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String email; // TODO: Maybe make email to primary key

    @JsonIgnore
    private String password;

    // Mitgliedsstatus
    @Enumerated
    private UserRole role = UserRole.NONE;

    // Bild
    @ManyToOne
    @JoinColumn(name="picture_id")
    private Image picture;

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

    
    // ################## Relations ##################

    @OneToMany(mappedBy="owner")
    private Collection<Figure> userFigures = new ArrayList<>();

    @OneToMany(mappedBy="uploader")
    private Collection<Image> userPictures = new ArrayList<>();

}
