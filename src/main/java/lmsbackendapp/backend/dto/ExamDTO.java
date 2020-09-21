package lmsbackendapp.backend.dto;

import java.util.Date;

public class ExamDTO {
    private int assessment;
    private String subject;
    private int year;
    private String studyProgramName;
    private int points;
    private java.util.Date date;
    private int espb;

    public ExamDTO(int assessment, String subject, int year, String studyProgramName, int points, Date date, int espb) {
        super();
        this.assessment = assessment;
        this.subject = subject;
        this.year = year;
        this.studyProgramName = studyProgramName;
        this.points = points;
        this.date = date;
        this.espb = espb;
    }

    public int getAssessment() {
        return assessment;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStudyProgramName() {
        return studyProgramName;
    }

    public void setStudyProgramName(String studyProgramName) {
        this.studyProgramName = studyProgramName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }
}
