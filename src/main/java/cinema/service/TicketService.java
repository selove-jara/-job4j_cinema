package cinema.service;

import cinema.model.Ticket;

import java.util.Collection;
import java.util.Optional;

public interface TicketService {
    Optional<Ticket> save(Ticket ticket);

    void deleteById(int id);

    Optional<Ticket> findById(int id);

    Collection<Ticket> findAll();

    Optional<Ticket> findTicketByRowAndPlace(int sessionId, int rowNumber, int placeNumber);
}
