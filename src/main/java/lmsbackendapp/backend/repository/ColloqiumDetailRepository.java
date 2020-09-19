package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.ColloquimDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColloqiumDetailRepository extends JpaRepository<ColloquimDetail,Long> {
}
