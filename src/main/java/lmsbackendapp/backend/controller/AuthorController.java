package lmsbackendapp.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lmsbackendapp.backend.model.Author;
import lmsbackendapp.backend.service.AuthorService;
import lmsbackendapp.backend.utils.ViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = {"http://loaclhost:4200"})
@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorSrvc;

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Author>> getAuthor() {
        return new ResponseEntity<Iterable<Author>>(authorSrvc.getAuthor(), HttpStatus.OK);
    }

    @JsonView(ViewUtils.HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Optional<Author> author = authorSrvc.getAuthorById(id);
        if(author.isPresent()) {
            return new ResponseEntity<Author>(author.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        authorSrvc.addAuthor(author);
        return new ResponseEntity<Author>(author, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Author> editupdateAuthor(@PathVariable Long id, @RequestBody Author author) {
        authorSrvc.editAuthor(id, author);
        return new ResponseEntity<Author>(author, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id) {
        try {
            authorSrvc.deleteAuthor(id);
        }catch (Exception e) {
            return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
    }
}
