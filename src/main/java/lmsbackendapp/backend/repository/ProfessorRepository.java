package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {
    @Query("SELECT p FROM Professor p WHERE p.personalData.name LIKE ?1")
    Iterable<Optional<Professor>> findProfessorByName(String name);

    @Query("SELECT p FROM Professor p WHERE p.personalData.upin = ?1")
    Optional<Professor> findProfessorByUpin(String upin);

    @Query("SELECT p FROM Professor p WHERE p.regUser.username = ?1")
    Optional<Professor> getByUsername(String username);

    @Query("SELECT DISTINCT pr.professor FROM ProfessorOnRealization pr WHERE pr.subjectRealization.studyYear.studyProgram.faculty.id = ?1")
    Iterable<Optional<Professor>> getAllByFaculty(Long facultyId);



}
