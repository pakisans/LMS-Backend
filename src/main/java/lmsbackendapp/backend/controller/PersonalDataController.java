package lmsbackendapp.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lmsbackendapp.backend.model.PersonalData;
import lmsbackendapp.backend.service.PersonalDataService;
import lmsbackendapp.backend.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/personalData")
public class PersonalDataController {
    @Autowired
    PersonalDataService personalDataSrvc;
    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<PersonalData>> getPersonalData() {
        return new ResponseEntity<Iterable<PersonalData>>(personalDataSrvc.getPersonalData(), HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PersonalData> getPersonalDataById(@PathVariable Long id) {
        Optional<PersonalData> personalData = personalDataSrvc.getPersonalDataById(id);
        if (personalData.isPresent()) {
            return new ResponseEntity<PersonalData>(personalData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<PersonalData>(HttpStatus.NOT_FOUND);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
    public ResponseEntity<PersonalData> getPersonalDataByUsername(@PathVariable String username) {
        Optional<PersonalData> personalData = personalDataSrvc.getPersonalDataByUsername(username);
        if (personalData.isPresent()) {
            return new ResponseEntity<PersonalData>(personalData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<PersonalData>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<PersonalData> addPersonalData(@RequestBody PersonalData personalData) {
        personalDataSrvc.addPersonalData(personalData);
        return new ResponseEntity<PersonalData>(personalData, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PersonalData> editPersonalData(@PathVariable Long id,
                                                         @RequestBody PersonalData personalData) {
        personalDataSrvc.editPersonalData(id, personalData);
        return new ResponseEntity<PersonalData>(personalData, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<PersonalData> deletePersonalData(@PathVariable Long id) {
        try {
            personalDataSrvc.deletePersonalData(id);
        } catch (Exception e) {
            return new ResponseEntity<PersonalData>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<PersonalData>(HttpStatus.NO_CONTENT);
    }


}
