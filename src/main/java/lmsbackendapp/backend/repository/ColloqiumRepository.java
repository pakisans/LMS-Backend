package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.Colloquium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ColloqiumRepository extends JpaRepository<Colloquium,Long> {
    @Query("SELECT sa.assessment, sa.subjectRealization.subject.name, sa.subjectRealization.studyYear.year, sa.subjectRealization.studyYear.studyProgram.name, et.points, et.colloquium.startTime, sa.subjectRealization.subject.espb "
            + "FROM ExamTaking et, SubjectAttending sa "
            + "WHERE sa.student.id = ?1 AND sa.assessment IS NOT NULL AND et.points IS NOT NULL AND et.colloquium.colloquiumType.name = 'FINAL' "
            + "AND sa.subjectRealization.id = et.colloquium.subjectRealization.id")
    ArrayList<Object[]> getExamByStudent(Long studentId);
}
