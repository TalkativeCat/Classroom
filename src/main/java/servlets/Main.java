package servlets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }


//    public static void main(String[] args) {
//        if (args.length == 0) {
//            System.out.println("Вы не ввели ни одной команды");
//        } else {
//            String command = args[0];
//            args = Arrays.copyOfRange(args, 1, args.length);
//            CommandBuilder commandBuilder = new CommandBuilder();
//            commandBuilder.selectCommand(command, args);
//        }
//    }
}
