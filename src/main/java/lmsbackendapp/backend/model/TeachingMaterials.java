package lmsbackendapp.backend.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class TeachingMaterials {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=64, nullable = false)
    private String name;

//    @JsonView()
    @OneToMany(mappedBy="teachingMaterials")
    private Set<Author> author;

    @Column(nullable = false)
    private Date yearIssue;

//    @JsonView()
    @OneToMany(mappedBy="teachingMaterials")
    private Set<File> file;

    @ManyToOne(cascade= CascadeType.ALL)
    private SubjectRealization subjectRealization;

    public TeachingMaterials() {
        super();
    }

    public TeachingMaterials(String name, Set<Author> author, Date yearIssue, Set<File> file,
                             SubjectRealization subjectRealization) {
        super();
        this.name = name;
        this.author = author;
        this.yearIssue = yearIssue;
        this.file= file;
        this.subjectRealization = subjectRealization;
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

    public Set<Author> getAuthor() {
        return author;
    }

    public void setAuthor(Set<Author> author) {
        this.author = author;
    }

    public Date getYearIssue() {
        return yearIssue;
    }

    public void setYearIssue(Date yearIssue) {
        this.yearIssue = yearIssue;
    }

    public Set<File> getFile() {
        return file;
    }

    public void setFile(Set<File> file) {
        this.file = file;
    }

    public SubjectRealization getSubjectRealization() {
        return subjectRealization;
    }

    public void setSubjectRealization(SubjectRealization subjectRealization) {
        this.subjectRealization = subjectRealization;
    }
}
