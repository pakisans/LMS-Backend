package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.AdminStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminStaffRepository extends JpaRepository<AdminStaff,Long> {
}
