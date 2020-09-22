package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.Student;
import lmsbackendapp.backend.repository.StudentExtendRepositoryImpl;
import lmsbackendapp.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private StudentExtendRepositoryImpl studentExtendRepo;
    @Autowired
    RegUserService regUserSrvc;
    @Autowired
    private AddressService adrsSrvc;
    @Autowired
    private PersonalDataService pdSrvc;
    @Autowired
    private LoginService loginSrvc;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public StudentService(){}

    public Iterable<Student> getStudent() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(id);
    }
    public Optional<Student> getStudentByUsername(String username) {
        return studentRepo.getByUsername(username);
    }

    public  void addStudent(Student student){
        loginSrvc.addPermission(student.getRegUser(),"ROLE_STUDENT");
        student.getRegUser().setPassword(passwordEncoder.encode(student.getRegUser().getPassword()));
        studentRepo.save(student);
    }
    public void editStudent(String username,Student student){
        Optional<Student> stdntEdt = studentRepo.getByUsername(username);
        if (stdntEdt.isPresent()){
            student.setId(stdntEdt.get().getId());
            student.getRegUser().setPassword(passwordEncoder.encode(student.getRegUser().getPassword()));
            regUserSrvc.editRegUser(student.getRegUser().getId(),student.getRegUser());
            adrsSrvc.editAddress(student.getAddress().getId(),student.getAddress());
            pdSrvc.editPersonalData(student.getPersonalData().getId(),student.getPersonalData());
        }
    }
    public void deleteStudent(Long id) {
        Optional<Student> student = studentRepo.findById(id);
        Student s = student.get();
        s.setDeleted(true);
        studentRepo.save(s);
    }

    public Iterable<Optional<Student>> getStudentByName(String name){
        return studentRepo.findStudentByName("%"+name+"%");
    }
    public Optional<Student> getStudentByUpin(String upin){
        return studentRepo.findStudentByUpin(upin);
    }
    public Collection<Student> searchStudent(String name,String lastname,String indexNumber,String subscription,String averageAssessment){
        return studentExtendRepo.searchStudent(name,lastname,indexNumber,subscription,averageAssessment);
    }
}
