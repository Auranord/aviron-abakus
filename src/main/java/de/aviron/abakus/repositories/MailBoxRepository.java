package de.aviron.abakus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.aviron.abakus.entities.MailBox;

@Repository
public interface MailBoxRepository extends JpaRepository<MailBox, Integer> {
    
}
