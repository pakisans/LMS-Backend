package lmsbackendapp.backend.model;

import javax.persistence.*;

@Entity
public class ExamTaking {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Integer points;

    @Column(length = 64, nullable = true)
    private String note;

    @ManyToOne(cascade= CascadeType.ALL)
    private Colloquium colloquium;

    @ManyToOne(cascade=CascadeType.ALL)
    private StudentInProgress studentInProgress;

    public ExamTaking() {
        super();
    }

    public ExamTaking(Integer points,String note,Colloquium colloquium, StudentInProgress studentInProgress) {
        super();
        this.points = points;
        this.note = note;
        this.colloquium = colloquium;
        this.studentInProgress = studentInProgress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Colloquium getColloquium() {
        return colloquium;
    }

    public void setColloquium(Colloquium colloquium) {
        this.colloquium = colloquium;
    }

    public StudentInProgress getStudentInProgress() {
        return studentInProgress;
    }

    public void setStudentInProgress(StudentInProgress studentInProgress) {
        this.studentInProgress = studentInProgress;
    }
}
