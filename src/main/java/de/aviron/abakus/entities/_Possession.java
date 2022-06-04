package de.aviron.abakus.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class _Possession {
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Authorities authorities;

}
