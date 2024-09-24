package cinema.repository;

import cinema.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {
    Optional<Genre> findById(int id);

    List<Genre> findAll();
}
