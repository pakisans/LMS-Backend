package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.ColloquiumType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColloquiumTypeRepository extends JpaRepository<ColloquiumType,Long> {
}
