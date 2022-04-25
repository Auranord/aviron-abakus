package de.aviron.abakus.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Figure {

    @Id
    @GeneratedValue // Mybe set strategy to AUTO
    private Integer id;

    private Integer owner;
    private String name;
    
}
