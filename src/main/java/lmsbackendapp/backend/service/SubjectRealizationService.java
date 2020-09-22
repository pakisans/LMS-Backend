package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.Professor;
import lmsbackendapp.backend.model.SubjectRealization;
import lmsbackendapp.backend.repository.SubjectRealizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectRealizationService {
    @Autowired
    private SubjectRealizationRepository subjectRealizationRepo;
    public SubjectRealizationService(){}

    public Iterable<SubjectRealization> getSubjectRealization(){
        return subjectRealizationRepo.findAll();
    }
    public Iterable<SubjectRealization> getSubjectRealizationByStudyYearId(Long id){
        return subjectRealizationRepo.findByStudyYearId(id);
    }
    public Optional<SubjectRealization> getSubjectRealizationId(Long id){
        return subjectRealizationRepo.findById(id);
    }
    public void addSubjectRealization(SubjectRealization subjectRealization){
        subjectRealizationRepo.save(subjectRealization);
    }
    public void editSubjectRealization(Long id,SubjectRealization subjectRealization){
        Optional<SubjectRealization> sbjctRealEdt = subjectRealizationRepo.findById(id);
        if (sbjctRealEdt.isPresent()){
            subjectRealization.setId(sbjctRealEdt.get().getId());
            subjectRealizationRepo.save(subjectRealization);
        }
    }
    public void deleteSubjectRealization(Long id){
        Optional<SubjectRealization> sbjctRelDel = subjectRealizationRepo.findById(id);
        subjectRealizationRepo.delete(sbjctRelDel.get());
    }



    public Iterable<Professor> getProfessorForExercises(Long subjectId){
        return subjectRealizationRepo.findProfesorForExercises(subjectId);
    }
}
