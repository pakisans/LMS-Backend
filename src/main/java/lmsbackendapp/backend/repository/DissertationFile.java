package lmsbackendapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DissertationFile extends JpaRepository<DissertationFile,Long> {
}
