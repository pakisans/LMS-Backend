package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.ProfessorOnRealization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorOnRealizationRepository extends JpaRepository<ProfessorOnRealization,Long> {

}
