package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.Professor;
import lmsbackendapp.backend.model.ProfessorOnRealization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorOnRealizationRepository extends JpaRepository<ProfessorOnRealization,Long> {
    @Query("SELECT pr.professor FROM ProfessorOnRealization pr WHERE pr.subjectRealization.subject.id = ?1")
    Iterable<Professor> findProfessorForSubject(Long subjectId);
    @Query("SELECT pr FROM ProfessorOnRealization pr WHERE pr.subjectRealization.studyYear.id = ?1")
    Iterable<Optional<ProfessorOnRealization>> getByStudyYear(Long studyYearId);

}
