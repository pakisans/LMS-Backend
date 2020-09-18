package lmsbackendapp.backend.model;

import javax.persistence.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=64, nullable = false)
    private String name;

    @Column(length=128, nullable = false)
    private String lastname;

    @ManyToOne(cascade= CascadeType.ALL)
    private TeachingMaterials teachingMaterials;

    public Author() {
        super();
    }

    public Author(String name, String lastname, TeachingMaterials teachingMaterials) {
        super();
        this.name = name;
        this.lastname = lastname;
        this.teachingMaterials = teachingMaterials;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public TeachingMaterials getTeachingMaterials() {
        return teachingMaterials;
    }

    public void setTeachingMaterials(TeachingMaterials teachingMaterials) {
        this.teachingMaterials = teachingMaterials;
    }
}
