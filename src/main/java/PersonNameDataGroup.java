

import java.util.*;

public class PersonNameDataGroup {

    /* в качестве аргумента принимается коллекция студентов со всеми полями, загруженная из файла, и преобразуется в HashMap.
    Ключ - первая буква фамилии студента, значение - коллекция студентов, фамилия которых начинается на данную букву
    * */
    public HashMap<Character, ArrayList<Person>> addPerson(List<Person> person) {

        HashMap<Character, ArrayList<Person>> sortedMap = new HashMap<>();

        for (Person persons : person) {
            char firstLetter = persons.getFamily().charAt(0);
            sortedMap.computeIfAbsent(firstLetter, k -> new ArrayList<>()).add(persons);
        }
        return sortedMap;
    }

    /* с помощью метода addPerson() по ключу (первая буква фамилии студента) находит всех студенов в значениях HashMap и пенредает их в массив.
    Далее осуществляется поиск конкретной фамилии по заранее отсортированному массиву и вывод результатов в консоль
    * */
    public void getPersonsByFamily(List<Person> person, String name) {

        Person[] persons = addPerson(person).get(name.charAt(0)).toArray(new Person[0]);

        for (Person obj : persons) {
            if (obj.getFamily().equals(name)) {
                System.out.println(obj.getFamily() + " " + obj.getName());
            }

        }
    }
}
