package lmsbackendapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudyYear extends JpaRepository<StudyYear,Long> {
    @Query("SELECT y from StudyYear y WHERE y.year=?1 AND y.studyProgram.id=?2")
    Optional<StudyYear> getNextStudyYear(int year, Long id);
}
