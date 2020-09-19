package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<Result,Long> {
    Iterable<Optional<Result>> findBySubjectId(Long id);
}
