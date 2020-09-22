package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.StudyYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface StudyYearRepository extends JpaRepository<StudyYear,Long> {
    @Query("SELECT y from StudyYear y WHERE y.year=?1 AND y.studyProgram.id=?2")
    Optional<StudyYear> getNextStudyYear(int year, Long id);
    ArrayList<StudyYear> findByStudyProgramEq(Long studyProgramId);
}
