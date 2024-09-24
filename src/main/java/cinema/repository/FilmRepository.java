package cinema.repository;

import cinema.model.Film;

import java.util.List;
import java.util.Optional;

public interface FilmRepository {
    Optional<Film> findById(int id);

    List<Film> findAll();
}
