package cinema.repository;

import cinema.model.Film;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Optional;

public class Sql2oFilmRepository implements FilmRepository {
    private final Sql2o sql2o;

    public Sql2oFilmRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<Film> findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM films WHERE id = :id");
            var film = query.addParameter("id", id).executeAndFetchFirst(Film.class);
            return Optional.ofNullable(film);
        }
    }

    @Override
    public List<Film> findAll() {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM films");
            return query.executeAndFetch(Film.class);
        }
    }
}
