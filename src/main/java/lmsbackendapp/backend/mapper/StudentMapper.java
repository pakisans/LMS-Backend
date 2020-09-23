package lmsbackendapp.backend.mapper;

import lmsbackendapp.backend.dto.StudentDTO;
import lmsbackendapp.backend.model.Student;
import org.xmlunit.util.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class StudentMapper implements Mapper<Student, StudentDTO> {
    public Student toEntity(
            StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }
        Student returnValue = new Student();

        returnValue.setId(studentDTO.getId());
        return returnValue;
    }
    public Collection<Student> toEntityList(Collection<StudentDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }
        Collection<Student> collection = new ArrayList<Student>(dtoList.size());
        for (StudentDTO student : dtoList) {
            collection.add(toEntity(student));
        }
        return collection;
    }
    public StudentDTO toDTO(Student entity) {
        if (entity == null) {
            return null;
        }
        StudentDTO returnValue = new StudentDTO();
        returnValue.setId(entity.getId());
        returnValue.setEmail(entity.getRegUser().getEmail());
        returnValue.setName(entity.getPersonalData().getName());
        returnValue.setLastname(entity.getPersonalData().getLastname());
        returnValue.setPhoneNumber(entity.getPersonalData().getPhoneNumber());
        return returnValue;

    }
    public Collection<StudentDTO> toDtoList(Collection<Student> entityList) {
        if (entityList == null) {
            return null;
        }
        Collection<StudentDTO> collection = new ArrayList<StudentDTO>(entityList.size());
        for (Student student : entityList) {
            collection.add(toDTO(student));
        }

        return collection;
    }

    @Override
    public StudentDTO apply(Student from) {
        return null;
    }
}
