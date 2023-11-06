import dataGroup.CommandBuilder;
import db.GetStatistics;
import db.Init;

import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {
//        Init init = new Init();
//        init.createDBAndData();

        if (args.length == 0) {
            System.out.println("Вы не ввели ни одной команды");
        } else {
            String command = args[0];
            args = Arrays.copyOfRange(args, 1, args.length);
            CommandBuilder commandBuilder = new CommandBuilder();
            commandBuilder.selectCommand(command, args);
        }
    }

}
