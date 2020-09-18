package lmsbackendapp.backend.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class StudyYear {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

//    @JsonView()
    @OneToMany(mappedBy="studyYear")
    private Set<SubjectRealization> subjectRealization;

    @ManyToOne(cascade= CascadeType.ALL)
    private StudyProgram studyProgram;

//    @JsonView()
    @OneToMany(mappedBy="studyYear")
    private Set<StudentInProgress> studentInProgresses;

    public StudyYear() {}

    public StudyYear(Long id, int year, Date startDate, Date endDate, Set<SubjectRealization> subjectRealization, StudyProgram studyProgram,
                         Set<StudentInProgress> studentInProgresses) {
        super();
        this.id = id;
        this.year = year;
        this.startDate = startDate;
        this.endDate= endDate;
        this.subjectRealization = subjectRealization;
        this.studyProgram = studyProgram;
        this.studentInProgresses = studentInProgresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<SubjectRealization> getSubjectRealization() {
        return subjectRealization;
    }

    public void setSubjectRealization(Set<SubjectRealization> subjectRealization) {
        this.subjectRealization = subjectRealization;
    }

    public StudyProgram getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(StudyProgram studyProgram) {
        this.studyProgram = studyProgram;
    }

    public Set<StudentInProgress> getStudentInProgresses() {
        return studentInProgresses;
    }

    public void setStudentInProgresses(Set<StudentInProgress> studentInProgresses) {
        this.studentInProgresses = studentInProgresses;
    }
}
