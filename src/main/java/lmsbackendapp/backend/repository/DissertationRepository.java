package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.Dissertation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DissertationRepository extends JpaRepository<Dissertation,Long> {
}
