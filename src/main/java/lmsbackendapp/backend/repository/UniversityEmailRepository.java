package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.UniversityEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityEmailRepository extends JpaRepository<UniversityEmail,Long> {
}
