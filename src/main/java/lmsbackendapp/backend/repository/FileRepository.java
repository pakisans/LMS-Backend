package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File,Long> {
    @Query("SELECT f FROM File f WHERE f.teachingMaterials.subjectRealization.subject.id = ?1")
    Iterable<Optional<File>> getAllBySubject(Long id);
}
