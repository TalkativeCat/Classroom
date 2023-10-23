import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClassroomDataGroups {
    /* в качестве аргумента принимается коллекция студентов? загруженная из файла со всеми полями, и преобразуется в HashMap.
    Ключ - класс студента, значение - коллекция студентов, обучающихся в данном классе
    * */
    public HashMap<Integer, ArrayList<Person>> addPerson(List<Person> person) {

        HashMap<Integer, ArrayList<Person>> sortedMap = new HashMap<>();

        for (Person persons : person) {
            Integer group = persons.getGroup();
            sortedMap.computeIfAbsent(group, k -> new ArrayList<>()).add(persons);
        }
        return sortedMap;
    }
    /* с помощью метода addPerson() по ключам (классы, в которых учатся студенты) находит всех студенов в значениях HashMap и пенредает их в массивы,
    которые затем объединяются в единый массив.
    Далее осуществляется поиск студентов-отличников старше 14 лет и вывод результатов в консоль
    * */

    public void getPersonsByGroup(List<Person> person, int age, int group1, int group2) {

        Person[] persons1 = addPerson(person).get(group1).toArray(new Person[0]);
        Person[] persons2 = addPerson(person).get(group2).toArray(new Person[0]);
        Person[] persons = new Person[persons1.length + persons2.length];
        System.arraycopy(persons1, 0, persons, 0, persons1.length);
        System.arraycopy(persons2, 0, persons, persons1.length, persons2.length);

        for (Person obj : persons) {
            int rating = obj.getPhysics() + obj.getMathematics() + obj.getRus() + obj.getLiterature() + obj.getGeometry() + obj.getInformatics();
            if ((rating == 30) && obj.getAge() > age) {
                System.out.println(obj.getFamily() + " " + obj.getName());
            }

        }
    }
}
