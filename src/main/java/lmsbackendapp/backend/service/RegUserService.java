package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.RegUser;
import lmsbackendapp.backend.repository.RegUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegUserService {
    @Autowired
    private RegUserRepository regUserRepo;
    public RegUserService(){

    }

    public Iterable<RegUser> getRegUser(){
        return regUserRepo.findAll();
    }
    public Optional<RegUser> getRegUserById(Long id){
        return regUserRepo.findById(id);
    }
    public Optional<RegUser> getRegUserByUsername(String username){
        return regUserRepo.findByUsername(username);
    }
    public void addRegUser(RegUser regUser){
        regUserRepo.save(regUser);
    }
    public void editRegUser(Long id,RegUser regUser){
        Optional<RegUser> Account = regUserRepo.findById(id);
        if(Account.isPresent()){
            regUser.setId(Account.get().getId());
            regUserRepo.save(regUser);
        }
    }
    public  void deleteRegUser(Long id){
        Optional<RegUser> regUser = regUserRepo.findById(id);
        regUserRepo.delete(regUser.get());
    }
}
