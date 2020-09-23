package lmsbackendapp.backend.mapper;

import lmsbackendapp.backend.dto.StudentInProgressDTO;
import lmsbackendapp.backend.model.StudentInProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class StudentInProgressMapper implements Mapper<StudentInProgress, StudentInProgressDTO> {
    @Autowired
    StudyYearMapper ysMapper;

    @Override
    public StudentInProgressDTO toDTO(StudentInProgress e) {
        if(e == null) return null;
        StudentInProgressDTO returnValue = new StudentInProgressDTO();
        returnValue.setIndexNumber(e.getIndexNumber());
        returnValue.setStartDate(e.getStartDate());
        returnValue.setStudyYear(ysMapper.toDTO(e.getStudyYear()));
        return returnValue;
    }

    @Override
    public StudentInProgress toEntity(StudentInProgressDTO edto) {
        return null;
    }

    @Override
    public Collection<StudentInProgressDTO> toDTO(Collection<StudentInProgress> es) {
        if (es.size() == 0) return null;
        Collection<StudentInProgressDTO> years= new ArrayList<StudentInProgressDTO>(es.size());
        for (StudentInProgress e : es) {
            years.add(toDTO(e));
        }
        return years;
    }

    @Override
    public Collection<StudentInProgress> toEntityList(Collection<StudentInProgressDTO> edtos) {
        return null;
    }
}
