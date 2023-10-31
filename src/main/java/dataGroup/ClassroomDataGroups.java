package dataGroup;

import dataLoad.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// класс не используется, обработка данных переведена в DataGroup
public class ClassroomDataGroups {
    Reader reader = new Reader();

    private final HashMap<Integer, List<Person>> sortedMap = new HashMap<>();

    public void addPerson() {

        for (Person persons : reader.loadDataFromCsv()) {
            Integer group = persons.getGroup();
            sortedMap.computeIfAbsent(group, k -> new ArrayList<>()).add(persons);
        }
    }
    public Person[] getPersons(int group) {
        if (sortedMap.isEmpty()) {
            addPerson();
        }
        return sortedMap.get(group).toArray(new Person[0]);
    }
}
