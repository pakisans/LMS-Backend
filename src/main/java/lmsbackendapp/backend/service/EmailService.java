package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.Email;
import lmsbackendapp.backend.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailService {
    @Autowired
    EmailRepository emailRepo;

    public Iterable<Email> getEmail() {

        return emailRepo.findAll();
    }
    public Optional<Email> getEmailById(Long id) {
        return emailRepo.findById(id);
    }
    public void addEmail(Email email) {
        emailRepo.save(email);
    }
    public void editEmail(Long id, Email email) {
        Optional<Email> em = emailRepo.findById(id);
        if(em.isPresent()) {
            email.setId(em.get().getId());
            emailRepo.save(email);
        }
    }
    public void deleteEmail(Long id) {
        Optional<Email> em = emailRepo.findById(id);
        if(em.isPresent()) {
            emailRepo.delete(em.get());
        }
    }
}
