package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.Phone;
import lmsbackendapp.backend.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhoneService {
    @Autowired
    PhoneRepository phoneRepo;

    public Iterable<Phone> getPhone(){
        return phoneRepo.findAll();
    }
    public Optional<Phone> getPhoneById(Long id){
        return phoneRepo.findById(id);
    }
    public void addPhone(Phone phone){
        phoneRepo.save(phone);
    }
    public void editPhone(Long id,Phone phone){
        Optional<Phone> phoneEdt = phoneRepo.findById(id);
        if(phoneEdt.isPresent()){
            phone.setId(phoneEdt.get().getId());
            phoneRepo.save(phone);
        }
    }
    public void deletePhone(Long id){
        Optional<Phone> phoneDel = phoneRepo.findById(id);
        if(phoneDel.isPresent()){
            phoneRepo.delete(phoneDel.get());
        }
    }

}
