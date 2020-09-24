package lmsbackendapp.backend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonView;
import lmsbackendapp.backend.utils.ViewUtils;

@Entity
public class PersonalData {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=64, nullable = false)
    private String name;

    @Column(length=64, nullable = false)
    private String lastname;

    @Column(length=64, nullable = false)
    private String phoneNumber;

    @Column(length=20, nullable = false)
    private String upin;

    @Column(length=150)
    private String pathProfilePic;

    @JsonView(ViewUtils.ShowProfessor.class)
    @OneToMany(mappedBy="personalData")
    private Set<Professor> professor;

    @JsonView(ViewUtils.ShowProfessorOnRealization.class)
    @OneToMany(mappedBy="personalData")
    private Set<ProfessorOnRealization> professorOnRealization;

    public PersonalData() {}

    public PersonalData(Long id, String name, String lastname, String phoneNumber, String upin, String pathProfilePic,
                       Set<Professor> professor, Set<ProfessorOnRealization> professorOnRealization) {
        super();
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.upin = upin;
        this.pathProfilePic = pathProfilePic;
        this.professor = professor;
        this.professorOnRealization = professorOnRealization;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUpin() {
        return upin;
    }

    public void setUpin(String upin) {
        this.upin = upin;
    }

    public String getPathProfilePic() {
        return pathProfilePic;
    }

    public void setPathProfilePic(String pathProfilePic) {
        this.pathProfilePic = pathProfilePic;
    }

    public Set<Professor> getProfessor() {
        return professor;
    }

    public void setProfessor(Set<Professor> professor) {
        this.professor = professor;
    }

    public Set<ProfessorOnRealization> getProfessorOnRealization() {
        return professorOnRealization;
    }

    public void setProfessorOnRealization(Set<ProfessorOnRealization> professorOnRealization) {
        this.professorOnRealization = professorOnRealization;
    }
}
