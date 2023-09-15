package imasdev.musicapi.controller;

import imasdev.musicapi.model.Musician;
import imasdev.musicapi.repository.MusicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicians")
public class MusicianController {

    private final MusicianRepository musicianRepository;

    @Autowired
    public MusicianController(MusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }

    // Obtener todos los músicos
    @GetMapping("/")
    public List<Musician> getAllMusicians() {
        return musicianRepository.findAll();
    }

    // Crear un nuevo músico
    @PostMapping("/")
    public Musician createMusician(@RequestBody Musician musician) {
        return musicianRepository.save(musician);
    }

    // Obtener un músico por ID
    @GetMapping("/{id}")
    public Musician getMusicianById(@PathVariable Long id) {
        return musicianRepository.findById(id).orElse(null);
    }

    // Actualizar un músico por ID
    @PutMapping("/{id}")
    public Musician updateMusician(@PathVariable Long id, @RequestBody Musician updatedMusician) {
        return musicianRepository.findById(id)
                .map(musician -> {
                    // Actualizar los campos relevantes aquí
                    musician.setFirstName(updatedMusician.getFirstName());
                    musician.setLastName(updatedMusician.getLastName());
                    // Actualizar otros campos...
                    return musicianRepository.save(musician);
                })
                .orElse(null);
    }

    // Eliminar un músico por ID
    @DeleteMapping("/{id}")
    public void deleteMusician(@PathVariable Long id) {
        musicianRepository.deleteById(id);
    }

}

