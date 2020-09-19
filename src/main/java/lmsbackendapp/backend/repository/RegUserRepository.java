package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.RegUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegUserRepository extends JpaRepository<RegUser,Long> {
    Optional<RegUser> findByUsername(String username);
}
