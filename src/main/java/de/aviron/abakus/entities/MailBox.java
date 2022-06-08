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
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class MailBox extends _Possession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Name
    private String name;

    // Briefe in Mailbox
    @OneToMany(cascade = CascadeType.ALL, mappedBy="box") @JsonIgnore
    private Collection<MailLetter> letters = new ArrayList<>();

    // Geheim
    private Boolean isSecret;

    // Neue Briefe
    private Boolean hasNewMail;

}
