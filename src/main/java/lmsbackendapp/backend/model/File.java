package lmsbackendapp.backend.model;

import javax.persistence.*;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=128, nullable = false)
    private String description;

    @Column(length=128, nullable = false)
    private String url;



    @ManyToOne(cascade=CascadeType.ALL)
    private TeachingMaterials teachingMaterials;

    public File() {
        super();
    }

    public File(String description, String url,TeachingMaterials teachingMaterials) {
        super();
        this.description = description;
        this.url = url;
        this.teachingMaterials = teachingMaterials;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TeachingMaterials getTeachingMaterials() {
        return teachingMaterials;
    }

    public void setTeachingMaterials(TeachingMaterials teachingMaterials) {
        this.teachingMaterials = teachingMaterials;
    }
}
