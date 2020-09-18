package lmsbackendapp.backend.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Colloquium {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date startTime;

    @Column
    private Date endTime;

    @Column(nullable = false)
    private Integer points;

    @Column(nullable = false)
    private Integer duration;

    @ManyToOne(cascade={CascadeType.REFRESH, CascadeType.MERGE})
    private SubjectRealization subjectRealization;

    @ManyToOne(cascade={CascadeType.REFRESH, CascadeType.MERGE})
    private ColloquiumType colloquiumType;

//    @JsonView()
    @OneToMany(mappedBy="colloquium")
    private Set<ExamTaking> examTaking;

//    @JsonView()
    @OneToMany(mappedBy="colloquium", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ColloquimDetail> syllabus;

    public Colloquium() {
        super();
    }

    public Colloquium(Date startTime, Date endTime, Integer points, Integer duration, SubjectRealization subjectRealization, ColloquiumType colloquiumType, Set<ExamTaking> examTaking,
                            Set<ColloquimDetail>
                                    syllabus) {
        super();
        this.startTime = startTime;
        this.endTime = endTime;
        this.points = points;
        this.duration = duration;
        this.subjectRealization = subjectRealization;
        this.colloquiumType = colloquiumType;
        this.examTaking = examTaking;
        this.syllabus = syllabus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public SubjectRealization getSubjectRealization() {
        return subjectRealization;
    }

    public void setSubjectRealization(SubjectRealization subjectRealization) {
        this.subjectRealization = subjectRealization;
    }

    public ColloquiumType getColloquiumType() {
        return colloquiumType;
    }

    public void setColloquiumType(ColloquiumType colloquiumType) {
        this.colloquiumType = colloquiumType;
    }

    public Set<ExamTaking> getExamTaking() {
        return examTaking;
    }

    public void setExamTaking(Set<ExamTaking> examTaking) {
        this.examTaking = examTaking;
    }

    public Set<ColloquimDetail> getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(Set<ColloquimDetail> syllabus) {
        this.syllabus = syllabus;
    }
}
