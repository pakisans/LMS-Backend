package lmsbackendapp.backend.service;

import lmsbackendapp.backend.model.ColloquimDetail;
import lmsbackendapp.backend.repository.ColloqiumDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColloquimDetailService {
    @Autowired
    ColloqiumDetailRepository colloqiumDetRepo;

    public Iterable<ColloquimDetail> getColloquimDetail(){
        return  colloqiumDetRepo.findAll();
    }
    public Optional<ColloquimDetail> getColloquimDetailById(Long id){
        return colloqiumDetRepo.findById(id);
    }
    public void addColloquimDetail(ColloquimDetail colloquimDetail){
        colloqiumDetRepo.save(colloquimDetail);
    }
    public void editColloquimDetail(Long id,ColloquimDetail colloquimDetail){
        Optional<ColloquimDetail> edtColloquimDetail = colloqiumDetRepo.findById(id);
            if(edtColloquimDetail.isPresent()){
                colloquimDetail.setId(edtColloquimDetail.get().getId());
                colloqiumDetRepo.save(colloquimDetail);
            }
        }
    public void deleteColloquimDetail(Long id){
        Optional<ColloquimDetail> delColloquimDetail = colloqiumDetRepo.findById(id);
        if(delColloquimDetail.isPresent()){
            colloqiumDetRepo.delete(delColloquimDetail.get());
        }
    }
}
