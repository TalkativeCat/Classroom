public class CommandBuilder {

        private final StudentService studentService;
        private int age;

        public CommandBuilder(StudentService studentService) {
            this.studentService = studentService;
        }

        public CommandBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public Command ExecuteGetByAge() {
            return new GetPersonsByAgeCommand(studentService, age);
        }
    }

