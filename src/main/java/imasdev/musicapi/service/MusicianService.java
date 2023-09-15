package imasdev.musicapi.service;

import imasdev.musicapi.repository.MusicianRepository;
import org.springframework.stereotype.Service;


@Service
public class MusicianService {

    private MusicianService musicianService;

    private MusicianRepository musicianRepository;


    public MusicianService(MusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }
}
