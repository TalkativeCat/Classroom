import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonNameDataGroup {
    Reader reader = new Reader();
private final HashMap<Character, List<Person>> sortedMap = new HashMap<>();

    public void addPerson() {

        for (Person persons : reader.readCsv()) {
            char firstLetter = persons.getFamily().charAt(0);
            sortedMap.computeIfAbsent(firstLetter, k -> new ArrayList<>()).add(persons);
        }
    }

    public Person[] getPersons(String family) {
        if (sortedMap.isEmpty()) {
            addPerson();
        }
        return sortedMap.get(family.charAt(0)).toArray(new Person[0]);

    }
}
