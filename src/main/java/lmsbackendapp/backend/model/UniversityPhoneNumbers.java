package lmsbackendapp.backend.model;

import javax.persistence.*;

@Entity
public class UniversityPhoneNumbers {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade= CascadeType.ALL)
    private University university;
    @ManyToOne(cascade=CascadeType.ALL)
    private Phone phone;

    public UniversityPhoneNumbers() {
        super();
    }

    public UniversityPhoneNumbers(University university, Phone phone) {
        super();
        this.university = university;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
