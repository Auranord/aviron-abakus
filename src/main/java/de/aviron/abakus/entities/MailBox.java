package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@EqualsAndHashCode(callSuper=true)
public class MailBox extends _Possession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Name
    private String name;

    // Briefe in Mailbox
    @OneToMany(cascade = CascadeType.ALL, mappedBy="box")
    private Collection<MailLetter> letters = new ArrayList<>();

    // Geheim
    private Boolean isSecret;

    // Neue Briefe
    private Boolean hasNewMail;

}
