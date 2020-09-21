package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.Author;
import lmsbackendapp.backend.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepo;

    public Iterable<Author> getAuthor(){
        return authorRepo.findAll();
    }
    public Optional<Author> getAuthorById(Long id){
        return authorRepo.findById(id);
    }
    public void addAuthor(Author author){
        authorRepo.save(author);
    }
    public void editAuthor(Long id,Author author){
        Optional<Author> authorEdt = authorRepo.findById(id);
        if(authorEdt.isPresent()){
            author.setId(authorEdt.get().getId());
            authorRepo.save(author);
        }
    }
    public void deleteAuthor(Long id){
        Optional<Author> authorDel = authorRepo.findById(id);
        if(authorDel.isPresent()){
            authorRepo.delete(authorDel.get());
        }
    }

}
