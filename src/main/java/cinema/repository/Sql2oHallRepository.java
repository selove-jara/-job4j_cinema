package cinema.repository;

import cinema.model.Genre;
import cinema.model.Hall;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Optional;

public class Sql2oHallRepository implements HallRepository {

    private final Sql2o sql2o;

    public Sql2oHallRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<Hall> findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM halls WHERE id = :id");
            var hall = query.addParameter("id", id).executeAndFetchFirst(Hall.class);
            return Optional.ofNullable(hall);
        }
    }

    @Override
    public List<Hall> findAll() {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM halls");
            return query.executeAndFetch(Hall.class);
        }
    }
}
