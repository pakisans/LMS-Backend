package lmsbackendapp.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lmsbackendapp.backend.model.Result;
import lmsbackendapp.backend.model.Subject;
import lmsbackendapp.backend.service.SubjectService;
import lmsbackendapp.backend.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectSrvc;

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Subject>> getSubject() {
        return new ResponseEntity<Iterable<Subject>>(subjectSrvc.getSubject(), HttpStatus.OK);
    }
    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {
        Optional<Subject> subject = subjectSrvc.getSubjectById(id);
        if(subject.isPresent()) {
            return new ResponseEntity<Subject>(subject.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Subject> addPredmet(@RequestBody Subject subject) {
        subjectSrvc.addSubject(subject);
        return new ResponseEntity<Subject>(subject, HttpStatus.CREATED);
    }
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Subject> editSubject(@PathVariable Long id, @RequestBody Subject subject) {
        subjectSrvc.editSubject(id, subject);
        return new ResponseEntity<Subject>(subject, HttpStatus.CREATED);
    }
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Subject> deleteSubject(@PathVariable Long id) {
        try {
            subjectSrvc.deleteSubject(id);
        }catch (Exception e) {
            return new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Subject>(HttpStatus.NO_CONTENT);
    }
    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/findByName/{name}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Optional<Subject>>> getSubjectByName(@PathVariable String name) {
        Iterable<Optional<Subject>> subject = subjectSrvc.getSubjectByName(name);
        return new ResponseEntity<Iterable<Optional<Subject>>>(subject, HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/sylabus/{sylabusId}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Result>> getSylabus(@PathVariable Long subjectId) {
        return new ResponseEntity<ArrayList<Result>>(subjectSrvc.getSylabus(subjectId), HttpStatus.OK);
    }

}
