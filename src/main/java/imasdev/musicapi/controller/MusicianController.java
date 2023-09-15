package imasdev.musicapi.controller;
import imasdev.musicapi.model.Musician;
import imasdev.musicapi.repository.MusicianRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicians")
@Tag(name = "MusicianController", description = "API para gestionar músicos")
public class MusicianController {

    private final MusicianRepository musicianRepository;

    @Autowired
    public MusicianController(MusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }

    @GetMapping("/")
    @Operation(summary = "Obtener todos los músicos")
    public List<Musician> getAllMusicians() {
        return musicianRepository.findAll();
    }

    @PostMapping("/")
    @Operation(summary = "Crear un nuevo músico")
    public Musician createMusician(@RequestBody Musician musician) {
        return musicianRepository.save(musician);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un músico por ID")
    public Musician getMusicianById(@PathVariable Long id) {
        return musicianRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un músico por ID")
    public Musician updateMusician(@PathVariable Long id, @RequestBody Musician updatedMusician) {
        return musicianRepository.findById(id)
                .map(musician -> {
                    // Actualizar los campos
                    musician.setFirstName(updatedMusician.getFirstName());
                    musician.setLastName(updatedMusician.getLastName());

                    return musicianRepository.save(musician);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un músico por ID")
    public void deleteMusician(@PathVariable Long id) {
        musicianRepository.deleteById(id);
    }
}
