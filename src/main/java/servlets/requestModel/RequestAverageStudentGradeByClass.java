package servlets.requestModel;

public class RequestAverageStudentGradeByClass {
    public RequestAverageStudentGradeByClass() {
    }
    public RequestAverageStudentGradeByClass(int group) {
        this.group = group;
    }


    public int getGroup() {
        return group;
    }


    int group;

}
