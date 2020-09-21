package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.Dissertation;
import lmsbackendapp.backend.model.DissertationFile;
//import lmsbackendapp.backend.repository.DissertationRepository;
import lmsbackendapp.backend.repository.DissertationFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DisertationFileService {
    @Autowired
    DissertationFileRepository dissFileRepo;

    public Iterable<DissertationFile> getDisserationFile(){
        return dissFileRepo.findAll();
    }
    public Optional<DissertationFile> getDissertationFileById(Long id){
        return dissFileRepo.findById(id);
    }
    public void addDissertationFile(DissertationFile dissertationFile){
        dissFileRepo.save(dissertationFile);
    }
    public void editDissertationFile(Long id, DissertationFile dissertationFile){
        Optional<DissertationFile> dissFileEdt = dissFileRepo.findById(id);
        if(dissFileEdt.isPresent()){
            dissertationFile.setId(dissFileEdt.get().getId());
            dissFileRepo.save(dissertationFile);
        }
    }
    public void deleteDisserationFile(Long id){
        Optional<DissertationFile> dissFileDel = dissFileRepo.findById(id);
        if (dissFileDel.isPresent()){
            dissFileRepo.delete(dissFileDel.get());
        }
    }
}
