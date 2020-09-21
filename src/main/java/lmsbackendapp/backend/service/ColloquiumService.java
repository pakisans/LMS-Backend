package lmsbackendapp.backend.service;

import lmsbackendapp.backend.dto.ExamDTO;
import lmsbackendapp.backend.model.ColloquimDetail;
import lmsbackendapp.backend.model.Colloquium;
import lmsbackendapp.backend.model.ColloquiumType;
import lmsbackendapp.backend.repository.ColloqiumDetailRepository;
import lmsbackendapp.backend.repository.ColloqiumRepository;
import lmsbackendapp.backend.repository.ColloquiumTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class ColloquiumService {
    @Autowired
    private ColloqiumRepository colloqRepo;
    @Autowired
    private ColloquimDetailService colloqDetService;
    @Autowired
    private ColloquiumTypeRepository colloqTypeRepo;

    public ColloquiumService(){}

    public Iterable<Colloquium> getColloquium(){
        return colloqRepo.findAll();
    }
    public Optional<Colloquium> getColloquiumById(Long id){
        return  colloqRepo.findById(id);
    }
    @Transactional
    public void addColloquium(Colloquium colloquium){
        Colloquium colloqAdd = new Colloquium(colloquium.getStartTime(),colloquium.getEndTime(),colloquium.getPoints(),colloquium.getDuration(),colloquium.getSubjectRealization(),colloquium.getColloquiumType(),colloquium.getExamTaking(),colloquium.getSyllabus());
        colloqAdd.setSyllabus(null);
        colloqAdd.setId(colloqRepo.save(colloqAdd).getId());
        for (ColloquimDetail colloquimDetail : colloquium.getSyllabus()){
            colloquimDetail.setColloquium(colloqAdd);
            colloqDetService.addColloquimDetail(colloquimDetail);
        }
    }

    public void editColloquium(Long id,Colloquium colloquium){
        Optional<Colloquium> colloqEdit = colloqRepo.findById(id);
        if (colloqEdit.isPresent()){
            colloquium.setId(colloqEdit.get().getId());
            colloqRepo.save(colloquium);
        }
    }
    public void deleteColloquium(Long id){
        Optional<Colloquium> colloqDel = colloqRepo.findById(id);
        colloqRepo.delete(colloqDel.get());
    }
    public Iterable<ColloquiumType> getColloquiumType(){
        return colloqTypeRepo.findAll();
    }
    public ArrayList<ExamDTO> getExamByStudent(Long studentId){
        ArrayList<Object[]> fetch = colloqRepo.getExamByStudent(studentId);
        ArrayList<ExamDTO> result = new ArrayList<ExamDTO>();
        try {
            if(fetch != null && fetch.size() > 0){
                for (int i = 0; i < fetch.size(); i++){
                    result.add(new ExamDTO( (int) fetch.get(i)[0], (String) fetch.get(i)[1],(int) fetch.get(i)[2], (String) fetch.get(i)[3], (int) fetch.get(i)[4], (Date) fetch.get(i)[5], (int) fetch.get(i)[6]));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }return  result;
    }

}
