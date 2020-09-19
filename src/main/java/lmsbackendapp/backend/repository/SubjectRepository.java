package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    ArrayList<Subject> findByStudyYearIdEquals(Long studyYearId);

    Iterable<Optional<Subject>> findByNameS(String name);
}
