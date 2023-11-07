package commands;

import db.ConnectionManager;
import db.GetStatistics;

public class GetPersonsByAgeCommandDB implements Command{
    private final int age;

    public GetPersonsByAgeCommandDB(int age) {
        this.age = age;
    }

    @Override
    public void execute() {
        GetStatistics getStatistics = new GetStatistics();
        getStatistics.getGoodStudentsOlderAge(age);
    }
}
