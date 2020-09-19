package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.TeachingTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeachingTermRepository extends JpaRepository<TeachingTerm,Long> {
    @Query("SELECT tt FROM  TeachingTerm tt WHERE tt.subjectRealization.studyYear.id = ?1")
    Iterable<Optional<TeachingTerm>> getByStudyYear(Long studyYearId);
}
