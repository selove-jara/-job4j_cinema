package cinema.repository;

import cinema.model.FilmSession;
import cinema.model.Hall;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Optional;

public class Sql2oFilmSessionRepository implements FilmSessionRepository {

    private final Sql2o sql2o;

    public Sql2oFilmSessionRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<FilmSession> findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM film_sessions WHERE id = :id");
            var filmSession = query.addParameter("id", id).executeAndFetchFirst(FilmSession.class);
            return Optional.ofNullable(filmSession);
        }
    }

    @Override
    public List<FilmSession> findAll() {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM film_sessions");
            return query.executeAndFetch(FilmSession.class);
        }
    }
}
