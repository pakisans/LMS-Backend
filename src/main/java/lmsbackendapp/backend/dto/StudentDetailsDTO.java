package lmsbackendapp.backend.dto;

import java.util.Collection;

public class StudentDetailsDTO {
    private Long id;
    private String name,lastname,email,pathToProfilePic;

    private Collection<StudentInProgressDTO> studentInProgres;

    public StudentDetailsDTO(){}

    public StudentDetailsDTO(Long id, String name, String lastname, String email, String pathToProfilePic, Collection<StudentInProgressDTO> studentInProgres) {
        super();
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.pathToProfilePic = pathToProfilePic;
        this.studentInProgres = studentInProgres;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPathToProfilePic() {
        return pathToProfilePic;
    }

    public void setPathToProfilePic(String pathToProfilePic) {
        this.pathToProfilePic = pathToProfilePic;
    }

    public Collection<StudentInProgressDTO> getStudentInProgres() {
        return studentInProgres;
    }

    public void setStudentInProgres(Collection<StudentInProgressDTO> studentInProgres) {
        this.studentInProgres = studentInProgres;
    }
}
