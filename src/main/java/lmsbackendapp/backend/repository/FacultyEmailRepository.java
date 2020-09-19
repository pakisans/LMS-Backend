package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.FacultyEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyEmailRepository extends JpaRepository<FacultyEmail,Long> {
}
