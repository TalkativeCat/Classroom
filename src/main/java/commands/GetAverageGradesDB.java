package commands;

import db.GetStatistics;

public class GetAverageGradesDB implements Command{

    private final int group1;
    private final int group2;

    public GetAverageGradesDB(int group1, int group2) {
        this.group1 = group1;
        this.group2 = group2;
    }


    @Override
    public void execute() {
        GetStatistics getStatistics = new GetStatistics();
        getStatistics.getAverageGrades(group1, group2);
    }
}
