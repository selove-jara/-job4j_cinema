package cinema.repository;

import cinema.model.File;

import java.util.Optional;

public interface FileRepository {
    Optional<File> findById(int id);
}