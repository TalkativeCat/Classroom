package dataGroup;

import commands.GetPersonsByAgeCommand;
import commands.GetPersonsByFamilyCommand;
import commands.GetPersonsByGroupCommand;

public class CommandBuilder {

    public void selectCommand(String command, String[] args) {
        switch (command) {
            case ("getAge"):
                new GetPersonsByAgeCommand(Integer.parseInt(args[0])).execute();
                break;
            case ("getFamily"):
                new GetPersonsByFamilyCommand(args[0]).execute();
                break;
            case ("getGroup"):
                new GetPersonsByGroupCommand(args).execute();
                break;
            default:
                System.out.println("Команда не распознана, введите другую");
                break;
        }


    }
}

