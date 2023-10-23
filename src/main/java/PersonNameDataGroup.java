

import java.util.*;

public class PersonNameDataGroup {
    Reader reader = new Reader();

    public HashMap<Character, ArrayList<Person>> addPerson() {

        HashMap<Character, ArrayList<Person>> sortedMap = new HashMap<>();

        for (Person persons : reader.readCsv()) {
            char firstLetter = persons.getFamily().charAt(0);
            sortedMap.computeIfAbsent(firstLetter, k -> new ArrayList<>()).add(persons);
        }
        return sortedMap;
    }

    public Person[] getPersons(String family) {

        return addPerson().get(family.charAt(0)).toArray(new Person[0]);

    }
}
