package lmsbackendapp.backend.model;

import javax.persistence.*;

@Entity
public class FacultyPhoneNumbers {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade= CascadeType.ALL)
    private Faculty faculty;
    @ManyToOne(cascade=CascadeType.ALL)
    private Phone phone;

    public FacultyPhoneNumbers() {super();
    }

    public FacultyPhoneNumbers(Faculty faculty,Phone phone){
        super();
        this.faculty = faculty;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
