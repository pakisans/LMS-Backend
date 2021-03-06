package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalData,Long> {
    @Query("SELECT p FROM PersonalData p WHERE p.pathProfilePic LIKE ?1")
    Optional<PersonalData> getByUsername(String username);
}
