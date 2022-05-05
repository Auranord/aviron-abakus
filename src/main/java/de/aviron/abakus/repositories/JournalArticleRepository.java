package de.aviron.abakus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.aviron.abakus.entities.JournalArticle;

@Repository
public interface JournalArticleRepository extends JpaRepository<JournalArticle, Integer> {
    
}
