package imasdev.musicapi.repository;

import imasdev.musicapi.model.Musician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicianRepository extends JpaRepository<Musician, Long> {

}

