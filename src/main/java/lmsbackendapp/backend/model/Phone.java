package lmsbackendapp.backend.model;

import javax.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=128, nullable = false)
    private String phone;

    public Phone() {super();
    }

    public Phone(String phone){
        super();
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
