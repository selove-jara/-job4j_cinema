package cinema.service;

import cinema.dto.FilmSessionDto;
import cinema.model.FilmSession;
import cinema.repository.FilmRepository;
import cinema.repository.FilmSessionRepository;
import cinema.repository.HallRepository;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ThreadSafe
public class SimpleFilmSessionService implements FilmSessionService {

    private final FilmRepository filmRepository;
    private final FilmSessionRepository filmSessionRepository;
    private final HallRepository hallRepository;

    public SimpleFilmSessionService(FilmRepository filmRepository, FilmSessionRepository filmSessionRepository, HallRepository hallRepository) {
        this.filmRepository = filmRepository;
        this.filmSessionRepository = filmSessionRepository;
        this.hallRepository = hallRepository;
    }

    @Override
    public Optional<FilmSessionDto> findById(int id) {
        var filmSession = filmSessionRepository.findById(id);
        if (filmSession.isEmpty()) {
            return Optional.empty();
        }
        var film = filmRepository.findById(filmSession.get().getFilmId()).get();
        var hall = hallRepository.findById(filmSession.get().getId()).get();
        return Optional.ofNullable(new FilmSessionDto(film, filmSession.get(), hall));
    }

    @Override
    public List<FilmSessionDto> findAll() {
        var filmSessions = filmSessionRepository.findAll();
        var filmSessionsDto = new ArrayList<FilmSessionDto>();
        for (FilmSession session : filmSessions) {
            filmSessionsDto.add(new FilmSessionDto(filmRepository.findById(session.getFilmId()).get(), session, hallRepository.findById(session.getHallsId()).get()));
        }
        return filmSessionsDto;
    }
}