package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.StudyProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StudyProgramRepository extends JpaRepository<StudyProgram,Long> {
    ArrayList<StudyProgram> findByFacultyEquals(Long id);
}
