package de.aviron.abakus.entities;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Property {
    
    // Besitzer
    private Collection<Figure> possessors = new ArrayList<>();

    // Benutzer
    private Collection<Figure> authorized = new ArrayList<>();


    // ################## Relations ##################

}
