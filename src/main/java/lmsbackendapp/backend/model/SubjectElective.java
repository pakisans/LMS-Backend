package lmsbackendapp.backend.model;

import javax.persistence.*;

@Entity
public class SubjectElective {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade= CascadeType.ALL)
    private Student student;

    @ManyToOne(cascade=CascadeType.ALL)
    private SubjectRealization subjectRealization;

    public SubjectElective() {}

    public SubjectElective(Student student, SubjectRealization subjectRealization){
        this.student = student;
        this.subjectRealization = subjectRealization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SubjectRealization getSubjectRealization() {
        return subjectRealization;
    }

    public void setSubjectRealization(SubjectRealization subjectRealization) {
        this.subjectRealization = subjectRealization;
    }
}
