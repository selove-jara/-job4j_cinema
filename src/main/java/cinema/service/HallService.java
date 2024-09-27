package cinema.service;

import cinema.model.Hall;

import java.util.List;
import java.util.Optional;

public interface HallService {
    Optional<Hall> findById(int id);

    List<Hall> findAll();
}
