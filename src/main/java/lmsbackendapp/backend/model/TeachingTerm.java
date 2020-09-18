package lmsbackendapp.backend.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Where(clause = "deleted = 'false'")
public class TeachingTerm {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String day;

    @Column(nullable = false)
    private Date startTime;

    @Column(nullable = false)
    private Date endTime;

    @ManyToOne(cascade= {CascadeType.REFRESH, CascadeType.MERGE})
    private SubjectRealization subjectRealization;

    @NotNull
    private Boolean deleted = false;

    public TeachingTerm() {
        super();
    }

    public TeachingTerm(String day, Date startTime, Date endTime, SubjectRealization subjectRealization,
                         Boolean deleted) {
        super();
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.subjectRealization = subjectRealization;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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

    public SubjectRealization getSubjectRealization() {
        return subjectRealization;
    }

    public void setSubjectRealization(SubjectRealization subjectRealization) {
        this.subjectRealization = subjectRealization;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
