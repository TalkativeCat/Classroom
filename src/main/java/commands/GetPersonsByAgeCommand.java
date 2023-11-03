package commands;

import dataGroup.DataGroup;
import dataGroup.Person;

public class GetPersonsByAgeCommand implements Command {


    private int age;

    public GetPersonsByAgeCommand(int age) {
        this.age = age;
    }

    @Override
    public void execute() {
        DataGroup<Integer> dataGroupAge = new DataGroup<>();
        System.out.println("Отличники среди студентов старше " + age + " лет:");
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

}
