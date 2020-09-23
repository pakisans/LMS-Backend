package lmsbackendapp.backend.mapper;

import lmsbackendapp.backend.dto.StudentDetailsDTO;
import lmsbackendapp.backend.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class StudentDetailsMapper implements Mapper<Student, StudentDetailsDTO> {
    @Autowired
    StudentInProgressMapper studentInProgressMapper;

    @Override
    public StudentDetailsDTO toDTO(Student e) {
        if (e==null)return null;
        StudentDetailsDTO returnValue = new StudentDetailsDTO();
        returnValue.setId(e.getId());
        returnValue.setName(e.getPersonalData().getName());
        returnValue.setLastname(e.getPersonalData().getLastname());
        returnValue.setEmail(e.getRegUser().getEmail());
        returnValue.setPathToProfilePic(e.getPersonalData().getPathProfilePic());
        returnValue.setStudentInProgres(studentInProgressMapper.toDTO(e.getStudentInProgress()));
        return returnValue;
    }

    @Override
    public Student toEntity(StudentDetailsDTO edto) {
        return null;
    }

    @Override
    public Collection<StudentDetailsDTO> toDTO(Collection<Student> es) {
        if (es.size()==0)return null;
        Collection<StudentDetailsDTO> students = new ArrayList<StudentDetailsDTO>(es.size());
        for(Student e : es){
            students.add(toDTO(e));
        }return students;
    }

    @Override
    public Collection<Student> toEntityList(Collection<StudentDetailsDTO> edtos) {
        return null;
    }
}
