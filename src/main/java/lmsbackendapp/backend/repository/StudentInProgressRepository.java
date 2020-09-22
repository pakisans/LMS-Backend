package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.StudentInProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentInProgressRepository extends JpaRepository<StudentInProgress,Long> {
    Optional<StudentInProgress> findByStudyYearAndStudentId(Long studentInProgressId,Long studentId);
    @Query("SELECT sy.id FROM StudentInProgress sy JOIN sy.studyYear.subjectRealization sr "
            + "WHERE  sr.id = ?1 "
            + "AND sy.student.regUser.username = ?2")
    Long getStudentInProgressBySubjectRealizationAndStudent(Long subjectRealizationId, String studentUsername);
}
