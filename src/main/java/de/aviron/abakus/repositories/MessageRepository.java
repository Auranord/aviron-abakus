package de.aviron.abakus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.aviron.abakus.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    
}
