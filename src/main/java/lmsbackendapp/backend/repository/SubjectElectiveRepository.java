package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.SubjectElective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectElectiveRepository extends JpaRepository<SubjectElective,Long> {
}
