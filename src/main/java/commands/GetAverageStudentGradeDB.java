package commands;

import db.GetStatistics;

public class GetAverageStudentGradeDB implements Command{
    private final String family;

    public GetAverageStudentGradeDB(String family) {
        this.family = family;
    }
    @Override
    public void execute() {
        GetStatistics getStatistics = new GetStatistics();
        getStatistics.getAverageStudentGrade(family);
    }
}
