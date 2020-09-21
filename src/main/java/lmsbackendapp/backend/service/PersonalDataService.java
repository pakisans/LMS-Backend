package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.PersonalData;
import lmsbackendapp.backend.repository.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalDataService {
    @Autowired
    private PersonalDataRepository personalDataRepo;
    public PersonalDataService(){}

    public Iterable<PersonalData> getPersonalData(){
        return personalDataRepo.findAll();
    }
    public Optional<PersonalData> getPersonalDataById(long id){
        return personalDataRepo.findById(id);
    }
    public Optional<PersonalData> getPersonalDataByUsername(String username){
        return personalDataRepo.getByUsername("%/"+username+".%");
    }
    public void addPersonalData(PersonalData personalData){
        personalDataRepo.save(personalData);
    }
    public void editPersonalData(Long id,PersonalData personalData){
        Optional<PersonalData> pdEdt = personalDataRepo.findById(id);
        if (pdEdt.isPresent()){
            personalData.setId(pdEdt.get().getId());
            personalDataRepo.save(personalData);
        }
    }
    public void deletePersonalData(Long id){
        Optional<PersonalData> prDataDel = personalDataRepo.findById(id);
        personalDataRepo.delete(prDataDel.get());
    }
}
