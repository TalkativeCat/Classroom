import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class PersonAgeDataGroups {
    Reader reader = new Reader();
    public HashMap<Integer, ArrayList<Person>> addPerson() {

        HashMap<Integer, ArrayList<Person>> sortedMap = new HashMap<>();

        for (Person persons : reader.readCsv()) {
            Integer age = persons.getAge();
            sortedMap.computeIfAbsent(age, k -> new ArrayList<>()).add(persons);
        }
        return sortedMap;
    }
    public Person[] getPersons(int age) {

        return addPerson().get(age).toArray(new Person[0]);
    }
}
