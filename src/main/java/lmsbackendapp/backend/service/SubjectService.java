package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.Result;
import lmsbackendapp.backend.model.Subject;
import lmsbackendapp.backend.repository.ResultRepository;
import lmsbackendapp.backend.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepo;
    @Autowired
    private ResultRepository resultRepo;
    public SubjectService(){}

    public Iterable<Subject> getSubject() {
        return subjectRepo.findAll();
    }

    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepo.findById(id);
    }

    public void addSubject(Subject Subject) {
        subjectRepo.save(Subject);
    }
    public void editSubject(Long id, Subject Subject) {
        Optional<Subject> Pr = subjectRepo.findById(id);
        if(Pr.isPresent()) {
            Subject.setId(Pr.get().getId());
            subjectRepo.save(Subject);
        }
    }
    public void deleteSubject(Long id) {
        Optional<Subject> Subject = subjectRepo.findById(id);
        Subject s = Subject.get();
        s.setDeleted(true);
        subjectRepo.save(s);
    }

    public Iterable<Optional<Subject>> getSubjectByName(String name){
        return subjectRepo.findByNameLike("%"+name+"%");
    }

    public ArrayList<Result> getSylabus(Long subjectId) {
        return resultRepo.findBySubjectIdEquals(subjectId);
    }

}
