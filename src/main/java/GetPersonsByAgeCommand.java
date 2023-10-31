public class GetPersonsByAgeCommand implements Command{

    private int age;

    public GetPersonsByAgeCommand(StudentService studentService, int age) {
        this.age = age;
    }

    @Override
    public void executeGetByAge() {
        DataGroup<Integer> dataGroupAge = new DataGroup<>();
        System.out.println("Отличники среди студентов старше 14 лет:");
        age += 1;
        while ((age < 18)) {
            for (Person obj : dataGroupAge.getPersons(Person::getAge, age)) {
                int number = obj.getPhysics() + obj.getMathematics() + obj.getRus() + obj.getLiterature() + obj.getGeometry() + obj.getInformatics();
                if (number == 30) {
                    System.out.println(obj.getFamily() + " " + obj.getName());
                }
            }
            age++;
        }
        System.out.println();
    }

    @Override
    public void executeGetByFamily() {

    }

    @Override
    public void executeGetByGroup() {

    }
}
