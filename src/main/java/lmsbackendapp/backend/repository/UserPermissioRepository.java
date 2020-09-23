package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserPermissioRepository extends JpaRepository<UserPermission,Long> {
    Set<UserPermissioRepository> getByRegUserId(Long id);
}
