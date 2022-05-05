package de.aviron.abakus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import de.aviron.abakus.repositories._TemplateRepository;
import de.aviron.abakus.entities._Template;

@Service
@AllArgsConstructor
public class _TemplateService {

    private _TemplateRepository repository;

    public List<_Template> getAll_Template() {
        return repository.findAll();
    }

    public _Template get_TemplateById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public _Template add_Template(_Template template) {
        return repository.save(template);
    }

    public _Template set_Template(Integer id, _Template template) {
        return repository.save(template);
    }

    public _Template update_Template(_Template template) {
        _Template old_Template = repository.findById(template.getId()).orElse(null);
        if(old_Template == null)
            return null;
            
        return repository.save(template);
    }
    
}
