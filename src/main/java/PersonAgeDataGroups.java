import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonAgeDataGroups {
    Reader reader = new Reader();

    private final HashMap<Integer, List<Person>> sortedMap = new HashMap<>();
    public void addPerson() {

        for (Person persons : reader.readCsv()) {
            Integer age = persons.getAge();
            sortedMap.computeIfAbsent(age, k -> new ArrayList<>()).add(persons);
        }
    }
    public Person[] getPersons(int age) {
        if (sortedMap.isEmpty()) {
            addPerson();
        }
        return sortedMap.get(age).toArray(new Person[0]);
    }
}
