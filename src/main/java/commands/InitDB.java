package commands;

import db.GetStatistics;
import db.Init;

public class InitDB implements Command{
    public InitDB() {
    }
    @Override
    public void execute() {
        Init init = new Init();
        init.initDataBase();
        init.addDataToDB();
        init.addDataToEducationalPlans();
    }
}
