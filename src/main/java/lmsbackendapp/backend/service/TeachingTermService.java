package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.TeachingTerm;
import lmsbackendapp.backend.repository.TeachingTermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeachingTermService {
    @Autowired
    private TeachingTermRepository teachingTermRepo;
    public TeachingTermService(){}

    public Iterable<TeachingTerm> getTeachingTerm(){
        return teachingTermRepo.findAll();
    }
    public Iterable<Optional<TeachingTerm>> getTeachingTermByStudyYear(Long studyYearId){
        return teachingTermRepo.getByStudyYear(studyYearId);
    }
    public Optional<TeachingTerm> getTeachingTermById(Long id){
        return teachingTermRepo.findById(id);
    }

    public void addTeachingTerm(TeachingTerm teachingTerm){
        teachingTermRepo.save(teachingTerm);
    }
    public void editTeachingTerm(Long id,TeachingTerm teachingTerm){
        Optional<TeachingTerm> teachTermEdt = teachingTermRepo.findById(id);
        if (teachTermEdt.isPresent()){
            teachingTerm.setId(teachTermEdt.get().getId());
            teachingTermRepo.save(teachingTerm);
        }
    }
    public void deleteTeachingTerm(Long id){
        Optional<TeachingTerm> techTermDel = teachingTermRepo.findById(id);
        TeachingTerm t = techTermDel.get();
        t.setDeleted(true);
        teachingTermRepo.save(t);
    }
}
