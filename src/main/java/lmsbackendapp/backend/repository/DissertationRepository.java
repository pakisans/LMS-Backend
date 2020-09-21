package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.Dissertation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DissertationRepository extends JpaRepository<Dissertation,Long> {
    @Query("SELECT dis.title, dis.dateDeffense, "
            + "dis.mentor.personalData.name, dis.mentor.personalData.lastname, "
            + "dis.studentInProgress.studyYear.studyProgram.name "
            + "FROM Dissertation dis WHERE dis.studentInProgress.student.id = ?1")
    ArrayList<Object> findByStudentInProgressStudentId(Long studentId);
}
