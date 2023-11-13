package servlets.requestModel;

import lombok.Data;

@Data
public class RequestChangeGradeForSubject {

    int personId;
    String subject;
    int newGrade;

}
