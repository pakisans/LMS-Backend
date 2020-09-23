package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.*;
import lmsbackendapp.backend.repository.FacultyEmailRepository;
import lmsbackendapp.backend.repository.FacultyPhoneNumbersRepository;
import lmsbackendapp.backend.repository.FacultyRepository;
import lmsbackendapp.backend.repository.StudyProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FacultyService {
    @Autowired
    FacultyRepository facultyRepo;
    @Autowired
    private StudyProgramRepository studyPRepo;
    @Autowired
    private FacultyPhoneNumbersRepository facultyPhoneNumbersRepo;
    @Autowired
    private FacultyEmailRepository facultyEmailRepo;

    public Iterable<Faculty> getFaculty(){
        return facultyRepo.findAll();
    }
    public Optional<Faculty> getFacultyById(Long id){
        return facultyRepo.findById(id);
    }
    public void addFaculty(Faculty faculty){
        facultyRepo.save(faculty);
    }
    public void editFaculty(Long id,Faculty faculty){
        Optional<Faculty> editFac = facultyRepo.findById(id);
        if(editFac.isPresent()){
            faculty.setId(editFac.get().getId());
            facultyRepo.save(faculty);
        }
    }
    public void deleteFaculty(Long id){
        Optional<Faculty> delFac = facultyRepo.findById(id);
        if(delFac.isPresent()){
            facultyRepo.delete(delFac.get());
        }
    }

    public ArrayList<StudyProgram> getStudyProgram(Long facultyId){
        return studyPRepo.findByFacultyEquals(facultyId);
    }
    public ArrayList<Phone> getFacultyPhone(Long facultyId){
        ArrayList<FacultyPhoneNumbers> phonesId = facultyPhoneNumbersRepo.findByFacultyIdEquals(facultyId);
        ArrayList<Phone> phones = new ArrayList<Phone>();
        for (FacultyPhoneNumbers p : phonesId){
            phones.add(p.getPhone());
        }return phones;
    }
    public ArrayList<Email> getFacultyEmail(Long facultyId){
        ArrayList<FacultyEmail> facEmail = facultyEmailRepo.findByFacultyIdEquals(facultyId);
        ArrayList<Email> emails = new ArrayList<Email>();
        for (FacultyEmail ep : facEmail){
            emails.add(ep.getEmail());
        }return emails;
    }

}
