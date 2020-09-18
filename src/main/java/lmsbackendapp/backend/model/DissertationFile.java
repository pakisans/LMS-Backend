package lmsbackendapp.backend.model;

import javax.persistence.*;

@Entity
public class DissertationFile {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=150, nullable = false)
    private String url;

    @OneToOne(mappedBy = "dissertationFile")
    private Dissertation dissertation;

    public DissertationFile() {
    }

    public DissertationFile(String url, Dissertation dissertation) {
        super();
        this.url = url;
        this.dissertation = dissertation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Dissertation getDissertation() {
        return dissertation;
    }

    public void setDissertation(Dissertation dissertation) {
        this.dissertation = dissertation;
    }
}
