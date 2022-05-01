package de.aviron.abakus.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.aviron.abakus.security.UserRole;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    private UserRole role = UserRole.NONE;

}
