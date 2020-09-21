package lmsbackendapp.backend.service;

import lmsbackendapp.backend.repository.AdminStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminStaffService {
    @Autowired
    private AdminStaffRepository adminStaffRepo;
}
