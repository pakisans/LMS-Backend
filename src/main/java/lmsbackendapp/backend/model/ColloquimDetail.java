package lmsbackendapp.backend.model;

import javax.persistence.*;

@Entity
public class ColloquimDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=128, nullable = false)
    private String description;

    @ManyToOne(cascade= {CascadeType.REFRESH, CascadeType.MERGE})
    private Colloquium colloquium;

    public ColloquimDetail() {}

    public ColloquimDetail(String description, Colloquium colloquium) {
        super();
        this.description = description;
        this.colloquium = colloquium;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Colloquium getColloquium() {
        return colloquium;
    }

    public void setColloquium(Colloquium colloquium) {
        this.colloquium = colloquium;
    }
}
