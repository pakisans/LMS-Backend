package lmsbackendapp.backend.model;

import javax.persistence.*;

public class FacultyEmail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade= CascadeType.ALL)
    private Email email;
    @ManyToOne(cascade=CascadeType.ALL)
    private Faculty faculty;

    public FacultyEmail() {
        super();
    }

    public FacultyEmail(Email email, Faculty faculty) {
        super();
        this.email = email;
        this.faculty = faculty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
