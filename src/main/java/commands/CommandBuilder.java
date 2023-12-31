package commands;

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
            case ("initDB"):
                new InitDB().execute();
                break;
            case ("getAgeFromDB"):
                new GetPersonsByAgeCommandDB(Integer.parseInt(args[0])).execute();
                break;
            case ("getAverageGradesFromDB"):
                new GetAverageGradesDB(Integer.parseInt(args[0]), Integer.parseInt(args[1])).execute();
                break;
            case ("getAverageStudentGradeFromDB"):
                new GetAverageStudentGradeDB(args[0]).execute();
                break;
            default:
                System.out.println("Команда не распознана, введите другую");
                break;
        }


    }
}

