package lmsbackendapp.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProfessorOnRealization {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer subjectNumber;

    @ManyToOne(cascade= CascadeType.ALL)
    private TeachingType teachingType;

    @ManyToOne(cascade=CascadeType.ALL)
    private Professor professor;

    @ManyToOne(cascade=CascadeType.ALL)
    private SubjectRealization subjectRealization;

    @ManyToOne(cascade=CascadeType.ALL)
    private PersonalData personalData;

    public ProfessorOnRealization() {}

    public ProfessorOnRealization(Long id, Integer subjectNumber, TeachingType teachingType, Professor professor,
                                  SubjectRealization subjectRealization, PersonalData personalData) {
        super();
        this.id = id;
        this.subjectNumber = subjectNumber;
        this.teachingType = teachingType;
        this.professor = professor;
        this.subjectRealization = subjectRealization;
        this.personalData = personalData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSubjectNumber() {
        return subjectNumber;
    }

    public void setSubjectNumber(Integer subjectNumber) {
        this.subjectNumber = subjectNumber;
    }

    public TeachingType getTeachingType() {
        return teachingType;
    }

    public void setTeachingType(TeachingType teachingType) {
        this.teachingType = teachingType;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public SubjectRealization getSubjectRealization() {
        return subjectRealization;
    }

    public void setSubjectRealization(SubjectRealization subjectRealization) {
        this.subjectRealization = subjectRealization;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }
}
