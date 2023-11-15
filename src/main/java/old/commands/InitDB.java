package old.commands;

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
