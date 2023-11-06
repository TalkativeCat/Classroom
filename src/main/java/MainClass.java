import commands.CommandBuilder;

import java.util.Arrays;

public class MainClass {
    //ввод команд осуществляется через аргументы, список команд доступен в классе CommandBuilder
    //Пример команды для вывода средней оценки по предметам среди 10 и 11 классов: getAverageGradesFromDB 10 11
    public static void main(String[] args) {

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
