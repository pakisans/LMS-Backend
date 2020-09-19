package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.FacultyPhoneNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FacultyPhoneNumbersRepository extends JpaRepository<FacultyPhoneNumbers,Long> {
    ArrayList<FacultyPhoneNumbers> findByFacultyIdEq(Long id);
}
