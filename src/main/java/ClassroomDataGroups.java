import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClassroomDataGroups {
    Reader reader = new Reader();
    public HashMap<Integer, ArrayList<Person>> addPerson() {

        HashMap<Integer, ArrayList<Person>> sortedMap = new HashMap<>();

        for (Person persons : reader.readCsv()) {
            Integer group = persons.getGroup();
            sortedMap.computeIfAbsent(group, k -> new ArrayList<>()).add(persons);
        }
        return sortedMap;
    }
    public Person[] getPersons(int group) {
        return addPerson().get(group).toArray(new Person[0]);
    }
}
