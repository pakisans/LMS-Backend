package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.FacultyEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FacultyEmailRepository extends JpaRepository<FacultyEmail,Long> {
    ArrayList<FacultyEmail> findByFacultyIdEquals(Long id);
}
