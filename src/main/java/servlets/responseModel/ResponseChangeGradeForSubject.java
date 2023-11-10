package servlets.responseModel;

public class ResponseChangeGradeForSubject {
    String status;
    int personId;
    String subject;
    int oldGrade;
    int newGrade;

    public ResponseChangeGradeForSubject(String status, int personId, String subject, int oldGrade, int newGrade) {
        this.status = status;
        this.personId = personId;
        this.subject = subject;
        this.oldGrade = oldGrade;
        this.newGrade = newGrade;
    }

    public ResponseChangeGradeForSubject(String status) {
        this.status = status;
    }

    public ResponseChangeGradeForSubject(int personId, int oldGrade, int newGrade) {
        this.personId = personId;
        this.oldGrade = oldGrade;
        this.newGrade = newGrade;
    }

    public ResponseChangeGradeForSubject() {

    }


    public String getStatus() {
        return status;
    }

    public int getPersonId() {
        return personId;
    }

    public String getSubject() {
        return subject;
    }

    public int getOldGrade() {
        return oldGrade;
    }

    public int getNewGrade() {
        return newGrade;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setOldGrade(int oldGrade) {
        this.oldGrade = oldGrade;
    }

    public void setNewGrade(int newGrade) {
        this.newGrade = newGrade;
    }
}
