package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.Student;

import java.util.Collection;

public interface StudentExtendRepository {
    Collection<Student> searchStudent(String name,String lastname,String indexNumber,String subscription,String averageAssessment);
}
