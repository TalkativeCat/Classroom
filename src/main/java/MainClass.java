import dataGroup.CommandBuilder;

import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {
        // из массива аргументов вытаскивется под индексом [0] - это команда, распознающаяся в CommandBuilder, все элементы под индексами далее - аргументы,
        // которые копируются со смещением в этот же массив и передаются для дальнейших вычислений в метод execute()

        // пример аргументов при запуске программы: getGroup 10 11
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
