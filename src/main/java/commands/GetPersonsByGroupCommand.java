package commands;

import dataGroup.DataGroup;
import dataGroup.Person;

public class GetPersonsByGroupCommand implements Command{

    private final String[] group;

    public GetPersonsByGroupCommand(String[] group) {
        this.group = group;
    }

    @Override
    public void execute() {
        DataGroup<Integer> dataGroupGroup = new DataGroup<>();
        double middle = 0;
        for (String s : group) {
            Person[] persons = dataGroupGroup.getPersons(Person::getGroup, Integer.parseInt(s));
            double number = 0;
            for (Person obj : persons) {
                number += (double) (obj.getPhysics() + obj.getMathematics() + obj.getRus() + obj.getLiterature() + obj.getGeometry() + obj.getInformatics()) / 6;
            }
            double middleTemp = (number / persons.length);
            middle += middleTemp;
        }
        String result = String.format("%.1f", (middle / group.length));
        if (group.length == 1) {
            System.out.println("Средний балл в " + group[0] + " классе: " + result);
        }
        else {
            System.out.print("Средний балл в ");
            for (String s : group) {
                System.out.print(s + " ");
            }
            System.out.print("классах: " + result);

        }
    }
}
