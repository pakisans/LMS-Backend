package lmsbackendapp.backend.model;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class University {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=64, nullable = false)
    private String name;

    @Column(nullable = false)
    private Date dateOfEstablishment;

//    @JsonView()
    @OneToMany(mappedBy="university")
    private Set<Faculty> faculty;

    @ManyToOne(cascade= CascadeType.ALL)
    private Address address;

    @ManyToOne(cascade=CascadeType.ALL)
    private Professor rector;

    @Column(length=128, nullable = false)
    private String description;

//    @JsonView()
    @OneToMany(mappedBy="university")
    private Set<UniversityPhoneNumbers> phone;

//    @JsonView()
    @OneToMany(mappedBy="university")
    private Set<UniversityEmail> email;

    public University() {}

    public University(String name, Date dateOfEstablishment, Set<Faculty> faculty, Address address, Professor rector,
                       String description, Set<UniversityPhoneNumbers> phone, Set<UniversityEmail> email) {
        super();
        this.name = name;
        this.dateOfEstablishment = dateOfEstablishment;
        this.faculty = faculty;
        this.address = address;
        this.rector = rector;
        this.description = description;
        this.phone = phone;
        this.email = email;
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

    public Date getDateOfEstablishment() {
        return dateOfEstablishment;
    }

    public void setDateOfEstablishment(Date dateOfEstablishment) {
        this.dateOfEstablishment = dateOfEstablishment;
    }

    public Set<Faculty> getFaculty() {
        return faculty;
    }

    public void setFaculty(Set<Faculty> faculty) {
        this.faculty = faculty;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Professor getRector() {
        return rector;
    }

    public void setRector(Professor rector) {
        this.rector = rector;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<UniversityPhoneNumbers> getPhone() {
        return phone;
    }

    public void setPhone(Set<UniversityPhoneNumbers> phone) {
        this.phone = phone;
    }

    public Set<UniversityEmail> getEmail() {
        return email;
    }

    public void setEmail(Set<UniversityEmail> email) {
        this.email = email;
    }
}
