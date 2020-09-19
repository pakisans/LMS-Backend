package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    @Query("SELECT s FROM Admin s WHERE s.regUser.username = ?1")
    Optional<Admin> getByUsername(String username);
}
