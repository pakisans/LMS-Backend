package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.TeachingMaterials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeachingMaterialsRepository extends JpaRepository<TeachingMaterials,Long> {
    @Query("SELECT s FROM TeachingMaterials s WHERE s.subjectRealization.subject.id = ?1")
    Iterable<Optional<TeachingMaterials>> getAllBySubject(Long id);
}
