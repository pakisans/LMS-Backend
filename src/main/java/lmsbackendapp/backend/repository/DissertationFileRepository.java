package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.DissertationFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DissertationFileRepository extends JpaRepository<DissertationFile,Long> {
}
