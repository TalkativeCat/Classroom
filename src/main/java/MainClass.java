import db.Init;

public class MainClass {

    public static void main(String[] args) throws Exception {
        Init init = new Init();
        init.initDB();
        init.addDataToDB();

//        if (args.length == 0) {
//            System.out.println("Вы не ввели ни одной команды");
//        } else {
//            String command = args[0];
//            args = Arrays.copyOfRange(args, 1, args.length);
//            CommandBuilder commandBuilder = new CommandBuilder();
//            commandBuilder.selectCommand(command, args);
//        }
    }

}
