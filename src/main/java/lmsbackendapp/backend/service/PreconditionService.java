package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.Precondition;
import lmsbackendapp.backend.repository.PreconditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PreconditionService {
    @Autowired
    PreconditionRepository preconditionRepo;

    public Iterable<Precondition> getPrecondition() {
        return preconditionRepo.findAll();
    }

    public Optional<Precondition> getPreconditionById(Long id) {
        return preconditionRepo.findById(id);
    }

    public void addPrecondition(Precondition precondition) {
        preconditionRepo.save(precondition);
    }

    public void deletePrecondition(Long id) {
        Optional<Precondition> pre = preconditionRepo.findById(id);
        if(pre.isPresent()) {
            preconditionRepo.delete(pre.get());
        }
    }
    public void editPrecondition(Long id, Precondition precondition) {
        Optional<Precondition> pre = preconditionRepo.findById(id);
        if(pre.isPresent()) {
            precondition.setId(pre.get().getId());
            preconditionRepo.save(precondition);
        }
    }
}
