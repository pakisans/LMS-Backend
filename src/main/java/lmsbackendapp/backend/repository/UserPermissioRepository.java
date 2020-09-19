package lmsbackendapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserPermissioRepository extends JpaRepository<UserPermissioRepository,Long> {
    Set<UserPermissioRepository> getByRegUserId(Long id);
}
