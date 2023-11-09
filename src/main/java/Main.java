import dataGroup.DataGroup;
import model.Person;

public class Main {

    public static void main(String[] args) {
        DataGroup<Integer> dataGroupGroup = new DataGroup<>();
        Person[] persons = dataGroupGroup.getPersons(Person::getGroup, 10);
        for (Person s : persons) {
            System.out.println(s.getPersonId() + s.getName() + s.getFamily());
        }

//        if (args.length == 0) {
//            System.out.println("Вы не ввели ни одной команды");
//        } else {
//            String command = args[0];
//            args = Arrays.copyOfRange(args, 1, args.length);
//            CommandBuilder commandBuilder = new CommandBuilder();
//            commandBuilder.selectCommand(command, args);
//        }
    }
    public void test() {

    }

}
