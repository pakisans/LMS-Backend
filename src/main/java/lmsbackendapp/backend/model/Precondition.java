package lmsbackendapp.backend.model;

import javax.persistence.*;

@Entity
public class Precondition {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade= CascadeType.ALL)
    private Subject subject;

    public Precondition() {
        super();
    }

    public Precondition(Subject subject) {
        super();
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
