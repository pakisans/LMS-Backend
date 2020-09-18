package lmsbackendapp.backend.model;

import javax.persistence.*;

@Entity
public class Email {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(length=128, nullable = false)
    private String email;

    public Email() {
        super();
    }

    public Email(String email) {
        super();
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
