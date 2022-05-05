package de.aviron.abakus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.aviron.abakus.entities.JournalLetter;

@Repository
public interface JournalLetterRepository extends JpaRepository<JournalLetter, Integer> {
    
}
