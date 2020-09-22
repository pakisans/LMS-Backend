package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.TeachingType;
import lmsbackendapp.backend.repository.TeachingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeachingTypeService {
    @Autowired
    TeachingTypeRepository teachTypeRepo;

    public Iterable<TeachingType> getTeachingType() {
        return teachTypeRepo.findAll();
    }
    public Optional<TeachingType> getTeachingTypeById(Long id) {
        return teachTypeRepo.findById(id);
    }
    public void addTeachingType(TeachingType teachingType) {
        teachTypeRepo.save(teachingType);
    }
    public void editTeachingType(Long id, TeachingType teachingType) {
        Optional<TeachingType> typ = teachTypeRepo.findById(id);
        if(typ.isPresent()) {
            teachingType.setId(typ.get().getId());
            teachTypeRepo.save(teachingType);
        }
    }
    public void deleteTeachingType(Long id) {
        Optional<TeachingType> teachingType = teachTypeRepo.findById(id);
        teachTypeRepo.delete(teachingType.get());
    }

}
