package de.aviron.abakus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.aviron.abakus.entities._Template;

@Repository
public interface _TemplateRepository extends JpaRepository<_Template, Integer> {
    
}