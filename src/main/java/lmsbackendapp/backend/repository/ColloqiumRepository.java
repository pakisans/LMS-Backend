package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.Colloquium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColloqiumRepository extends JpaRepository<Colloquium,Long> {
}
