package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.Professor;
import lmsbackendapp.backend.model.ProfessorOnRealization;
import lmsbackendapp.backend.repository.ProfessorOnRealizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorOnRealizationService {
    @Autowired
    private ProfessorOnRealizationRepository profOnRealRepo;
    public ProfessorOnRealizationService(){}

    public Iterable<ProfessorOnRealization> getProfessorOnRealization(){
        return profOnRealRepo.findAll();
    }
    public Iterable<Optional<ProfessorOnRealization>> getProfessorOnRealizationByStudyYear(long studyYear){
        return profOnRealRepo.getByStudyYear(studyYear);
    }

    public Optional<ProfessorOnRealization> getProfessorOnRealizationById(Long id){
        return profOnRealRepo.findById(id);
    }

    public void addProfessorOnRealization(ProfessorOnRealization professorOnRealization) {
        profOnRealRepo.save(professorOnRealization);
    }
    public void editProfessorOnRealization(Long id, ProfessorOnRealization professorOnRealization) {
        Optional<ProfessorOnRealization> profOnEdt = profOnRealRepo.findById(id);
        if(profOnEdt.isPresent()) {
            professorOnRealization.setId(profOnEdt.get().getId());
            profOnRealRepo.save(professorOnRealization);
        }
    }
    public void deleteProfessorOnRealization(Long id) {
        Optional<ProfessorOnRealization> professorOnRealization = profOnRealRepo.findById(id);
        profOnRealRepo.delete(professorOnRealization.get());
    }

    public Iterable<Professor> getProfessorForSubject(Long subjectId) {
        return profOnRealRepo.findProfessorForSubject(subjectId);
    }
}

