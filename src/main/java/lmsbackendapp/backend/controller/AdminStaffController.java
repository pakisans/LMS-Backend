package lmsbackendapp.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import lmsbackendapp.backend.model.AdminStaff;
import lmsbackendapp.backend.model.StudyYear;
import lmsbackendapp.backend.service.AdminStaffService;
import lmsbackendapp.backend.service.FileService;
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

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/adminStaff")
public class AdminStaffController {
    @Autowired
    AdminStaffService adminStaffService;

    @Autowired
    FileService fileService;

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<AdminStaff>> getAdminStaff() {
        return new ResponseEntity<Iterable<AdminStaff>>(adminStaffService.getAdminStaff(), HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<AdminStaff> getAdminStaffById(@PathVariable Long id) {
        Optional<AdminStaff> adminStaff = adminStaffService.getAdminStaffById(id);
        if(adminStaff.isPresent()) {
            return new ResponseEntity<AdminStaff>(adminStaff.get(), HttpStatus.OK);
        }
        return new ResponseEntity<AdminStaff>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<AdminStaff> deleteAdminStaff(@PathVariable Long id) {
        try {
            adminStaffService.deleteAdminStaff(id);
        }catch (Exception e) {
            return new ResponseEntity<AdminStaff>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<AdminStaff>(HttpStatus.NO_CONTENT);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Secured("ROLE_ADMIN")
    public ResponseEntity<AdminStaff> addAAdminStaff(@RequestPart("profileImage") Optional<MultipartFile> file, @RequestPart("data") String admStfStr) throws IOException {
        AdminStaff admStf = new ObjectMapper().readValue(admStfStr, AdminStaff.class);
        if(file.isPresent()) {
            fileService.savedProfileImage(file.get(), "admin_staff_" + admStf.getRegUser().getUsername(), admStf.getPersonalData());
        }
        adminStaffService.addAdminStaff(admStf);
        return new ResponseEntity<AdminStaff>(admStf, HttpStatus.CREATED);
    }




    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/upis/{studentId}", method=RequestMethod.PUT)
    public ResponseEntity<Boolean> upisStudenataUNarednuGodinu(@PathVariable Long studentId, @RequestBody StudyYear studyYear) {
        return new ResponseEntity<Boolean>(adminStaffService.subStudentForNextYear(studentId, studyYear), HttpStatus.OK);
    }
}
