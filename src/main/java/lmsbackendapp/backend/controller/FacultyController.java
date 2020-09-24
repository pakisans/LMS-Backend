package lmsbackendapp.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lmsbackendapp.backend.model.*;
import lmsbackendapp.backend.service.FacultyService;
import lmsbackendapp.backend.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    FacultyService facultySrvc;

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Faculty>> getFaculty() {
        Iterable<Faculty> faculties = facultySrvc.getFaculty();
        return new ResponseEntity<Iterable<Faculty>>(faculties, HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id) {
        Optional<Faculty> faculty = facultySrvc.getFacultyById(id);
        if(faculty.isPresent()) {
            return new ResponseEntity<Faculty>(faculty.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Faculty>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty) {
        facultySrvc.addFaculty(faculty);
        return new ResponseEntity<Faculty>(faculty, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        facultySrvc.editFaculty(id, faculty);
        return new ResponseEntity<Faculty>(faculty, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id) {
        try {
            facultySrvc.deleteFaculty(id);
        }catch (Exception e) {
            return new ResponseEntity<Faculty>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Faculty>(HttpStatus.NO_CONTENT);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/studyProgram/{facultyId}", method= RequestMethod.GET)
    public ResponseEntity<ArrayList<StudyProgram>> getStudyProgram(@PathVariable Long facultyId) {
        return new ResponseEntity<ArrayList<StudyProgram>>(facultySrvc.getStudyProgram(facultyId), HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/phone/{facultyId}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Phone>> getFacultyPhone(@PathVariable Long facultyId) {
        return new ResponseEntity<ArrayList<Phone>>(facultySrvc.getFacultyPhone(facultyId), HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/email/{facultyId}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Email>> getFacultyEmail(@PathVariable Long facultyId) {
        return new ResponseEntity<ArrayList<Email>>(facultySrvc.getFacultyEmail(facultyId), HttpStatus.OK);
    }

}
