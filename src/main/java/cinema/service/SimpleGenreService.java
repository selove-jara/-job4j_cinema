package cinema.service;

import cinema.model.Genre;
import cinema.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SimpleGenreService implements GenreService {

    private final GenreRepository genreRepository;

    public SimpleGenreService(GenreRepository sql2oGenreRepository) {
        this.genreRepository = sql2oGenreRepository;
    }

    @Override
    public Optional<Genre> findById(int id) {
        return genreRepository.findById(id);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
