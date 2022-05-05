package de.aviron.abakus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.aviron.abakus.entities.JournalIssue;

@Repository
public interface JournalIssueRepository extends JpaRepository<JournalIssue, Integer> {
    
}
