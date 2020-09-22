package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT s FROM Student s WHERE s.regUser.username = ?1")
    Optional<Student> getByUsername(String username);
    @Query("SELECT s FROM Student s WHERE s.personalData.upin = ?1")
    Optional<Student> findStudentByUpin(String upin);
    @Query("SELECT s FROM Student s WHERE s.personalData.name LIKE ?1")
    Iterable<Optional<Student>> findStudentByName(String name);
}
