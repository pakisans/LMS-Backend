package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.UniversityEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UniversityEmailRepository extends JpaRepository<UniversityEmail,Long> {


    ArrayList<UniversityEmail> findByUniversityIdEquals(Long id);
}
