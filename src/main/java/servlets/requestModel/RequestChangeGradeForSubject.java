package servlets.requestModel;

public class RequestChangeGradeForSubject {

    int personId;
    String subject;
    int newGrade;

    public RequestChangeGradeForSubject(int personId, String subject, int newGrade) {
        this.personId = personId;
        this.subject = subject;
        this.newGrade = newGrade;
    }

    public RequestChangeGradeForSubject() {
    }


    public int getPersonId() {
        return personId;
    }

    public String getSubject() {
        return subject;
    }

    public int getNewGrade() {
        return newGrade;
    }
}
