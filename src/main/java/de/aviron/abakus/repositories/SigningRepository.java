package de.aviron.abakus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.aviron.abakus.entities.Signing;

@Repository
public interface SigningRepository extends JpaRepository<Signing, Integer> {
    
}
