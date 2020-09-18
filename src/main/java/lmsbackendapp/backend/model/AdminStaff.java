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

public class AdminStaff {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade= CascadeType.ALL)
    private RegUser regUser;

    @ManyToOne(cascade=CascadeType.ALL)
    private Address address;

    @ManyToOne(cascade=CascadeType.ALL)
    private PersonalData personalData;

    @NotNull
    private Boolean deleted = false;


    public AdminStaff() {}

    public AdminStaff(Address address, RegUser regUser, PersonalData personalData, Boolean deleted) {
        super();
        this.regUser = regUser;
        this.address= address;
        this.personalData = personalData;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RegUser getRegUser() {
        return regUser;
    }

    public void setRegUser(RegUser regUser) {
        this.regUser = regUser;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
