import commands.CommandBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import servlets.StudentsApi;


import java.util.Arrays;
//@EnableJpaRepositories
//@SpringBootApplication
public class Main {

//    public static void main(String[] args) {
//        SpringApplication.run(Main.class);
//    }


//        RequestChangeGradeForSubject requestChangeGradeForSubject = new RequestChangeGradeForSubject(99, "physics", 5);
//        ChangeGradeForSubject changeGradeForSubject = new ChangeGradeForSubject();
//        System.out.println(changeGradeForSubject.changeGrade(requestChangeGradeForSubject).getPersonId() + " " + changeGradeForSubject.changeGrade(requestChangeGradeForSubject).getOldGrade() + " " + changeGradeForSubject.changeGrade(requestChangeGradeForSubject).getNewGrade());
//


//        DataGroup<Integer> dataGroupGroup = new DataGroup<>();
//        Person[] persons = dataGroupGroup.getPersons(Person::getGroup, 10);
//        for (Person s : persons) {
//            System.out.println(s.getPersonId() + s.getName() + s.getFamily());
//        }

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
