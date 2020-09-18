package lmsbackendapp.backend.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement
@Entity
@Where(clause = "deleted = 'false'")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

//    @JsonView()
    @OneToMany(mappedBy="student")
    private Set<SubjectAttending> subjectAttending;

//    @JsonView()
    @OneToMany(mappedBy="student")
    private Set<SubjectElective> subjectElective;

    @ManyToOne(cascade= CascadeType.ALL)
    private Address address;

//    @JsonView()
    @OneToMany(mappedBy="student", cascade=CascadeType.ALL)
    private Set<StudentInProgress> studentInProgress;

    @ManyToOne(cascade=CascadeType.ALL)
    private RegUser regUser;

    @ManyToOne(cascade=CascadeType.ALL)
    private PersonalData personalData;

    @NotNull
    private Boolean deleted = false;

    public Student() {}

    public Student(Long id, String name, String lastname, String email) {
        this.id = id;
        this.personalData.setName(name);
        this.personalData.setLastname(lastname);
        this.regUser.setEmail(email);
    }

    public Student(Set<SubjectAttending> subjectAttending, Set<SubjectElective> subjectElective, Address address, Set<StudentInProgress> studentInProgress,
                   RegUser regUser, PersonalData personalData, Boolean deleted) {
        super();
        this.subjectAttending = subjectAttending;
        this.subjectElective = subjectElective;
        this.address = address;
        this.studentInProgress = studentInProgress;
        this.regUser = regUser;
        this.personalData = personalData;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<SubjectAttending> getSubjectAttending() {
        return subjectAttending;
    }

    public void setSubjectAttending(Set<SubjectAttending> subjectAttending) {
        this.subjectAttending = subjectAttending;
    }

    public Set<SubjectElective> getSubjectElective() {
        return subjectElective;
    }

    public void setSubjectElective(Set<SubjectElective> subjectElective) {
        this.subjectElective = subjectElective;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<StudentInProgress> getStudentInProgress() {
        return studentInProgress;
    }

    public void setStudentInProgress(Set<StudentInProgress> studentInProgress) {
        this.studentInProgress = studentInProgress;
    }

    public RegUser getRegUser() {
        return regUser;
    }

    public void setRegUser(RegUser regUser) {
        this.regUser = regUser;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
