package lmsbackendapp.backend.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Where(clause = "deleted = 'false'")
public class StudyProgram {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=64, nullable = false)
    private String name;

    @Column(length=128, nullable = false)
    private String description;

//    @JsonView()
    @OneToMany(mappedBy="studyProgram")
    private Set<StudyYear> studyYear;

    @ManyToOne(cascade= {CascadeType.REFRESH})
    private Professor rector;

    @ManyToOne(cascade= {CascadeType.REFRESH})
    private Faculty faculty;


    @NotNull
    private Boolean deleted = false;

    public StudyProgram() {}

    public StudyProgram(String name,String description, Set<StudyYear> studyYear, Professor rector, Faculty faculty,
                            Boolean deleted) {
        super();
        this.name = name;
        this.description = description;
        this.studyYear = studyYear;
        this.rector = rector;
        this.faculty = faculty;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<StudyYear> getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(Set<StudyYear> studyYear) {
        this.studyYear = studyYear;
    }

    public Professor getRector() {
        return rector;
    }

    public void setRector(Professor rector) {
        this.rector = rector;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
