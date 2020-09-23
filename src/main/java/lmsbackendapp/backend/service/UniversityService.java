package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.*;
import lmsbackendapp.backend.repository.UniversityEmailRepository;
import lmsbackendapp.backend.repository.UniversityPhoneNumbersRepository;
import lmsbackendapp.backend.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository univerRepo;
    @Autowired
    private UniversityPhoneNumbersRepository univerPhoneRepo;
    @Autowired
    private UniversityEmailRepository univerEmailRepo;

    public UniversityService(){}
    public Iterable<University> getUniversity(){
        return univerRepo.findAll();
    }
    public Optional<University> getUniversityById(Long id){
        return univerRepo.findById(id);
    }
    public void addUniversity(University university){
        univerRepo.save(university);
    }
    public void editUniversity(Long id,University university){
        Optional<University> univerEdt = univerRepo.findById(id);
        if(univerEdt.isPresent()){
            university.setId(univerEdt.get().getId());
            univerRepo.save(university);
        }
    }
    public void deleteUniver(Long id){
        Optional<University> univerDel = univerRepo.findById(id);
        univerRepo.delete(univerDel.get());
    }

    public ArrayList<Phone> getUniversityPhones(Long universityId){
        ArrayList<UniversityPhoneNumbers> phonesId = univerPhoneRepo.findByUniversityIdEquals(universityId);
        ArrayList<Phone> phones = new ArrayList<Phone>();
        for(UniversityPhoneNumbers p : phonesId) {
            phones.add(p.getPhone());
        }
        return phones;
    }
    public ArrayList<Email> getUniversityEmail(Long universityId) {
        ArrayList<UniversityEmail> emailsId = univerEmailRepo.findByUniversityIdEquals(universityId);
        ArrayList<Email> emails = new ArrayList<Email>();
        for(UniversityEmail e : emailsId) {
            emails.add(e.getEmail());
        }
        return emails;
    }
}
