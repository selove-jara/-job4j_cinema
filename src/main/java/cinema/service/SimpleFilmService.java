package cinema.service;

import cinema.dto.FilmDto;
import cinema.model.File;
import cinema.model.Film;
import cinema.repository.FileRepository;
import cinema.repository.FilmRepository;
import cinema.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SimpleFilmService implements FilmService {

    private final FilmRepository filmRepository;
    private final FileRepository fileRepository;
    private final GenreRepository genreRepository;

    public SimpleFilmService(FilmRepository filmRepository, FileRepository fileRepository, GenreRepository genreRepository) {
        this.filmRepository = filmRepository;
        this.fileRepository = fileRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public Optional<FilmDto> findById(int id) {
        var film = filmRepository.findById(id);
        if (film.isEmpty()) {
            return Optional.empty();
        }
        var genre = genreRepository.findById(film.get().getGenreId());
        var file = fileRepository.findById(film.get().getFileId());
        return Optional.ofNullable(new FilmDto(film.get(), genre.get(), file.get()));
    }

    @Override
    public List<FilmDto> findAll() {
        var films = filmRepository.findAll();
        List<FilmDto> filmsDto = new ArrayList<>();
        for (Film film : films) {
            filmsDto.add(new FilmDto(film, genreRepository.findById(film.getGenreId()).get(), fileRepository.findById(film.getFileId()).get()));
        }
        return filmsDto;
    }
}
