package lmsbackendapp.backend.service;

import lmsbackendapp.backend.repository.DissertationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DissertationService {
    @Autowired
    DissertationRepository dissertationRepo;
    public ArrayList<Object> findDisserationByStudentId(Long studentId){
        return dissertationRepo.findByStudentInProgressStudentId(studentId);
    }
}
