package de.aviron.abakus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.aviron.abakus.entities.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    
}
