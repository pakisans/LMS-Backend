package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.Precondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreconditionRepository extends JpaRepository<Precondition,Long> {

}
