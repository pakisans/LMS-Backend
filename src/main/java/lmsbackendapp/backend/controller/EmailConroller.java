package lmsbackendapp.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lmsbackendapp.backend.model.Email;
import lmsbackendapp.backend.service.EmailService;
import lmsbackendapp.backend.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/email")
public class EmailConroller {
    @Autowired
    EmailService emailSrvc;

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Email>> getEmail() {
        return new ResponseEntity<Iterable<Email>>(emailSrvc.getEmail(), HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Email> getEmailById(@PathVariable Long id) {
        Optional<Email> email= emailSrvc.getEmailById(id);
        if(email.isPresent()) {
            return new ResponseEntity<Email>(email.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Email>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Email> addEmail(@RequestBody Email email) {
        emailSrvc.addEmail(email);
        return new ResponseEntity<Email>(email, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Email> editEmail(@PathVariable Long id, @RequestBody Email email) {
        emailSrvc.editEmail(id, email);
        return new ResponseEntity<Email>(email, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Email> deleteEmail(@PathVariable Long id) {
        try {
            emailSrvc.deleteEmail(id);
        }catch (Exception e) {
            return new ResponseEntity<Email>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Email>(HttpStatus.NO_CONTENT);
    }
}
