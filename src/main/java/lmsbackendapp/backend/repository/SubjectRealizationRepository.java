package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.Professor;
import lmsbackendapp.backend.model.SubjectRealization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRealizationRepository extends JpaRepository<SubjectRealization,Long>
{
    Iterable<SubjectRealization> findByStudyYearId(Long id);

    @Query("SELECT pp.professor FROM ProfessorOnRealization pp WHERE pp.teachingType.name='Exercises' AND pp.subjectRealization.subject.id = ?1")
    Iterable<Professor> findProfesorForExercises(Long subjectId);
}
