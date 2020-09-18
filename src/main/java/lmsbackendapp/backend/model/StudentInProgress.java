package lmsbackendapp.backend.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class StudentInProgress {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date startDate;

    @Column(length=64, nullable = false)
    private String indexNumber;


    @ManyToOne(cascade= CascadeType.ALL)
    private Student student;

    @ManyToOne(cascade=CascadeType.ALL)
    private StudyYear studyYear;


    @OneToOne(mappedBy = "studentInProgress")
    private Dissertation dissertation;

//    @JsonView()
    @OneToMany(mappedBy="studentInProgress")
    private Set<ExamTaking> examTaking;

    public StudentInProgress() {}

    public StudentInProgress(Date startDate, String indexNumber, Student student, StudyYear studyYear,
                           Dissertation dissertation, Set<ExamTaking> examTaking ) {
        super();
        this.startDate = startDate;
        this.indexNumber = indexNumber;
        this.student = student;
        this.studyYear = studyYear;
        this.dissertation = dissertation;
        this.examTaking = examTaking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudyYear getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(StudyYear studyYear) {
        this.studyYear = studyYear;
    }

    public Dissertation getDissertation() {
        return dissertation;
    }

    public void setDissertation(Dissertation dissertation) {
        this.dissertation = dissertation;
    }

    public Set<ExamTaking> getExamTaking() {
        return examTaking;
    }

    public void setExamTaking(Set<ExamTaking> examTaking) {
        this.examTaking = examTaking;
    }
}
