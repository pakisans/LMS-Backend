package lmsbackendapp.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lmsbackendapp.backend.model.Admin;
import lmsbackendapp.backend.service.AdminService;
import lmsbackendapp.backend.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins ={"http://localhost:4200"})
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminSrvc;

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Admin>> getAdmin() {
        return new ResponseEntity<Iterable<Admin>>(adminSrvc.getAdmin(), HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Optional<Admin> admin = adminSrvc.getAdminById(id);
        if(admin.isPresent()) {
            return new ResponseEntity<Admin>(admin.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/username/{username}", method= RequestMethod.GET)
    public ResponseEntity<Admin> getAdminByUsername(@PathVariable String username) {
        Optional<Admin> admin = adminSrvc.getAdminByUsername(username);
        if(admin.isPresent()) {
            return new ResponseEntity<Admin>(admin.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin Admins) {
        adminSrvc.addAdmin(Admins);
        return new ResponseEntity<Admin>(Admins, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{username}", method=RequestMethod.PUT)
    public ResponseEntity<Admin> editAdmin(@PathVariable String username, @RequestBody Admin Admins) {
        adminSrvc.editAdmin(username, Admins);
        return new ResponseEntity<Admin>(Admins, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Admin> deleteAdmin(@PathVariable Long id) {
        try {
            adminSrvc.deleteAdmin(id);
        }catch (Exception e) {
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Admin>(HttpStatus.NO_CONTENT);
    }
}
