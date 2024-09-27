package cinema.service;

import cinema.dto.FilmDto;
import cinema.model.Film;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    Optional<FilmDto> findById(int id);

    List<FilmDto> findAll();
}
