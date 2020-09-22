package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.StudentInProgress;
import lmsbackendapp.backend.repository.StudentInProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentInProgressService {
    @Autowired
    private StudentInProgressRepository studentInPRepo;
    public StudentInProgressService(){}

    public Iterable<StudentInProgress> getStudentInProgress() {
        return studentInPRepo.findAll();
    }
    public Optional<StudentInProgress> getStudentInProgressById(Long id) {
        return studentInPRepo.findById(id);
    }
    public void addStudentInProgress(StudentInProgress studentInProgress) {
        studentInPRepo.save(studentInProgress);
    }
    public void editStudentInProgress(Long id, StudentInProgress studentInProgress) {
        Optional<StudentInProgress> stuEdt = studentInPRepo.findById(id);
        if(stuEdt.isPresent()) {
            studentInProgress.setId(stuEdt.get().getId());
            studentInPRepo.save(studentInProgress);
        }
    }
    public void deleteStudentInProgress(Long id) {
        Optional<StudentInProgress> studentInProgress = studentInPRepo.findById(id);
        studentInPRepo.delete(studentInProgress.get());
    }

    public Optional<StudentInProgress> getStudentInProgressByStudyYearIdAndStudentId(Long studyYearId, Long studentId) {
        return studentInPRepo.findByStudyYearAndStudentId(studyYearId, studentId);
    }

}
