package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.ScientificField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScientificFieldRepository extends JpaRepository<ScientificField,Long> {
}
