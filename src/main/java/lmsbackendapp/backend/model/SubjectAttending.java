package lmsbackendapp.backend.model;

import javax.persistence.*;

@Entity
public class SubjectAttending {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Integer assessment;

    @ManyToOne(cascade= CascadeType.ALL)
    private Student student;

    @ManyToOne(cascade=CascadeType.ALL)
    private SubjectRealization subjectRealization;

    public SubjectAttending() {}

    public SubjectAttending(Integer assessment, Student student, SubjectRealization subjectRealization){
        this.assessment = assessment;
        this.student = student;
        this.subjectRealization = subjectRealization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAssessment() {
        return assessment;
    }

    public void setAssessment(Integer assessment) {
        this.assessment = assessment;
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
