package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.TeachingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachingTypeRepository extends JpaRepository<TeachingType,Long> {



}
