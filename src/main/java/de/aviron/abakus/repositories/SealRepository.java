package de.aviron.abakus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.aviron.abakus.entities.Seal;

@Repository
public interface SealRepository extends JpaRepository<Seal, Integer> {
    
}
