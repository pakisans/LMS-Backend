package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.StudyYear;
import lmsbackendapp.backend.model.Subject;
import lmsbackendapp.backend.repository.StudyYearRepository;
import lmsbackendapp.backend.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudyYearService {
    @Autowired
    private StudyYearRepository studyYearRepo;
    @Autowired
    private SubjectRepository subjectRepo;
    @Autowired
    private StudyYearService studyYearService;
    public StudyYearService(){}

    public Iterable<StudyYear> getStudyYear(){
        return studyYearRepo.findAll();
    }
    public Optional<StudyYear> getStudyYearById(Long id){
        return studyYearRepo.findById(id);
    }
    public void addStudyYear(StudyYear studyYear){

        studyYearRepo.save(studyYear);

    }
    public void editStudyYear(Long id,StudyYear studyYear){
        Optional<StudyYear> studyYEdt = studyYearRepo.findById(id);
        if(studyYEdt.isPresent()){
            studyYear.setId(studyYEdt.get().getId());
            studyYearRepo.save(studyYear);
        }
    }
    public void deleteStudyYear(Long id){
        Optional<StudyYear> studyYear = studyYearRepo.findById(id);
        studyYearRepo.delete(studyYear.get());
    }

    public ArrayList<Subject> getSubject(Long studyYearId){
        return subjectRepo.findByStudyYearIdEquals(studyYearId);
    }
    public Optional<StudyYear> getNextStudyYearByStudyProgram(Long id){
        Optional<StudyYear> sy = studyYearService.getStudyYearById(id);
        if (sy.isPresent()){
            StudyYear studyYear = sy.get();
            int year = studyYear.getYear();
            year = year + 1;
            Optional<StudyYear> nextStudyYear = studyYearRepo.getNextStudyYear(year,studyYear.getStudyProgram().getId());
            return nextStudyYear;
        }
        return sy;
    }
}
