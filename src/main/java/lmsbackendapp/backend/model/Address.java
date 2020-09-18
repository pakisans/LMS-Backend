package lmsbackendapp.backend.model;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=64, nullable = false)
    private String number;

    @Column(length=64, nullable = false)
    private String street;

    @ManyToOne(cascade= CascadeType.ALL)
    private Country country;

    public Address() {
    }

    public Address(String number, String street, Country country) {
        this.number = number;
        this.street = street;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
