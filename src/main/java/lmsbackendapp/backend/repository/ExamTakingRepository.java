package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.ExamTaking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamTakingRepository extends JpaRepository<ExamTaking,Long> {
}
