package lmsbackendapp.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lmsbackendapp.backend.model.Email;
import lmsbackendapp.backend.model.Phone;
import lmsbackendapp.backend.model.University;
import lmsbackendapp.backend.service.UniversityService;
import lmsbackendapp.backend.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    UniversityService universitySrvc;

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<University>> getUniversity() {
        return new ResponseEntity<Iterable<University>>(universitySrvc.getUniversity(), HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<University> getUniversityById(@PathVariable Long id) {
        Optional<University> university = universitySrvc.getUniversityById(id);
        if(university.isPresent()) {
            return new ResponseEntity<University>(university.get(), HttpStatus.OK);
        }
        return new ResponseEntity<University>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<University> addUniversity(@RequestBody University university) {
        universitySrvc.addUniversity(university);
        return new ResponseEntity<University>(university, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<University> editUniversity(@PathVariable Long id, @RequestBody University university) {
        universitySrvc.editUniversity(id, university);
        return new ResponseEntity<University>(university, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<University> deleteUniversity(@PathVariable Long id) {
        try {
            universitySrvc.deleteUniver(id);
        }catch (Exception e) {
            return new ResponseEntity<University>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<University>(HttpStatus.NO_CONTENT);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/phone/{universityId}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Phone>> getPhoneUniversitya(@PathVariable Long universityId) {
        return new ResponseEntity<ArrayList<Phone>>(universitySrvc.getUniversityPhones(universityId), HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/emails/{universityId}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Email>> getEmailUniversitya(@PathVariable Long universityId) {
        return new ResponseEntity<ArrayList<Email>>(universitySrvc.getUniversityEmail(universityId), HttpStatus.OK);
    }
}
