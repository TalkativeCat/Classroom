package servlets.responseModel;

import lombok.Data;

@Data
public class ResponseAverageStudentGradeByClass {

    String name;
    String family;
    double averageGrade;


    public ResponseAverageStudentGradeByClass(String name, String family, double averageGrade) {
        this.name = name;
        this.family = family;
        this.averageGrade = averageGrade;
    }
}
