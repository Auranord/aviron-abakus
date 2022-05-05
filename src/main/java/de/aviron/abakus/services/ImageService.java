package de.aviron.abakus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import de.aviron.abakus.repositories.ImageRepository;
import de.aviron.abakus.entities.Image;

@Service
@AllArgsConstructor
public class ImageService {

    private ImageRepository repository;

    public List<Image> getAllImage() {
        return repository.findAll();
    }

    public Image getImageById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Image addImage(Image image) {
        return repository.save(image);
    }

    public Image setImage(Integer id, Image image) {
        return repository.save(image);
    }

    public Image updateImage(Image image) {
        Image oldImage = repository.findById(image.getId()).orElse(null);
        if(oldImage == null)
            return null;
            
        return repository.save(image);
    }
    
}
