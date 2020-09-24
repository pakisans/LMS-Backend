package lmsbackendapp.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import lmsbackendapp.backend.model.Professor;
import lmsbackendapp.backend.model.RegUser;
import lmsbackendapp.backend.service.FileService;
import lmsbackendapp.backend.service.ProfessorService;
import lmsbackendapp.backend.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@CrossOrigin(origins ={"http://localhost:4200"} )
@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    ProfessorService professorSrvc;
    @Autowired
    FileService fileSrvc;

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Professor>> getProfessor() {
        Iterable<Professor> professors = professorSrvc.getProfessor();
        return new ResponseEntity<Iterable<Professor>>(professors, HttpStatus.OK);
    }


    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/faculty/{facultyId}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Optional<Professor>>> getProfessorByFaculty(@PathVariable Long facultyId) {
        return new ResponseEntity<Iterable<Optional<Professor>>>(professorSrvc.getProfessorByFaculty(facultyId), HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        Optional<Professor> professor = professorSrvc.getProfessorById(id);
        if(professor.isPresent()) {
            return new ResponseEntity<Professor>(professor.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Professor>(HttpStatus.NOT_FOUND);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/username/{username}", method=RequestMethod.GET)
    public ResponseEntity<Professor> getProfessorByUsername(@PathVariable String username) {
        Optional<Professor> professor = professorSrvc.getProfessorByUsername(username);
        if(professor.isPresent()) {
            return new ResponseEntity<Professor>(professor.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Professor>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/{username}", method=RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Professor> editProfessor(@PathVariable String username, @RequestPart("profileImage") Optional<MultipartFile> file, @RequestPart("data") String professorStr) throws IOException {
        Professor professor = new ObjectMapper().readValue(professorStr, Professor.class);
        if(file.isPresent()) {
            fileSrvc.savedProfileImage(file.get(), "teacher_" + professor.getRegUser().getUsername(), professor.getPersonalData());
        }
        professorSrvc.editProfessor(username, professor);
        return new ResponseEntity<Professor>(professor, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Professor> deleteProfessor(@PathVariable Long id) {
        try {
            professorSrvc.deleteProfessor(id);
        }catch (Exception e) {
            return new ResponseEntity<Professor>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Professor>(HttpStatus.NO_CONTENT);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/findByName/{name}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Optional<Professor>>> getProfessorByName(@PathVariable String name) {
        Iterable<Optional<Professor>> professor = professorSrvc.getProfessorByName(name);
        return new ResponseEntity<Iterable<Optional<Professor>>>(professor, HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/findByUpin/{upin}", method=RequestMethod.GET)
    public ResponseEntity<Professor> getProfessorByUpin(@PathVariable String upin) {
        Optional<Professor> professor = professorSrvc.getProfessorByUpin(upin);
        if(professor.isPresent()) {
            return new ResponseEntity<Professor>(professor.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Professor>(HttpStatus.NOT_FOUND);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Professor> addProfessor(@RequestPart("profileImage") Optional<MultipartFile> file, @RequestPart("data") String professorStr) throws IOException {
        Professor professor = new ObjectMapper().readValue(professorStr, Professor.class);
        if(file.isPresent()) {
            fileSrvc.savedProfileImage(file.get(), "professor_" + professor.getRegUser().getUsername(), professor.getPersonalData());
        }
        professorSrvc.addProfessor(professor);
        return new ResponseEntity<Professor>(professor, HttpStatus.CREATED);
    }
}
