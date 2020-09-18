package lmsbackendapp.backend.model;

import javax.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=64, nullable = false)
    private String name;

    @ManyToOne(cascade= CascadeType.ALL)
    private Country country;

    public City(){ }

    public City(String name,Country country){
        this.name = name;
        this.country = country;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
