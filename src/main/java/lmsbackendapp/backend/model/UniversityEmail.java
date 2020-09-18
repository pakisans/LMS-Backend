package lmsbackendapp.backend.model;

import javax.persistence.*;

@Entity
public class UniversityEmail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade= CascadeType.ALL)
    private University university;
    @ManyToOne(cascade=CascadeType.ALL)
    private Email email;

    public UniversityEmail() {
        super();
    }

    public UniversityEmail(University university, Email email) {
        super();
        this.university = university;
        this.email = email;
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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
