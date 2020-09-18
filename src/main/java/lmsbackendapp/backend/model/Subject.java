package lmsbackendapp.backend.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Where(clause = "deleted = 'false'")
public class Subject {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=64, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer espb;

    @Column(nullable = false)
    private Boolean required;

    @Column(nullable = false)
    private Integer numberLecture;

    @Column(nullable = false)
    private Integer numberExercises;

    @Column(nullable = false)
    private Integer otherFromsOfTeaching;

    @Column(nullable = false)
    private Integer research;

    @Column(nullable = false)
    private Integer otherSubjects;

//    @JsonView()
    @OneToMany(mappedBy="subject")
    private Set<Result> syllabus;

    @ManyToMany
    private Set<Subject> precondition;

//    @JsonView()
    @ManyToMany(mappedBy="precondition")
    private Set<Subject> preconditionFor;

//    @JsonView()
    @ManyToOne(cascade= CascadeType.ALL)
    private StudyYear studyYear;

    @NotNull
    private Boolean deleted = false;

    public Subject() {}

    public Subject(String name, Integer espb, Boolean required, Integer numberLecture, Integer numberExercises,
                   Integer otherFromsOfTeaching, Integer research, Integer otherSubjects, Set<Result> syllabuss,
                   Set<Subject> precondition, Set<Subject> preconditionFor, StudyYear studyYear, Boolean deleted) {
        super();
        this.name = name;
        this.espb = espb;
        this.required = required;
        this.numberLecture = numberLecture;
        this.numberExercises = numberExercises;
        this.otherFromsOfTeaching = otherFromsOfTeaching;
        this.research = research;
        this.otherSubjects = otherSubjects;
        this.syllabus = syllabuss;
        this.precondition = precondition;
        this.preconditionFor = preconditionFor;
        this.studyYear = studyYear;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEspb() {
        return espb;
    }

    public void setEspb(Integer espb) {
        this.espb = espb;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Integer getNumberLecture() {
        return numberLecture;
    }

    public void setNumberLecture(Integer numberLecture) {
        this.numberLecture = numberLecture;
    }

    public Integer getNumberExercises() {
        return numberExercises;
    }

    public void setNumberExercises(Integer numberExercises) {
        this.numberExercises = numberExercises;
    }

    public Integer getOtherFromsOfTeaching() {
        return otherFromsOfTeaching;
    }

    public void setOtherFromsOfTeaching(Integer otherFromsOfTeaching) {
        this.otherFromsOfTeaching = otherFromsOfTeaching;
    }

    public Integer getResearch() {
        return research;
    }

    public void setResearch(Integer research) {
        this.research = research;
    }

    public Integer getOtherSubjects() {
        return otherSubjects;
    }

    public void setOtherSubjects(Integer otherSubjects) {
        this.otherSubjects = otherSubjects;
    }

    public Set<Result> getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(Set<Result> syllabus) {
        this.syllabus = syllabus;
    }

    public Set<Subject> getPrecondition() {
        return precondition;
    }

    public void setPrecondition(Set<Subject> precondition) {
        this.precondition = precondition;
    }

    public Set<Subject> getPreconditionFor() {
        return preconditionFor;
    }

    public void setPreconditionFor(Set<Subject> preconditionFor) {
        this.preconditionFor = preconditionFor;
    }

    public StudyYear getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(StudyYear studyYear) {
        this.studyYear = studyYear;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
