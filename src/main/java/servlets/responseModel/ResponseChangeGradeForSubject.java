package servlets.responseModel;

import lombok.Data;

@Data
public class ResponseChangeGradeForSubject {
    String status;
    int personId;
    String subject;
    int oldGrade;
    int newGrade;


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


}
