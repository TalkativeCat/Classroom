package servlets.commands;

import dataGroup.DataGroup;
import model.Person;
import servlets.responseModel.ResponseAverageStudentGradeByClass;

public class AverageStudentGradeByClass {

    public ResponseAverageStudentGradeByClass[] getGrades(int group) {
        DataGroup<Integer> dataGroupGroup = new DataGroup<>();
        Person[] persons = dataGroupGroup.getPersons(Person::getGroup, group);
        ResponseAverageStudentGradeByClass[] personList = new ResponseAverageStudentGradeByClass[persons.length];

        for (int i = 0; i < persons.length; i++) {
            Person person = persons[i];
            double averageGrade = calculateAverage(person);
            personList[i] = new ResponseAverageStudentGradeByClass(person.getFamily(), person.getName(), averageGrade);
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

        return Math.round(average * 10.0) / 10.0;
    }
}
