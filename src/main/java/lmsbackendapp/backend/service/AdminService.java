package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.Admin;
import lmsbackendapp.backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepo;
    @Autowired
    private LoginService loginSrvc;
    @Autowired RegUserService regUserSrvc;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public AdminService(){}

    public Iterable<Admin> getAdmin(){
        return adminRepo.findAll();
    }
    public Optional<Admin> getAdminById(Long id){
        return adminRepo.findById(id);
    }
    public Optional<Admin> getAdminByUsername(String username){
        return adminRepo.getByUsername(username);
    }
    public void addAdmin(Admin admin){
        loginSrvc.addPermission(admin.getRegUser(),"ROLE_ADMINISTRATOR");
        admin.getRegUser().setPassword(passwordEncoder.encode(admin.getRegUser().getPassword()));
        adminRepo.save(admin);
    }
    public void editAdmin(String username,Admin admin){
        Optional<Admin> admn = adminRepo.getByUsername(username);
        if (admn.isPresent()){
            admin.setId(admn.get().getId());
            admin.getRegUser().setPassword(passwordEncoder.encode(admin.getRegUser().getPassword()));
            regUserSrvc.editRegUser(admin.getRegUser().getId(),admin.getRegUser());
        }
    }
    public void deleteAdmin(Long id){
        Optional<Admin> addmn = adminRepo.findById(id);
        Admin a = addmn.get();
        a.setDeleted(true);
        adminRepo.save(a);
    }

}
