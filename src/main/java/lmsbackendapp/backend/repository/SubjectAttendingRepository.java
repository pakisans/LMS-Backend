package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.Student;
import lmsbackendapp.backend.model.Subject;
import lmsbackendapp.backend.model.SubjectAttending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
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

    @Query("SELECT sa.assessment, sa.subjectRealization.subject.name, sa.subjectRealization.studyYear.year, "
            + "sa.subjectRealization.studyYear.studyProgram.name, et.points, et.colloquium.startTime, sa.subjectRealization.subject.espb \n" +
            "FROM ExamTaking et, SubjectAttending sa \n" +
            "WHERE sa.student.regUser.username = ?1 \n" +
            "AND sa.subjectRealization.id = et.colloquium.subjectRealization.id "
            + "AND sa.assessment IS NOT NULL")
    ArrayList<Object> findPassedSubjects(String username);

    @Query("SELECT sa.student FROM SubjectAttending sa, ProfessorOnRealization pr "
            + "WHERE sa.subjectRealization.subject.id = ?1 "
            + "AND sa.subjectRealization.studyYear.startDate <= ?2 "
            + "AND sa.subjectRealization.studyYear.endDate >= ?2 "
            + "AND sa.subjectRealization.subject = pr.subjectRealization.subject "
            + "AND pr.professor.regUser.username = ?3")
    ArrayList<Student> findStudentBySubject(Long predmetId, Date today, String professorUsername);


}
