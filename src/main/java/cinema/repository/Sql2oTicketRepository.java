package cinema.repository;

import cinema.model.Ticket;
import org.sql2o.Sql2o;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Sql2oTicketRepository implements TicketRepository {

    private final Sql2o sql2o;

    public Sql2oTicketRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Ticket save(Ticket ticket) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Optional<Ticket> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<Ticket> findAll() {
        return List.of();
    }
}
