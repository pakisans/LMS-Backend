package lmsbackendapp.backend.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Where(clause = "deleted = 'false'")
public class Result {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=128, nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer week;

    @Column(length=150)
    private String pathToIcon;

    @ManyToOne(cascade= {CascadeType.REFRESH, CascadeType.MERGE})
    private Subject subject;
    @ManyToOne(cascade= {CascadeType.REFRESH, CascadeType.MERGE})
    private SubjectRealization subjectRealization;

    @NotNull
    private Boolean deleted = false;

    public Result() {}

    public Result(Long id, String description, Integer week, String pathToIcon, Subject subject,
                 SubjectRealization subjectRealization, @NotNull Boolean deleted) {
        super();
        this.id = id;
        this.description = description;
        this.week = week;
        this.pathToIcon = pathToIcon;
        this.subject = subject;
        this.subjectRealization = subjectRealization;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getPathToIcon() {
        return pathToIcon;
    }

    public void setPathToIcon(String pathToIcon) {
        this.pathToIcon = pathToIcon;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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
