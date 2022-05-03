package de.aviron.abakus.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class _Template {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    // 
    //private Object;

}
