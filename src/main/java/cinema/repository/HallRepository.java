package cinema.repository;

import cinema.model.Hall;

import java.util.List;
import java.util.Optional;

public interface HallRepository {
    Optional<Hall> findById(int id);

    List<Hall> findAll();
}
