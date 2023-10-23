import java.util.Scanner;


public class MainClass {
    static ClassroomDataGroups classroomDataGroups = new ClassroomDataGroups();
    static PersonAgeDataGroups personAgeDataGroups = new PersonAgeDataGroups();
    static PersonNameDataGroup personNameDataGroup = new PersonNameDataGroup();

    public static void main(String[] args) {
        getPersonsByGroup(10, 11);
        getPersonsByAge(14);
        getPersonsByFamily();

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
        String result = String.format("%.1f", middle);
        System.out.println("Средний балл в " + group1 + " и " + group2 + " классах: " + result + "\n");
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

    public static void getPersonsByAge(int age) {
        System.out.println("Отличники среди студентов старше 14 лет:");
        age += 1;
        while ((age < 18)) {
            for (Person obj : personAgeDataGroups.getPersons(age)) {
                int number = obj.getPhysics() + obj.getMathematics() + obj.getRus() + obj.getLiterature() + obj.getGeometry() + obj.getInformatics();
                if (number == 30) {
                    System.out.println(obj.getFamily() + " " + obj.getName());
                }
            }
            age++;
        }
        System.out.println("");
    }


}
