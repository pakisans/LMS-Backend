package lmsbackendapp.backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Dissertation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=128, nullable = false)
    private String title;

    @Column(length=64, nullable = false)
    private Date dateDeffense;

    @ManyToOne(cascade= {CascadeType.REFRESH, CascadeType.MERGE})
    private Professor mentor;

    @OneToOne(fetch = FetchType.LAZY)
    private StudentInProgress studentInProgress;

    @OneToOne(fetch = FetchType.EAGER)
    private DissertationFile dissertationFile;

    public Dissertation() {}

    public Dissertation(Long id, String title, Date dateDeffense, Professor mentor,
                       StudentInProgress studentInProgress, DissertationFile dissertationFile) {
        super();
        this.id = id;
        this.title = title;
        this.dateDeffense = dateDeffense;
        this.mentor = mentor;
        this.studentInProgress = studentInProgress;
        this.dissertationFile = dissertationFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateDeffense() {
        return dateDeffense;
    }

    public void setDateDeffense(Date dateDeffense) {
        this.dateDeffense = dateDeffense;
    }

    public Professor getMentor() {
        return mentor;
    }

    public void setMentor(Professor mentor) {
        this.mentor = mentor;
    }

    public StudentInProgress getStudentInProgress() {
        return studentInProgress;
    }

    public void setStudentInProgress(StudentInProgress studentInProgress) {
        this.studentInProgress = studentInProgress;
    }

    public DissertationFile getDissertationFile() {
        return dissertationFile;
    }

    public void setDissertationFile(DissertationFile dissertationFile) {
        this.dissertationFile = dissertationFile;
    }
}
