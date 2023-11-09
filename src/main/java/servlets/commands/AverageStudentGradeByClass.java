package servlets.commands;

import dataGroup.DataGroup;
import model.Person;
import model.PersonAwerageGrade;

public class AverageStudentGradeByClass {

    public PersonAwerageGrade[] getGrades(int group) {
        DataGroup<Integer> dataGroupGroup = new DataGroup<>();
        Person[] persons = dataGroupGroup.getPersons(Person::getGroup, group);
        PersonAwerageGrade[] personList = new PersonAwerageGrade[persons.length];

        for (int i = 0; i < persons.length; i++) {
            Person person = persons[i];
            double averageGrade = calculateAverage(person);
            personList[i] = new PersonAwerageGrade(person.getFamily(), person.getName(), averageGrade);
        }

        return personList;
    }



    private double calculateAverage(Person person) {
        int physics = person.getPhysics();
        int mathematics = person.getMathematics();
        int rus = person.getRus();
        int literature = person.getLiterature();
        int geometry = person.getGeometry();
        int informatics = person.getInformatics();

        int sum = physics + mathematics + rus + literature + geometry + informatics;
        double average = sum / 6.0;

        // Округление до одного знака после запятой

        return Math.round(average * 10.0) / 10.0;
    }
}
