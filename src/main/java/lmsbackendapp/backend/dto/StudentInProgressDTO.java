package lmsbackendapp.backend.dto;

import java.util.Date;

public class StudentInProgressDTO {
    private java.util.Date startDate;
    private String indexNumber;
    private StudyYearDTO studyYear;

    public StudentInProgressDTO(){}

    public StudentInProgressDTO(Date startDate, String indexNumber, StudyYearDTO studyYear) {
        super();
        this.startDate = startDate;
        this.indexNumber = indexNumber;
        this.studyYear = studyYear;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public StudyYearDTO getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(StudyYearDTO studyYear) {
        this.studyYear = studyYear;
    }
}
