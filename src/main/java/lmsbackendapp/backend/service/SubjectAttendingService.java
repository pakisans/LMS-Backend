package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.Student;
import lmsbackendapp.backend.model.Subject;
import lmsbackendapp.backend.model.SubjectAttending;
import lmsbackendapp.backend.repository.SubjectAttendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SubjectAttendingService {
    @Autowired
    SubjectAttendingRepository subjectAttendingRepo;
    public SubjectAttendingService(){}

    public Iterable<SubjectAttending> getSubjectAttending(){
        return subjectAttendingRepo.findAll();
    }
    public Optional<SubjectAttending> getSubjectAttendingById(Long id){
        return subjectAttendingRepo.findById(id);
    }
    public void addSubjectAttending(SubjectAttending subjectAttending){
        subjectAttendingRepo.save(subjectAttending);
    }
    public void editSubjectAttending(Long id, SubjectAttending subjectAttending){
        Optional<SubjectAttending> subjectAttendingEdt = subjectAttendingRepo.findById(id);
        if (subjectAttendingEdt.isPresent()){
            subjectAttending.setId(subjectAttendingEdt.get().getId());
            subjectAttendingRepo.save(subjectAttending);
        }

    }
    public void deleteSubjectAttending(Long id){
        Optional<SubjectAttending> subjectAtDel = getSubjectAttendingById(id);
        subjectAttendingRepo.delete(subjectAtDel.get());
    }
    public Double getAvgAssessment(Long studentId){
        return subjectAttendingRepo.findAverageAssessment(studentId);
    }
    public Iterable<Student> getStudentNotPassExam(Long subjectId){
        return subjectAttendingRepo.findStudentXSubject(subjectId);
    }
    public ArrayList<Subject> getCurrentSubjects(String username){
        return subjectAttendingRepo.findCurrentSubject(username);
    }
    public ArrayList<Object> getPassedSubjects(String username){
        return subjectAttendingRepo.findPassedSubjects(username);
    }
    public ArrayList<Student> getStudentBySubject(Long subjectId,String professorUsername){
        java.sql.Date today = new java.sql.Date(0);
        return subjectAttendingRepo.findStudentBySubject(subjectId,today,professorUsername);
    }
}
