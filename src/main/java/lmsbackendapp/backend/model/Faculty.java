package lmsbackendapp.backend.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=64, nullable = false)
    private String name;

    @ManyToOne(cascade= CascadeType.ALL)
    private University university;

    @ManyToOne(cascade=CascadeType.ALL)
    private Address address;

    @ManyToOne(cascade=CascadeType.ALL)
    private Professor dean;

//    @JsonView()
    @OneToMany(mappedBy="faculty")
    private Set<StudyProgram> studyProgram;

    @Column(length=128, nullable = false)
    private String description;

//    @JsonView()
    @OneToMany(mappedBy="faculty")
    private Set<FacultyPhoneNumbers> facultyPhoneNumbers;

//    @JsonView()
    @OneToMany(mappedBy="faculty")
    private Set<FacultyEmail> facultyEmail;

    public Faculty() {}

    public Faculty(String name, University university, Address address, Professor dean, Set<StudyProgram> studyProgram,
                    String description, Set<FacultyPhoneNumbers> facultyPhoneNumbers, Set<FacultyEmail> facultyEmail) {
        super();
        this.name = name;
        this.university = university;
        this.address = address;
        this.dean = dean;
        this.studyProgram = studyProgram;
        this.description = description;
        this.facultyPhoneNumbers = facultyPhoneNumbers;
        this.facultyEmail = facultyEmail;

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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Professor getDean() {
        return dean;
    }

    public void setDean(Professor dean) {
        this.dean = dean;
    }

    public Set<StudyProgram> getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(Set<StudyProgram> studyProgram) {
        this.studyProgram = studyProgram;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<FacultyPhoneNumbers> getFacultyPhoneNumbers() {
        return facultyPhoneNumbers;
    }

    public void setFacultyPhoneNumbers(Set<FacultyPhoneNumbers> facultyPhoneNumbers) {
        this.facultyPhoneNumbers = facultyPhoneNumbers;
    }

    public Set<FacultyEmail> getFacultyEmail() {
        return facultyEmail;
    }

    public void setFacultyEmail(Set<FacultyEmail> facultyEmail) {
        this.facultyEmail = facultyEmail;
    }
}
