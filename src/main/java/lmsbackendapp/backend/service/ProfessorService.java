package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.Professor;
import lmsbackendapp.backend.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepo;
    @Autowired
    private LoginService loginSrvc;
    @Autowired
    private AddressService addressSrvc;
    @Autowired
    private  RegUserService regUserSrvc;
    @Autowired
    private PersonalDataService personalDataSrvc;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ProfessorService(){
    }

    public Iterable<Professor> getProfessor(){
        return professorRepo.findAll();
    }
    public Iterable<Optional<Professor>> getProfessorByFaculty(Long facultyId){
        return professorRepo.getAllByFaculty(facultyId);
    }
    public Optional<Professor> getProfessorById(Long id){
        return professorRepo.findById(id);
    }
    public Optional<Professor> getProfessorByUsername(String username){
        return professorRepo.getByUsername(username);
    }
    public void addProfessor(Professor professor){
        loginSrvc.addPermission(professor.getRegUser(),"ROLE_PROFESSOR");
        professor.getRegUser().setPassword(passwordEncoder.encode(professor.getRegUser().getPassword()));
        professorRepo.save(professor);
    }
    public void editProfessor(String username,Professor professor){
        Optional<Professor> profEdt = professorRepo.getByUsername(username);
        if(profEdt.isPresent()){
            professor.setId(profEdt.get().getId());
            professor.getRegUser().setPassword(passwordEncoder.encode(professor.getRegUser().getPassword()));
            regUserSrvc.editRegUser(professor.getRegUser().getId(),professor.getRegUser());
            addressSrvc.editAddress(professor.getAddress().getId(),professor.getAddress());
            personalDataSrvc.editPersonalData(professor.getPersonalData().getId(),professor.getPersonalData());

        }
    }
    public Iterable<Optional<Professor>> getProfessorByName(String name){
        return professorRepo.findProfessorByName("%"+name+"%");
    }
    public Optional<Professor> getProfessorByUpin(String upin){
        return professorRepo.findProfessorByUpin(upin);
    }
}
