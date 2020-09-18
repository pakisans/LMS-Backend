package lmsbackendapp.backend.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SubjectRealization {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

//    @JsonView()
    @OneToMany(mappedBy="subjectRealization")
    private Set<ProfessorOnRealization> professorOnRealization;

//    @JsonView()
    @OneToMany(mappedBy="subjectRealization")
    private Set<Result> result;

//    @JsonView()
    @OneToMany(mappedBy="subjectRealization")
    private Set<TeachingTerm> teachingTerm;


    @ManyToOne(cascade= CascadeType.ALL)
    private Subject subject;

    @ManyToOne(cascade=CascadeType.ALL)
    private StudyYear studyYear;

//    @JsonView()
    @OneToMany(mappedBy="subjectRealization")
    private Set<TeachingMaterials> teachingMaterials;


    public SubjectRealization() {}

    public SubjectRealization(Set<ProfessorOnRealization> professorOnRealization, Set<Result> result, Set<TeachingTerm> teachingTerm,
                               Subject subject, StudyYear studyYear, Set<TeachingMaterials> teachingMaterials) {
        super();
        this.professorOnRealization = professorOnRealization;
        this.result = result;
        this.teachingTerm = teachingTerm;
        this.subject = subject;
        this.studyYear = studyYear;
        this.teachingMaterials = teachingMaterials;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ProfessorOnRealization> getProfessorOnRealization() {
        return professorOnRealization;
    }

    public void setProfessorOnRealization(Set<ProfessorOnRealization> professorOnRealization) {
        this.professorOnRealization = professorOnRealization;
    }

    public Set<Result> getResult() {
        return result;
    }

    public void setResult(Set<Result> result) {
        this.result = result;
    }

    public Set<TeachingTerm> getTeachingTerm() {
        return teachingTerm;
    }

    public void setTeachingTerm(Set<TeachingTerm> teachingTerm) {
        this.teachingTerm = teachingTerm;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public StudyYear getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(StudyYear studyYear) {
        this.studyYear = studyYear;
    }

    public Set<TeachingMaterials> getTeachingMaterials() {
        return teachingMaterials;
    }

    public void setTeachingMaterials(Set<TeachingMaterials> teachingMaterials) {
        this.teachingMaterials = teachingMaterials;
    }
}
