package lmsbackendapp.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lmsbackendapp.backend.model.Phone;
import lmsbackendapp.backend.service.PhoneService;
import lmsbackendapp.backend.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    PhoneService phoneSrvc;

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Phone>> getPhone() {
        return new ResponseEntity<Iterable<Phone>>(phoneSrvc.getPhone(), HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Phone> getPhoneById(@PathVariable Long id) {
        Optional<Phone> phone = phoneSrvc.getPhoneById(id);
        if(phone.isPresent()) {
            return new ResponseEntity<Phone>(phone.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Phone>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Phone> addPhone(@RequestBody Phone phone) {
        phoneSrvc.addPhone(phone);
        return new ResponseEntity<Phone>(phone, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Phone> editPhone(@PathVariable Long id, @RequestBody Phone phone) {
        phoneSrvc.editPhone(id, phone);
        return new ResponseEntity<Phone>(phone, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Phone> deletePhone(@PathVariable Long id) {
        try {
            phoneSrvc.deletePhone(id);
        }catch (Exception e) {
            return new ResponseEntity<Phone>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Phone>(HttpStatus.NO_CONTENT);
    }



}
