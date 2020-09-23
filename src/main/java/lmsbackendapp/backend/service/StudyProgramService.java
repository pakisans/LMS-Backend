package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.StudyProgram;
import lmsbackendapp.backend.model.StudyYear;
import lmsbackendapp.backend.repository.StudyProgramRepository;
import lmsbackendapp.backend.repository.StudyYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudyProgramService {
    @Autowired
    private StudyProgramRepository studyPRepo;
    @Autowired
    private StudyYearRepository studyYRepo;

    public StudyProgramService(){}
    public Iterable<StudyProgram> getStudyProgram(){
        return studyPRepo.findAll();
    }
    public Optional<StudyProgram> getStudyProgramById(Long id){
        return studyPRepo.findById(id);
    }
    public void addStudyProgram(StudyProgram studyProgram){
        studyPRepo.save(studyProgram);
    }
    public void editStudyPRogram(Long id,StudyProgram studyProgram){
        Optional<StudyProgram> studyPEdt = studyPRepo.findById(id);
        if(studyPEdt.isPresent()){
            studyProgram.setId(studyPEdt.get().getId());

            studyPRepo.save(studyProgram);
        }
    }
    public void deleteStudyProgram(Long id){
        Optional<StudyProgram> studyPDel = studyPRepo.findById(id);
        StudyProgram sp = studyPDel.get();
        sp.setDeleted(true);
        studyPRepo.save(sp);
    }
    public ArrayList<StudyYear> getStudyYear(Long studyProgramId){
        return studyYRepo.findByStudyProgramEquals(studyProgramId);
    }
}
