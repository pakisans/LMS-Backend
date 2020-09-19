package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.Student;
import lmsbackendapp.backend.model.Subject;
import lmsbackendapp.backend.model.SubjectAttending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SubjectAttendingRepository extends JpaRepository<SubjectAttending,Long> {
    @Query("SELECT DISTINCT sa.subjectRealization.subject FROM SubjectAttending sa WHERE sa.student.regUser.username = ?1 AND sa.assessment IS NULL")
    ArrayList<Subject> findCurrentSubject(String username);

    @Query("SELECT sa.student FROM SubjectAttending sa WHERE sa.assessment < 6 AND sa.subjectRealization.subject.id = ?1")
    Iterable<Student> findStudentXSubject(Long subjectId); //Student didnt passed subject;

    //AverageAssessment
    @Query("SELECT AVG(sa.assessment) FROM SubjectAttending sa WHERE sa.student.id = ?1")
    Double findAverageAssessment(Long studentId);

}
