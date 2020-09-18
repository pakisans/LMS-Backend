package lmsbackendapp.backend.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.CascadeType;

@Entity
@Where(clause = "deleted = 'false'")
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade= CascadeType.ALL)
    private PersonalData personalData;

    @ManyToOne(cascade=CascadeType.ALL)
    private RegUser regUser;

    @NotNull
    private Boolean deleted = false;


    public Admin() {}

    public Admin(PersonalData personalData, RegUser regUser, Boolean deleted) {
        super();
        this.personalData = personalData;
        this.regUser = regUser;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public RegUser getRegUser() {
        return regUser;
    }

    public void setRegUser(RegUser regUser) {
        this.regUser = regUser;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
