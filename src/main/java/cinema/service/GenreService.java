package cinema.service;

import cinema.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Optional<Genre> findById(int id);

    List<Genre> findAll();
}
