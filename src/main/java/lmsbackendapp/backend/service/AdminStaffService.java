package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.*;
import lmsbackendapp.backend.repository.AdminStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminStaffService {
    @Autowired
    private AdminStaffRepository adminStaffRepo;
    @Autowired
    private LoginService loginSrvc;
    @Autowired
    private StudentService studentSrvc;
    @Autowired
    private StudyYearService studyYearSrvc;
    @Autowired
    private StudentInProgressService studentInProgressSrvc;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SubjectRealizationService subjectRealizationSrvc;
    @Autowired
    SubjectAttendingService subjectAttendingSrvc;

    public AdminStaffService(){}

    public Iterable<AdminStaff> getAdminStaff(){
        return adminStaffRepo.findAll();
    }
    public Optional<AdminStaff> getAdminStaffById(Long id){
        return adminStaffRepo.findById(id);
    }
    public void addAdminStaff(AdminStaff adminStaff){
        loginSrvc.addPermission(adminStaff.getRegUser(),"ROLE_ADMIN_STAFF");
        adminStaff.getRegUser().setPassword(passwordEncoder.encode(adminStaff.getRegUser().getPassword()));
        adminStaffRepo.save(adminStaff);
    }
    public void deleteAdminStaff(Long id){
        Optional<AdminStaff> adminStaffdel = adminStaffRepo.findById(id);
        AdminStaff a = adminStaffdel.get();
        a.setDeleted(true);
        adminStaffRepo.save(a);
    }
    //--------------Subscription stu for next year-----------------//
    public Boolean subStudentForNextYear(Long studentId, StudyYear studyYear){
        Optional<Student> student = studentSrvc.getStudentById(studentId);
        if(student.isPresent()){
            Optional<StudyYear> lastStudyYear = studyYearSrvc.getStudyYearById(studyYear.getId());
            Optional<StudyYear> nextStudyYear = studyYearSrvc.getNextStudyYearByStudyProgram(studyYear.getId());
            Optional<StudentInProgress> studentInProgress = studentInProgressSrvc.getStudentInProgressByStudyYearIdAndStudentId(lastStudyYear.get().getId(),student.get().getId());
            studentInProgress.get().setStudyYear(nextStudyYear.get());
            studentInProgressSrvc.editStudentInProgress(studentInProgress.get().getId(),studentInProgress.get());

            //------//

            Iterable<SubjectRealization> subjectRealizations = subjectRealizationSrvc.getSubjectRealizationByStudyYearId(nextStudyYear.get().getId());
            for(SubjectRealization sr: subjectRealizations){
                if (sr.getSubject().getRequired()){
                    subjectAttendingSrvc.addSubjectAttending(new SubjectAttending(null,student.get(),sr));
                }else if(!sr.getSubject().getRequired()){
                    for (SubjectElective se: student.get().getSubjectElective()){
                        if (se.getSubjectRealization().getId() == se.getId()){
                            subjectAttendingSrvc.addSubjectAttending(new SubjectAttending(null,student.get(),sr));
                        }
                    }
                }
            }return true;

        }return false;
    }
}
