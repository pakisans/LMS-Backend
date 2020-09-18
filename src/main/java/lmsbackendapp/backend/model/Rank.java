package lmsbackendapp.backend.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Rank {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @ManyToOne(cascade= CascadeType.ALL)
    private ScientificField scientificField;

    @ManyToOne(cascade=CascadeType.ALL)
    private Professor professor;

    public Rank() {}

    public Rank(Date startDate, Date endDate, ScientificField scientificField, Professor professor){
        this.startDate = startDate;
        this.endDate = endDate;
        this.scientificField = scientificField;
        this.professor = professor;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ScientificField getScientificField() {
        return scientificField;
    }

    public void setScientificField(ScientificField scientificField) {
        this.scientificField = scientificField;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
