package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.UniversityPhoneNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UniversityPhoneNumbersRepository extends JpaRepository<UniversityPhoneNumbers,Long> {
    ArrayList<UniversityPhoneNumbers> findByUniversityIdEq(Long id);
}
