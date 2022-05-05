package de.aviron.abakus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.aviron.abakus.entities.JournalEvent;

@Repository
public interface JournalEventRepository extends JpaRepository<JournalEvent, Integer> {
    
}
