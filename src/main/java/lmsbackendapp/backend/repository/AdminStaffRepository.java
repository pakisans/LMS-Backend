package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.AdminStaff;
import lmsbackendapp.backend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminStaffRepository extends JpaRepository<AdminStaff,Long> {
    @Query("SELECT DISTINCT s, sy.studyYear.year FROM Student s JOIN s.studentInProgress sy JOIN s.subjectAttending sa JOIN sa.subjectRealization sr WHERE sy.studyYear.id=?1 AND sa.assessment IS NOT NULL GROUP BY s.id HAVING (SUM(sr.subject.espb))>=(48*(sy.studyYear.year))")
    Iterable<Student> findStudentForNextYear(Long studyYearId);
}
