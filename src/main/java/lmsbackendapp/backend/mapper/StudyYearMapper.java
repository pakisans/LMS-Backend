package lmsbackendapp.backend.mapper;

import lmsbackendapp.backend.dto.StudyYearDTO;
import lmsbackendapp.backend.model.StudyYear;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class StudyYearMapper implements Mapper<StudyYear, StudyYearDTO> {
    @Override
    public StudyYearDTO toDTO(StudyYear e) {
        if(e==null) return null;
        StudyYearDTO returnVal = new StudyYearDTO();
        returnVal.setId(e.getId());
        returnVal.setStartDate(e.getStartDate());
        returnVal.setEndDate(e.getEndDate());
        returnVal.setYear(e.getYear());
        returnVal.setStudyProgramName(e.getStudyProgram().getName());
        returnVal.setFacultyName(e.getStudyProgram().getFaculty().getName());
        return returnVal;
    }

    @Override
    public StudyYear toEntity(StudyYearDTO edto) {
        return null;
    }

    @Override
    public Collection<StudyYearDTO> toDTO(Collection<StudyYear> es) {
        if (es == null) return null;
        Collection<StudyYearDTO> ys = new ArrayList<StudyYearDTO>();
        for (StudyYear y: es){
            ys.add(toDTO(y));
        }return ys;
    }

    @Override
    public Collection<StudyYear> toEntityList(Collection<StudyYearDTO> edtos) {
        return null;
    }
}
