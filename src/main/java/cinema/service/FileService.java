package cinema.service;

import cinema.dto.FileDto;
import cinema.model.File;

import java.util.Optional;

public interface FileService {
    Optional<FileDto> findById(int id);
}
