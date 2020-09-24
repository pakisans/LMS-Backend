package lmsbackendapp.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lmsbackendapp.backend.model.RegUser;
import lmsbackendapp.backend.service.RegUserService;
import lmsbackendapp.backend.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/regUser")
public class RegUserController {
    @Autowired
    RegUserService regUserSrvc;

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<RegUser>> getRegUser(){
        Iterable<RegUser> users = regUserSrvc.getRegUser();
        return new ResponseEntity<Iterable<RegUser>>(users, HttpStatus.OK);
    }
    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<RegUser> getRegUserById(@PathVariable Long id) {
        Optional<RegUser> regUser = regUserSrvc.getRegUserById(id);
        if(regUser.isPresent()) {
            return new ResponseEntity<RegUser>(regUser.get(), HttpStatus.OK);
        }
        return new ResponseEntity<RegUser>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<RegUser> addRegUser(@RequestBody RegUser regUser) {
        regUserSrvc.addRegUser(regUser);
        return new ResponseEntity<RegUser>(regUser, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<RegUser> editRegUser(@PathVariable Long id, @RequestBody RegUser regUser) {
        regUserSrvc.editRegUser(id, regUser);
        return new ResponseEntity<RegUser>(regUser, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<RegUser> deleteRegUser(@PathVariable Long id) {
        try {
            regUserSrvc.deleteRegUser(id);
        }catch (Exception e) {
            return new ResponseEntity<RegUser>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<RegUser>(HttpStatus.NO_CONTENT);
    }
}
