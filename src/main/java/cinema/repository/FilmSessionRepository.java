package cinema.repository;

import cinema.model.FilmSession;

import java.util.List;
import java.util.Optional;

public interface FilmSessionRepository {
    Optional<FilmSession> findById(int id);

    List<FilmSession> findAll();
}
