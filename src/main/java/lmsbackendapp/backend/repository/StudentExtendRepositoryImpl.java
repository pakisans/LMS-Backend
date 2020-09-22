package lmsbackendapp.backend.repository;

import lmsbackendapp.backend.model.PersonalData;
import lmsbackendapp.backend.model.Student;
import lmsbackendapp.backend.model.StudentInProgress;
import lmsbackendapp.backend.model.SubjectAttending;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class StudentExtendRepositoryImpl implements StudentExtendRepository {
    @PersistenceContext
    EntityManager entityManager;
    public Collection<Student> searchStudent(String name, String lastname, String indexNumber, String subscription, String averageAssessment) {
        Session session = entityManager.unwrap(Session.class);
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);

        Root<Student> myObjectRoot = criteria.from(Student.class);
        ArrayList<Predicate> predicates = new ArrayList<Predicate>();

        if (name != null && name != "") {
            Join<Student, PersonalData> joinPersonalData = myObjectRoot.join("personalData");
            Predicate likeRestrictionName = builder.and(builder.like(joinPersonalData.get("name"), "%" + name + "%"));
            predicates.add(likeRestrictionName);
        };
        if (lastname != null && lastname != "") {
            Join<Student, PersonalData> joinPersonalData = myObjectRoot.join("personalData");
            Predicate likeRestrictionLastName = builder.and(builder.like(joinPersonalData.get("lastname"), "%" + lastname + "%"));
            predicates.add(likeRestrictionLastName);
        };
        if (indexNumber != null && indexNumber != "") {
            Join<Student, PersonalData> joinPersonalData = myObjectRoot.join("personalData");
            Predicate likeRestrictionIndexNumber = builder.and(builder.like(joinPersonalData.get("indexNumber"), "%" + indexNumber + "%"));
            predicates.add(likeRestrictionIndexNumber);
        };
        if (subscription != null && subscription != "") {
            try {
                int subscriptionYear = 0;
                subscriptionYear = Integer.parseInt(subscription);
                Join<Student, StudentInProgress> joinStudentInProgress = myObjectRoot.join("studentInProgress");
                Predicate subscriptionRestriction = builder.and(builder.equal(
                        builder.function("YEAR", Integer.class, joinStudentInProgress.get("startDate")), subscriptionYear));
                predicates.add(subscriptionRestriction);

            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        if (averageAssessment != null && averageAssessment != "") {
            try {
                double avg = 0;
                avg = Double.parseDouble(averageAssessment);
                Join<Student, SubjectAttending> joinSubjectAttending = myObjectRoot.join("subjectAttending");
                Subquery<Double> sub = criteria.subquery(Double.class);
                sub.select(builder.avg(joinSubjectAttending.get("assessment")));
                sub.from(SubjectAttending.class);
                sub.having(builder.equal(myObjectRoot.get("id"), joinSubjectAttending.get("student").get("id")));
                Predicate assessmentRestriction = builder.and(builder.equal(sub, avg));
                predicates.add(assessmentRestriction);

            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Collection<Student> results = entityManager.createQuery(criteria.where(predicates.toArray(new Predicate[0]))).getResultList();
        return results;

    }
}
