package lmsbackendapp.backend.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Where(clause = "deleted = 'false'")
public class Professor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=128, nullable = false)
    private String biography;

//    @JsonView()
    @OneToMany(mappedBy="professor")
    private Set<Rank> rank;

    @ManyToOne(cascade= CascadeType.ALL)
    private Address address;

    @ManyToOne(cascade=CascadeType.ALL)
    private RegUser regUser;

    @ManyToOne(cascade=CascadeType.ALL)
    private PersonalData personalData;

//    @JsonView()
    @OneToMany(mappedBy="professor")
    private Set<ProfessorOnRealization> professorOnRealization;


    @NotNull
    private Boolean deleted = false;

    public Professor() {}

    public Professor(Long id, String biography, Set<Rank> rank, Address address,
                     RegUser regUser, PersonalData personalData,
                     Set<ProfessorOnRealization> professorOnRealization, @NotNull Boolean deleted) {
        super();
        this.id = id;
        this.biography = biography;
        this.rank = rank;
        this.address = address;
        this.regUser = regUser;
        this.personalData = personalData;
        this.professorOnRealization = professorOnRealization;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Set<Rank> getRank() {
        return rank;
    }

    public void setRank(Set<Rank> rank) {
        this.rank = rank;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public Set<ProfessorOnRealization> getProfessorOnRealization() {
        return professorOnRealization;
    }

    public void setProfessorOnRealization(Set<ProfessorOnRealization> professorOnRealization) {
        this.professorOnRealization = professorOnRealization;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
