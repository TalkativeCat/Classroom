import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MainClass {
    static ClassroomDataGroups classroomDataGroups = new ClassroomDataGroups();
    static PersonAgeDataGroups personAgeDataGroups = new PersonAgeDataGroups();
    static PersonNameDataGroup personNameDataGroup = new PersonNameDataGroup();
    public static void main(String[] args) throws FileNotFoundException {
        getPersonsByFamily();
        getPersonsByGroup(10, 11);

    }

    public static String getFamily() {
        System.out.println("Введите фамилию студента: ");
        Scanner console = new Scanner(System.in);
        return console.nextLine();
    }
    public static void getPersonsByGroup(int group1, int group2) {
        Person[] persons1 = classroomDataGroups.getPersons(group1);
        Person[] persons2 = classroomDataGroups.getPersons(group2);
        Person[] persons = new Person[persons1.length + persons2.length];
        System.arraycopy(persons1, 0, persons, 0, persons1.length);
        System.arraycopy(persons2, 0, persons, persons1.length, persons2.length);
        double number = 0;
        for (Person obj : persons) {
            number += (double) (obj.getPhysics() + obj.getMathematics() + obj.getRus() + obj.getLiterature() + obj.getGeometry() + obj.getInformatics()) / 6;
        }
        double middle = (number / persons.length);
        System.out.println("Средняя оценка в " + group1 + " и " + group2 + " классах: " + middle);
    }
    public static void getPersonsByFamily() {
        System.out.println("Введите фамилию студента: ");
        Scanner console = new Scanner(System.in);
        String family = console.nextLine();
        for (Person obj : personNameDataGroup.getPersons(family)) {
            if (obj.getFamily().equals(family)) {
                System.out.println(obj.getFamily() + " " + obj.getName());
            }

        }
    }



}
