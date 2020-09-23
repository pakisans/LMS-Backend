package lmsbackendapp.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import lmsbackendapp.backend.dto.StudentDTO;
import lmsbackendapp.backend.dto.StudentDetailsDTO;
import lmsbackendapp.backend.mapper.StudentDetailsMapper;
import lmsbackendapp.backend.mapper.StudentMapper;
import lmsbackendapp.backend.model.Student;
import lmsbackendapp.backend.service.FileService;
import lmsbackendapp.backend.service.StudentService;
import lmsbackendapp.backend.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentSrvc;

    @Autowired
    FileService fileSrvc;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    StudentDetailsMapper studentDetailsMapper;

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Student>> getStudent() {
        return new ResponseEntity<Iterable<Student>>(studentSrvc.getStudent(), HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentSrvc.getStudentById(id);
        if(student.isPresent()) {
            return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/username/{username}", method=RequestMethod.GET)
    public ResponseEntity<Student> getStudentByUsername(@PathVariable String username) {
        Optional<Student> student = studentSrvc.getStudentByUsername(username);
        if(student.isPresent()) {
            return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/{username}", method=RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Student> updateStudent(@PathVariable String username, @RequestPart("profileImage") Optional<MultipartFile> file, @RequestPart("data") String studentStr) throws IOException {
        Student student = new ObjectMapper().readValue(studentStr, Student.class);
        if(file.isPresent()) {
            fileSrvc.savedProfileImage(file.get(), "student_" + student.getRegUser().getUsername(), student.getPersonalData());
        }
        studentSrvc.editStudent(username, student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        try {
            studentSrvc.deleteStudent(id);
        }catch (Exception e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/findByName/{name}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Optional<Student>>> getStudentByName(@PathVariable String name) {
        Iterable<Optional<Student>> student = studentSrvc.getStudentByName(name);
        return new ResponseEntity<Iterable<Optional<Student>>>(student, HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/findByUpin/{upin}", method=RequestMethod.GET)
    public ResponseEntity<Student> getStudentByUpin(@PathVariable String upin) {
        Optional<Student> student = studentSrvc.getStudentByUpin(upin);
        if(student.isPresent()) {
            return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN_STAFF','ROLE_ADMIN')")
    public ResponseEntity<Student> addStudent(@RequestPart("profileImage") Optional<MultipartFile> file, @RequestPart("data") String studentStr) throws IOException {
        Student student = new ObjectMapper().readValue(studentStr, Student.class);
        if(file.isPresent()) {
            fileSrvc.savedProfileImage(file.get(), "student_" + student.getRegUser().getUsername(), student.getPersonalData());
        }
        studentSrvc.addStudent(student);
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value = "/search/", method = RequestMethod.GET)
    public ResponseEntity<Collection<StudentDTO>> searchStudent(@RequestParam(required = false) String name,
                                                                @RequestParam(required = false) String lastname, @RequestParam(required = false) String indexNumber,
                                                                @RequestParam(required = false) String subscription, @RequestParam(required = false) String assessment) {

        Collection<Student> student = studentSrvc.searchStudent(name, lastname, indexNumber, subscription, assessment);
        if(student.size()>0) {
            Collection<StudentDTO> findStudents= studentMapper.toDtoList(student);
            return new ResponseEntity<Collection<StudentDTO>>(findStudents, HttpStatus.OK);
        }
        else return new ResponseEntity<Collection<StudentDTO>>(HttpStatus.NO_CONTENT);

    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/details/{id}", method=RequestMethod.GET)
    public ResponseEntity<StudentDetailsDTO> getStudentDetailsById(@PathVariable Long id){
        Optional<Student> student = studentSrvc.getStudentById(id);
        System.out.println(student.get().getPersonalData().getName());
        if (student.isPresent()) return new ResponseEntity<StudentDetailsDTO>(studentDetailsMapper.toDTO(student.get()), HttpStatus.OK);
        return new ResponseEntity<StudentDetailsDTO>(HttpStatus.NO_CONTENT);

    }
}
